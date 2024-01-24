package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CommissionAmtInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CommissionAmtInput;
import org.compiere.model.MCommissionAmt;

import java.util.List;

/**
 * Generated Query Resolver for C_CommissionAmt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CommissionAmtMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CommissionAmtInput.Table_Name;
	}

	public MCommissionAmt C_CommissionAmtSave(I_C_CommissionAmtInput input, DataFetchingEnvironment environment) {
		return (MCommissionAmt) super.save((X_C_CommissionAmtInput) input, environment);
	}

	public boolean C_CommissionAmtDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
