package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_MovementLineConfirmInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MovementLineConfirmInput;
import org.compiere.model.MMovementLineConfirm;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_MovementLineConfirmMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MovementLineConfirmInput.Table_Name;
	}

	public MMovementLineConfirm M_MovementLineConfirmSave(I_M_MovementLineConfirmInput Entity, DataFetchingEnvironment environment) {
		return (MMovementLineConfirm) super.save((X_M_MovementLineConfirmInput) Entity, environment);
	}

	public List<MMovementLineConfirm> M_MovementLineConfirmSaveMany(List<I_M_MovementLineConfirmInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_MovementLineConfirmInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMovementLineConfirm) entity).collect(Collectors.toList());
	}

	public boolean M_MovementLineConfirmDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
