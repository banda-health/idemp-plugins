package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueRecommendationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueStatusDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestDataLoader;
import org.compiere.model.MRequest;
import org.compiere.model.X_R_IssueKnown;
import org.compiere.model.X_R_IssueRecommendation;
import org.compiere.model.X_R_IssueStatus;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_IssueKnownResolver extends POResolver<X_R_IssueKnown> implements GraphQLResolver<X_R_IssueKnown> {


	public Boolean Processing(X_R_IssueKnown entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Issue Recommendation.
	 *
	 * @return Recommendations how to fix an Issue
	 */
	public CompletableFuture<X_R_IssueRecommendation> R_IssueRecommendation(X_R_IssueKnown entity, DataFetchingEnvironment environment) {
		if (entity.getR_IssueRecommendation_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_R_IssueRecommendation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_IssueRecommendationDataLoader.DATALOADER_R_IssueRecommendation_BY_ID);
		return dataLoader.load(entity.getR_IssueRecommendation_ID());
	}


	/**
	 * Get Issue Status.
	 *
	 * @return Status of an Issue
	 */
	public CompletableFuture<X_R_IssueStatus> R_IssueStatus(X_R_IssueKnown entity, DataFetchingEnvironment environment) {
		if (entity.getR_IssueStatus_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_R_IssueStatus> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_IssueStatusDataLoader.DATALOADER_R_IssueStatus_BY_ID);
		return dataLoader.load(entity.getR_IssueStatus_ID());
	}


	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	public CompletableFuture<MRequest> R_Request(X_R_IssueKnown entity, DataFetchingEnvironment environment) {
		if (entity.getR_Request_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestDataLoader.DATALOADER_R_Request_BY_ID);
		return dataLoader.load(entity.getR_Request_ID());
	}

}
