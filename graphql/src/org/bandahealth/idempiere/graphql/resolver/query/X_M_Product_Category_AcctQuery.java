package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_Category_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductCategoryAcct;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Product_Category_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_Product_Category_AcctQuery extends POQuery<MProductCategoryAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductCategoryAcct.Table_Name;
	}

	public CompletableFuture<MProductCategoryAcct> M_Product_Category_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProductCategoryAcct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_Category_AcctDataLoader.DATALOADER_M_Product_Category_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProductCategoryAcct> M_Product_Category_AcctGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
