package org.bandahealth.idempiere.webui.forms;

import org.adempiere.webui.panel.ADForm;
import org.compiere.util.CLogger;
import org.zkoss.zul.Iframe;

public class BHKibanaMetricsForm extends ADForm {

	private static final long serialVersionUID = 1L;

	Iframe metricsIFrame = new Iframe();
	// TODO Create this url configuration entry in idempiere window and access via
	// db read
	private static final String ELK_URL = "http://192.168.2.12:5601/goto/ea26c2229abe967f65b740194ada2d45?embed=true\" height=\"600\" width=\"800\"";

	private CLogger logger = CLogger.getCLogger(getClass());

	@Override
	protected void initForm() {
		metricsIFrame.setHflex("true");
		metricsIFrame.setVflex("true");
		metricsIFrame.setSrc(ELK_URL);
		this.appendChild(metricsIFrame);
		logger.info("Metrics iframe at url: " + metricsIFrame.getSrc());
	}

}
