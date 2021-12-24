create table books(
	id bigint not null, 
    isbn varchar(255),
    name varchar(255),
	description varchar(255),
	category_id bigint,
    author_id bigint,
    publisher_id bigint
);

create table categories(
	id bigint not null, 
    name varchar(255),
	category_id bigint
);	

create table authors(
	id bigint not null, 
    name varchar(255),
    description varchar(255),
	book_id bigint
);	

create table books_authors(
	book_id bigint not null, 
    author_id bigint not null
);	

create table books_categories(
	book_id bigint not null, 
    category_id bigint not null
);

create table books_publishers(
	book_id bigint not null, 
    publisher_id bigint not null
);

create table publishers(
	id bigint not null, 
    name varchar(255),
	book_id bigint
);