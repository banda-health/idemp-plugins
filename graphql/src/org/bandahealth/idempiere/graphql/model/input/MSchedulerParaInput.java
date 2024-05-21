package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSchedulerParaInput extends X_AD_Scheduler_ParaInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Scheduler_Para_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MSchedulerParaInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
