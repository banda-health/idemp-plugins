package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQ_TopicSubscriberInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQ_TopicSubscriberInput;
import org.compiere.model.MRfQTopicSubscriber;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RfQ_TopicSubscriber - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQ_TopicSubscriberMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQ_TopicSubscriberInput.Table_Name;
	}

	public MRfQTopicSubscriber C_RfQ_TopicSubscriberSave(I_C_RfQ_TopicSubscriberInput Entity, DataFetchingEnvironment environment) {
		return (MRfQTopicSubscriber) super.save((X_C_RfQ_TopicSubscriberInput) Entity, environment);
	}

	public List<MRfQTopicSubscriber> C_RfQ_TopicSubscriberSaveMany(List<I_C_RfQ_TopicSubscriberInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RfQ_TopicSubscriberInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQTopicSubscriber) entity).collect(Collectors.toList());
	}

	public boolean C_RfQ_TopicSubscriberDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
