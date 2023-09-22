package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;

@JsonInclude(value = Include.NON_NULL)
public class EncounterTypeWindow extends BaseMetadata {

	private ReferenceList encounterType;
	private Window window;

	private static final long serialVersionUID = 1L;

	public EncounterTypeWindow() {
	}

	public EncounterTypeWindow(MBHEncounterTypeWindow entity) {
		super(entity);
	}

	public ReferenceList getEncounterType() {
		return encounterType;
	}

	public void setEncounterType(ReferenceList encounterType) {
		this.encounterType = encounterType;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
}
