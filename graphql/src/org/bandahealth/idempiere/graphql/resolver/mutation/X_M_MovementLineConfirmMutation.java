package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_MovementLineConfirmInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MovementLineConfirmInput;
import org.compiere.model.MMovementLineConfirm;

import java.util.List;

/**
 * Generated Query Resolver for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_MovementLineConfirmMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MovementLineConfirmInput.Table_Name;
	}

	public MMovementLineConfirm M_MovementLineConfirmSave(I_M_MovementLineConfirmInput input, DataFetchingEnvironment environment) {
		return (MMovementLineConfirm) super.save((X_M_MovementLineConfirmInput) input, environment);
	}

	public boolean M_MovementLineConfirmDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
