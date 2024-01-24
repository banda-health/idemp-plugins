package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_SellerInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_SellerInput;
import org.compiere.model.X_B_Seller;

import java.util.List;

/**
 * Generated Query Resolver for B_Seller - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_SellerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_SellerInput.Table_Name;
	}

	public X_B_Seller B_SellerSave(I_B_SellerInput input, DataFetchingEnvironment environment) {
		return (X_B_Seller) super.save((X_B_SellerInput) input, environment);
	}

	public boolean B_SellerDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
