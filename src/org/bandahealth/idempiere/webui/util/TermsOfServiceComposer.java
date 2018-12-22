package org.bandahealth.idempiere.webui.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.adempiere.webui.AdempiereWebUI;
import org.adempiere.webui.component.Messagebox;
import org.adempiere.webui.theme.ThemeManager;
import org.bandahealth.idempiere.webui.TermsOfAgreementService;
import org.compiere.util.CLogger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.metainfo.PageDefinition;
import org.zkoss.zk.ui.metainfo.PageDefinitions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
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
	}

	@Listen("onClick = button#rejectBtn")
	public void rejectTermsOfService(Event event) {
		logger.info("Rejecting terms!...");
	}
}
