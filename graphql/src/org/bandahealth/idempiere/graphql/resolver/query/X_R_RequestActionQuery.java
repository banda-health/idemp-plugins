package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestActionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestAction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_RequestAction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestActionQuery extends POQuery<MRequestAction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestAction.Table_Name;
	}

	public CompletableFuture<MRequestAction> R_RequestAction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequestAction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_RequestActionDataLoader.DATALOADER_R_RequestAction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequestAction> R_RequestActionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
