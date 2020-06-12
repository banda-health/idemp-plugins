package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;

public class BaseEntity extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private String description;
	private String name;
	private String value;

	public BaseEntity() {
		super();
	}

	public BaseEntity(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
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

	@XmlElement
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
