package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetAcct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_AcctQuery extends POQuery<MAssetAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetAcct.Table_Name;
	}

	public CompletableFuture<MAssetAcct> A_Asset_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetAcct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_AcctDataLoader.DATALOADER_A_Asset_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetAcct> A_Asset_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
