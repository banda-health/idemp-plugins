package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHTags;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_TagsDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Tags - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_TagsQuery extends POQuery<MBHTags> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHTags.Table_Name;
	}

	public CompletableFuture<MBHTags> BH_Tags(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHTags> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TagsDataLoader.DATALOADER_BH_Tags_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHTags> BH_TagsGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
