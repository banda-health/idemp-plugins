package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSPaymentInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSPaymentInput;
import org.compiere.model.X_C_POSPayment;

import java.util.List;

/**
 * Generated Query Resolver for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSPaymentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSPaymentInput.Table_Name;
	}

	public X_C_POSPayment C_POSPaymentSave(I_C_POSPaymentInput input, DataFetchingEnvironment environment) {
		return (X_C_POSPayment) super.save((X_C_POSPaymentInput) input, environment);
	}

	public boolean C_POSPaymentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
