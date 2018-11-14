package org.bandahealth.idempiere.webui;

import org.adempiere.webui.dashboard.DashboardPanel;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Vlayout;

public class BHDesktop extends DashboardPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vlayout layout = new Vlayout();
	private Div content = new Div();
	private Label label = new Label("It works");
	
	public BHDesktop() {
		super();
		layout.setParent(this);
		setup();
	}
	
	private void setup() {
		layout.setStyle("background:green; width:100%; height:100%"); 
		content.setStyle("background:green; width:100%; height:100%"); 
		content.appendChild(label);
		layout.appendChild(content);
	}

}
