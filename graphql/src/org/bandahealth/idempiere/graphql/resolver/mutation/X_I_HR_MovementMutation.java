package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_HR_MovementInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_HR_MovementInput;
import org.eevolution.model.X_I_HR_Movement;

import java.util.List;

/**
 * Generated Query Resolver for I_HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_HR_MovementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_HR_MovementInput.Table_Name;
	}

	public X_I_HR_Movement I_HR_MovementSave(I_I_HR_MovementInput input, DataFetchingEnvironment environment) {
		return (X_I_HR_Movement) super.save((X_I_HR_MovementInput) input, environment);
	}

	public boolean I_HR_MovementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
