package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_Run_LineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payroll_Run_Line - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_LineQuery extends POQuery<MBHPayrollRunLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayrollRunLine.Table_Name;
	}

	public CompletableFuture<MBHPayrollRunLine> BH_Payroll_Run_Line(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayrollRunLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payroll_Run_LineDataLoader.DATALOADER_BH_Payroll_Run_Line_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayrollRunLine> BH_Payroll_Run_LineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
