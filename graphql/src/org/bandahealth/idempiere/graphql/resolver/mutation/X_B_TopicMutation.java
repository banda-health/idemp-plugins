package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_TopicInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_TopicInput;
import org.compiere.model.X_B_Topic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for B_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_B_TopicMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicInput.Table_Name;
	}

	public X_B_Topic B_TopicSave(I_B_TopicInput Entity, DataFetchingEnvironment environment) {
		return (X_B_Topic) super.save((X_B_TopicInput) Entity, environment);
	}

	public List<X_B_Topic> B_TopicSaveMany(List<I_B_TopicInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_B_TopicInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_B_Topic) entity).collect(Collectors.toList());
	}

	public boolean B_TopicDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
