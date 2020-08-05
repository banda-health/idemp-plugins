package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.IProcessFactory;
import org.bandahealth.idempiere.base.process.InitializeStockProcess;
import org.bandahealth.idempiere.base.process.OrderProcess;
import org.bandahealth.idempiere.base.process.StockTakeProcess;
import org.compiere.process.ProcessCall;
import org.compiere.util.CLogger;

public class BHProcessFactory implements IProcessFactory {

	CLogger log = CLogger.getCLogger(BHProcessFactory.class);

	@Override
	public ProcessCall newProcessInstance(String className) {

		if (className.equals(OrderProcess.class.getName())) {
			return new OrderProcess();
		} else if (className.equals(StockTakeProcess.class.getName())) {
			return new StockTakeProcess();
		} else if (className.equals(InitializeStockProcess.class.getName())) {
			return new InitializeStockProcess();
		}

		return null;
	}
}
