package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductPrice_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductPriceInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductPriceInput;

import java.util.List;
import java.util.stream.Collectors;

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

	public MProductPrice_BH M_ProductPriceSave(I_M_ProductPriceInput entity, DataFetchingEnvironment environment) {
		return (MProductPrice_BH) super.save((X_M_ProductPriceInput) entity, environment);
	}

	public List<MProductPrice_BH> M_ProductPriceSaveMany(List<I_M_ProductPriceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_ProductPriceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProductPrice_BH) entity).collect(Collectors.toList());
	}

	public boolean M_ProductPriceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
