package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectPhaseInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectPhaseInput;
import org.compiere.model.MProjectPhase;

import java.util.List;

/**
 * Generated Query Resolver for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectPhaseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectPhaseInput.Table_Name;
	}

	public MProjectPhase C_ProjectPhaseSave(I_C_ProjectPhaseInput input, DataFetchingEnvironment environment) {
		return (MProjectPhase) super.save((X_C_ProjectPhaseInput) input, environment);
	}

	public boolean C_ProjectPhaseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
