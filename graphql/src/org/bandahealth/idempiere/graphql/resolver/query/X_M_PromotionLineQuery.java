package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_PromotionLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_PromotionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionLineQuery extends POQuery<X_M_PromotionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionLine.Table_Name;
	}

	public CompletableFuture<X_M_PromotionLine> M_PromotionLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_PromotionLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PromotionLineDataLoader.DATALOADER_M_PromotionLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_PromotionLine> M_PromotionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
