package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderPayScheduleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrderPaySchedule;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_OrderPayScheduleQuery extends POQuery<MOrderPaySchedule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrderPaySchedule.Table_Name;
	}

	public CompletableFuture<MOrderPaySchedule> C_OrderPaySchedule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOrderPaySchedule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OrderPayScheduleDataLoader.DATALOADER_C_OrderPaySchedule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOrderPaySchedule> C_OrderPayScheduleGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
