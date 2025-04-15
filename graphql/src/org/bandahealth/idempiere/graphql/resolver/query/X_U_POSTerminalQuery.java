package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_POSTerminalDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPOSTerminal;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_POSTerminalQuery extends POQuery<MPOSTerminal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPOSTerminal.Table_Name;
	}

	public CompletableFuture<MPOSTerminal> U_POSTerminal(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPOSTerminal> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_U_POSTerminalDataLoader.DATALOADER_U_POSTerminal_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPOSTerminal> U_POSTerminalGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
