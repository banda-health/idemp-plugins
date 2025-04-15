package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMovementLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_MovementLineQuery extends POQuery<MMovementLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovementLine.Table_Name;
	}

	public CompletableFuture<MMovementLine> M_MovementLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMovementLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_MovementLineDataLoader.DATALOADER_M_MovementLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMovementLine> M_MovementLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
