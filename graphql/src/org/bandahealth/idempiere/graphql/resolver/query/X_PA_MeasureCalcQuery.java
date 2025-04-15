package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_MeasureCalcDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMeasureCalc;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_MeasureCalc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_MeasureCalcQuery extends POQuery<MMeasureCalc> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMeasureCalc.Table_Name;
	}

	public CompletableFuture<MMeasureCalc> PA_MeasureCalc(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMeasureCalc> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_MeasureCalcDataLoader.DATALOADER_PA_MeasureCalc_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMeasureCalc> PA_MeasureCalcGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
