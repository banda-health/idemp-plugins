package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindowMapping;
import org.bandahealth.idempiere.rest.utils.DateUtil;

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
		// super(entity); fails fetching the uuid
		
		setClientId(entity.getAD_Client_ID());
		setOrgId(entity.getAD_Org_ID());
		setUuid(entity.getBH_Encounter_Type_Window_Mapping_UU());
		setIsActive(entity.isActive());
		setCreated(DateUtil.parse(entity.getCreated()));
		setCreatedTimestamp(entity.getCreated());
		setCreatedBy(entity.getCreatedBy());
		
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
