package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentTransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentTransactionInput;
import org.compiere.model.MPaymentTransaction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PaymentTransactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentTransactionInput.Table_Name;
	}

	public MPaymentTransaction C_PaymentTransactionSave(I_C_PaymentTransactionInput Entity, DataFetchingEnvironment environment) {
		return (MPaymentTransaction) super.save((X_C_PaymentTransactionInput) Entity, environment);
	}

	public List<MPaymentTransaction> C_PaymentTransactionSaveMany(List<I_C_PaymentTransactionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PaymentTransactionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaymentTransaction) entity).collect(Collectors.toList());
	}

	public boolean C_PaymentTransactionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
