package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueRecommendationInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueRecommendationInput;
import org.compiere.model.X_R_IssueRecommendation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_IssueRecommendation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueRecommendationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueRecommendationInput.Table_Name;
	}

	public X_R_IssueRecommendation R_IssueRecommendationSave(I_R_IssueRecommendationInput entity, DataFetchingEnvironment environment) {
		return (X_R_IssueRecommendation) super.save((X_R_IssueRecommendationInput) entity, environment);
	}

	public List<X_R_IssueRecommendation> R_IssueRecommendationSaveMany(List<I_R_IssueRecommendationInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_R_IssueRecommendationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_IssueRecommendation) entity).collect(Collectors.toList());
	}

	public boolean R_IssueRecommendationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
