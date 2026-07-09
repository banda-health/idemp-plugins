package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_Run_Line_ItemDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payroll_Run_Line_Item - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_Line_ItemQuery extends POQuery<MBHPayrollRunLineItem> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayrollRunLineItem.Table_Name;
	}

	public CompletableFuture<MBHPayrollRunLineItem> BH_Payroll_Run_Line_Item(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayrollRunLineItem> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payroll_Run_Line_ItemDataLoader.DATALOADER_BH_Payroll_Run_Line_Item_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayrollRunLineItem> BH_Payroll_Run_Line_ItemGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
