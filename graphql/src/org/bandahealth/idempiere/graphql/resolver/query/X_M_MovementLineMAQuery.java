package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementLineMADataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMovementLineMA;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_MovementLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementLineMAQuery extends POQuery<MMovementLineMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovementLineMA.Table_Name;
	}

	public CompletableFuture<MMovementLineMA> M_MovementLineMA(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMovementLineMA> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_MovementLineMADataLoader.DATALOADER_M_MovementLineMA_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMovementLineMA> M_MovementLineMAGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
