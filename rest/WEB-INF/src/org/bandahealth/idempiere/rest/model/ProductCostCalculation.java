package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ProductCostCalculation {
	private Integer productId;
	private Integer attributeSetInstanceId;
	private BigDecimal purchasePrice;
	private Timestamp purchaseDate;

	public ProductCostCalculation() {
		this.productId = 0;
		this.attributeSetInstanceId = 0;
		this.purchasePrice = BigDecimal.ZERO;
	}

	public ProductCostCalculation(Integer productId, Integer attributeSetInstanceId, BigDecimal purchasePrice,
			Timestamp purchaseDate) {
		this.productId = productId;
		this.attributeSetInstanceId = attributeSetInstanceId;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(Integer attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
