package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import org.compiere.model.MWindow;

public class Window extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private List<Tab> tabs = new ArrayList<>();

	public Window() {
	}

	public Window(MWindow window) {
		super(window, window.getName(), window.getDescription(), null);
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}
}
