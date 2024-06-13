package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_StorageReservationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStorageReservation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_StorageReservation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_StorageReservationQuery extends POQuery<MStorageReservation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStorageReservation.Table_Name;
	}

	public CompletableFuture<MStorageReservation> M_StorageReservation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStorageReservation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_StorageReservationDataLoader.DATALOADER_M_StorageReservation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStorageReservation> M_StorageReservationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
