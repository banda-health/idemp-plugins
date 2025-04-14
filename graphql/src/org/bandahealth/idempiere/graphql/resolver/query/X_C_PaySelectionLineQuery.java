package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaySelectionLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaySelectionLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PaySelectionLineQuery extends POQuery<MPaySelectionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaySelectionLine.Table_Name;
	}

	public CompletableFuture<MPaySelectionLine> C_PaySelectionLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPaySelectionLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaySelectionLineDataLoader.DATALOADER_C_PaySelectionLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPaySelectionLine> C_PaySelectionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
