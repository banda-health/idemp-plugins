package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrgAssignmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrgAssignmentInput;
import org.compiere.model.X_C_OrgAssignment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_OrgAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrgAssignmentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrgAssignmentInput.Table_Name;
	}

	public X_C_OrgAssignment C_OrgAssignmentSave(I_C_OrgAssignmentInput entity, DataFetchingEnvironment environment) {
		return (X_C_OrgAssignment) super.save((X_C_OrgAssignmentInput) entity, environment);
	}

	public List<X_C_OrgAssignment> C_OrgAssignmentSaveMany(List<I_C_OrgAssignmentInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_OrgAssignmentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_OrgAssignment) entity).collect(Collectors.toList());
	}

	public boolean C_OrgAssignmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
