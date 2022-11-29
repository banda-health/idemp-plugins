package org.bandahealth.idempiere.base.model;

import org.bandahealth.idempiere.base.utils.JsonUtils;

import com.fasterxml.jackson.databind.JsonNode;

public class OCLCodedDiagnosisMapping {

	private String externalId;
	private boolean retired;
	private String mapType;
	private String source;
	private String owner;
	private String owerType;
	private String fromConceptCode;
	private String fromConceptName;
	private String fromConceptUrl;
	private String toConceptCode;
	private String toConceptName;
	private String toConceptUrl;
	private String fromSourceOwner;
	private String fromSourceOwnerType;
	private String fromSourceUrl;
	private String fromSourceName;
	private String toSourceOwner;
	private String toSourceOwnerType;
	private String toSourceUrl;
	private String toSourceName;
	private String url;
	private String version;
	private String id;
	private int versionedObjectId;
	private String versionedObjectUrl;
	private boolean isLatestVersion;
	private String updateComment;
	private String versionUrl;
	private String uuid;
	private String versionCreatedOn;
	private String fromSourceVersion;
	private String toSourceVersion;
	private String fromConceptNameResolved;
	private String toConceptNameResolved;
	private Object extras;
	private String type;
	private String createdOn;
	private String updatedOn;
	private String createdBy;
	private String updatedBy;
	private String internalReferenceId;
	private boolean publicCanView;

	public OCLCodedDiagnosisMapping() {
	}

