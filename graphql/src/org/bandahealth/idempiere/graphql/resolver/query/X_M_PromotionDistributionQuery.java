package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionDistributionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_PromotionDistribution;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionDistributionQuery extends POQuery<X_M_PromotionDistribution> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionDistribution.Table_Name;
	}

	public CompletableFuture<X_M_PromotionDistribution> M_PromotionDistribution(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_PromotionDistribution> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PromotionDistributionDataLoader.DATALOADER_M_PromotionDistribution_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_PromotionDistribution> M_PromotionDistributionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
