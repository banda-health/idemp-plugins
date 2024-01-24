package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_JobAssignmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_JobAssignmentInput;
import org.compiere.model.X_C_JobAssignment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_JobAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_JobAssignmentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_JobAssignmentInput.Table_Name;
	}

	public X_C_JobAssignment C_JobAssignmentSave(I_C_JobAssignmentInput entity, DataFetchingEnvironment environment) {
		return (X_C_JobAssignment) super.save((X_C_JobAssignmentInput) entity, environment);
	}

	public List<X_C_JobAssignment> C_JobAssignmentSaveMany(List<I_C_JobAssignmentInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_JobAssignmentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_JobAssignment) entity).collect(Collectors.toList());
	}

	public boolean C_JobAssignmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
