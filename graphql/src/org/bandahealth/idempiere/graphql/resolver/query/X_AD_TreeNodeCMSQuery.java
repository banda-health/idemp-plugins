package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodeCMSDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodeCMS;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNodeCMS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TreeNodeCMSQuery extends POQuery<MTree_NodeCMS> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodeCMS.Table_Name;
	}

	public CompletableFuture<MTree_NodeCMS> AD_TreeNodeCMS(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTree_NodeCMS> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodeCMSDataLoader.DATALOADER_AD_TreeNodeCMS_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTree_NodeCMS> AD_TreeNodeCMSGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
