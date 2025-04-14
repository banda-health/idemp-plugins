package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_TopicTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_TopicTypeInput;
import org.compiere.model.X_B_TopicType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for B_TopicType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_TopicTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicTypeInput.Table_Name;
	}

	public X_B_TopicType B_TopicTypeSave(I_B_TopicTypeInput Entity, DataFetchingEnvironment environment) {
		return (X_B_TopicType) super.save((X_B_TopicTypeInput) Entity, environment);
	}

	public List<X_B_TopicType> B_TopicTypeSaveMany(List<I_B_TopicTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_B_TopicTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_B_TopicType) entity).collect(Collectors.toList());
	}

	public boolean B_TopicTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
