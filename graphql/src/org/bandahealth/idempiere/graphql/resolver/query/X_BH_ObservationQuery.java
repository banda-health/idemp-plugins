package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ObservationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Observation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_ObservationQuery extends POQuery<MBHObservation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHObservation.Table_Name;
	}

	public CompletableFuture<MBHObservation> BH_Observation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHObservation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_ObservationDataLoader.DATALOADER_BH_Observation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHObservation> BH_ObservationGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
