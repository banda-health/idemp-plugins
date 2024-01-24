package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_TopicTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_TopicTypeInput;
import org.compiere.model.X_B_TopicType;

import java.util.List;

/**
 * Generated Query Resolver for B_TopicType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_TopicTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicTypeInput.Table_Name;
	}

	public X_B_TopicType B_TopicTypeSave(I_B_TopicTypeInput input, DataFetchingEnvironment environment) {
		return (X_B_TopicType) super.save((X_B_TopicTypeInput) input, environment);
	}

	public boolean B_TopicTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
