package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PhaseInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PhaseInput;
import org.compiere.model.MProjectTypePhase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PhaseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PhaseInput.Table_Name;
	}

	public MProjectTypePhase C_PhaseSave(I_C_PhaseInput Entity, DataFetchingEnvironment environment) {
		return (MProjectTypePhase) super.save((X_C_PhaseInput) Entity, environment);
	}

	public List<MProjectTypePhase> C_PhaseSaveMany(List<I_C_PhaseInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PhaseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProjectTypePhase) entity).collect(Collectors.toList());
	}

	public boolean C_PhaseDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
