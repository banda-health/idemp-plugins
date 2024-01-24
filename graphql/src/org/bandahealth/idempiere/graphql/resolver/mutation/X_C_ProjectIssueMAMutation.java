package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectIssueMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectIssueMAInput;
import org.compiere.model.X_C_ProjectIssueMA;

import java.util.List;

/**
 * Generated Query Resolver for C_ProjectIssueMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectIssueMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectIssueMAInput.Table_Name;
	}

	public X_C_ProjectIssueMA C_ProjectIssueMASave(I_C_ProjectIssueMAInput input, DataFetchingEnvironment environment) {
		return (X_C_ProjectIssueMA) super.save((X_C_ProjectIssueMAInput) input, environment);
	}

	public boolean C_ProjectIssueMADelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
