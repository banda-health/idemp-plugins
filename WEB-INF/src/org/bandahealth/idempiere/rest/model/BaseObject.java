package org.bandahealth.idempiere.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	public BaseObject(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
