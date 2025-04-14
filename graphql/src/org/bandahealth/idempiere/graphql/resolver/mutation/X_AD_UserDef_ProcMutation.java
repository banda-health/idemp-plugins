package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_ProcInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_ProcInput;
import org.compiere.model.MUserDefProc;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserDef_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDef_ProcMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_ProcInput.Table_Name;
	}

	public MUserDefProc AD_UserDef_ProcSave(I_AD_UserDef_ProcInput Entity, DataFetchingEnvironment environment) {
		return (MUserDefProc) super.save((X_AD_UserDef_ProcInput) Entity, environment);
	}

	public List<MUserDefProc> AD_UserDef_ProcSaveMany(List<I_AD_UserDef_ProcInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_UserDef_ProcInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserDefProc) entity).collect(Collectors.toList());
	}

	public boolean AD_UserDef_ProcDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
