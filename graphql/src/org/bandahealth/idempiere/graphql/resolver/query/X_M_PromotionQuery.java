package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_Promotion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Promotion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionQuery extends POQuery<X_M_Promotion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_Promotion.Table_Name;
	}

	public CompletableFuture<X_M_Promotion> M_Promotion(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_Promotion> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PromotionDataLoader.DATALOADER_M_Promotion_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_Promotion> M_PromotionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
