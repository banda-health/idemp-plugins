package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LotCtlDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLotCtl;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_LotCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_LotCtlQuery extends POQuery<MLotCtl> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLotCtl.Table_Name;
	}

	public CompletableFuture<MLotCtl> M_LotCtl(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLotCtl> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_LotCtlDataLoader.DATALOADER_M_LotCtl_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLotCtl> M_LotCtlGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
