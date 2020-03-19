package org.bandahealth.idempiere.rest.model;

import java.sql.Date;

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
	private Date expirationDate;
	private int quantity;
	private int shelfLife;

	public Inventory() {
	}

	public Inventory(int productId) {
		super();
		this.productId = productId;
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

	public Date getExpirationDate() {
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

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setShlfLife(int shlfLife) {
		this.shelfLife = shlfLife;
	}

}