package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_StorageOnHandDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStorageOnHand;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_StorageOnHand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_StorageOnHandQuery extends POQuery<MStorageOnHand> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStorageOnHand.Table_Name;
	}

	public CompletableFuture<MStorageOnHand> M_StorageOnHand(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStorageOnHand> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_StorageOnHandDataLoader.DATALOADER_M_StorageOnHand_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStorageOnHand> M_StorageOnHandGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
