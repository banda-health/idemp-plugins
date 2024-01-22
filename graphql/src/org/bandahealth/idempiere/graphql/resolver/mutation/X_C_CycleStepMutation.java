package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CycleStepInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CycleStepInput;
import org.compiere.model.X_C_CycleStep;

import java.util.List;

/**
 * Generated Query Resolver for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CycleStepMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CycleStepInput.Table_Name;
	}

	public X_C_CycleStep C_CycleStepSave(I_C_CycleStepInput input, DataFetchingEnvironment environment) {
		return (X_C_CycleStep) super.save((X_C_CycleStepInput) input, environment);
	}

	public boolean C_CycleStepDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
