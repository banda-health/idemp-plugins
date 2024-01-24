package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRfQTopicSubscriberInput extends X_C_RfQ_TopicSubscriberInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_RfQ_TopicSubscriber_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRfQTopicSubscriberInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
