package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodeBPDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodeBP;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNodeBP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeBPQuery extends POQuery<MTree_NodeBP> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodeBP.Table_Name;
	}

	public CompletableFuture<MTree_NodeBP> AD_TreeNodeBP(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTree_NodeBP> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodeBPDataLoader.DATALOADER_AD_TreeNodeBP_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTree_NodeBP> AD_TreeNodeBPGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
