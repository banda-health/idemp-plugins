package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChangeNoticeInput extends X_M_ChangeNoticeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MChangeNoticeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
