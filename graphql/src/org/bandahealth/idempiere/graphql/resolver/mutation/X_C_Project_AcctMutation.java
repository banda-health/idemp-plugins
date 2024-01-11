package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Project_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Project_AcctInput;
import org.compiere.model.X_C_Project_Acct;

import java.util.List;

/**
 * Generated Query Resolver for C_Project_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Project_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Project_AcctInput.Table_Name;
	}

	public X_C_Project_Acct C_Project_AcctSave(I_C_Project_AcctInput input, DataFetchingEnvironment environment) {
		return (X_C_Project_Acct) super.save((X_C_Project_AcctInput) input, environment);
	}

	public boolean C_Project_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
