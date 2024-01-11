package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLotCtlExcludeInput extends X_M_LotCtlExcludeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MLotCtlExcludeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
