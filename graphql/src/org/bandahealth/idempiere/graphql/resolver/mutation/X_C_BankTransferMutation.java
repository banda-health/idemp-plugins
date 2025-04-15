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
 * @version Release 12 - $Id$
 */
public class X_C_BankTransferMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankTransferInput.Table_Name;
	}

	public MBankTransfer C_BankTransferSave(I_C_BankTransferInput Entity, DataFetchingEnvironment environment) {
		return (MBankTransfer) super.save((X_C_BankTransferInput) Entity, environment);
	}

	public List<MBankTransfer> C_BankTransferSaveMany(List<I_C_BankTransferInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BankTransferInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBankTransfer) entity).collect(Collectors.toList());
	}

	public boolean C_BankTransferDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
