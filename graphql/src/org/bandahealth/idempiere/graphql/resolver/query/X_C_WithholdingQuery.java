package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_WithholdingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWithholding;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_WithholdingQuery extends POQuery<MWithholding> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWithholding.Table_Name;
	}

	public CompletableFuture<MWithholding> C_Withholding(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MWithholding> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_WithholdingDataLoader.DATALOADER_C_Withholding_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MWithholding> C_WithholdingGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
