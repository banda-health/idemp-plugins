package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxCategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxCategoryInput;
import org.compiere.model.MTaxCategory;

import java.util.List;

/**
 * Generated Query Resolver for C_TaxCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxCategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxCategoryInput.Table_Name;
	}

	public MTaxCategory C_TaxCategorySave(I_C_TaxCategoryInput input, DataFetchingEnvironment environment) {
		return (MTaxCategory) super.save((X_C_TaxCategoryInput) input, environment);
	}

	public boolean C_TaxCategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
