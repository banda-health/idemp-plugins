package org.bandahealth.idempiere.webui.forms;

import org.adempiere.webui.component.Textbox;
import org.adempiere.webui.panel.ADForm;
import org.compiere.util.CLogger;
import org.zkoss.zul.Iframe;

public class BHKibanaMetricsForm extends ADForm {

	private static final long serialVersionUID = 1L;
	
	Textbox txtUrl = new Textbox("Enter some text");
	Iframe metricsIFrame = new Iframe();
	private CLogger logger = CLogger.getCLogger(getClass());
	
	@Override
	protected void initForm() {
		metricsIFrame.setHflex("true");
		metricsIFrame.setVflex("true");
		metricsIFrame.setSrc("http://192.168.2.12:5601/goto/c160f6af330380014928059fc73c620c");
		this.appendChild(metricsIFrame);
		logger.info("Metrics iframe at url: " + metricsIFrame.getSrc());
	}

}
