package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_RunDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payroll_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_RunQuery extends POQuery<MBHPayrollRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayrollRun.Table_Name;
	}

	public CompletableFuture<MBHPayrollRun> BH_Payroll_Run(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayrollRun> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payroll_RunDataLoader.DATALOADER_BH_Payroll_Run_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayrollRun> BH_Payroll_RunGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
