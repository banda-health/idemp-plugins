package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MatchPODataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMatchPO;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_MatchPO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_MatchPOQuery extends POQuery<MMatchPO> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMatchPO.Table_Name;
	}

	public CompletableFuture<MMatchPO> M_MatchPO(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMatchPO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_MatchPODataLoader.DATALOADER_M_MatchPO_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMatchPO> M_MatchPOGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
