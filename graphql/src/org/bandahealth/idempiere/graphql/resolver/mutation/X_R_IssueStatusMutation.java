package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueStatusInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueStatusInput;
import org.compiere.model.X_R_IssueStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_IssueStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueStatusMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueStatusInput.Table_Name;
	}

	public X_R_IssueStatus R_IssueStatusSave(I_R_IssueStatusInput entity, DataFetchingEnvironment environment) {
		return (X_R_IssueStatus) super.save((X_R_IssueStatusInput) entity, environment);
	}

	public List<X_R_IssueStatus> R_IssueStatusSaveMany(List<I_R_IssueStatusInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_R_IssueStatusInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_IssueStatus) entity).collect(Collectors.toList());
	}

	public boolean R_IssueStatusDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
