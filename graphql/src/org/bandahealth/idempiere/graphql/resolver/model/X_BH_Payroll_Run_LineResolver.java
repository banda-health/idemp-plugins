package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_RunDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_EmployeeDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payroll_Run_Line - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_LineResolver extends POResolver<MBHPayrollRunLine> implements GraphQLResolver<MBHPayrollRunLine> {


	/**
	 * Get Payroll Run.
	 *
	 * @return Payroll Run
	 */
	public CompletableFuture<MBHPayrollRun> BH_Payroll_Run(MBHPayrollRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payroll_Run_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHPayrollRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payroll_RunDataLoader.DATALOADER_BH_Payroll_Run_BY_ID);
		return dataLoader.load(entity.getBH_Payroll_Run_ID());
	}

	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	public CompletableFuture<MHREmployee_BH> HR_Employee(MBHPayrollRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Employee_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MHREmployee_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_EmployeeDataLoader.DATALOADER_HR_Employee_BY_ID);
		return dataLoader.load(entity.getHR_Employee_ID());
	}
}
