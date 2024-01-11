package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_FundingMode_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_FundingMode_AcctInput;
import org.compiere.model.X_A_FundingMode_Acct;

import java.util.List;

/**
 * Generated Query Resolver for A_FundingMode_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_FundingMode_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_FundingMode_AcctInput.Table_Name;
	}

	public X_A_FundingMode_Acct A_FundingMode_AcctSave(I_A_FundingMode_AcctInput input, DataFetchingEnvironment environment) {
		return (X_A_FundingMode_Acct) super.save((X_A_FundingMode_AcctInput) input, environment);
	}

	public boolean A_FundingMode_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
