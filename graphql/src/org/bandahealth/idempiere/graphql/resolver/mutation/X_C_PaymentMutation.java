package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaymentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentInput.Table_Name;
	}

	public MPayment_BH C_PaymentSave(I_C_PaymentInput entity, DataFetchingEnvironment environment) {
		return (MPayment_BH) super.save((X_C_PaymentInput) entity, environment);
	}

	public List<MPayment_BH> C_PaymentSaveMany(List<I_C_PaymentInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_PaymentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPayment_BH) entity).collect(Collectors.toList());
	}

	public boolean C_PaymentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
