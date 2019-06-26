package org.bandahealth.idempiere.webui.composers;

import org.adempiere.webui.dashboard.DashboardPanel;
import org.bandahealth.idempiere.webui.dataservice.impl.TermsOfUseService;
import org.compiere.util.CLogger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Html;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Vlayout;

public class DashboardTermsOfUseComposer extends SelectorComposer<Vlayout>{

	private static final long serialVersionUID = 1L;

	@Wire("#bhRootDashboardComponent")
	private Vlayout dashboard;

	public void doAfterCompose(Vlayout dashboardPanel) {
		try {
			super.doAfterCompose(dashboardPanel);
			if (TermsOfUseService.isAccepted()) {
				System.out.println("Checking terms!" + TermsOfUseService.isAccepted());
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
