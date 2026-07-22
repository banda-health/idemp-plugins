package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEmployeeComponent;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_ComponentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_EmployeeDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Employee_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Employee_ComponentResolver extends POResolver<MBHEmployeeComponent> implements GraphQLResolver<MBHEmployeeComponent> {


	/**
	 * Get Payroll Component.
	 *
	 * @return Payroll Component
	 */
	public CompletableFuture<MBHPayrollComponent> BH_Payroll_Component(MBHEmployeeComponent entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payroll_Component_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHPayrollComponent> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payroll_ComponentDataLoader.DATALOADER_BH_Payroll_Component_BY_ID);
		return dataLoader.load(entity.getBH_Payroll_Component_ID());
	}

	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	public CompletableFuture<MHREmployee_BH> HR_Employee(MBHEmployeeComponent entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Employee_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MHREmployee_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_EmployeeDataLoader.DATALOADER_HR_Employee_BY_ID);
		return dataLoader.load(entity.getHR_Employee_ID());
	}
}
