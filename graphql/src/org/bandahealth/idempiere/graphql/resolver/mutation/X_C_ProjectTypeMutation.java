package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectTypeInput;
import org.compiere.model.MProjectType;

import java.util.List;

/**
 * Generated Query Resolver for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectTypeInput.Table_Name;
	}

	public MProjectType C_ProjectTypeSave(I_C_ProjectTypeInput input, DataFetchingEnvironment environment) {
		return (MProjectType) super.save((X_C_ProjectTypeInput) input, environment);
	}

	public boolean C_ProjectTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
