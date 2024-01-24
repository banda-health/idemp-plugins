package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQ_TopicSubscriberInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQ_TopicSubscriberInput;
import org.compiere.model.MRfQTopicSubscriber;

import java.util.List;

/**
 * Generated Query Resolver for C_RfQ_TopicSubscriber - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQ_TopicSubscriberMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQ_TopicSubscriberInput.Table_Name;
	}

	public MRfQTopicSubscriber C_RfQ_TopicSubscriberSave(I_C_RfQ_TopicSubscriberInput input, DataFetchingEnvironment environment) {
		return (MRfQTopicSubscriber) super.save((X_C_RfQ_TopicSubscriberInput) input, environment);
	}

	public boolean C_RfQ_TopicSubscriberDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
