package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_Process_ParaInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_Process_ParaInput;
import org.compiere.model.X_ASP_Process_Para;

import java.util.List;

/**
 * Generated Query Resolver for ASP_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_Process_ParaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Process_ParaInput.Table_Name;
	}

	public X_ASP_Process_Para ASP_Process_ParaSave(I_ASP_Process_ParaInput input, DataFetchingEnvironment environment) {
		return (X_ASP_Process_Para) super.save((X_ASP_Process_ParaInput) input, environment);
	}

	public boolean ASP_Process_ParaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
