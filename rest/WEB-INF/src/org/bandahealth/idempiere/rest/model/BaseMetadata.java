package org.bandahealth.idempiere.rest.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.PO;

public class BaseMetadata implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Integer id;
	private Integer clientId;
	private Integer orgId;
	private String uuid;
	private boolean isActive = true;
	private String created;
	@JsonIgnore
	private int createdById;
	private User createdBy;
	@JsonIgnore
	private Integer updatedById;
	private User updatedBy;
	private Timestamp updated;
	private Timestamp createdTimestamp;

	public BaseMetadata() {
	}

	public BaseMetadata(PO entity) {
		id = entity.get_ID();
		clientId = entity.getAD_Client_ID();
		orgId = entity.getAD_Org_ID();
		uuid = entity.get_Value(entity.getUUIDColumnName()).toString();
		isActive = entity.isActive();
		created = DateUtil.parse(entity.getCreated());
		createdTimestamp = entity.getCreated();
		createdById = entity.getCreatedBy();
		setUpdatedById(entity.getUpdatedBy());
		setUpdated(entity.getUpdated());
	}

	public BaseMetadata(Integer clientId, Integer orgId, String uuid, boolean isActive, String created,
			Integer createdById) {
		this.clientId = clientId;
		this.orgId = orgId;
		this.uuid = uuid;
		this.isActive = isActive;
		this.created = created;
		this.createdById = createdById;
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
	public boolean getIsActive() {
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
	public Integer getCreatedById() {
		return createdById;
	}

	@JsonIgnore
	public void setCreatedById(Integer createdById) {
		this.createdById = createdById;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	@JsonIgnore
	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore
	public Integer getUpdatedById() {
		return updatedById;
	}

	@JsonIgnore
	public void setUpdatedById(Integer updatedById) {
		this.updatedById = updatedById;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
}