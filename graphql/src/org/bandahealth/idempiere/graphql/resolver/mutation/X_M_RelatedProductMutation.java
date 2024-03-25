package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RelatedProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RelatedProductInput;
import org.compiere.model.X_M_RelatedProduct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_RelatedProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RelatedProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RelatedProductInput.Table_Name;
	}

	public X_M_RelatedProduct M_RelatedProductSave(I_M_RelatedProductInput entity, DataFetchingEnvironment environment) {
		return (X_M_RelatedProduct) super.save((X_M_RelatedProductInput) entity, environment);
	}

	public List<X_M_RelatedProduct> M_RelatedProductSaveMany(List<I_M_RelatedProductInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_RelatedProductInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_RelatedProduct) entity).collect(Collectors.toList());
	}

	public boolean M_RelatedProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
