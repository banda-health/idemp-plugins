package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectInput;
import org.compiere.model.MProject;

import java.util.List;

/**
 * Generated Query Resolver for C_Project - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectInput.Table_Name;
	}

	public MProject C_ProjectSave(I_C_ProjectInput input, DataFetchingEnvironment environment) {
		return (MProject) super.save((X_C_ProjectInput) input, environment);
	}

	public boolean C_ProjectDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
