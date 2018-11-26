package org.bandahealth.idempiere.webui.util;

import org.compiere.util.CLogger;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.West;

public class DesktopWestPanelComposer extends SelectorComposer<Borderlayout> {

	private CLogger logger = CLogger.getCLogger(this.getClass());
	private static final long serialVersionUID = 1L;

	@Wire("#desktop-left-column")
	private West leftPanel;
	
	@Wire("#windowArea")
	private Center windowArea;
	

	public void doAfterCompose(Borderlayout layout) {
		try {
			super.doAfterCompose(layout);
			logger.info("Loaded desktop layout");
			//TODO Access panel to add org name as Div
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
