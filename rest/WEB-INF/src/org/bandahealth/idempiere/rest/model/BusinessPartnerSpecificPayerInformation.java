package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;

public class BusinessPartnerSpecificPayerInformation extends BaseEntity {
	@JsonIgnore
	private int orderLineId;
	@JsonIgnore
	private int payerInformationFieldId;
	private String payerInformationFieldUuid;

	/**
	 * Empty constructor needed for deserialization
	 */
	public BusinessPartnerSpecificPayerInformation() {}

	public BusinessPartnerSpecificPayerInformation(MBHBPSpecificPayerInfo entity) {
		super(entity, entity.getName(), entity.getDescription(), null);

		setOrderLineId(entity.getC_OrderLine_ID());
		setPayerInformationFieldId(entity.getBH_BP_Payer_Info_ID());
	}

	public int getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
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
