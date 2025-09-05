package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Group_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetGroupAcct;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_Group_AcctQuery extends POQuery<MAssetGroupAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetGroupAcct.Table_Name;
	}

	public CompletableFuture<MAssetGroupAcct> A_Asset_Group_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetGroupAcct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Group_AcctDataLoader.DATALOADER_A_Asset_Group_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetGroupAcct> A_Asset_Group_AcctGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
