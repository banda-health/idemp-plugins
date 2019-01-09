package org.bandahealth.idempiere.webui.forms;

import org.adempiere.webui.panel.ADForm;
import org.compiere.model.MSysConfig;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zul.Iframe;

public class BHKibanaMetricsForm extends ADForm {

	private CLogger	log = CLogger.getCLogger (getClass());
	private static final String BANDA_KIBANA_URL = "BANDA_KIBANA_URL";
	private static final long serialVersionUID = 1L;

	@Override
	protected void initForm() {
		String url = getKibanaURL();
		if (url == null) {
			return;
		}
		
		Iframe metricsIFrame = new Iframe();
		metricsIFrame.setHflex("true");
		metricsIFrame.setVflex("true");
		metricsIFrame.setSrc(url);
		this.appendChild(metricsIFrame);
		log.info("Metrics iframe at url: " + metricsIFrame.getSrc());
	}

	private String getKibanaURL() {
		String url = MSysConfig.getValue(BANDA_KIBANA_URL, "", Env.getAD_Client_ID(Env.getCtx()));
		if (url == null || url.equalsIgnoreCase("")) {
			log.severe("KIBANA URL NOT SET. Kindly create a '" + BANDA_KIBANA_URL + "' config with the correct url for this client");
			return null;
		}
		
		return url;
	}
}
