package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefInfoRelatedInput extends X_AD_UserDef_Info_RelatedInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUserDefInfoRelatedInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
