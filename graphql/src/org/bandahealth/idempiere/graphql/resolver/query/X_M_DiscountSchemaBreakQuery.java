package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaBreakDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDiscountSchemaBreak;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_DiscountSchemaBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DiscountSchemaBreakQuery extends POQuery<MDiscountSchemaBreak> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDiscountSchemaBreak.Table_Name;
	}

	public CompletableFuture<MDiscountSchemaBreak> M_DiscountSchemaBreak(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDiscountSchemaBreak> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DiscountSchemaBreakDataLoader.DATALOADER_M_DiscountSchemaBreak_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDiscountSchemaBreak> M_DiscountSchemaBreakGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
