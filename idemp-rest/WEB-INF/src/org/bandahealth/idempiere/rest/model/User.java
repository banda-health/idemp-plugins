package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MRole;

import java.sql.Timestamp;

@XmlRootElement(name = "user")
public class User extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private String name;
	private Timestamp lastLogin;
	private MRole[] roles;

	public User() {
	}
	
	public User(String uuid) {
		this.setUuid(uuid);
	}
	
	public User(String name, String uuid) {
		this.setName(name);
		this.setUuid(uuid);
	}
	
	public User(String name, String uuid, Timestamp createdTimestamp, Timestamp lastLogin) {
		this.setName(name);
		this.setUuid(uuid);
		this.setCreatedTimestamp(createdTimestamp);
		this.setLastLogin(lastLogin);
	}
	
	public User(String name, String uuid, Timestamp createdTimestamp, Timestamp lastLogin, boolean isActive) {
		this.setName(name);
		this.setUuid(uuid);
		this.setCreatedTimestamp(createdTimestamp);
		this.setLastLogin(lastLogin);
		this.setIsActive(isActive);
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public MRole[] getRoles() {
		return roles;
	}

	public void setRoles(MRole[] roles) {
		this.roles = roles;
	}

}
