package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShippingTransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShippingTransactionInput;
import org.compiere.model.MShippingTransaction;

import java.util.List;

/**
 * Generated Query Resolver for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShippingTransactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShippingTransactionInput.Table_Name;
	}

	public MShippingTransaction M_ShippingTransactionSave(I_M_ShippingTransactionInput input, DataFetchingEnvironment environment) {
		return (MShippingTransaction) super.save((X_M_ShippingTransactionInput) input, environment);
	}

	public boolean M_ShippingTransactionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
