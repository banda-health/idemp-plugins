package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDiscountSchemaLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DiscountSchemaLineQuery extends POQuery<MDiscountSchemaLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDiscountSchemaLine.Table_Name;
	}

	public CompletableFuture<MDiscountSchemaLine> M_DiscountSchemaLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDiscountSchemaLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DiscountSchemaLineDataLoader.DATALOADER_M_DiscountSchemaLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDiscountSchemaLine> M_DiscountSchemaLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
