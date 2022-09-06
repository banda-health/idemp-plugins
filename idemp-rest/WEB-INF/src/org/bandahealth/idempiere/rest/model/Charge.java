package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.compiere.model.MElementValue;
import org.compiere.model.MRefList;

import java.util.ArrayList;
import java.util.List;

public class Charge extends BaseEntity {
	private ReferenceList subType;
	private boolean needAdditionalVisitInformation;
	private List<ChargeInformation> chargeInformationList = new ArrayList<>();
	private Account account;
	private ChargeType chargeType;
	@JsonProperty("isLocked")
	private boolean isLocked;
	@JsonIgnore
	private int chargeTypeId;
	@JsonIgnore
	private String subTypeValue;

	/**
	 * Empty constructor needed for deserialization
	 */
	public Charge() {}

	public Charge(MCharge_BH entity) {
		this(entity, null);
	}

	public Charge(MCharge_BH entity, MChargeType_BH chargeType) {
		this(entity, chargeType, null, null);
	}

	public Charge(MCharge_BH entity, MChargeType_BH chargeType, MRefList subType, MElementValue account) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setNeedAdditionalVisitInformation(entity.isBH_NeedAdditionalVisitInfo());
		setChargeTypeId(entity.getC_ChargeType_ID());
		setSubTypeValue(entity.getBH_SubType());
		setLocked(entity.isBH_Locked());
		if (chargeType != null) {
			setChargeType(new ChargeType(chargeType));
		}
		if (subType != null) {
			setSubType(new ReferenceList(subType));
		}
		if (account != null) {
			setAccount(new Account(account));
		}
	}

	public boolean isNeedAdditionalVisitInformation() {
		return needAdditionalVisitInformation;
	}

	public void setNeedAdditionalVisitInformation(boolean needAdditionalVisitInformation) {
		this.needAdditionalVisitInformation = needAdditionalVisitInformation;
	}

	public ReferenceList getSubType() {
		return subType;
	}

	public void setSubType(ReferenceList subType) {
		this.subType = subType;
	}

	public List<ChargeInformation> getChargeInformationList() {
		return chargeInformationList;
	}

	public void setChargeInformationList(List<ChargeInformation> chargeInformationList) {
		this.chargeInformationList = chargeInformationList;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ChargeType getChargeType() {
		return chargeType;
	}

	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean locked) {
		isLocked = locked;
	}

	public int getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(int chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	public String getSubTypeValue() {
		return subTypeValue;
	}

	public void setSubTypeValue(String subTypeValue) {
		this.subTypeValue = subTypeValue;
	}
}
