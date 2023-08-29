package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;

public class BusinessPartnerSpecificPayerInformation extends BaseEntity {
	@JsonIgnore
	private int invoiceLineId;
	@JsonIgnore
	private int payerInformationFieldId;
	private String payerInformationFieldUuid;

	/**
	 * Empty constructor needed for deserialization
	 */
	public BusinessPartnerSpecificPayerInformation() {}

	public BusinessPartnerSpecificPayerInformation(MBHBPSpecificPayerInfo entity) {
		super(entity, entity.getName(), entity.getDescription(), null);

		setInvoiceLineId(entity.getC_InvoiceLine_ID());
		setPayerInformationFieldId(entity.getBH_Payer_Info_Fld_ID());
	}

	public int getInvoiceLineId() {
		return invoiceLineId;
	}

	public void setInvoiceLineId(int invoiceLineId) {
		this.invoiceLineId = invoiceLineId;
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
