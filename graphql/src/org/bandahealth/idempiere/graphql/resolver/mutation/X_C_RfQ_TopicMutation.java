package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQ_TopicInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQ_TopicInput;
import org.compiere.model.MRfQTopic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RfQ_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQ_TopicMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQ_TopicInput.Table_Name;
	}

	public MRfQTopic C_RfQ_TopicSave(I_C_RfQ_TopicInput Entity, DataFetchingEnvironment environment) {
		return (MRfQTopic) super.save((X_C_RfQ_TopicInput) Entity, environment);
	}

	public List<MRfQTopic> C_RfQ_TopicSaveMany(List<I_C_RfQ_TopicInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RfQ_TopicInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQTopic) entity).collect(Collectors.toList());
	}

	public boolean C_RfQ_TopicDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
