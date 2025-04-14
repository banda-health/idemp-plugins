package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_WinInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_WinInput;
import org.compiere.model.MUserDefWin;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserDef_Win - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDef_WinMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_WinInput.Table_Name;
	}

	public MUserDefWin AD_UserDef_WinSave(I_AD_UserDef_WinInput Entity, DataFetchingEnvironment environment) {
		return (MUserDefWin) super.save((X_AD_UserDef_WinInput) Entity, environment);
	}

	public List<MUserDefWin> AD_UserDef_WinSaveMany(List<I_AD_UserDef_WinInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_UserDef_WinInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserDefWin) entity).collect(Collectors.toList());
	}

	public boolean AD_UserDef_WinDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
