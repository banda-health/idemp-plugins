package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_ResourceAssignmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_ResourceAssignmentInput;
import org.compiere.model.MResourceAssignment;

import java.util.List;

/**
 * Generated Query Resolver for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_ResourceAssignmentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_ResourceAssignmentInput.Table_Name;
	}

	public MResourceAssignment S_ResourceAssignmentSave(I_S_ResourceAssignmentInput input, DataFetchingEnvironment environment) {
		return (MResourceAssignment) super.save((X_S_ResourceAssignmentInput) input, environment);
	}

	public boolean S_ResourceAssignmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
