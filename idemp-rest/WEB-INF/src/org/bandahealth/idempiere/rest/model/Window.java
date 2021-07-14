package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MWindow;

public class Window extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public Window(MWindow window) {
		super(window, window.getName(), window.getDescription(), null);
		
	}

}
