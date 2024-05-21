package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectPhaseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectPhase;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectPhaseQuery extends POQuery<MProjectPhase> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectPhase.Table_Name;
	}

	public CompletableFuture<MProjectPhase> C_ProjectPhase(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProjectPhase> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ProjectPhaseDataLoader.DATALOADER_C_ProjectPhase_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProjectPhase> C_ProjectPhaseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
