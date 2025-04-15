package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PackageDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackage;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_PackageQuery extends POQuery<MPackage> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackage.Table_Name;
	}

	public CompletableFuture<MPackage> M_Package(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPackage> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PackageDataLoader.DATALOADER_M_Package_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPackage> M_PackageGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
