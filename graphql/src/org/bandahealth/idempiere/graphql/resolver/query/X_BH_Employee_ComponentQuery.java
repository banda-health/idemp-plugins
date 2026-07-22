package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEmployeeComponent;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Employee_ComponentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Employee_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Employee_ComponentQuery extends POQuery<MBHEmployeeComponent> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHEmployeeComponent.Table_Name;
	}

	public CompletableFuture<MBHEmployeeComponent> BH_Employee_Component(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHEmployeeComponent> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Employee_ComponentDataLoader.DATALOADER_BH_Employee_Component_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHEmployeeComponent> BH_Employee_ComponentGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
