package org.bandahealth.idempiere.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseMetadata implements Serializable {

	private static final long serialVersionUID = 1L;
	private int clientId;
	private int orgId;
	private String uuid;
	private boolean isActive = true;
	private String created;
	private int createdBy;

	public BaseMetadata() {
	}

	public BaseMetadata(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy) {
		this.clientId = clientId;
		this.orgId = orgId;
		this.uuid = uuid;
		this.isActive = isActive;
		this.created = created;
		this.createdBy = createdBy;
	}

	@XmlElement
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@XmlElement
	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
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
	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
}