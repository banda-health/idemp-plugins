package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MStorageOnHand;

import java.math.BigDecimal;

public class StorageOnHand extends BaseMetadata {
	private BigDecimal quantityOnHand;
	private AttributeSetInstance attributeSetInstance;

	/**
	 * Empty constructor needed for deserialization
	 */
	public StorageOnHand() {}

	public StorageOnHand(MStorageOnHand model) {
		super(model);

		setQuantityOnHand(model.getQtyOnHand());
	}

	public BigDecimal getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(BigDecimal quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public AttributeSetInstance getAttributeSetInstance() {
		return attributeSetInstance;
	}

	public void setAttributeSetInstance(AttributeSetInstance attributeSetInstance) {
		this.attributeSetInstance = attributeSetInstance;
	}
}
