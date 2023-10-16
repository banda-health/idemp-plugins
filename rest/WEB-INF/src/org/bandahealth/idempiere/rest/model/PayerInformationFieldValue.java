package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;

public class PayerInformationFieldValue extends BaseEntity {
	private int lineNumber;
	@JsonIgnore
	private int payerInfoFieldId;

	/**
	 * Empty constructor needed for deserialization
	 */
	public PayerInformationFieldValue() {
	}

	public PayerInformationFieldValue(MBHPayerInfoFldVal entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setPayerInfoFieldId(entity.getBH_Payer_Info_Fld_ID());
		setLineNumber(entity.getLine());
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getPayerInfoFieldId() {
		return payerInfoFieldId;
	}

	public void setPayerInfoFieldId(int payerInfoFieldId) {
		this.payerInfoFieldId = payerInfoFieldId;
	}
}
