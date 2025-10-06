package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DemandDetailDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_DemandDetail;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_DemandDetailQuery extends POQuery<X_M_DemandDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_DemandDetail.Table_Name;
	}

	public CompletableFuture<X_M_DemandDetail> M_DemandDetail(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_DemandDetail> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DemandDetailDataLoader.DATALOADER_M_DemandDetail_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_DemandDetail> M_DemandDetailGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
