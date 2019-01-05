package org.bandahealth.idempiere.webui.util;

import org.adempiere.webui.desktop.IDesktop;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.webui.TermsOfAgreementService;
import org.compiere.util.CLogger;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

public class TermsOfServiceComposer extends SelectorComposer<Window> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire("#tosWindow")
	private Window window;

	private CLogger logger = CLogger.getCLogger(this.getClass());
	private TermsOfAgreementService termsOfAgreementService = new TermsOfAgreementService();

	public void doAfterCompose(Window window) {
		try {
			super.doAfterCompose(window);
			logger.info("doAfterCompose on " + String.valueOf(window.getId()) + "-> " + getClass().getName());
		} catch (Exception e) {
		}
	}

	@Listen("onClick = button#acceptBtn")
	public void acceptTermsOfService(Event event) {
		logger.info("Accepted terms!...");
		termsOfAgreementService.acceptTermsOfUse();
		window.getParent().removeChild(window);
		IDesktop desktop = SessionManager.getAppDesktop();
				desktop.openWindow(1000006, null);
		
	}

	@Listen("onClick = button#rejectBtn")
	public void rejectTermsOfService(Event event) {
		logger.info("Rejecting terms!...");
//		logout user and present login page
	}
}
