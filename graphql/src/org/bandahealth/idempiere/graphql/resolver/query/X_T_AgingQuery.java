package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_AgingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAging;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_Aging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_AgingQuery extends POQuery<MAging> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAging.Table_Name;
	}

	public CompletableFuture<MAging> T_Aging(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAging> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_AgingDataLoader.DATALOADER_T_Aging_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAging> T_AgingGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
