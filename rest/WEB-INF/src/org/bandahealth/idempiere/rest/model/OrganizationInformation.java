package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MOrgInfo_BH;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class OrganizationInformation extends BaseMetadata {
	private static final long serialVersionUID = 1L;

	private String receiptFooterMessage;
	private Image logo;
	private String phone;
	private String headerMessage;
	private String facilityNumber;
	private String paymentInformation;
	private Location location;

	public OrganizationInformation() {
	}
	
	public OrganizationInformation(MOrgInfo_BH instance) {
		super(instance);
		
		this.receiptFooterMessage = instance.getReceiptFooterMsg();
		this.phone = instance.getPhone();
		this.headerMessage = instance.getBH_Header();
		this.facilityNumber = instance.getBH_FacilityNumber();
		this.paymentInformation = instance.getBH_PaymentInformation();
	}

	public String getReceiptFooterMessage() {
		return receiptFooterMessage;
	}

	public void setReceiptFooterMessage(String receiptFooterMessage) {
		this.receiptFooterMessage = receiptFooterMessage;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHeaderMessage() {
		return headerMessage;
	}

	public void setHeaderMessage(String headerMessage) {
		this.headerMessage = headerMessage;
	}

	public String getFacilityNumber() {
		return facilityNumber;
	}

	public void setFacilityNumber(String facilityNumber) {
		this.facilityNumber = facilityNumber;
	}

	public String getPaymentInformation() {
		return paymentInformation;
	}

	public void setPaymentInformation(String paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
