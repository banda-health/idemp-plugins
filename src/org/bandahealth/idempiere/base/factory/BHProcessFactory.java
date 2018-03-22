package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.IProcessFactory;
import org.bandahealth.idempiere.base.process.SalesProcess;
import org.compiere.process.ProcessCall;

public class BHProcessFactory implements IProcessFactory {

	@Override
	public ProcessCall newProcessInstance(String className) {

		if (className.equals(SalesProcess.class)) {
			return new SalesProcess();
		}

		return null;
	}
}
