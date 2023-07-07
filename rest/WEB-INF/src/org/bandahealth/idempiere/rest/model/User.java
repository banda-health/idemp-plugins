package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MUser_BH;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "user")
public class User extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private String name;
	private Timestamp dateLastLogin;
	private List<Role> roles = new ArrayList<>();
	private String resetPassword;

	public User() {
	}

	public User(MUser_BH model) {
		super(model);

		this.setName(model.getName());
		this.setDateLastLogin(model.getDateLastLogin());
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
		this.setDateLastLogin(lastLogin);
	}

	public User(String name, String uuid, Timestamp createdTimestamp, Timestamp lastLogin, boolean isActive,
			List<Role> roles) {
		this.setName(name);
		this.setUuid(uuid);
		this.setCreatedTimestamp(createdTimestamp);
		this.setDateLastLogin(lastLogin);
		this.setIsActive(isActive);
		this.setRoles(roles);
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Timestamp getDateLastLogin() {
		return dateLastLogin;
	}

	public void setDateLastLogin(Timestamp dateLastLogin) {
		this.dateLastLogin = dateLastLogin;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}
}
