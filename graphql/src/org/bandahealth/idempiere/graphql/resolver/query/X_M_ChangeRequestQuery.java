package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeRequestDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChangeRequest;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ChangeRequestQuery extends POQuery<MChangeRequest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChangeRequest.Table_Name;
	}

	public CompletableFuture<MChangeRequest> M_ChangeRequest(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChangeRequest> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ChangeRequestDataLoader.DATALOADER_M_ChangeRequest_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChangeRequest> M_ChangeRequestGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
