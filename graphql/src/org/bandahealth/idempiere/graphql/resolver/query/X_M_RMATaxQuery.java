package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMATaxDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRMATax;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_RMATax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_RMATaxQuery extends POQuery<MRMATax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRMATax.Table_Name;
	}

	public CompletableFuture<MRMATax> M_RMATax(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRMATax> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_RMATaxDataLoader.DATALOADER_M_RMATax_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRMATax> M_RMATaxGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
