package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ZoomConditionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MZoomCondition;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ZoomCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ZoomConditionQuery extends POQuery<MZoomCondition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MZoomCondition.Table_Name;
	}

	public CompletableFuture<MZoomCondition> AD_ZoomCondition(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MZoomCondition> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ZoomConditionDataLoader.DATALOADER_AD_ZoomCondition_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MZoomCondition> AD_ZoomConditionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
