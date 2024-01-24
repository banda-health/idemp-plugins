package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AddressTransactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AddressTransactionInput;
import org.compiere.model.MAddressTransaction;

import java.util.List;

/**
 * Generated Query Resolver for C_AddressTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AddressTransactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AddressTransactionInput.Table_Name;
	}

	public MAddressTransaction C_AddressTransactionSave(I_C_AddressTransactionInput input, DataFetchingEnvironment environment) {
		return (MAddressTransaction) super.save((X_C_AddressTransactionInput) input, environment);
	}

	public boolean C_AddressTransactionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
