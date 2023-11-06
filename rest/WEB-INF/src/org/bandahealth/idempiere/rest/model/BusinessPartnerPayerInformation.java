package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;

import java.util.ArrayList;
import java.util.List;

public class BusinessPartnerPayerInformation extends BaseEntity {
	@JsonIgnore
	private int payerId;
	@JsonIgnore
	private int businessPartnerId;
	private String payerUuid;
	private String businessPartnerUuid;
	List<BusinessPartnerGeneralPayerInformation> businessPartnerGeneralPayerInformationList = new ArrayList<>();

	/**
	 * Empty constructor needed for deserialization
	 */
	public BusinessPartnerPayerInformation() {}

	public BusinessPartnerPayerInformation(MBHBPPayerInfo entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
		setPayerId(entity.getBH_Payer_ID());
		setBusinessPartnerId(entity.getC_BPartner_ID());
	}

	public int getPayerId() {
		return payerId;
	}

	public void setPayerId(int payerId) {
		this.payerId = payerId;
	}

	public int getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setBusinessPartnerId(int businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public String getPayerUuid() {
		return payerUuid;
	}

	public void setPayerUuid(String payerUuid) {
		this.payerUuid = payerUuid;
	}

	public String getBusinessPartnerUuid() {
		return businessPartnerUuid;
	}

	public void setBusinessPartnerUuid(String businessPartnerUuid) {
		this.businessPartnerUuid = businessPartnerUuid;
	}

	public List<BusinessPartnerGeneralPayerInformation> getBusinessPartnerGeneralPayerInformationList() {
		return businessPartnerGeneralPayerInformationList;
	}

	public void setBusinessPartnerGeneralPayerInformationList(
			List<BusinessPartnerGeneralPayerInformation> businessPartnerGeneralPayerInformationList) {
		this.businessPartnerGeneralPayerInformationList = businessPartnerGeneralPayerInformationList;
	}
}
