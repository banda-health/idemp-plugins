package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRfQTopicSubscriberOnlyInput extends X_C_RfQ_TopicSubscriberOnlyInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRfQTopicSubscriberOnlyInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
