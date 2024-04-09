package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectPhaseInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectPhaseInput;
import org.compiere.model.MProjectPhase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectPhaseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectPhaseInput.Table_Name;
	}

	public MProjectPhase C_ProjectPhaseSave(I_C_ProjectPhaseInput Entity, DataFetchingEnvironment environment) {
		return (MProjectPhase) super.save((X_C_ProjectPhaseInput) Entity, environment);
	}

	public List<MProjectPhase> C_ProjectPhaseSaveMany(List<I_C_ProjectPhaseInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ProjectPhaseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProjectPhase) entity).collect(Collectors.toList());
	}

	public boolean C_ProjectPhaseDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
