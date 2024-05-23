package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaySelectionCheckDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaySelectionCheck;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaySelectionCheckQuery extends POQuery<MPaySelectionCheck> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaySelectionCheck.Table_Name;
	}

	public CompletableFuture<MPaySelectionCheck> C_PaySelectionCheck(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPaySelectionCheck> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaySelectionCheckDataLoader.DATALOADER_C_PaySelectionCheck_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPaySelectionCheck> C_PaySelectionCheckGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
