package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import org.compiere.model.MTab;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Tab extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private int windowId;

	private List<Field> fields = new ArrayList<>();

	public Tab() {
	}

	public Tab(MTab tab) {
		super(tab);
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
}
