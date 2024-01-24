package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueUserInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueUserInput;
import org.compiere.model.MIssueUser;

import java.util.List;

/**
 * Generated Query Resolver for R_IssueUser - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_IssueUserMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueUserInput.Table_Name;
	}

	public MIssueUser R_IssueUserSave(I_R_IssueUserInput input, DataFetchingEnvironment environment) {
		return (MIssueUser) super.save((X_R_IssueUserInput) input, environment);
	}

	public boolean R_IssueUserDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
