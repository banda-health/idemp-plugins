package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_PaymentInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_PaymentInput;
import org.compiere.model.X_I_Payment;

import java.util.List;

/**
 * Generated Query Resolver for I_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_PaymentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_PaymentInput.Table_Name;
	}

	public X_I_Payment I_PaymentSave(I_I_PaymentInput input, DataFetchingEnvironment environment) {
		return (X_I_Payment) super.save((X_I_PaymentInput) input, environment);
	}

	public boolean I_PaymentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
