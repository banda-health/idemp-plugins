package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MRefList;

public class ReferenceList {
	private String uuid;
	private String name;
	private String value;

	public ReferenceList(MRefList model) {
		uuid = model.getAD_Ref_List_UU();
		name = model.getName();
		value = model.getValue();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
