package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Encounter_DiagnosisInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Encounter_DiagnosisInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Encounter_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Encounter_DiagnosisMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Encounter_DiagnosisInput.Table_Name;
	}

	public MBHEncounterDiagnosis BH_Encounter_DiagnosisSave(I_BH_Encounter_DiagnosisInput entity, DataFetchingEnvironment environment) {
		return (MBHEncounterDiagnosis) super.save((X_BH_Encounter_DiagnosisInput) entity, environment);
	}

	public List<MBHEncounterDiagnosis> BH_Encounter_DiagnosisSaveMany(List<I_BH_Encounter_DiagnosisInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_Encounter_DiagnosisInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHEncounterDiagnosis) entity).collect(Collectors.toList());
	}

	public boolean BH_Encounter_DiagnosisDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
