package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AcctSchema_GLInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AcctSchema_GLInput;
import org.compiere.model.MAcctSchemaGL;

import java.util.List;

/**
 * Generated Query Resolver for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AcctSchema_GLMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AcctSchema_GLInput.Table_Name;
	}

	public MAcctSchemaGL C_AcctSchema_GLSave(I_C_AcctSchema_GLInput input, DataFetchingEnvironment environment) {
		return (MAcctSchemaGL) super.save((X_C_AcctSchema_GLInput) input, environment);
	}

	public boolean C_AcctSchema_GLDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
