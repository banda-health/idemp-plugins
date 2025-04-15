package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_EDIDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_BP_EDI;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BP_EDI - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BP_EDIQuery extends POQuery<X_C_BP_EDI> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_EDI.Table_Name;
	}

	public CompletableFuture<X_C_BP_EDI> C_BP_EDI(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_BP_EDI> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BP_EDIDataLoader.DATALOADER_C_BP_EDI_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_BP_EDI> C_BP_EDIGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
