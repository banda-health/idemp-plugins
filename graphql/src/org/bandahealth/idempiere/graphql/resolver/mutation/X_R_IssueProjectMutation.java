package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueProjectInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueProjectInput;
import org.compiere.model.MIssueProject;

import java.util.List;

/**
 * Generated Query Resolver for R_IssueProject - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_IssueProjectMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueProjectInput.Table_Name;
	}

	public MIssueProject R_IssueProjectSave(I_R_IssueProjectInput input, DataFetchingEnvironment environment) {
		return (MIssueProject) super.save((X_R_IssueProjectInput) input, environment);
	}

	public boolean R_IssueProjectDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
