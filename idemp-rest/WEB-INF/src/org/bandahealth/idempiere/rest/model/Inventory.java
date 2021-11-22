package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "inventory")
@JsonInclude(value = Include.NON_NULL)
public class Inventory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int productId;
	private int warehouseId;
	private String productName;
	private String expirationDate;
	private int quantity;
	private int shelfLife;
	private int attributeSetInstanceId;
	private Integer updateReason;

	public Inventory() {
	}

	public Inventory(int productId, int warehouseId, String productName, String expiration, int quantity, int shelfLife,
			int attributeSetInstanceId, int clientId, int orgId, String created, int createdBy, String description) {
		super(clientId, orgId, null, true, created, createdBy, null, description);

		this.productId = productId;
		this.warehouseId = warehouseId;
		this.productName = productName;
		this.expirationDate = expiration;
		this.quantity = quantity;
		this.shelfLife = shelfLife;
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public String getProductName() {
		return productName;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getShelfLife() {
		return shelfLife;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setShlfLife(int shlfLife) {
		this.shelfLife = shlfLife;
	}

	public int getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(int attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}
	
	public void setUpdateReason(Integer updateReason) {
		this.updateReason = updateReason;
	}
	
	public Integer getUpdateReason() {
		return updateReason;
	}
}