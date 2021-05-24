package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHChargeInfoValue;

public class ChargeInformationValue extends BaseEntity {
	private int lineNumber;
	@JsonIgnore
	private int chargeInfoId;

	/**
	 * Empty constructor needed for deserialization
	 */
	public ChargeInformationValue() {
	}

	public ChargeInformationValue(MBHChargeInfoValue entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setChargeInfoId(entity.getBH_Charge_Info_ID());
		setLineNumber(entity.getLine());
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getChargeInfoId() {
		return chargeInfoId;
	}

	public void setChargeInfoId(int chargeInfoId) {
		this.chargeInfoId = chargeInfoId;
	}
}
