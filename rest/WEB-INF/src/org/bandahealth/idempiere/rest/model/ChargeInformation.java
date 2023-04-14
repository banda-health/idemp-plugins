package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.compiere.model.MRefList;

import java.util.ArrayList;
import java.util.List;

public class ChargeInformation extends BaseEntity {
	private boolean shouldFillFromPatient;
	private int lineNumber;
	private ReferenceList dataType;
	private List<ChargeInformationValue> values = new ArrayList<>();
	@JsonIgnore
	private int chargeId;

	/**
	 * Empty constructor needed for deserialization
	 */
	public ChargeInformation() {}

	public ChargeInformation(MBHChargeInfo entity) {
		this(entity, null);
	}

	public ChargeInformation(MBHChargeInfo entity, MRefList dataType) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setChargeId(entity.getC_Charge_ID());
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

	public List<ChargeInformationValue> getValues() {
		return values;
	}

	public void setValues(List<ChargeInformationValue> values) {
		this.values = values;
	}

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}
}
