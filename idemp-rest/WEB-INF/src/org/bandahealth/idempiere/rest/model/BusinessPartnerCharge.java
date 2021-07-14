package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHBPartnerCharge;

import java.util.ArrayList;
import java.util.List;

public class BusinessPartnerCharge extends BaseEntity {
	@JsonIgnore
	private int chargeId;
	@JsonIgnore
	private int businessPartnerId;
	private String chargeUuid;
	private String businessPartnerUuid;
	List<BusinessPartnerChargeInformation> chargeInformationList = new ArrayList<>();

	/**
	 * Empty constructor needed for deserialization
	 */
	public BusinessPartnerCharge() {}

	public BusinessPartnerCharge(MBHBPartnerCharge entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setChargeId(entity.getC_Charge_ID());
		setBusinessPartnerId(entity.getC_BPartner_ID());
	}

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	public int getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setBusinessPartnerId(int businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public String getChargeUuid() {
		return chargeUuid;
	}

	public void setChargeUuid(String chargeUuid) {
		this.chargeUuid = chargeUuid;
	}

	public String getBusinessPartnerUuid() {
		return businessPartnerUuid;
	}

	public void setBusinessPartnerUuid(String businessPartnerUuid) {
		this.businessPartnerUuid = businessPartnerUuid;
	}

	public List<BusinessPartnerChargeInformation> getChargeInformationList() {
		return chargeInformationList;
	}

	public void setChargeInformationList(
			List<BusinessPartnerChargeInformation> chargeInformationList) {
		this.chargeInformationList = chargeInformationList;
	}
}
