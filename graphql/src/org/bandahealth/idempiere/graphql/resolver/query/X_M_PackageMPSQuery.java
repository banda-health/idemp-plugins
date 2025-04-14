package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PackageMPSDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageMPS;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_PackageMPSQuery extends POQuery<MPackageMPS> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageMPS.Table_Name;
	}

	public CompletableFuture<MPackageMPS> M_PackageMPS(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPackageMPS> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PackageMPSDataLoader.DATALOADER_M_PackageMPS_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPackageMPS> M_PackageMPSGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
