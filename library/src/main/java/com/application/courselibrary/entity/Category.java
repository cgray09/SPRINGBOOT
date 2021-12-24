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
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

//    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL) cascade = CascadeType.ALL deletes all related table data
    @ManyToMany(mappedBy = "categories")
    private Set<Book> books = new HashSet<Book>();
    
    public Category(){
    	   super();
    }

    public Category(String name) {
    	super();
        this.name = name;
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
}
