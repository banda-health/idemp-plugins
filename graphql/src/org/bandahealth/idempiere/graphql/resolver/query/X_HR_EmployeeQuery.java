package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_EmployeeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Employee - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_EmployeeQuery extends POQuery<MHREmployee_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MHREmployee_BH.Table_Name;
	}

	public CompletableFuture<MHREmployee_BH> HR_Employee(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MHREmployee_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_EmployeeDataLoader.DATALOADER_HR_Employee_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MHREmployee_BH> HR_EmployeeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
