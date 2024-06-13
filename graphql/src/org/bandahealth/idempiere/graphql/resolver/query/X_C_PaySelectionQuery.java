package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaySelectionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaySelection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PaySelection - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaySelectionQuery extends POQuery<MPaySelection> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaySelection.Table_Name;
	}

	public CompletableFuture<MPaySelection> C_PaySelection(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPaySelection> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaySelectionDataLoader.DATALOADER_C_PaySelection_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPaySelection> C_PaySelectionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
