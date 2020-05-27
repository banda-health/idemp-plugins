package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.IProcessFactory;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.process.*;
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
		} else if (className.equals(InitializeStockProcess.class.getName())) {
			return new InitializeStockProcess();
		} else if (className.equals(ExpenseProcess.class.getName())) {
			return new ExpenseProcess();
		} else if (className.equals(MBHPaymentRef.class.getName())) {
			return new BHPaymentRefProcess();
		} else if (className.equals(InitialBandaClientSetup.class.getName())) {
			return new InitialBandaClientSetup();
		}

		return null;
	}
}
