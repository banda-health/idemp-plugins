package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_WithholdingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_BP_Withholding;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BP_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BP_WithholdingQuery extends POQuery<X_C_BP_Withholding> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_Withholding.Table_Name;
	}

	public CompletableFuture<X_C_BP_Withholding> C_BP_Withholding(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_BP_Withholding> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BP_WithholdingDataLoader.DATALOADER_C_BP_Withholding_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_BP_Withholding> C_BP_WithholdingGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
