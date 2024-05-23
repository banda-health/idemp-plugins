package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionGroupLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_PromotionGroupLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionGroupLineQuery extends POQuery<X_M_PromotionGroupLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionGroupLine.Table_Name;
	}

	public CompletableFuture<X_M_PromotionGroupLine> M_PromotionGroupLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_PromotionGroupLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PromotionGroupLineDataLoader.DATALOADER_M_PromotionGroupLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_PromotionGroupLine> M_PromotionGroupLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
