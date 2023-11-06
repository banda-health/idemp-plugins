package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.compiere.model.MRefList;

import java.util.ArrayList;
import java.util.List;

public class PayerInformationFieldSuggestion extends BaseEntity {
	private boolean shouldFillFromPatient;
	private int lineNumber;
	private ReferenceList dataType;
	@JsonIgnore
	private String dataTypeValue;
	private List<PayerInformationFieldValueSuggestion> values = new ArrayList<>();
	private ReferenceList subType;
	@JsonIgnore
	private String subTypeValue;

	public PayerInformationFieldSuggestion(MBHPayerInfoFldSug entity) {
		this(entity, null);
	}

	public PayerInformationFieldSuggestion(MBHPayerInfoFldSug entity, MRefList dataType) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setShouldFillFromPatient(entity.isBH_FillFromPatient());
		setLineNumber(entity.getLine());
		setDataTypeValue(entity.getBH_PayerInfoFieldDataType());
		setSubTypeValue(entity.getBH_SubType());
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

	public List<PayerInformationFieldValueSuggestion> getValues() {
		return values;
	}

	public void setValues(List<PayerInformationFieldValueSuggestion> values) {
		this.values = values;
	}

	public ReferenceList getSubType() {
		return subType;
	}

	public void setSubType(ReferenceList subType) {
		this.subType = subType;
	}

	public String getDataTypeValue() {
		return dataTypeValue;
	}

	public void setDataTypeValue(String dataTypeValue) {
		this.dataTypeValue = dataTypeValue;
	}

	public String getSubTypeValue() {
		return subTypeValue;
	}

	public void setSubTypeValue(String subTypeValue) {
		this.subTypeValue = subTypeValue;
	}
}
