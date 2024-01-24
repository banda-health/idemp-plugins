package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_Fact_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_Fact_AcctInput;
import org.compiere.model.MFactAcct;

import java.util.List;

/**
 * Generated Query Resolver for Fact_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_Fact_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_Fact_AcctInput.Table_Name;
	}

	public MFactAcct Fact_AcctSave(I_Fact_AcctInput input, DataFetchingEnvironment environment) {
		return (MFactAcct) super.save((X_Fact_AcctInput) input, environment);
	}

	public boolean Fact_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
