package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.compiere.model.MStorageOnHand;

import java.math.BigDecimal;

public class StorageOnHand extends BaseMetadata {
	private BigDecimal quantityOnHand;
	@JsonIgnore
	private int attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;
	@JsonIgnore
	private int locatorId;
	private Locator locator;

	/**
	 * Empty constructor needed for deserialization
	 */
	public StorageOnHand() {
	}

	public StorageOnHand(MStorageOnHand model) {
		super(model);

		setQuantityOnHand(model.getQtyOnHand());
	}

	public StorageOnHand(Inventory model) {
		super(model.getClientId(), model.getOrgId(), model.getUuid(), model.getIsActive(), model.getCreated(),
				model.getCreatedBy());

		setQuantityOnHand(new BigDecimal(model.getQuantity()));
		setAttributeSetInstanceId(model.getAttributeSetInstanceId());
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

	public int getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(int attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public int getLocatorId() {
		return locatorId;
	}

	public void setLocatorId(int locatorId) {
		this.locatorId = locatorId;
	}

	public Locator getLocator() {
		return locator;
	}

	public void setLocator(Locator locator) {
		this.locator = locator;
	}
}
