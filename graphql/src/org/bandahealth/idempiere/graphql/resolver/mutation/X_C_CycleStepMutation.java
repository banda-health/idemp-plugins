package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CycleStepInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CycleStepInput;
import org.compiere.model.X_C_CycleStep;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CycleStepMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CycleStepInput.Table_Name;
	}

	public X_C_CycleStep C_CycleStepSave(I_C_CycleStepInput entity, DataFetchingEnvironment environment) {
		return (X_C_CycleStep) super.save((X_C_CycleStepInput) entity, environment);
	}

	public List<X_C_CycleStep> C_CycleStepSaveMany(List<I_C_CycleStepInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CycleStepInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_CycleStep) entity).collect(Collectors.toList());
	}

	public boolean C_CycleStepDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
