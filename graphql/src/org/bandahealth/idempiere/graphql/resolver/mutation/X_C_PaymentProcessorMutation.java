package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentProcessorInput;
import org.compiere.model.MPaymentProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PaymentProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentProcessorInput.Table_Name;
	}

	public MPaymentProcessor C_PaymentProcessorSave(I_C_PaymentProcessorInput Entity, DataFetchingEnvironment environment) {
		return (MPaymentProcessor) super.save((X_C_PaymentProcessorInput) Entity, environment);
	}

	public List<MPaymentProcessor> C_PaymentProcessorSaveMany(List<I_C_PaymentProcessorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PaymentProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaymentProcessor) entity).collect(Collectors.toList());
	}

	public boolean C_PaymentProcessorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
