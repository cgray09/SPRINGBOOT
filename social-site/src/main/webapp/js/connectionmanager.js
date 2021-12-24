/*******************************************************************************
 * 
 * Deals with retrieving messages, creating message notifications, etc
 * 
 ******************************************************************************/

function ConnectionManager(webSocketEndpoint) {
	console.log("New connection manager created");

	var csrfTokenName = $("meta[name='_csrf_header']").attr("content");
	var csrfTokenValue = $("meta[name='_csrf']").attr("content");

	console.log("CSRF name", csrfTokenName);
	console.log("CSRF value", csrfTokenValue);

	this.webSocketEndpoint = webSocketEndpoint;
	this.client = null;
	this.headers = [];
	this.headers[csrfTokenName] = csrfTokenValue;
	
	console.log("this.headers", this.headers);
	
	this.timedout=false;

	this.subscriptions = [];

	$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
		jqXHR.setRequestHeader(csrfTokenName, csrfTokenValue);
	});
}

ConnectionManager.prototype.connect = function() {
	console.log("Connect method called");

	var wsocket = new SockJS(this.webSocketEndpoint);
	this.client = Stomp.over(wsocket);

	var _self = this;

	console.log("CHECK this.headers", this.headers);
	this.client.connect(this.headers, function() {
		_self.connectSuccess()
	}, function() {
		_self.timedout=true;
	});

}

ConnectionManager.prototype.fetchMessages = function(conversationAjaxUrl,
		refreshMessages, page) {
	
	var request = JSON.stringify({
		'page': page
	});

//	var jqXHR = $.ajax({
//		url : conversationAjaxUrl,
//		dataType : 'json',
//		data: request,
//		contentType: 'application/json',
//		method : 'POST'
//	});
	
	var jqXHR = $.ajax({
		url : conversationAjaxUrl,
		dataType : 'json',
		method : 'GET'
	});
	
	jqXHR.done(function(messages) {
		refreshMessages(messages);
		console.log("messages: ", messages);
	});

	jqXHR.fail(function(jqXHR, textStatus) {
		console.log("Could not retrieve messages: ", textStatus);
		
	});

	

}

ConnectionManager.prototype.connectSuccess = function() {

	console.log("Established web socket connection");

	for (var i = 0; i < this.subscriptions.length; i++) {
		var subscription = this.subscriptions[i];

		var inboundDestination = subscription.inboundDestination;
		var newMessageCallback = subscription.newMessageCallback;

		this.client.subscribe(inboundDestination, newMessageCallback);
		console.log(inboundDestination, ": ", newMessageCallback);
	}

}

ConnectionManager.prototype.send = function(outboundDestination, message) {
	
	
	if(this.timedout == true) {
		alert("Connection lost. Please refresh the page");
	}
	else {
		console.log("MAKING REQUEST");
		
		
//		var url = outboundDestination;
//		fetch(url, {
//		  method: 'POST', // or 'PUT'
//		  body: JSON.stringify(message), // data can be `string` or {object}!
//		  headers:{
//		    'Content-Type': 'application/json'
//		  }
//		});
		
		
		this.client.send(outboundDestination, this.headers, JSON.stringify(message));
	}
	
}

ConnectionManager.prototype.addSubscription = function(inboundDestination,
		newMessageCallback) {

	this.subscriptions.push({
		"inboundDestination" : inboundDestination,
		"newMessageCallback" : newMessageCallback
	});

	console.log("add subscription method called");
	console.log("inboundDestination:",  inboundDestination);
	console.log("newMessageCallback:",  newMessageCallback);
}
