package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ClientConceptExtra extends BaseMetadata {

	private static final long serialVersionUID = -2371895569523894294L;
	private ConceptExtra conceptExtra;
	@JsonIgnore
	private int conceptExtraId;
	private String value;

	public ClientConceptExtra() {
	}

	public ClientConceptExtra(MBHClientConceptExtra entity) {
		super(entity);

		setConceptExtraId(entity.getBH_Concept_Extra_ID());
		setValue(entity.getBH_Value());
	}

	public ConceptExtra getConceptExtra() {
		return conceptExtra;
	}

	public void setConceptExtra(ConceptExtra conceptExtra) {
		this.conceptExtra = conceptExtra;
	}

	public int getConceptExtraId() {
		return conceptExtraId;
	}

	public void setConceptExtraId(int conceptExtraId) {
		this.conceptExtraId = conceptExtraId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
