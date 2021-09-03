package org.bandahealth.idempiere.base.model;

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
	private boolean publicCaniew;

	public OCLCodedDiagnosisMapping() {
	}

	public OCLCodedDiagnosisMapping(JsonNode node) {
		setExternalId(node.get("external_id").asText());
		setRetired(node.get("retired").asBoolean());
		setMapType(node.get("map_type").asText());
		setSource(node.get("source").asText());
		setOwner(node.get("owner").asText());
		setOwerType(node.get("owner_type").asText());
		setFromConceptCode(node.get("from_concept_code").asText());
		setFromConceptName(node.get("from_concept_name").asText());
		setToConceptCode(node.get("to_concept_code").asText());
		setToConceptName(node.get("to_concept_name").asText());
		setToConceptUrl(node.get("to_concept_url").asText());
		setFromSourceOwner(node.get("from_source_owner").asText());
		setFromSourceOwnerType(node.get("from_source_owner_type").asText());
		setFromSourceUrl(node.get("from_source_url").asText());
		setFromSourceName(node.get("from_source_name").asText());
		setToSourceOwner(node.get("to_source_owner").asText());
		setToSourceOwnerType(node.get("to_source_owner_type").asText());
		setToSourceUrl(node.get("to_source_url").asText());
		setToSourceName(node.get("to_source_name").asText());
		setUrl(node.get("url").asText());
		setVersion(node.get("version").asText());
		setId(node.get("id").asText());
		setVersionedObjectId(node.get("versioned_object_id").asInt());
		setVersionedObjectUrl(node.get("versioned_object_url").asText());
		setLatestVersion(node.get("is_latest_version").asBoolean());
		setUpdateComment(node.get("update_comment").asText());
		setVersionUrl(node.get("version_url").asText());
		setUuid(node.get("uuid").asText());
		setVersionCreatedOn(node.get("version_created_on").asText());
		setFromSourceVersion(node.get("from_source_version").asText());
		setToSourceVersion(node.get("to_source_version").asText());
		setFromConceptNameResolved(node.get("from_concept_name_resolved").asText());
		setToConceptNameResolved(
				node.get("to_concept_name_resolved") != null ? node.get("to_concept_name_resolved").asText() : null);
		setExtras(node.get("extras"));
		setType(node.get("type").asText());
		setCreatedOn(node.get("created_on").asText());
		setUpdatedOn(node.get("updated_on").asText());
		setCreatedBy(node.get("created_by").asText());
		setUpdatedBy(node.get("updated_by").asText());
		setInternalReferenceId(node.get("internal_reference_id").asText());
		setPublicCaniew(node.get("public_can_view").asBoolean());
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

	public boolean isPublicCaniew() {
		return publicCaniew;
	}

	public void setPublicCaniew(boolean publicCaniew) {
		this.publicCaniew = publicCaniew;
	}
}
