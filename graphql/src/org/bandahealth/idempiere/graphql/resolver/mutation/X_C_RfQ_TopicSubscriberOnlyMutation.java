package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQ_TopicSubscriberOnlyInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQ_TopicSubscriberOnlyInput;
import org.compiere.model.MRfQTopicSubscriberOnly;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_RfQ_TopicSubscriberOnlyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQ_TopicSubscriberOnlyInput.Table_Name;
	}

	public MRfQTopicSubscriberOnly C_RfQ_TopicSubscriberOnlySave(I_C_RfQ_TopicSubscriberOnlyInput Entity, DataFetchingEnvironment environment) {
		return (MRfQTopicSubscriberOnly) super.save((X_C_RfQ_TopicSubscriberOnlyInput) Entity, environment);
	}

	public List<MRfQTopicSubscriberOnly> C_RfQ_TopicSubscriberOnlySaveMany(List<I_C_RfQ_TopicSubscriberOnlyInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RfQ_TopicSubscriberOnlyInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQTopicSubscriberOnly) entity).collect(Collectors.toList());
	}

	public boolean C_RfQ_TopicSubscriberOnlyDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
