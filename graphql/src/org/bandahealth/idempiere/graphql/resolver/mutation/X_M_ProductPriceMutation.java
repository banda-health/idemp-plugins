package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductPriceInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductPriceInput;
import org.compiere.model.MProductPrice;

import java.util.List;

/**
 * Generated Query Resolver for M_ProductPrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductPriceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductPriceInput.Table_Name;
	}

	public MProductPrice M_ProductPriceSave(I_M_ProductPriceInput input, DataFetchingEnvironment environment) {
		return (MProductPrice) super.save((X_M_ProductPriceInput) input, environment);
	}

	public boolean M_ProductPriceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
