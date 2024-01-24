package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQ_TopicInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQ_TopicInput;
import org.compiere.model.MRfQTopic;

import java.util.List;

/**
 * Generated Query Resolver for C_RfQ_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQ_TopicMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQ_TopicInput.Table_Name;
	}

	public MRfQTopic C_RfQ_TopicSave(I_C_RfQ_TopicInput input, DataFetchingEnvironment environment) {
		return (MRfQTopic) super.save((X_C_RfQ_TopicInput) input, environment);
	}

	public boolean C_RfQ_TopicDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
