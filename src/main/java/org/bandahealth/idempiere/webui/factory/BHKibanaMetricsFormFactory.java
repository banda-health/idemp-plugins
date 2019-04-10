package org.bandahealth.idempiere.webui.factory;

import org.adempiere.webui.factory.IFormFactory;
import org.adempiere.webui.panel.ADForm;
import org.bandahealth.idempiere.webui.forms.BHKibanaMetricsForm;
import org.compiere.util.CLogger;

public class BHKibanaMetricsFormFactory implements IFormFactory {

	private CLogger logger = CLogger.getCLogger(getClass());
	
	@Override
	public ADForm newFormInstance(String formName) {
		if(formName.contains("BHKibanaMetricsForm")) {
			logger.info("Loaded dashboard instance "+getClass().getName());
			return new BHKibanaMetricsForm();
		}
		return null;
	}

}
