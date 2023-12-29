package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Charge_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Charge_AcctInput;
import org.compiere.model.X_C_Charge_Acct;

import java.util.List;

/**
 * Generated Query Resolver for C_Charge_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Charge_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Charge_AcctInput.Table_Name;
	}

	public X_C_Charge_Acct C_Charge_AcctSave(I_C_Charge_AcctInput input, DataFetchingEnvironment environment) {
		return (X_C_Charge_Acct) super.save((X_C_Charge_AcctInput) input, environment);
	}

	public boolean C_Charge_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
