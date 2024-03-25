package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_DepartmentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_EmployeeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ListTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PayrollDataLoader;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Employee;
import org.eevolution.model.X_HR_List;
import org.eevolution.model.X_HR_ListType;
import org.eevolution.model.X_HR_Payroll;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListResolver extends POResolver<X_HR_List> implements GraphQLResolver<X_HR_List> {



	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	public CompletableFuture<X_HR_Department> HR_Department(X_HR_List entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Department_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Department> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_DepartmentDataLoader.DATALOADER_HR_Department_BY_ID);
		return dataLoader.load(entity.getHR_Department_ID());
	}


	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	public CompletableFuture<X_HR_Employee> HR_Employee(X_HR_List entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Employee_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Employee> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_EmployeeDataLoader.DATALOADER_HR_Employee_BY_ID);
		return dataLoader.load(entity.getHR_Employee_ID());
	}


	/**
	 * Get Payroll List Type.
	 *
	 * @return Payroll List Type
	 */
	public CompletableFuture<X_HR_ListType> HR_ListType(X_HR_List entity, DataFetchingEnvironment environment) {
		if (entity.getHR_ListType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_ListType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ListTypeDataLoader.DATALOADER_HR_ListType_BY_ID);
		return dataLoader.load(entity.getHR_ListType_ID());
	}


	/**
	 * Get Payroll.
	 *
	 * @return Payroll
	 */
	public CompletableFuture<X_HR_Payroll> HR_Payroll(X_HR_List entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Payroll_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Payroll> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_PayrollDataLoader.DATALOADER_HR_Payroll_BY_ID);
		return dataLoader.load(entity.getHR_Payroll_ID());
	}

	public Boolean IsEmployee(X_HR_List entity, DataFetchingEnvironment environment) {
		return entity.isEmployee();
	}

}
