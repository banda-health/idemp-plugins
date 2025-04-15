package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_MovementInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_MovementInput;
import org.eevolution.model.X_HR_Movement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_MovementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_MovementInput.Table_Name;
	}

	public X_HR_Movement HR_MovementSave(I_HR_MovementInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_Movement) super.save((X_HR_MovementInput) Entity, environment);
	}

	public List<X_HR_Movement> HR_MovementSaveMany(List<I_HR_MovementInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_MovementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Movement) entity).collect(Collectors.toList());
	}

	public boolean HR_MovementDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
