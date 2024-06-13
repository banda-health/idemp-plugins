package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MColor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ColorQuery extends POQuery<MColor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MColor.Table_Name;
	}

	public CompletableFuture<MColor> AD_Color(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MColor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ColorDataLoader.DATALOADER_AD_Color_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MColor> AD_ColorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
