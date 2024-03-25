package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AddressTransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AddressTransactionInput;
import org.compiere.model.MAddressTransaction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AddressTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AddressTransactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AddressTransactionInput.Table_Name;
	}

	public MAddressTransaction C_AddressTransactionSave(I_C_AddressTransactionInput entity, DataFetchingEnvironment environment) {
		return (MAddressTransaction) super.save((X_C_AddressTransactionInput) entity, environment);
	}

	public List<MAddressTransaction> C_AddressTransactionSaveMany(List<I_C_AddressTransactionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_AddressTransactionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAddressTransaction) entity).collect(Collectors.toList());
	}

	public boolean C_AddressTransactionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
