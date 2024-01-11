package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAttachmentNoteInput extends X_AD_AttachmentNoteInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAttachmentNoteInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
