package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementConfirmDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMovementConfirm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_MovementConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_MovementConfirmQuery extends POQuery<MMovementConfirm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovementConfirm.Table_Name;
	}

	public CompletableFuture<MMovementConfirm> M_MovementConfirm(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMovementConfirm> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_MovementConfirmDataLoader.DATALOADER_M_MovementConfirm_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMovementConfirm> M_MovementConfirmGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
