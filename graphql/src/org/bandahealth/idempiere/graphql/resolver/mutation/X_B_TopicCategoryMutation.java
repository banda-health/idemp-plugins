package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_TopicCategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_TopicCategoryInput;
import org.compiere.model.X_B_TopicCategory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_TopicCategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicCategoryInput.Table_Name;
	}

	public X_B_TopicCategory B_TopicCategorySave(I_B_TopicCategoryInput entity, DataFetchingEnvironment environment) {
		return (X_B_TopicCategory) super.save((X_B_TopicCategoryInput) entity, environment);
	}

	public List<X_B_TopicCategory> B_TopicCategorySaveMany(List<I_B_TopicCategoryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_B_TopicCategoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_B_TopicCategory) entity).collect(Collectors.toList());
	}

	public boolean B_TopicCategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
