package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankAccount_ProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankAccount_ProcessorInput;
import org.compiere.model.MBankAccountProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BankAccount_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccount_ProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankAccount_ProcessorInput.Table_Name;
	}

	public MBankAccountProcessor C_BankAccount_ProcessorSave(I_C_BankAccount_ProcessorInput entity, DataFetchingEnvironment environment) {
		return (MBankAccountProcessor) super.save((X_C_BankAccount_ProcessorInput) entity, environment);
	}

	public List<MBankAccountProcessor> C_BankAccount_ProcessorSaveMany(List<I_C_BankAccount_ProcessorInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_BankAccount_ProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBankAccountProcessor) entity).collect(Collectors.toList());
	}

	public boolean C_BankAccount_ProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
