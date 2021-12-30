package com.vega.springit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @ManyToMany( mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<User> users;
    
    
    
    
    public void setName(String role) {
    	this.name = role;
    }
    
    public String getName() {
    	return this.name;
    }

}