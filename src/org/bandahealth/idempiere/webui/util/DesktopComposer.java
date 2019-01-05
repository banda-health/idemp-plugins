package org.bandahealth.idempiere.webui.util;

import org.adempiere.webui.dashboard.DashboardPanel;
import org.bandahealth.idempiere.webui.TermsOfAgreementService;
import org.compiere.util.CLogger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Html;

public class DesktopComposer extends SelectorComposer<DashboardPanel>{

	private CLogger logger = CLogger.getCLogger(this.getClass());
	private static final long serialVersionUID = 1L;

	@Wire("#bandaDashboard")
	private DashboardPanel dashboard;

	private TermsOfAgreementService termsOfAgreementService = new TermsOfAgreementService();

	public void doAfterCompose(DashboardPanel dashboardPanel) {
		try {
			super.doAfterCompose(dashboardPanel);
			if (termsOfAgreementService.isAccepted())
				return;
			Component termsOfServiceComponent = Executions.createComponents("zul/TermsOfService.zul", null, null);
			Html termsOfServiceText = new Html(termsOfAgreementService.getTermsAndConditionsContent());
			termsOfServiceComponent.getFellow("tosText", true).appendChild(termsOfServiceText);
			dashboardPanel.appendChild(termsOfServiceComponent);
		} catch (Exception e) {
			logger.severe("Error in DesktopComposer: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
