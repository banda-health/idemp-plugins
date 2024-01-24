package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShippingTransactionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShippingTransactionLineInput;
import org.compiere.model.MShippingTransactionLine;

import java.util.List;

/**
 * Generated Query Resolver for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingTransactionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShippingTransactionLineInput.Table_Name;
	}

	public MShippingTransactionLine M_ShippingTransactionLineSave(I_M_ShippingTransactionLineInput input, DataFetchingEnvironment environment) {
		return (MShippingTransactionLine) super.save((X_M_ShippingTransactionLineInput) input, environment);
	}

	public boolean M_ShippingTransactionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
