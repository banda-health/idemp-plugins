package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_MovementInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_MovementInput;
import org.eevolution.model.X_I_Movement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_MovementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_MovementInput.Table_Name;
	}

	public X_I_Movement I_MovementSave(I_I_MovementInput entity, DataFetchingEnvironment environment) {
		return (X_I_Movement) super.save((X_I_MovementInput) entity, environment);
	}

	public List<X_I_Movement> I_MovementSaveMany(List<I_I_MovementInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_MovementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_Movement) entity).collect(Collectors.toList());
	}

	public boolean I_MovementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
