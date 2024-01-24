package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CyclePhaseInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CyclePhaseInput;
import org.compiere.model.X_C_CyclePhase;

import java.util.List;

/**
 * Generated Query Resolver for C_CyclePhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CyclePhaseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CyclePhaseInput.Table_Name;
	}

	public X_C_CyclePhase C_CyclePhaseSave(I_C_CyclePhaseInput input, DataFetchingEnvironment environment) {
		return (X_C_CyclePhase) super.save((X_C_CyclePhaseInput) input, environment);
	}

	public boolean C_CyclePhaseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
