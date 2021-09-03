package org.bandahealth.idempiere.base.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = OCLCodedDiagnosisDeserializer.class)
public class OCLCodedDiagnosis {

	private String uuid;
	private String id;
	private String externalId;
	private String conceptClass;
	private String datatype;
	private String url;
	private boolean retired;
	private String source;
	private String owner;
	private String ownerType;
	private String displayName;
	private String displayLocale;
	private String version;
	private String updateComment;
	private String locale;
	private String versionCreatedBy;
	private String versionCreatedOn;
	private boolean isLatestVersion;
	private List<OCLCodedDiagnosisMapping> mappings = new ArrayList<OCLCodedDiagnosisMapping>();
	private Map<String, String> extras = new HashMap<String, String>();

	public OCLCodedDiagnosis() {
	}

	public OCLCodedDiagnosis(JsonNode node) {
		setUuid(node.get("uuid").asText());
		setId(node.get("id").asText());
		setExternalId(node.get("external_id").asText());
		setConceptClass(node.get("concept_class").asText());
		setDatatype(node.get("datatype").asText());
		setUrl(node.get("url").asText());
		setRetired(node.get("retired").asBoolean());
		setSource(node.get("source").asText());
		setOwner(node.get("owner").asText());
		setOwnerType(node.get("owner_type").asText());
		setDisplayName(node.get("display_name").asText());
		setDisplayLocale(node.get("display_locale").asText());
		setVersion(node.get("version").asText());
		setUpdateComment(node.get("update_comment").asText());
		setLocale(node.get("locale").asText());
		setVersionCreatedBy(node.get("version_created_by").asText());
		setVersionCreatedOn(node.get("version_created_on").asText());
		setLatestVersion(node.get("is_latest_version").asBoolean());

		StreamSupport.stream(node.get("mappings").spliterator(), false).forEach(mapping -> {
			addMapping(new OCLCodedDiagnosisMapping(mapping));
		});
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getConceptClass() {
		return conceptClass;
	}

	public void setConceptClass(String conceptClass) {
		this.conceptClass = conceptClass;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
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

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayLocale() {
		return displayLocale;
	}

	public void setDisplayLocale(String displayLocale) {
		this.displayLocale = displayLocale;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUpdateComment() {
		return updateComment;
	}

	public void setUpdateComment(String updateComment) {
		this.updateComment = updateComment;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getVersionCreatedBy() {
		return versionCreatedBy;
	}

	public void setVersionCreatedBy(String versionCreatedBy) {
		this.versionCreatedBy = versionCreatedBy;
	}

	public String getVersionCreatedOn() {
		return versionCreatedOn;
	}

	public void setVersionCreatedOn(String versionCreatedOn) {
		this.versionCreatedOn = versionCreatedOn;
	}

	public boolean isLatestVersion() {
		return isLatestVersion;
	}

	public void setLatestVersion(boolean isLatestVersion) {
		this.isLatestVersion = isLatestVersion;
	}

	public List<OCLCodedDiagnosisMapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<OCLCodedDiagnosisMapping> mappings) {
		this.mappings = mappings;
	}

	private void addMapping(OCLCodedDiagnosisMapping mapping) {
		if (this.mappings == null) {
			this.mappings = new ArrayList<OCLCodedDiagnosisMapping>();
		}

		this.mappings.add(mapping);
	}

	public Map<String, String> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, String> extras) {
		this.extras = extras;
	}
}
