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
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<Book>();

    public Author(){
  	   super();
     }
    
    public Author(String name, String description) {
    	super();
        this.name = name;
        this.description = description;
    }

	public Set<Book> getBooks() {
		// TODO Auto-generated method stub
		return this.books;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
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

}
