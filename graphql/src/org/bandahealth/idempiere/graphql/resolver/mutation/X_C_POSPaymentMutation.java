package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSPaymentInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSPaymentInput;
import org.compiere.model.MPOSPayment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSPaymentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSPaymentInput.Table_Name;
	}

	public MPOSPayment C_POSPaymentSave(I_C_POSPaymentInput entity, DataFetchingEnvironment environment) {
		return (MPOSPayment) super.save((X_C_POSPaymentInput) entity, environment);
	}

	public List<MPOSPayment> C_POSPaymentSaveMany(List<I_C_POSPaymentInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_POSPaymentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPOSPayment) entity).collect(Collectors.toList());
	}

	public boolean C_POSPaymentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
