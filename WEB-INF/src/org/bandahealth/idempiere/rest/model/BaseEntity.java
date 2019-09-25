package org.bandahealth.idempiere.rest.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;

public class BaseEntity extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private String description;
	private String name;

	public BaseEntity() {
		super();
	}

	public BaseEntity(int clientId, int orgId, String uuid, boolean isActive, Timestamp created, int createdBy,
			String name, String description) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.name = name;
		this.description = description;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
