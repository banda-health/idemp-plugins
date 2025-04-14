package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_Proc_ParameterInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_Proc_ParameterInput;
import org.compiere.model.MUserDefProcParameter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDef_Proc_ParameterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_Proc_ParameterInput.Table_Name;
	}

	public MUserDefProcParameter AD_UserDef_Proc_ParameterSave(I_AD_UserDef_Proc_ParameterInput Entity, DataFetchingEnvironment environment) {
		return (MUserDefProcParameter) super.save((X_AD_UserDef_Proc_ParameterInput) Entity, environment);
	}

	public List<MUserDefProcParameter> AD_UserDef_Proc_ParameterSaveMany(List<I_AD_UserDef_Proc_ParameterInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_UserDef_Proc_ParameterInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserDefProcParameter) entity).collect(Collectors.toList());
	}

	public boolean AD_UserDef_Proc_ParameterDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
