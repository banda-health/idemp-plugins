package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentTransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentTransactionInput;
import org.compiere.model.MPaymentTransaction;

import java.util.List;

/**
 * Generated Query Resolver for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTransactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentTransactionInput.Table_Name;
	}

	public MPaymentTransaction C_PaymentTransactionSave(I_C_PaymentTransactionInput input, DataFetchingEnvironment environment) {
		return (MPaymentTransaction) super.save((X_C_PaymentTransactionInput) input, environment);
	}

	public boolean C_PaymentTransactionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
