package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StyleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStyle;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Style - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_StyleQuery extends POQuery<MStyle> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStyle.Table_Name;
	}

	public CompletableFuture<MStyle> AD_Style(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStyle> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_StyleDataLoader.DATALOADER_AD_Style_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStyle> AD_StyleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
