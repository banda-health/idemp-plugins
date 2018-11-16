package org.bandahealth.idempiere.webui;

import org.adempiere.webui.component.Borderlayout;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Window;
import org.zkoss.zul.Div;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.West;

public class DashboardMenu extends Borderlayout {

	private static final long serialVersionUID = 1L;
	
	private Vlayout layout = new Vlayout();
	private Div content = new Div();
	private Window window = new Window();
	private Label label = new Label("This is a test of the menu!");
	West westbar = this.getWest();
	
	public DashboardMenu() {
		super();
//		layout.setParent(this);
		setup();
	}
	
	private void setup() {
		layout.setStyle("background:green; width:400px; height:200px"); 
		content.setStyle("background:green; width:100%; height:100%"); 
		content.appendChild(label);
		window.appendChild(content);
		layout.appendChild(window);
		westbar.appendChild(layout);
	}

}
