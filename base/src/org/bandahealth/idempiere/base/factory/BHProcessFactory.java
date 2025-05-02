package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.IProcessFactory;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.process.BHPaymentRefProcess;
import org.bandahealth.idempiere.base.process.ImportProductsProcess;
import org.bandahealth.idempiere.base.process.InitialBandaClientSetup;
import org.compiere.process.ProcessCall;
import org.compiere.util.CLogger;

public class BHProcessFactory implements IProcessFactory {

	CLogger log = CLogger.getCLogger(BHProcessFactory.class);

	@Override
	public ProcessCall newProcessInstance(String className) {

		if (className.equals(MBHPaymentRef.class.getName())) {
			return new BHPaymentRefProcess();
		} else if (className.equals(InitialBandaClientSetup.class.getName())) {
			return new InitialBandaClientSetup();
		} else if (className.equals(ImportProductsProcess.class.getName())) {
			return new ImportProductsProcess();
		}

		return null;
	}
}
