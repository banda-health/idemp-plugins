package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CyclePhaseInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CyclePhaseInput;
import org.compiere.model.X_C_CyclePhase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CyclePhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CyclePhaseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CyclePhaseInput.Table_Name;
	}

	public X_C_CyclePhase C_CyclePhaseSave(I_C_CyclePhaseInput Entity, DataFetchingEnvironment environment) {
		return (X_C_CyclePhase) super.save((X_C_CyclePhaseInput) Entity, environment);
	}

	public List<X_C_CyclePhase> C_CyclePhaseSaveMany(List<I_C_CyclePhaseInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_CyclePhaseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_CyclePhase) entity).collect(Collectors.toList());
	}

	public boolean C_CyclePhaseDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
