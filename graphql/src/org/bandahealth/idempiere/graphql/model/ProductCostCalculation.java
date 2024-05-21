package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ProductCostCalculation {
	private Integer M_Product_ID;
	private Integer M_AttributeSetInstance_ID;
	private BigDecimal purchasePrice;
	private Timestamp purchaseDate;

	public ProductCostCalculation() {
		this.M_Product_ID = 0;
		this.M_AttributeSetInstance_ID = 0;
		this.purchasePrice = BigDecimal.ZERO;
	}

	public ProductCostCalculation(Integer productId, Integer attributeSetInstanceId, BigDecimal purchasePrice,
			Timestamp purchaseDate) {
		this.M_Product_ID = productId;
		this.M_AttributeSetInstance_ID = attributeSetInstanceId;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
	}

	public Integer getM_Product_ID() {
		return M_Product_ID;
	}

	public void setM_Product_ID(Integer m_Product_ID) {
		this.M_Product_ID = m_Product_ID;
	}

	public Integer getM_AttributeSetInstance_ID() {
		return M_AttributeSetInstance_ID;
	}

	public void setM_AttributeSetInstance_ID(Integer m_AttributeSetInstance_ID) {
		this.M_AttributeSetInstance_ID = m_AttributeSetInstance_ID;
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
