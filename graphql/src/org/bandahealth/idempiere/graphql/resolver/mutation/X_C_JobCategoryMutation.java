package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_JobCategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_JobCategoryInput;
import org.compiere.model.X_C_JobCategory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_JobCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_JobCategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_JobCategoryInput.Table_Name;
	}

	public X_C_JobCategory C_JobCategorySave(I_C_JobCategoryInput entity, DataFetchingEnvironment environment) {
		return (X_C_JobCategory) super.save((X_C_JobCategoryInput) entity, environment);
	}

	public List<X_C_JobCategory> C_JobCategorySaveMany(List<I_C_JobCategoryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_JobCategoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_JobCategory) entity).collect(Collectors.toList());
	}

	public boolean C_JobCategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
