package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankTransferInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankTransferInput;
import org.compiere.model.MBankTransfer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BankTransfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankTransferMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankTransferInput.Table_Name;
	}

	public MBankTransfer C_BankTransferSave(I_C_BankTransferInput entity, DataFetchingEnvironment environment) {
		return (MBankTransfer) super.save((X_C_BankTransferInput) entity, environment);
	}

	public List<MBankTransfer> C_BankTransferSaveMany(List<I_C_BankTransferInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_BankTransferInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBankTransfer) entity).collect(Collectors.toList());
	}

	public boolean C_BankTransferDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
