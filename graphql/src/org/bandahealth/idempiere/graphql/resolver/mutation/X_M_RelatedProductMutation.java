package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RelatedProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RelatedProductInput;
import org.compiere.model.X_M_RelatedProduct;

import java.util.List;

/**
 * Generated Query Resolver for M_RelatedProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_RelatedProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RelatedProductInput.Table_Name;
	}

	public X_M_RelatedProduct M_RelatedProductSave(I_M_RelatedProductInput input, DataFetchingEnvironment environment) {
		return (X_M_RelatedProduct) super.save((X_M_RelatedProductInput) input, environment);
	}

	public boolean M_RelatedProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
