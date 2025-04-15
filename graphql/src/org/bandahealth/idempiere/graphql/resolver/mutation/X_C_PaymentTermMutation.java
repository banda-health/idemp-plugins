package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentTermInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentTermInput;
import org.compiere.model.MPaymentTerm;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PaymentTermMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentTermInput.Table_Name;
	}

	public MPaymentTerm C_PaymentTermSave(I_C_PaymentTermInput Entity, DataFetchingEnvironment environment) {
		return (MPaymentTerm) super.save((X_C_PaymentTermInput) Entity, environment);
	}

	public List<MPaymentTerm> C_PaymentTermSaveMany(List<I_C_PaymentTermInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PaymentTermInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaymentTerm) entity).collect(Collectors.toList());
	}

	public boolean C_PaymentTermDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
