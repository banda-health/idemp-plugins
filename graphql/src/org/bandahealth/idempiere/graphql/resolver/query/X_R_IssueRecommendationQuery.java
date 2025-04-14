package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueRecommendationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_IssueRecommendation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_IssueRecommendation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_IssueRecommendationQuery extends POQuery<X_R_IssueRecommendation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueRecommendation.Table_Name;
	}

	public CompletableFuture<X_R_IssueRecommendation> R_IssueRecommendation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_R_IssueRecommendation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_IssueRecommendationDataLoader.DATALOADER_R_IssueRecommendation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_R_IssueRecommendation> R_IssueRecommendationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
