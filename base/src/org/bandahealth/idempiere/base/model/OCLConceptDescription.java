package org.bandahealth.idempiere.base.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.bandahealth.idempiere.base.utils.JsonUtils;

public class OCLConceptDescription {

	private String uuid;
	private String description;
	private String externalId;
	private String type;
	private String locale;
	private boolean localePreferred;
	private String descriptionType;

	public OCLConceptDescription() {
	}

	public OCLConceptDescription(JsonNode node) {
		setUuid(JsonUtils.getValue(node.get("uuid")));
		setDescription(JsonUtils.getValue(node.get("description")));
		setExternalId(JsonUtils.getValue(node.get("external_id")));
		setType(JsonUtils.getValue(node.get("type")));
		setLocale(JsonUtils.getValue(node.get("locale")));
		setLocalePreferred(JsonUtils.getBoolValue(node.get("locale_preferred")));
		setDescriptionType(JsonUtils.getValue(node.get("description_type")));
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public boolean isLocalePreferred() {
		return localePreferred;
	}

	public void setLocalePreferred(boolean localePreferred) {
		this.localePreferred = localePreferred;
	}

	public String getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}
}
