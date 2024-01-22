package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrgAssignmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrgAssignmentInput;
import org.compiere.model.X_C_OrgAssignment;

import java.util.List;

/**
 * Generated Query Resolver for C_OrgAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrgAssignmentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrgAssignmentInput.Table_Name;
	}

	public X_C_OrgAssignment C_OrgAssignmentSave(I_C_OrgAssignmentInput input, DataFetchingEnvironment environment) {
		return (X_C_OrgAssignment) super.save((X_C_OrgAssignmentInput) input, environment);
	}

	public boolean C_OrgAssignmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
