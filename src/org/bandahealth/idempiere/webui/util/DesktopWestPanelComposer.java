package org.bandahealth.idempiere.webui.util;

import org.bandahealth.idempiere.webui.TermsOfService;
import org.compiere.util.CLogger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;
import org.zkoss.zul.West;

public class DesktopWestPanelComposer extends SelectorComposer<Borderlayout> {

	private CLogger logger = CLogger.getCLogger(this.getClass());
	private static final long serialVersionUID = 1L;

	@Wire("#desktop-left-column")
	private West leftPanel;

	@Wire("#windowArea")
	private Center windowArea;
	
	private TermsOfService termsOfService = new TermsOfService();

	public void doAfterCompose(Borderlayout layout) {
		try {
			super.doAfterCompose(layout);
			// TODO:
			//Check if user has accepted ToS
			//If not show ToS panel
			//If yes proceed to load desktop
			
			if(termsOfService.hasAcceptedTermsOfUse())
				return;
			Component c = Executions.createComponents("zul/TermsOfService.zul",null,null);
			Html tos = new Html(termsOfService.getTermsAndConditionsContent());
			c.getFellow("tosText", true).appendChild(tos);
			windowArea.appendChild(c);
		} catch (Exception e) {
			logger.severe("something is seriously BAD!");
			e.printStackTrace();
		}
	}

}
