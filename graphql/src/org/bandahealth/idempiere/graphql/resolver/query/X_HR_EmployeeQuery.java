package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_EmployeeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Employee;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Employee - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_EmployeeQuery extends POQuery<X_HR_Employee> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Employee.Table_Name;
	}

	public CompletableFuture<X_HR_Employee> HR_Employee(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Employee> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_EmployeeDataLoader.DATALOADER_HR_Employee_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Employee> HR_EmployeeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
