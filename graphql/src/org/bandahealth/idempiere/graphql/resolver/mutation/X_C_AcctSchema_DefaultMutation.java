package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AcctSchema_DefaultInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AcctSchema_DefaultInput;
import org.compiere.model.MAcctSchemaDefault;

import java.util.List;

/**
 * Generated Query Resolver for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchema_DefaultMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AcctSchema_DefaultInput.Table_Name;
	}

	public MAcctSchemaDefault C_AcctSchema_DefaultSave(I_C_AcctSchema_DefaultInput input, DataFetchingEnvironment environment) {
		return (MAcctSchemaDefault) super.save((X_C_AcctSchema_DefaultInput) input, environment);
	}

	public boolean C_AcctSchema_DefaultDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
