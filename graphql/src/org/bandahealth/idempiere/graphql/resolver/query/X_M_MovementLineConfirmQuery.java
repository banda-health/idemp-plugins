package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementLineConfirmDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMovementLineConfirm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_MovementLineConfirmQuery extends POQuery<MMovementLineConfirm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovementLineConfirm.Table_Name;
	}

	public CompletableFuture<MMovementLineConfirm> M_MovementLineConfirm(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMovementLineConfirm> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_MovementLineConfirmDataLoader.DATALOADER_M_MovementLineConfirm_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMovementLineConfirm> M_MovementLineConfirmGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
