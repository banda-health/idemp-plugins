package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.IProcessFactory;
import org.bandahealth.idempiere.base.process.SalesProcess;
import org.bandahealth.idempiere.base.process.StockTakeProcess;
import org.compiere.process.ProcessCall;
import org.compiere.util.CLogger;

public class BHProcessFactory implements IProcessFactory {

	CLogger log = CLogger.getCLogger(BHProcessFactory.class);

	@Override
	public ProcessCall newProcessInstance(String className) {

		if (className.equals(SalesProcess.class.getName())) {
			return new SalesProcess();
		} else if (className.equals(StockTakeProcess.class.getName())) {
			return new StockTakeProcess();
		}

		return null;
	}
}
