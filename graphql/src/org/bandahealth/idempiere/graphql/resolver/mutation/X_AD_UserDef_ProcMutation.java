package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_ProcInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_ProcInput;
import org.compiere.model.MUserDefProc;

import java.util.List;

/**
 * Generated Query Resolver for AD_UserDef_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_ProcMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_ProcInput.Table_Name;
	}

	public MUserDefProc AD_UserDef_ProcSave(I_AD_UserDef_ProcInput input, DataFetchingEnvironment environment) {
		return (MUserDefProc) super.save((X_AD_UserDef_ProcInput) input, environment);
	}

	public boolean AD_UserDef_ProcDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
