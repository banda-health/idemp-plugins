package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_FilingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payroll_Filing - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_FilingQuery extends POQuery<MBHPayrollFiling> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayrollFiling.Table_Name;
	}

	public CompletableFuture<MBHPayrollFiling> BH_Payroll_Filing(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayrollFiling> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payroll_FilingDataLoader.DATALOADER_BH_Payroll_Filing_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayrollFiling> BH_Payroll_FilingGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
