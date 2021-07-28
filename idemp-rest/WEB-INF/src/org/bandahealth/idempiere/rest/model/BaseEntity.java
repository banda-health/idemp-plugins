package org.bandahealth.idempiere.rest.model;

import org.compiere.model.PO;

import javax.xml.bind.annotation.XmlElement;

public class BaseEntity extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private String description;
	private String name;
	private String value;

	public BaseEntity() {
		super();
	}

	public BaseEntity(PO entity, String name, String description, String value) {
		super(entity);
		this.description = description;
		this.name = name;
		this.value = value;
	}

	public BaseEntity(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
										String name, String description) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.name = name;
		this.description = description;
	}

	public BaseEntity(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
										String name, String description, String value) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.name = name;
		this.description = description;
		this.value = value;
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
