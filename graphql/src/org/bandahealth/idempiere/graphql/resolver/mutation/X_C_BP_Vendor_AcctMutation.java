package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_Vendor_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_Vendor_AcctInput;
import org.compiere.model.X_C_BP_Vendor_Acct;

import java.util.List;

/**
 * Generated Query Resolver for C_BP_Vendor_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BP_Vendor_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_Vendor_AcctInput.Table_Name;
	}

	public X_C_BP_Vendor_Acct C_BP_Vendor_AcctSave(I_C_BP_Vendor_AcctInput input, DataFetchingEnvironment environment) {
		return (X_C_BP_Vendor_Acct) super.save((X_C_BP_Vendor_AcctInput) input, environment);
	}

	public boolean C_BP_Vendor_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
