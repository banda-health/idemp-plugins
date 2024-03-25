package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosisMapping;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Coded_Diagnosis_MappingInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Coded_Diagnosis_MappingInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Coded_Diagnosis_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Coded_Diagnosis_MappingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Coded_Diagnosis_MappingInput.Table_Name;
	}

	public MBHCodedDiagnosisMapping BH_Coded_Diagnosis_MappingSave(I_BH_Coded_Diagnosis_MappingInput entity, DataFetchingEnvironment environment) {
		return (MBHCodedDiagnosisMapping) super.save((X_BH_Coded_Diagnosis_MappingInput) entity, environment);
	}

	public List<MBHCodedDiagnosisMapping> BH_Coded_Diagnosis_MappingSaveMany(List<I_BH_Coded_Diagnosis_MappingInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_Coded_Diagnosis_MappingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHCodedDiagnosisMapping) entity).collect(Collectors.toList());
	}

	public boolean BH_Coded_Diagnosis_MappingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
