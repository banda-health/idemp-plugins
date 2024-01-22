package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PhaseInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PhaseInput;
import org.compiere.model.MProjectTypePhase;

import java.util.List;

/**
 * Generated Query Resolver for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PhaseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PhaseInput.Table_Name;
	}

	public MProjectTypePhase C_PhaseSave(I_C_PhaseInput input, DataFetchingEnvironment environment) {
		return (MProjectTypePhase) super.save((X_C_PhaseInput) input, environment);
	}

	public boolean C_PhaseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
