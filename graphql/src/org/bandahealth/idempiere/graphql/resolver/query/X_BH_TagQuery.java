package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHTag;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_TagDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Tag - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_TagQuery extends POQuery<MBHTag> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHTag.Table_Name;
	}

	public CompletableFuture<MBHTag> BH_Tag(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHTag> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_TagDataLoader.DATALOADER_BH_Tag_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHTag> BH_TagGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
