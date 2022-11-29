package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHBPartnerChargeInfo;

public class BusinessPartnerChargeInformation extends BaseEntity {
	@JsonIgnore
	private int businessPartnerChargeId;
	@JsonIgnore
	private int chargeInformationId;
	private String chargeInformationUuid;
	/**
	 * Empty constructor needed for deserialization
	 */
	public BusinessPartnerChargeInformation() {}

	public BusinessPartnerChargeInformation(MBHBPartnerChargeInfo entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setBusinessPartnerChargeId(entity.getBH_BPartner_Charge_ID());
		setChargeInformationId(entity.getBH_Charge_Info_ID());
	}

	public int getBusinessPartnerChargeId() {
		return businessPartnerChargeId;
	}

	public void setBusinessPartnerChargeId(int businessPartnerChargeId) {
		this.businessPartnerChargeId = businessPartnerChargeId;
	}

	public int getChargeInformationId() {
		return chargeInformationId;
	}

	public void setChargeInformationId(int chargeInformationId) {
		this.chargeInformationId = chargeInformationId;
	}

	public String getChargeInformationUuid() {
		return chargeInformationUuid;
	}

	public void setChargeInformationUuid(String chargeInformationUuid) {
		this.chargeInformationUuid = chargeInformationUuid;
	}
}
