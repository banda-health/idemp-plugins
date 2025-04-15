package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PackageLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_PackageLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_PackageLineQuery extends POQuery<MPackageLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageLine.Table_Name;
	}

	public CompletableFuture<MPackageLine> M_PackageLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPackageLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PackageLineDataLoader.DATALOADER_M_PackageLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPackageLine> M_PackageLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
