package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_JobAssignmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_JobAssignmentInput;
import org.compiere.model.X_C_JobAssignment;

import java.util.List;

/**
 * Generated Query Resolver for C_JobAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_JobAssignmentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_JobAssignmentInput.Table_Name;
	}

	public X_C_JobAssignment C_JobAssignmentSave(I_C_JobAssignmentInput input, DataFetchingEnvironment environment) {
		return (X_C_JobAssignment) super.save((X_C_JobAssignmentInput) input, environment);
	}

	public boolean C_JobAssignmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
