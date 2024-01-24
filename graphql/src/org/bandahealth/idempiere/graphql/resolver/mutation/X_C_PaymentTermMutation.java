package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentTermInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentTermInput;
import org.compiere.model.MPaymentTerm;

import java.util.List;

/**
 * Generated Query Resolver for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaymentTermMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentTermInput.Table_Name;
	}

	public MPaymentTerm C_PaymentTermSave(I_C_PaymentTermInput input, DataFetchingEnvironment environment) {
		return (MPaymentTerm) super.save((X_C_PaymentTermInput) input, environment);
	}

	public boolean C_PaymentTermDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
