package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQ;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQ - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQQuery extends POQuery<MRfQ> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQ.Table_Name;
	}

	public CompletableFuture<MRfQ> C_RfQ(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQ> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQDataLoader.DATALOADER_C_RfQ_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQ> C_RfQGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
