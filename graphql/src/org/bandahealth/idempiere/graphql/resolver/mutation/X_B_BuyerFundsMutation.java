package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_BuyerFundsInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_BuyerFundsInput;
import org.compiere.model.X_B_BuyerFunds;

import java.util.List;

/**
 * Generated Query Resolver for B_BuyerFunds - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BuyerFundsMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_BuyerFundsInput.Table_Name;
	}

	public X_B_BuyerFunds B_BuyerFundsSave(I_B_BuyerFundsInput input, DataFetchingEnvironment environment) {
		return (X_B_BuyerFunds) super.save((X_B_BuyerFundsInput) input, environment);
	}

	public boolean B_BuyerFundsDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
