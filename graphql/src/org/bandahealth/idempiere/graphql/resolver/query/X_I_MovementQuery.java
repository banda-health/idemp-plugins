package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_MovementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_I_Movement;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_MovementQuery extends POQuery<X_I_Movement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Movement.Table_Name;
	}

	public CompletableFuture<X_I_Movement> I_Movement(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_Movement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_MovementDataLoader.DATALOADER_I_Movement_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_Movement> I_MovementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
