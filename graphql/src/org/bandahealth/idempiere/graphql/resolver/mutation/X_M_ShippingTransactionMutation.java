package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShippingTransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShippingTransactionInput;
import org.compiere.model.MShippingTransaction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingTransactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShippingTransactionInput.Table_Name;
	}

	public MShippingTransaction M_ShippingTransactionSave(I_M_ShippingTransactionInput entity, DataFetchingEnvironment environment) {
		return (MShippingTransaction) super.save((X_M_ShippingTransactionInput) entity, environment);
	}

	public List<MShippingTransaction> M_ShippingTransactionSaveMany(List<I_M_ShippingTransactionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_ShippingTransactionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MShippingTransaction) entity).collect(Collectors.toList());
	}

	public boolean M_ShippingTransactionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
