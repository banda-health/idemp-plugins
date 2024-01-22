package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_Warehouse_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_Warehouse_AcctInput;
import org.compiere.model.X_M_Warehouse_Acct;

import java.util.List;

/**
 * Generated Query Resolver for M_Warehouse_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_Warehouse_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_Warehouse_AcctInput.Table_Name;
	}

	public X_M_Warehouse_Acct M_Warehouse_AcctSave(I_M_Warehouse_AcctInput input, DataFetchingEnvironment environment) {
		return (X_M_Warehouse_Acct) super.save((X_M_Warehouse_AcctInput) input, environment);
	}

	public boolean M_Warehouse_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
