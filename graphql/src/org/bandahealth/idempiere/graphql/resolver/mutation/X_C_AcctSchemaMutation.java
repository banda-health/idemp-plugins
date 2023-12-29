package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AcctSchemaInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AcctSchemaInput;
import org.compiere.model.MAcctSchema;

import java.util.List;

/**
 * Generated Query Resolver for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchemaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AcctSchemaInput.Table_Name;
	}

	public MAcctSchema C_AcctSchemaSave(I_C_AcctSchemaInput input, DataFetchingEnvironment environment) {
		return (MAcctSchema) super.save((X_C_AcctSchemaInput) input, environment);
	}

	public boolean C_AcctSchemaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
