package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHPayerInfoField;
import org.compiere.model.MRefList;

import java.util.ArrayList;
import java.util.List;

public class PayerInformationField extends BaseEntity {
	private boolean shouldFillFromPatient;
	private int lineNumber;
	private ReferenceList dataType;
	private List<PayerInformationFieldValue> values = new ArrayList<>();
	@JsonIgnore
	private int payerId;

	/**
	 * Empty constructor needed for deserialization
	 */
	public PayerInformationField() {}

	public PayerInformationField(MBHPayerInfoField entity) {
		this(entity, null);
	}

	public PayerInformationField(MBHPayerInfoField entity, MRefList dataType) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setPayerId(entity.getBH_Payer_ID());
		setShouldFillFromPatient(entity.isBH_FillFromPatient());
		setLineNumber(entity.getLine());
		if (dataType != null) {
			setDataType(new ReferenceList(dataType));
		}
	}

	public boolean isShouldFillFromPatient() {
		return shouldFillFromPatient;
	}

	public void setShouldFillFromPatient(boolean shouldFillFromPatient) {
		this.shouldFillFromPatient = shouldFillFromPatient;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public ReferenceList getDataType() {
		return dataType;
	}

	public void setDataType(ReferenceList dataType) {
		this.dataType = dataType;
	}

	public List<PayerInformationFieldValue> getValues() {
		return values;
	}

	public void setValues(List<PayerInformationFieldValue> values) {
		this.values = values;
	}

	public int getPayerId() {
		return payerId;
	}

	public void setPayerId(int payerId) {
		this.payerId = payerId;
	}
}
