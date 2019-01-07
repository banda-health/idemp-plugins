package org.bandahealth.idempiere.webui.util;

import org.adempiere.webui.dashboard.DashboardPanel;
import org.bandahealth.idempiere.webui.TermsOfUseService;
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

	private TermsOfUseService termsOfUseService = new TermsOfUseService();

	public void doAfterCompose(DashboardPanel dashboardPanel) {
		try {
			super.doAfterCompose(dashboardPanel);
			if (termsOfUseService.isAccepted())
				return;
			Component termsOfServiceComponent = Executions.createComponents("zul/TermsOfUse.zul", null, null);
			Html termsOfServiceText = new Html(termsOfUseService.getTermsOfUseContent());
			termsOfServiceComponent.getFellow("tosText", true).appendChild(termsOfServiceText);
			dashboardPanel.appendChild(termsOfServiceComponent);
		} catch (Exception e) {
			logger.severe("Error in DesktopComposer: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
