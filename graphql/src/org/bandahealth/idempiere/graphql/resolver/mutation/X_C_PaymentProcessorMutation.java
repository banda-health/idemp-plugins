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
 * @version Release 7.1 - $Id$
 */
public class X_C_PaymentProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentProcessorInput.Table_Name;
	}

	public MPaymentProcessor C_PaymentProcessorSave(I_C_PaymentProcessorInput entity, DataFetchingEnvironment environment) {
		return (MPaymentProcessor) super.save((X_C_PaymentProcessorInput) entity, environment);
	}

	public List<MPaymentProcessor> C_PaymentProcessorSaveMany(List<I_C_PaymentProcessorInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_PaymentProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaymentProcessor) entity).collect(Collectors.toList());
	}

	public boolean C_PaymentProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
