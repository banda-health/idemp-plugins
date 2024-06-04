package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostDetailDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCostDetail;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_CostDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostDetailQuery extends POQuery<MCostDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCostDetail.Table_Name;
	}

	public CompletableFuture<MCostDetail> M_CostDetail(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCostDetail> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_CostDetailDataLoader.DATALOADER_M_CostDetail_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCostDetail> M_CostDetailGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
