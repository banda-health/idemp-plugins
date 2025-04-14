package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PhaseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectTypePhase;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PhaseQuery extends POQuery<MProjectTypePhase> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectTypePhase.Table_Name;
	}

	public CompletableFuture<MProjectTypePhase> C_Phase(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProjectTypePhase> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PhaseDataLoader.DATALOADER_C_Phase_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProjectTypePhase> C_PhaseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
