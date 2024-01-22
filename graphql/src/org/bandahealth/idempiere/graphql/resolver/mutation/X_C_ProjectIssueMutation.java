package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectIssueInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectIssueInput;
import org.compiere.model.MProjectIssue;

import java.util.List;

/**
 * Generated Query Resolver for C_ProjectIssue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectIssueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectIssueInput.Table_Name;
	}

	public MProjectIssue C_ProjectIssueSave(I_C_ProjectIssueInput input, DataFetchingEnvironment environment) {
		return (MProjectIssue) super.save((X_C_ProjectIssueInput) input, environment);
	}

	public boolean C_ProjectIssueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
