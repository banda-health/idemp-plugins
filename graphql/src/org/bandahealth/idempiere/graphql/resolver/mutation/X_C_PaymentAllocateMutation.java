package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentAllocateInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaymentAllocateInput;
import org.compiere.model.MPaymentAllocate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaymentAllocateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaymentAllocateInput.Table_Name;
	}

	public MPaymentAllocate C_PaymentAllocateSave(I_C_PaymentAllocateInput entity, DataFetchingEnvironment environment) {
		return (MPaymentAllocate) super.save((X_C_PaymentAllocateInput) entity, environment);
	}

	public List<MPaymentAllocate> C_PaymentAllocateSaveMany(List<I_C_PaymentAllocateInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_PaymentAllocateInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaymentAllocate) entity).collect(Collectors.toList());
	}

	public boolean C_PaymentAllocateDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
