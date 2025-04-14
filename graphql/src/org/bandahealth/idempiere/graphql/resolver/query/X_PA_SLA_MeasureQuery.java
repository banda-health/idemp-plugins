package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_SLA_MeasureDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_SLA_Measure;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_SLA_MeasureQuery extends POQuery<X_PA_SLA_Measure> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_SLA_Measure.Table_Name;
	}

	public CompletableFuture<X_PA_SLA_Measure> PA_SLA_Measure(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PA_SLA_Measure> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_SLA_MeasureDataLoader.DATALOADER_PA_SLA_Measure_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PA_SLA_Measure> PA_SLA_MeasureGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
