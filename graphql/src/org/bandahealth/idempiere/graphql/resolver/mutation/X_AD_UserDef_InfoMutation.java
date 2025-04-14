package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_InfoInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_InfoInput;
import org.compiere.model.MUserDefInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserDef_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDef_InfoMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_InfoInput.Table_Name;
	}

	public MUserDefInfo AD_UserDef_InfoSave(I_AD_UserDef_InfoInput Entity, DataFetchingEnvironment environment) {
		return (MUserDefInfo) super.save((X_AD_UserDef_InfoInput) Entity, environment);
	}

	public List<MUserDefInfo> AD_UserDef_InfoSaveMany(List<I_AD_UserDef_InfoInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_UserDef_InfoInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserDefInfo) entity).collect(Collectors.toList());
	}

	public boolean AD_UserDef_InfoDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
