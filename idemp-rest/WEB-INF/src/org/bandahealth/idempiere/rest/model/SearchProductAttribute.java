package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "searchproduct")
@JsonInclude(value = Include.NON_NULL)
public class SearchProductAttribute extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private BigDecimal existingQuantity;
	private String expiry;
	private Integer attributeSetInstanceId;
	private String attributeSetInstanceUuid;
	private String warehouseUuid;

	public SearchProductAttribute() {
	}

	public SearchProductAttribute(String expiry, Integer attributeSetInstanceId) {
		this.expiry = expiry;
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public BigDecimal getExistingQuantity() {
		return existingQuantity;
	}

	public void setExistingQuantity(BigDecimal existingQuantity) {
		this.existingQuantity = existingQuantity;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public Integer getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(Integer attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public String getWarehouseUuid() {
		return warehouseUuid;
	}

	public void setWarehouseUuid(String warehouseUuid) {
		this.warehouseUuid = warehouseUuid;
	}

	public String getAttributeSetInstanceUuid() {
		return attributeSetInstanceUuid;
	}

	public void setAttributeSetInstanceUuid(String attributeSetInstanceUuid) {
		this.attributeSetInstanceUuid = attributeSetInstanceUuid;
	}
}
