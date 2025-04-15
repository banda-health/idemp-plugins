package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDiscountSchema;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_DiscountSchemaQuery extends POQuery<MDiscountSchema> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDiscountSchema.Table_Name;
	}

	public CompletableFuture<MDiscountSchema> M_DiscountSchema(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDiscountSchema> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDiscountSchema> M_DiscountSchemaGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
