package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;

import java.sql.Timestamp;

public class AttributeSetInstance extends BaseMetadata {
	private Timestamp guaranteeDate;
	private ReferenceList updateReason;

	/**
	 * Empty constructor needed for deserialization
	 */
	public AttributeSetInstance() {}

	public AttributeSetInstance(MAttributeSetInstance_BH model) {
		super(model);
		setGuaranteeDate(model.getGuaranteeDate());
	}

	public Timestamp getGuaranteeDate() {
		return guaranteeDate;
	}

	public void setGuaranteeDate(Timestamp guaranteeDate) {
		this.guaranteeDate = guaranteeDate;
	}

	public ReferenceList getUpdateReason() {
		return updateReason;
	}

	public void setUpdateReason(ReferenceList updateReason) {
		this.updateReason = updateReason;
	}
}
