package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MInOutLineInput extends X_M_InOutLineInput {

	private BigDecimal Qty;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_InOutLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInOutLineInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}

	public BigDecimal getQty() {
		return Qty;
	}

	@Override
	public void setQty(BigDecimal qty) {
		Qty = qty;
		super.setQty(qty);
	}
}
