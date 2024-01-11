package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQ_TopicSubscriberOnlyInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQ_TopicSubscriberOnlyInput;
import org.compiere.model.MRfQTopicSubscriberOnly;

import java.util.List;

/**
 * Generated Query Resolver for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQ_TopicSubscriberOnlyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQ_TopicSubscriberOnlyInput.Table_Name;
	}

	public MRfQTopicSubscriberOnly C_RfQ_TopicSubscriberOnlySave(I_C_RfQ_TopicSubscriberOnlyInput input, DataFetchingEnvironment environment) {
		return (MRfQTopicSubscriberOnly) super.save((X_C_RfQ_TopicSubscriberOnlyInput) input, environment);
	}

	public boolean C_RfQ_TopicSubscriberOnlyDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
