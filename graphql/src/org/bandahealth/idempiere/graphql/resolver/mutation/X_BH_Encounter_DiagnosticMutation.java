package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Encounter_DiagnosticInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Encounter_DiagnosticInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Encounter_Diagnostic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Encounter_DiagnosticMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Encounter_DiagnosticInput.Table_Name;
	}

	public MBHEncounterDiagnostic BH_Encounter_DiagnosticSave(I_BH_Encounter_DiagnosticInput Entity, DataFetchingEnvironment environment) {
		return (MBHEncounterDiagnostic) super.save((X_BH_Encounter_DiagnosticInput) Entity, environment);
	}

	public List<MBHEncounterDiagnostic> BH_Encounter_DiagnosticSaveMany(List<I_BH_Encounter_DiagnosticInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Encounter_DiagnosticInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHEncounterDiagnostic) entity).collect(Collectors.toList());
	}

	public boolean BH_Encounter_DiagnosticDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
