package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_Exp_DetailDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageExpDetail;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Package_Exp_DetailQuery extends POQuery<MPackageExpDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageExpDetail.Table_Name;
	}

	public CompletableFuture<MPackageExpDetail> AD_Package_Exp_Detail(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPackageExpDetail> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Package_Exp_DetailDataLoader.DATALOADER_AD_Package_Exp_Detail_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPackageExpDetail> AD_Package_Exp_DetailGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
