package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRfQTopicSubscriberInput extends X_C_RfQ_TopicSubscriberInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRfQTopicSubscriberInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
