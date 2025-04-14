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
 * @version Release 13 - $Id$
 */
public class X_C_JobCategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_JobCategoryInput.Table_Name;
	}

	public X_C_JobCategory C_JobCategorySave(I_C_JobCategoryInput Entity, DataFetchingEnvironment environment) {
		return (X_C_JobCategory) super.save((X_C_JobCategoryInput) Entity, environment);
	}

	public List<X_C_JobCategory> C_JobCategorySaveMany(List<I_C_JobCategoryInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_JobCategoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_JobCategory) entity).collect(Collectors.toList());
	}

	public boolean C_JobCategoryDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
