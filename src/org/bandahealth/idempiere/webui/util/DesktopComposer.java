package org.bandahealth.idempiere.webui.util;

import org.bandahealth.idempiere.webui.TermsOfAgreementService;
import org.compiere.util.CLogger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Html;
import org.zkoss.zul.West;
import org.zkoss.zul.Window;

public class DesktopComposer extends SelectorComposer<Borderlayout>{

	private CLogger logger = CLogger.getCLogger(this.getClass());
	private static final long serialVersionUID = 1L;

	@Wire("#desktop-left-column")
	private West leftPanel;

	@Wire("#windowArea")
	private Center windowArea;

	@Wire("#tosWindow")
	private Window window;

	private TermsOfAgreementService termsOfAgreementService = new TermsOfAgreementService();

	public void doAfterCompose(Borderlayout layout) {
		try {
			super.doAfterCompose(layout);
			if (termsOfAgreementService.isAccepted())
				return;
			Component termsOfServiceComponent = Executions.createComponents("zul/TermsOfService.zul", null, null);
			Html termsOfServiceText = new Html(termsOfAgreementService.getTermsAndConditionsContent());
			termsOfServiceComponent.getFellow("tosText", true).appendChild(termsOfServiceText);
			windowArea.appendChild(termsOfServiceComponent);
		} catch (Exception e) {
			logger.severe("Error in DesktopComposer: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
