package com.vega.springit.domain;

import com.vega.springit.service.BeanUtil;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class Link extends Auditable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty(message = "Please enter a title.")
    private String title;

    @NonNull
    @NotEmpty(message = "Please enter a url.")
    @URL(message = "Please enter a valid url.")
    private String url;

    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "link")
    private List<Vote> votes = new ArrayList<>();

    private int voteCount = 0;

    @ManyToOne
    private User user;

    
	

	public void addComment(Comment comment) {
        comments.add(comment);
    }
	
	public List<Comment> getComments() {
    	return this.comments;
    }

    public String getDomainName() throws URISyntaxException {
        URI uri = new URI(this.url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

	public void setUser(User u1) {
		// TODO Auto-generated method stub
		this.user = u1;
		
	}
	
	public User getUser() {
    	return this.user;
    }

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id;
		
	}

	public void setVoteCount(int voteCount) {
		// TODO Auto-generated method stub
		this.voteCount = voteCount;
		
	}
	
	public int getVoteCount() {
		// TODO Auto-generated method stub
		return this.voteCount;
	}
	
	public String getTitle() {
    	return this.title;
    }
	
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}
	
	public String getUrl() {
    	return this.url;
    }
	
	public void setUrl(String url) {
		// TODO Auto-generated method stub
		this.url = url;
	}
}
