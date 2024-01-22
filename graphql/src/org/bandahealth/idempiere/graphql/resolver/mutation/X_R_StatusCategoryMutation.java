package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_StatusCategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_StatusCategoryInput;
import org.compiere.model.MStatusCategory;

import java.util.List;

/**
 * Generated Query Resolver for R_StatusCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_StatusCategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_StatusCategoryInput.Table_Name;
	}

	public MStatusCategory R_StatusCategorySave(I_R_StatusCategoryInput input, DataFetchingEnvironment environment) {
		return (MStatusCategory) super.save((X_R_StatusCategoryInput) input, environment);
	}

	public boolean R_StatusCategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
