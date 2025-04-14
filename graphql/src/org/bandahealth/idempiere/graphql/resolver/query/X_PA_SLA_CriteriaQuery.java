package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_SLA_CriteriaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_SLA_Criteria;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_SLA_Criteria - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_SLA_CriteriaQuery extends POQuery<X_PA_SLA_Criteria> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_SLA_Criteria.Table_Name;
	}

	public CompletableFuture<X_PA_SLA_Criteria> PA_SLA_Criteria(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PA_SLA_Criteria> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_SLA_CriteriaDataLoader.DATALOADER_PA_SLA_Criteria_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PA_SLA_Criteria> PA_SLA_CriteriaGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
