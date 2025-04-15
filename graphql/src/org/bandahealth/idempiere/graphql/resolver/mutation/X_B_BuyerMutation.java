package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_BuyerInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_BuyerInput;
import org.compiere.model.X_B_Buyer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for B_Buyer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_B_BuyerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_BuyerInput.Table_Name;
	}

	public X_B_Buyer B_BuyerSave(I_B_BuyerInput Entity, DataFetchingEnvironment environment) {
		return (X_B_Buyer) super.save((X_B_BuyerInput) Entity, environment);
	}

	public List<X_B_Buyer> B_BuyerSaveMany(List<I_B_BuyerInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_B_BuyerInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_B_Buyer) entity).collect(Collectors.toList());
	}

	public boolean B_BuyerDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
