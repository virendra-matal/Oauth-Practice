package com.veer.oauth.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	public Role() {
		super();
	}
	public Role(int roleId, String name, List<User> users) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.users = users;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUsername() {
		return name;
	}
	public void setUsername(String name) {
		this.name = name;
	}
	public List<User> getUser() {
		return users;
	}
	public void setUser(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", user=" + users + "]";
	}
	@Override
	public String getAuthority() {
		return name;
	}
	
	
	
}
