package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AlertDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlert;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertQuery extends POQuery<MAlert> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlert.Table_Name;
	}

	public CompletableFuture<MAlert> AD_Alert(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAlert> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AlertDataLoader.DATALOADER_AD_Alert_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAlert> AD_AlertGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
