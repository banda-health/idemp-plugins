package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_MeasureDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMeasure;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_MeasureQuery extends POQuery<MMeasure> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMeasure.Table_Name;
	}

	public CompletableFuture<MMeasure> PA_Measure(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMeasure> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_MeasureDataLoader.DATALOADER_PA_Measure_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMeasure> PA_MeasureGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
