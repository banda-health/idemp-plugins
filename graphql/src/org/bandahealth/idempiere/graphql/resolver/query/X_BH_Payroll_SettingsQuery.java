package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollSettings;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_SettingsDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payroll_Settings - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_SettingsQuery extends POQuery<MBHPayrollSettings> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayrollSettings.Table_Name;
	}

	public CompletableFuture<MBHPayrollSettings> BH_Payroll_Settings(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayrollSettings> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payroll_SettingsDataLoader.DATALOADER_BH_Payroll_Settings_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayrollSettings> BH_Payroll_SettingsGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
