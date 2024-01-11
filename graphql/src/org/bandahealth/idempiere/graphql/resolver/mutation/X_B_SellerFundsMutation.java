package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_SellerFundsInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_SellerFundsInput;
import org.compiere.model.X_B_SellerFunds;

import java.util.List;

/**
 * Generated Query Resolver for B_SellerFunds - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_SellerFundsMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_SellerFundsInput.Table_Name;
	}

	public X_B_SellerFunds B_SellerFundsSave(I_B_SellerFundsInput input, DataFetchingEnvironment environment) {
		return (X_B_SellerFunds) super.save((X_B_SellerFundsInput) input, environment);
	}

	public boolean B_SellerFundsDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
