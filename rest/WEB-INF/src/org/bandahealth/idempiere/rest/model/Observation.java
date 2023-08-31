package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHObservation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Observation extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private Field field;
	@JsonIgnore
	private int encounterId;
	private int lineNo;
	private String value;

	public Observation() {
	}
	
	public Observation(MBHObservation entity) {
		super(entity);
		
		this.lineNo = entity.getLineNo();
		this.value = entity.getBH_Value();
		this.encounterId = entity.getBH_Encounter_ID();
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
