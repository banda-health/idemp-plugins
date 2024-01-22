package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_FreightCategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_FreightCategoryInput;
import org.compiere.model.MFreightCategory;

import java.util.List;

/**
 * Generated Query Resolver for M_FreightCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_FreightCategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_FreightCategoryInput.Table_Name;
	}

	public MFreightCategory M_FreightCategorySave(I_M_FreightCategoryInput input, DataFetchingEnvironment environment) {
		return (MFreightCategory) super.save((X_M_FreightCategoryInput) input, environment);
	}

	public boolean M_FreightCategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
