package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_MovementConfirmInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MovementConfirmInput;
import org.compiere.model.MMovementConfirm;

import java.util.List;

/**
 * Generated Query Resolver for M_MovementConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementConfirmMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MovementConfirmInput.Table_Name;
	}

	public MMovementConfirm M_MovementConfirmSave(I_M_MovementConfirmInput input, DataFetchingEnvironment environment) {
		return (MMovementConfirm) super.save((X_M_MovementConfirmInput) input, environment);
	}

	public boolean M_MovementConfirmDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
