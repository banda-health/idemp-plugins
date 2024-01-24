package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Process_ParaInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Process_ParaInput;
import org.compiere.model.MProcessPara;

import java.util.List;

/**
 * Generated Query Resolver for AD_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Process_ParaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Process_ParaInput.Table_Name;
	}

	public MProcessPara AD_Process_ParaSave(I_AD_Process_ParaInput input, DataFetchingEnvironment environment) {
		return (MProcessPara) super.save((X_AD_Process_ParaInput) input, environment);
	}

	public boolean AD_Process_ParaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
