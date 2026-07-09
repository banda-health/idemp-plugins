package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_ComponentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payroll_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_ComponentQuery extends POQuery<MBHPayrollComponent> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayrollComponent.Table_Name;
	}

	public CompletableFuture<MBHPayrollComponent> BH_Payroll_Component(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayrollComponent> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payroll_ComponentDataLoader.DATALOADER_BH_Payroll_Component_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayrollComponent> BH_Payroll_ComponentGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
