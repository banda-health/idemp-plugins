package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementQuery extends POQuery<MMovement_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovement_BH.Table_Name;
	}

	public CompletableFuture<MMovement_BH> M_Movement(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMovement_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_MovementDataLoader.DATALOADER_M_Movement_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMovement_BH> M_MovementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
