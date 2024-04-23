package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHConceptDescription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ConceptDescription extends BaseMetadata {

	private static final long serialVersionUID = -2371895569523894294L;

	@JsonIgnore
	private int conceptId;
	private String locale;
	private String type;
	private String externalId;
	private String name;
	private String descriptionType;

	public ConceptDescription() {
	}

	public ConceptDescription(MBHConceptDescription entity) {
		super(entity);
		setConceptId(entity.getBH_Concept_ID());
		setLocale(entity.getBH_Concept_Locale());
		setType(entity.getBH_Concept_Type());
		setExternalId(entity.getBH_ExternalID());
		setName(entity.getName());
		setDescriptionType(entity.getBH_Concept_Description_Type());
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

	public String getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}
}
