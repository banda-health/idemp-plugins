package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;

public class BusinessPartnerGeneralPayerInformation extends BaseEntity {
	@JsonIgnore
	private int businessPartnerPayerInformationId;
	@JsonIgnore
	private int payerInformationFieldId;
	private String payerInformationFieldUuid;

	/**
	 * Empty constructor needed for deserialization
	 */
	public BusinessPartnerGeneralPayerInformation() {
	}

	public BusinessPartnerGeneralPayerInformation(MBHBPGeneralPayerInfo entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setBusinessPartnerPayerInformationId(entity.getBH_BP_Payer_Info_ID());
		setPayerInformationFieldId(entity.getBH_Payer_Info_Field_ID());
	}

	public int getBusinessPartnerPayerInformationId() {
		return businessPartnerPayerInformationId;
	}

	public void setBusinessPartnerPayerInformationId(int businessPartnerPayerInformationId) {
		this.businessPartnerPayerInformationId = businessPartnerPayerInformationId;
	}

	public int getPayerInformationFieldId() {
		return payerInformationFieldId;
	}

	public void setPayerInformationFieldId(int payerInformationFieldId) {
		this.payerInformationFieldId = payerInformationFieldId;
	}

	public String getPayerInformationFieldUuid() {
		return payerInformationFieldUuid;
	}

	public void setPayerInformationFieldUuid(String payerInformationFieldUuid) {
		this.payerInformationFieldUuid = payerInformationFieldUuid;
	}
}
