package org.bandahealth.idempiere.webui.util;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.adempiere.webui.component.Messagebox;
import org.bandahealth.idempiere.webui.TermsOfService;
import org.compiere.util.CLogger;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
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
	private TermsOfService termsOfService = new TermsOfService();
	
	public void doAfterCompose(Window window) {
		try {
			super.doAfterCompose(window);
			logger.info("inside tos composer...");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Listen("onClick = button#acceptBtn")
	public void acceptTermsOfService(Event event) {
		logger.info("Accepting terms!...");
		termsOfService.acceptTermsOfUse(window);
		
		Execution exec = Executions.getCurrent();
		HttpServletResponse response = (HttpServletResponse)exec.getNativeResponse();
		try {
			response.sendRedirect(response.encodeRedirectURL("desktop.zul"));
			exec.setVoided(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Listen("onClick = button#rejectBtn")
	public void rejectTermsOfService(Event event) {
		logger.info("Rejecting terms!...");
			Executions.getCurrent().sendRedirect("login.zul");
	}
}
