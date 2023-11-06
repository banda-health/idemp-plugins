package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;

public class PayerInformationFieldValueSuggestion extends BaseEntity {
	private int lineNumber;
	@JsonIgnore
	private int payerInfoFieldSuggestionId;

	public PayerInformationFieldValueSuggestion(MBHPayerInfoFldValSug entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setPayerInfoFieldSuggestionId(entity.getBH_Payer_Info_Fld_Sug_ID());
		setLineNumber(entity.getLine());
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getPayerInfoFieldSuggestionId() {
		return payerInfoFieldSuggestionId;
	}

	public void setPayerInfoFieldSuggestionId(int payerInfoFieldSuggestionId) {
		this.payerInfoFieldSuggestionId = payerInfoFieldSuggestionId;
	}
}
