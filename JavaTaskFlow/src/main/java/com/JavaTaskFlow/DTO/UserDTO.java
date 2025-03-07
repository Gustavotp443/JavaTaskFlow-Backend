package com.JavaTaskFlow.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.LastModifiedDate;

import com.JavaTaskFlow.models.AuthProvider;
import com.JavaTaskFlow.models.Project;
import com.JavaTaskFlow.models.Role;
import com.JavaTaskFlow.models.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private String password; 
	private String profileImageUrl;
	private AuthProvider authProvider; 
	private String companyId; 
	private Role role;  
	private Set<Project> projects = new HashSet<Project>(); 
	private Instant createdAt;
    private Instant updatedAt;
    
	public UserDTO(){}
	
	public UserDTO(User obj) {
		this.id = obj.getId();
	    this.name = obj.getName();
	    this.email = obj.getEmail();
	    this.password = obj.getPassword();
	    this.profileImageUrl = obj.getProfileImageUrl();
	    this.authProvider = obj.getAuthProvider();
	    this.companyId = obj.getCompanyId();
	    this.role = obj.getRole();
	    this.projects = obj.getProjects();
	    this.createdAt = obj.getCreatedAt();
	    this.updatedAt = obj.getUpdatedAt();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public AuthProvider getAuthProvider() {
		return authProvider;
	}

	public void setAuthProvider(AuthProvider authProvider) {
		this.authProvider = authProvider;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}
	
	public Set<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
    	this.projects.add(project);
    }

    
	
}
