package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_BP_PriceInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_BP_PriceInput;
import org.compiere.model.X_M_BP_Price;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_BP_Price - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_BP_PriceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_BP_PriceInput.Table_Name;
	}

	public X_M_BP_Price M_BP_PriceSave(I_M_BP_PriceInput Entity, DataFetchingEnvironment environment) {
		return (X_M_BP_Price) super.save((X_M_BP_PriceInput) Entity, environment);
	}

	public List<X_M_BP_Price> M_BP_PriceSaveMany(List<I_M_BP_PriceInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_BP_PriceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_BP_Price) entity).collect(Collectors.toList());
	}

	public boolean M_BP_PriceDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
