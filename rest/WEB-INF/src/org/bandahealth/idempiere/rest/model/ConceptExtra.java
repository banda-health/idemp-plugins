package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHConceptExtra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ConceptExtra extends BaseMetadata {

	private static final long serialVersionUID = -2371895569523894294L;

	@JsonIgnore
	private int conceptId;
	@JsonIgnore
	private int conceptMappingId;
	private String key;
	private String value;

	public ConceptExtra() {
	}

	public ConceptExtra(MBHConceptExtra entity) {
		super(entity);
		setConceptId(entity.getBH_Concept_ID());
		setKey(entity.getBH_Key());
		setValue(entity.getBH_Value());
		setConceptMappingId(entity.getBH_Concept_Mapping_ID());
	}

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getConceptMappingId() {
		return conceptMappingId;
	}

	public void setConceptMappingId(int conceptMappingId) {
		this.conceptMappingId = conceptMappingId;
	}
}
