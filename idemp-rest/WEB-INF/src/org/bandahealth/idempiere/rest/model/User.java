package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private String name;

	public User() {
	}
	
	public User(String uuid) {
		this.setUuid(uuid);
	}
	
	public User(String name, String uuid) {
		this.setName(name);
		this.setUuid(uuid);
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
