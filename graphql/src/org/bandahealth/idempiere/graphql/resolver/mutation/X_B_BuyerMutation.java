package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_BuyerInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_BuyerInput;
import org.compiere.model.X_B_Buyer;

import java.util.List;

/**
 * Generated Query Resolver for B_Buyer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_B_BuyerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_BuyerInput.Table_Name;
	}

	public X_B_Buyer B_BuyerSave(I_B_BuyerInput input, DataFetchingEnvironment environment) {
		return (X_B_Buyer) super.save((X_B_BuyerInput) input, environment);
	}

	public boolean B_BuyerDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
