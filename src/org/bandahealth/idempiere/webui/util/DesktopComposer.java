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

	private static final long serialVersionUID = 1L;

	@Wire("#bandaDashboard")
	private DashboardPanel dashboard;

	public void doAfterCompose(DashboardPanel dashboardPanel) {
		try {
			super.doAfterCompose(dashboardPanel);
			if (TermsOfUseService.isAccepted()) {
				return;
			}
			Component termsOfServiceComponent = Executions.createComponents("zul/TermsOfUse.zul", null, null);
			Html termsOfServiceText = new Html(TermsOfUseService.getTermsOfUseContent());
			termsOfServiceComponent.getFellow("tosText", true).appendChild(termsOfServiceText);
			dashboardPanel.appendChild(termsOfServiceComponent);
		} catch (Exception e) {
			CLogger.get().severe(e.getMessage());
		}
	}
}
