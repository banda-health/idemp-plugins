package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Coded_DiagnosisInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Coded_DiagnosisInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Coded_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Coded_DiagnosisMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Coded_DiagnosisInput.Table_Name;
	}

	public MBHCodedDiagnosis BH_Coded_DiagnosisSave(I_BH_Coded_DiagnosisInput input, DataFetchingEnvironment environment) {
		return (MBHCodedDiagnosis) super.save((X_BH_Coded_DiagnosisInput) input, environment);
	}

	public boolean BH_Coded_DiagnosisDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
