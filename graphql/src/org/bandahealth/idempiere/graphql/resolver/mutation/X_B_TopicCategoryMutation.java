package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_TopicCategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_TopicCategoryInput;
import org.compiere.model.X_B_TopicCategory;

import java.util.List;

/**
 * Generated Query Resolver for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_TopicCategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicCategoryInput.Table_Name;
	}

	public X_B_TopicCategory B_TopicCategorySave(I_B_TopicCategoryInput input, DataFetchingEnvironment environment) {
		return (X_B_TopicCategory) super.save((X_B_TopicCategoryInput) input, environment);
	}

	public boolean B_TopicCategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
