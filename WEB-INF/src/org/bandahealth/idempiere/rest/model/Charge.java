package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.compiere.model.MRefList;

import java.util.ArrayList;
import java.util.List;

public class Charge extends BaseEntity {
	private ReferenceList subType;
	private boolean needAdditionalVisitInformation;
	private List<ChargeInfo> chargeInfoList = new ArrayList<>();
	private Account account;
	private ChargeType chargeType;

	public Charge(MCharge_BH entity) {
		this(entity, null);
	}

	public Charge(MCharge_BH entity, MChargeType_BH chargeType) {
		this(entity, chargeType, null);
	}

	public Charge(MCharge_BH entity, MChargeType_BH chargeType, MRefList subType) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setNeedAdditionalVisitInformation(entity.isBH_NeedAdditionalVisitInfo());
		if (chargeType != null) {
			setChargeType(new ChargeType(chargeType));
		}
		if (subType != null) {
			setSubType(new ReferenceList(subType));
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

	public List<ChargeInfo> getChargeInfoList() {
		return chargeInfoList;
	}

	public void setChargeInfoList(List<ChargeInfo> chargeInfoList) {
		this.chargeInfoList = chargeInfoList;
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
}
