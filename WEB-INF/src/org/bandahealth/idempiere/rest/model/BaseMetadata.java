package org.bandahealth.idempiere.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseMetadata implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer clientId;
	private Integer orgId;
	private String uuid;
	private boolean isActive = true;
	private String created;
	private int createdBy;

	public BaseMetadata() {
	}

	public BaseMetadata(Integer clientId, Integer orgId, String uuid, boolean isActive, String created,
			Integer createdBy) {
		this.clientId = clientId;
		this.orgId = orgId;
		this.uuid = uuid;
		this.isActive = isActive;
		this.created = created;
		this.createdBy = createdBy;
	}

	@XmlElement
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@XmlElement
	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@XmlElement
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@XmlElement
	public boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@XmlElement
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	@JsonIgnore
	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
}