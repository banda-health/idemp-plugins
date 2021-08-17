package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MAttributeSetInstance;

import java.sql.Timestamp;

public class AttributeSetInstance extends BaseMetadata {
	private Timestamp guaranteeDate;

	/**
	 * Empty constructor needed for deserialization
	 */
	public AttributeSetInstance() {}

	public AttributeSetInstance(MAttributeSetInstance model) {
		super(model);
		setGuaranteeDate(model.getGuaranteeDate());
	}

	public Timestamp getGuaranteeDate() {
		return guaranteeDate;
	}

	public void setGuaranteeDate(Timestamp guaranteeDate) {
		this.guaranteeDate = guaranteeDate;
	}
}
