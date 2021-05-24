package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHChargeInfoValue;
import org.bandahealth.idempiere.base.model.MBHChargeInfoValueSuggestion;

public class ChargeInformationValueSuggestion extends BaseEntity {
	private int lineNumber;
	@JsonIgnore
	private int chargeInfoSuggestionId;

	public ChargeInformationValueSuggestion(MBHChargeInfoValueSuggestion entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setChargeInfoSuggestionId(entity.getBH_Charge_Info_Suggestion_ID());
		setLineNumber(entity.getLine());
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getChargeInfoSuggestionId() {
		return chargeInfoSuggestionId;
	}

	public void setChargeInfoSuggestionId(int chargeInfoSuggestionId) {
		this.chargeInfoSuggestionId = chargeInfoSuggestionId;
	}
}
