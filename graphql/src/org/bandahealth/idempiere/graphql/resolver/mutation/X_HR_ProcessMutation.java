package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ProcessInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ProcessInput;
import org.eevolution.model.X_HR_Process;

import java.util.List;

/**
 * Generated Query Resolver for HR_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_ProcessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ProcessInput.Table_Name;
	}

	public X_HR_Process HR_ProcessSave(I_HR_ProcessInput input, DataFetchingEnvironment environment) {
		return (X_HR_Process) super.save((X_HR_ProcessInput) input, environment);
	}

	public boolean HR_ProcessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
