package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class MAttributeSetInstanceInput extends X_M_AttributeSetInstanceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeSetInstance_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAttributeSetInstanceInput(@JsonProperty("UU") String UUID,
			@JsonProperty("GuaranteeDate") Timestamp guaranteeDate) {
		super(UUID);
		setGuaranteeDate(guaranteeDate);
	}
}
