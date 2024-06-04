package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Default_DocAction_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Default_DocAction_AccessQuery extends POQuery<MBHDefaultDocActionAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHDefaultDocActionAccess.Table_Name;
	}

	public CompletableFuture<MBHDefaultDocActionAccess> BH_Default_DocAction_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHDefaultDocActionAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Default_DocAction_AccessDataLoader.DATALOADER_BH_Default_DocAction_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHDefaultDocActionAccess> BH_Default_DocAction_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
