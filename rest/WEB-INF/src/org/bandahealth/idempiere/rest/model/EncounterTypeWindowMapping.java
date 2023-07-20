package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindowMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class EncounterTypeWindowMapping extends BaseMetadata {

	private String encounterType;

	private Window window;

	private static final long serialVersionUID = 1L;

	public EncounterTypeWindowMapping() {
	}

	public EncounterTypeWindowMapping(MBHEncounterTypeWindowMapping entity) {
		super(entity);
		
		this.encounterType = entity.getBH_EncounterType();
	}

	public String getEncounterType() {
		return encounterType;
	}

	public void setEncounterType(String encounterType) {
		this.encounterType = encounterType;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
}
