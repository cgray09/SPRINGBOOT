package com.application.courselibrary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", length = 50, nullable = false, unique = true)
    private String isbn;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "books_publishers",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
    private Set<Publisher> publishers = new HashSet<Publisher>();
    
    public Book(){
 	   super();
    }
    
    public Book(String isbn, String name, String description) {
    	super();
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    public void removePublisher(Publisher publisher){
        this.publishers.remove(publisher);
        publisher.getBooks().remove(publisher);
    }

    public void addPublisher(Publisher publisher){
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    public void removeAuthor(Author author){
        this.authors.remove(author);
        author.getBooks().remove(author);
    }

    public void addAuthor(Author author){
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeCategory(Category category){
        this.categories.remove(category);
        category.getBooks().remove(category);
    }

    public void addCategory(Category category){
        this.categories.add(category);
        category.getBooks().add(this);
    }
    
    public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		// TODO Auto-generated method stub
		return this.isbn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}
	
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	public Set<Publisher> getPublishers() {
		return this.publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}
}
