package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Ref_ListQuery extends POQuery<MRefList_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRefList_BH.Table_Name;
	}

	public CompletableFuture<MRefList_BH> AD_Ref_List(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRefList_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRefList_BH> AD_Ref_ListGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
