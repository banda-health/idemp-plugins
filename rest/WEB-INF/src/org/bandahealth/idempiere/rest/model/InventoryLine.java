package org.bandahealth.idempiere.rest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;

import java.math.BigDecimal;

public class InventoryLine extends BaseEntity {
	private Product product;
	private AttributeSetInstance attributeSetInstance;
	private Locator locator;
	private Integer line;
	private BigDecimal quantityCount;
	@JsonIgnore
	private int inventoryId;

	public InventoryLine() {
	}

	public InventoryLine(MInventoryLine_BH model) {
		super(model, null, model.getDescription(), null);
		line = model.getLine();
		quantityCount = model.getQtyCount();
		inventoryId = model.getM_Inventory_ID();
	}

	public AttributeSetInstance getAttributeSetInstance() {
		return attributeSetInstance;
	}

	public void setAttributeSetInstance(AttributeSetInstance attributeSetInstance) {
		this.attributeSetInstance = attributeSetInstance;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Locator getLocator() {
		return locator;
	}

	public void setLocator(Locator locator) {
		this.locator = locator;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public BigDecimal getQuantityCount() {
		return quantityCount;
	}

	public void setQuantityCount(BigDecimal quantityCount) {
		this.quantityCount = quantityCount;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getInventoryId() {
		return inventoryId;
	}
}
