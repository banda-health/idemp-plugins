package org.bandahealth.idempiere.base.model;

import org.bandahealth.idempiere.base.utils.JsonUtils;

import com.fasterxml.jackson.databind.JsonNode;

public class OCLConceptName {

	private String name;
	private String type;
	private String locale;
	private boolean localePreferred;
	private String nameType;
	private String uuid;
	private String externalId;

	public OCLConceptName() {
	}

	public OCLConceptName(JsonNode node) {
		setName(JsonUtils.getValue(node.get("name")));
		setType(JsonUtils.getValue(node.get("type")));
		setLocale(JsonUtils.getValue(node.get("locale")));
		setLocalePreferred(JsonUtils.getBoolValue(node.get("locale_preferred")));
		setNameType(JsonUtils.getValue(node.get("name_type")));
		setUuid(JsonUtils.getValue(node.get("uuid")));
		setExternalId(JsonUtils.getValue(node.get("external_id")));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
}
