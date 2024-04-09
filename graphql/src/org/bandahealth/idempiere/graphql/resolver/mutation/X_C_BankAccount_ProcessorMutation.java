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
 * @version Release 11 - $Id$
 */
public class X_C_BankAccount_ProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankAccount_ProcessorInput.Table_Name;
	}

	public MBankAccountProcessor C_BankAccount_ProcessorSave(I_C_BankAccount_ProcessorInput Entity, DataFetchingEnvironment environment) {
		return (MBankAccountProcessor) super.save((X_C_BankAccount_ProcessorInput) Entity, environment);
	}

	public List<MBankAccountProcessor> C_BankAccount_ProcessorSaveMany(List<I_C_BankAccount_ProcessorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BankAccount_ProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBankAccountProcessor) entity).collect(Collectors.toList());
	}

	public boolean C_BankAccount_ProcessorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
