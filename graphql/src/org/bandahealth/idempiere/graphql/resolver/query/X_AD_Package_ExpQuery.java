package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_ExpDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageExp;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Package_ExpQuery extends POQuery<MPackageExp> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageExp.Table_Name;
	}

	public CompletableFuture<MPackageExp> AD_Package_Exp(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPackageExp> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Package_ExpDataLoader.DATALOADER_AD_Package_Exp_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPackageExp> AD_Package_ExpGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
