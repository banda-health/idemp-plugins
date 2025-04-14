package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_OfferDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_Offer;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for B_Offer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_OfferQuery extends POQuery<X_B_Offer> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_Offer.Table_Name;
	}

	public CompletableFuture<X_B_Offer> B_Offer(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_B_Offer> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_B_OfferDataLoader.DATALOADER_B_Offer_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_B_Offer> B_OfferGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
