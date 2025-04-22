package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_DepartmentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Department;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Department - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_DepartmentQuery extends POQuery<X_HR_Department> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Department.Table_Name;
	}

	public CompletableFuture<X_HR_Department> HR_Department(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Department> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_DepartmentDataLoader.DATALOADER_HR_Department_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Department> HR_DepartmentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
