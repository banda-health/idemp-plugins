package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_Customer_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_Customer_AcctInput;
import org.compiere.model.X_C_BP_Customer_Acct;

import java.util.List;

/**
 * Generated Query Resolver for C_BP_Customer_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_Customer_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_Customer_AcctInput.Table_Name;
	}

	public X_C_BP_Customer_Acct C_BP_Customer_AcctSave(I_C_BP_Customer_AcctInput input, DataFetchingEnvironment environment) {
		return (X_C_BP_Customer_Acct) super.save((X_C_BP_Customer_AcctInput) input, environment);
	}

	public boolean C_BP_Customer_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
