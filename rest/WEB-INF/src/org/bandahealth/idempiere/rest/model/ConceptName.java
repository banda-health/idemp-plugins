package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHConceptName;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ConceptName extends BaseMetadata {

	private static final long serialVersionUID = -2371895569523894294L;

	@JsonIgnore
	private int conceptId;
	private String locale;
	private String type;
	private String nameType;
	private String externalId;
	private String name;
	private boolean localePreferred;

	public ConceptName() {
	}

	public ConceptName(MBHConceptName entity) {
		super(entity);
		setConceptId(entity.getBH_Concept_ID());
		setLocale(entity.getBH_Concept_Locale());
		setType(entity.getBH_Concept_Type());
		setNameType(entity.getBH_Concept_Name_Type());
		setExternalId(entity.getBH_ExternalID());
		setName(entity.getName());
		setLocalePreferred(entity.isBH_Concept_Locale_Preferred());
	}

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLocalePreferred() {
		return localePreferred;
	}

	public void setLocalePreferred(boolean localePreferred) {
		this.localePreferred = localePreferred;
	}
}
