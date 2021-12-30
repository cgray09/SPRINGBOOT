package com.vega.springit.domain;

import com.vega.springit.domain.validator.PasswordsMatch;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@PasswordsMatch
@Table(name = "user_accounts")
public class User implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 8, max = 20)
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(length = 100)
    private String password;

    @NonNull
    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    @NonNull
    @NotEmpty(message = "You must enter First Name.")
    private String firstName;

    @NonNull
    @NotEmpty(message = "You must enter Last Name.")
    private String lastName;

    @Transient
    @Setter(AccessLevel.NONE)
    private String fullName;

    @NonNull
    @NotEmpty(message = "Please enter alias.")
    @Column(nullable = false)
    private String alias;

    @Transient
    @NotEmpty(message = "Please enter Password Confirmation")
    private String confirmPassword;

    private String activationCode;
    
     

	
	public String getFullName(){
        return firstName + " " + lastName;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void addRoles(Set<Role> roles) {
        roles.forEach(this::addRole);
    }
    
    public Set<Role> getRoles() {
    	return this.roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	
	public void setPassword(String secret) {
		// TODO Auto-generated method stub
		this.password = secret;
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setConfirmPassword(String secret) {
		// TODO Auto-generated method stub
		this.confirmPassword = secret;
	}
	
	public String getConfirmPassword() {
		// TODO Auto-generated method stub
		return this.confirmPassword;
	}
	
	public void setAlias(String string) {
		// TODO Auto-generated method stub
		this.alias = string;
	}
	
	public String getAlias() {
    	return this.alias;
    }
	
	public void setFirstName(String string) {
		// TODO Auto-generated method stub
		this.firstName = string;
	}
	
	public String getFirstName() {
    	return this.firstName;
    }
	
	public void setLastName(String string) {
		// TODO Auto-generated method stub
		this.lastName = string;
	}
	
	public String getLastName() {
    	return this.lastName;
    }

	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}
	
	public void setEmail(String email) {
    	this.email = email;
    }

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setId(Long id) {
    	this.id = id;
    }

	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		this.enabled = b;
		
	}
	
	public boolean getEnabled() {
    	return this.enabled;
    }

	public void setActivationCode(String string) {
		// TODO Auto-generated method stub
		this.activationCode = string;
	}
	
	public String getActivationCode() {
		// TODO Auto-generated method stub
		return this.activationCode;
	}
}