	public OCLCodedDiagnosisMapping(JsonNode node) {
		setExternalId(JsonUtils.getValue(node.get("external_id")));
		setRetired(JsonUtils.getBoolValue(node.get("retired")));
		setMapType(JsonUtils.getValue(node.get("map_type")));
		setSource(JsonUtils.getValue(node.get("source")));
		setOwner(JsonUtils.getValue(node.get("owner")));
		setOwerType(JsonUtils.getValue(node.get("owner_type")));
		setFromConceptCode(JsonUtils.getValue(node.get("from_concept_code")));
		setFromConceptName(JsonUtils.getValue(node.get("from_concept_name")));
		setToConceptCode(JsonUtils.getValue(node.get("to_concept_code")));
		setToConceptName(JsonUtils.getValue(node.get("to_concept_name")));
		setToConceptUrl(JsonUtils.getValue(node.get("to_concept_url")));
		setFromSourceOwner(JsonUtils.getValue(node.get("from_source_owner")));
		setFromSourceOwnerType(JsonUtils.getValue(node.get("from_source_owner_type")));
		setFromSourceUrl(JsonUtils.getValue(node.get("from_source_url")));
		setFromSourceName(JsonUtils.getValue(node.get("from_source_name")));
		setToSourceOwner(JsonUtils.getValue(node.get("to_source_owner")));
		setToSourceOwnerType(JsonUtils.getValue(node.get("to_source_owner_type")));
		setToSourceUrl(JsonUtils.getValue(node.get("to_source_url")));
		setToSourceName(JsonUtils.getValue(node.get("to_source_name")));
		setUrl(JsonUtils.getValue(node.get("url")));
		setVersion(JsonUtils.getValue(node.get("version")));
		setId(JsonUtils.getValue(node.get("id")));
		setVersionedObjectId(JsonUtils.getIntValue(node.get("versioned_object_id")));
		setVersionedObjectUrl(JsonUtils.getValue(node.get("versioned_object_url")));
		setLatestVersion(JsonUtils.getBoolValue(node.get("is_latest_version")));
		setUpdateComment(JsonUtils.getValue(node.get("update_comment")));
		setVersionUrl(JsonUtils.getValue(node.get("version_url")));
		setUuid(JsonUtils.getValue(node.get("uuid")));
		setVersionCreatedOn(JsonUtils.getValue(node.get("version_created_on")));
		setFromSourceVersion(JsonUtils.getValue(node.get("from_source_version")));
		setToSourceVersion(JsonUtils.getValue(node.get("to_source_version")));
		setFromConceptNameResolved(JsonUtils.getValue(node.get("from_concept_name_resolved")));
		setToConceptNameResolved(JsonUtils.getValue(node.get("to_concept_name_resolved")));
		setExtras(JsonUtils.getValue(node.get("extras")));
		setType(JsonUtils.getValue(node.get("type")));
		setCreatedOn(JsonUtils.getValue(node.get("created_on")));
		setUpdatedOn(JsonUtils.getValue(node.get("updated_on")));
		setCreatedBy(JsonUtils.getValue(node.get("created_by")));
		setUpdatedBy(JsonUtils.getValue(node.get("updated_by")));
		setInternalReferenceId(JsonUtils.getValue(node.get("internal_reference_id")));
		setPublicCanView(JsonUtils.getBoolValue(node.get("public_can_view")));
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public String getMapType() {
		return mapType;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwerType() {
		return owerType;
	}

	public void setOwerType(String owerType) {
		this.owerType = owerType;
	}

	public String getFromConceptCode() {
		return fromConceptCode;
	}

	public void setFromConceptCode(String fromConceptCode) {
		this.fromConceptCode = fromConceptCode;
	}

	public String getFromConceptName() {
		return fromConceptName;
	}

	public void setFromConceptName(String fromConceptName) {
		this.fromConceptName = fromConceptName;
	}

	public String getFromConceptUrl() {
		return fromConceptUrl;
	}

	public void setFromConceptUrl(String fromConceptUrl) {
		this.fromConceptUrl = fromConceptUrl;
	}

	public String getToConceptCode() {
		return toConceptCode;
	}

	public void setToConceptCode(String toConceptCode) {
		this.toConceptCode = toConceptCode;
	}

	public String getToConceptName() {
		return toConceptName;
	}

	public void setToConceptName(String toConceptName) {
		this.toConceptName = toConceptName;
	}

	public String getToConceptUrl() {
		return toConceptUrl;
	}

	public void setToConceptUrl(String toConceptUrl) {
		this.toConceptUrl = toConceptUrl;
	}

	public String getFromSourceOwner() {
		return fromSourceOwner;
	}

	public void setFromSourceOwner(String fromSourceOwner) {
		this.fromSourceOwner = fromSourceOwner;
	}

	public String getFromSourceOwnerType() {
		return fromSourceOwnerType;
	}

	public void setFromSourceOwnerType(String fromSourceOwnerType) {
		this.fromSourceOwnerType = fromSourceOwnerType;
	}

	public String getFromSourceUrl() {
		return fromSourceUrl;
	}

	public void setFromSourceUrl(String fromSourceUrl) {
		this.fromSourceUrl = fromSourceUrl;
	}

	public String getFromSourceName() {
		return fromSourceName;
	}

	public void setFromSourceName(String fromSourceName) {
		this.fromSourceName = fromSourceName;
	}

	public String getToSourceOwner() {
		return toSourceOwner;
	}

	public void setToSourceOwner(String toSourceOwner) {
		this.toSourceOwner = toSourceOwner;
	}

	public String getToSourceOwnerType() {
		return toSourceOwnerType;
	}

	public void setToSourceOwnerType(String toSourceOwnerType) {
		this.toSourceOwnerType = toSourceOwnerType;
	}

	public String getToSourceUrl() {
		return toSourceUrl;
	}

	public void setToSourceUrl(String toSourceUrl) {
		this.toSourceUrl = toSourceUrl;
	}

	public String getToSourceName() {
		return toSourceName;
	}

	public void setToSourceName(String toSourceName) {
		this.toSourceName = toSourceName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersionedObjectId() {
		return versionedObjectId;
	}

	public void setVersionedObjectId(int versionedObjectId) {
		this.versionedObjectId = versionedObjectId;
	}

	public String getVersionedObjectUrl() {
		return versionedObjectUrl;
	}

	public void setVersionedObjectUrl(String versionedObjectUrl) {
		this.versionedObjectUrl = versionedObjectUrl;
	}

	public boolean isLatestVersion() {
		return isLatestVersion;
	}

	public void setLatestVersion(boolean isLatestVersion) {
		this.isLatestVersion = isLatestVersion;
	}

	public String getUpdateComment() {
		return updateComment;
	}

	public void setUpdateComment(String updateComment) {
		this.updateComment = updateComment;
	}

	public String getVersionUrl() {
		return versionUrl;
	}

	public void setVersionUrl(String versionUrl) {
		this.versionUrl = versionUrl;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getVersionCreatedOn() {
		return versionCreatedOn;
	}

	public void setVersionCreatedOn(String versionCreatedOn) {
		this.versionCreatedOn = versionCreatedOn;
	}

	public String getFromSourceVersion() {
		return fromSourceVersion;
	}

	public void setFromSourceVersion(String fromSourceVersion) {
		this.fromSourceVersion = fromSourceVersion;
	}

	public String getToSourceVersion() {
		return toSourceVersion;
	}

	public void setToSourceVersion(String toSourceVersion) {
		this.toSourceVersion = toSourceVersion;
	}

	public String getFromConceptNameResolved() {
		return fromConceptNameResolved;
	}

	public void setFromConceptNameResolved(String fromConceptNameResolved) {
		this.fromConceptNameResolved = fromConceptNameResolved;
	}

	public String getToConceptNameResolved() {
		return toConceptNameResolved;
	}

	public void setToConceptNameResolved(String toConceptNameResolved) {
		this.toConceptNameResolved = toConceptNameResolved;
	}

	public Object getExtras() {
		return extras;
	}

	public void setExtras(Object extras) {
		this.extras = extras;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getInternalReferenceId() {
		return internalReferenceId;
	}

	public void setInternalReferenceId(String internalReferenceId) {
		this.internalReferenceId = internalReferenceId;
	}

	public boolean isPublicCanView() {
		return publicCanView;
	}

	public void setPublicCanView(boolean publicCaniew) {
		this.publicCanView = publicCaniew;
	}
}
