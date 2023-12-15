package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MBPartnerLocation;

public class BusinessPartnerLocation extends BaseMetadata {
	private String name;
	@JsonProperty("isBillTo")
	private boolean isBillTo;
	@JsonProperty("isShipTo")
	private boolean isShipTo;
	@JsonProperty("isPayFrom")
	private boolean isPayFrom;
	@JsonProperty("isRemitTo")
	private boolean isRemitTo;
	private String phone;
	private String phone2;
	private String fax;
	private String isdn;
	@JsonIgnore
	private Integer salesRegionId;
	@JsonIgnore
	private Integer businessPartnerId;
	private BusinessPartner businessPartner;
	private String customerAddressId;
	@JsonProperty("isPreserveCustomName")
	private boolean isPreserveCustomName;

	// Blank constructor for deserialization
	public BusinessPartnerLocation() {}

	public BusinessPartnerLocation(MBPartnerLocation entity) {
		super(entity);

		setName(entity.getName());
		setBillTo(entity.isBillTo());
		setShipTo(entity.isShipTo());
		setPayFrom(entity.isPayFrom());
		setRemitTo(entity.isRemitTo());
		setPhone(entity.getPhone());
		setPhone2(entity.getPhone2());
		setFax(entity.getFax());
		setIsdn(entity.getISDN());
		setSalesRegionId(entity.getC_SalesRegion_ID());
		setBusinessPartnerId(entity.getC_BPartner_ID());
		setCustomerAddressId(entity.getCustomerAddressID());
		setPreserveCustomName(entity.isPreserveCustomName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("isBillTo")
	public boolean isBillTo() {
		return isBillTo;
	}

	@JsonProperty("isBillTo")
	public void setBillTo(boolean billTo) {
		isBillTo = billTo;
	}

	@JsonProperty("isShipTo")
	public boolean isShipTo() {
		return isShipTo;
	}

	@JsonProperty("isShipTo")
	public void setShipTo(boolean shipTo) {
		isShipTo = shipTo;
	}

	@JsonProperty("isPayFrom")
	public boolean isPayFrom() {
		return isPayFrom;
	}

	@JsonProperty("isPayFrom")
	public void setPayFrom(boolean payFrom) {
		isPayFrom = payFrom;
	}

	@JsonProperty("isRemitTo")
	public boolean isRemitTo() {
		return isRemitTo;
	}

	@JsonProperty("isRemitTo")
	public void setRemitTo(boolean remitTo) {
		isRemitTo = remitTo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	@JsonIgnore
	public Integer getSalesRegionId() {
		return salesRegionId;
	}

	@JsonIgnore
	public void setSalesRegionId(Integer salesRegionId) {
		this.salesRegionId = salesRegionId;
	}

	@JsonIgnore
	public Integer getBusinessPartnerId() {
		return businessPartnerId;
	}

	@JsonIgnore
	public void setBusinessPartnerId(Integer businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public String getCustomerAddressId() {
		return customerAddressId;
	}

	public void setCustomerAddressId(String customerAddressId) {
		this.customerAddressId = customerAddressId;
	}

	@JsonProperty("isPreserveCustomName")
	public boolean isPreserveCustomName() {
		return isPreserveCustomName;
	}

	@JsonProperty("isPreserveCustomName")
	public void setPreserveCustomName(boolean preserveCustomName) {
		isPreserveCustomName = preserveCustomName;
	}
}
