package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_MovementInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MovementInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MovementInput.Table_Name;
	}

	public MMovement_BH M_MovementSave(I_M_MovementInput Entity, DataFetchingEnvironment environment) {
		return (MMovement_BH) super.save((X_M_MovementInput) Entity, environment);
	}

	public List<MMovement_BH> M_MovementSaveMany(List<I_M_MovementInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_MovementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMovement_BH) entity).collect(Collectors.toList());
	}

	public boolean M_MovementDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
