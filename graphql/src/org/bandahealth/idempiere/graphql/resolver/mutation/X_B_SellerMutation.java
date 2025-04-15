package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_SellerInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_SellerInput;
import org.compiere.model.X_B_Seller;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for B_Seller - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_B_SellerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_SellerInput.Table_Name;
	}

	public X_B_Seller B_SellerSave(I_B_SellerInput Entity, DataFetchingEnvironment environment) {
		return (X_B_Seller) super.save((X_B_SellerInput) Entity, environment);
	}

	public List<X_B_Seller> B_SellerSaveMany(List<I_B_SellerInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_B_SellerInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_B_Seller) entity).collect(Collectors.toList());
	}

	public boolean B_SellerDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
