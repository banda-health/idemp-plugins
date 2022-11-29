package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.compiere.model.MStorageOnHand;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StorageOnHand extends BaseMetadata {
	private BigDecimal quantityOnHand;
	@JsonIgnore
	private int attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;
	@JsonIgnore
	private int locatorId;
	private Locator locator;
	private Timestamp dateMaterialPolicy;
	@JsonIgnore
	private int productId;
	private Product product;

	/**
	 * Empty constructor needed for deserialization
	 */
	public StorageOnHand() {
	}

	public StorageOnHand(MStorageOnHand model) {
		super(model);

		setQuantityOnHand(model.getQtyOnHand());
		setLocatorId(model.getM_Locator_ID());
		setAttributeSetInstanceId(model.getM_AttributeSetInstance_ID());
		setDateMaterialPolicy(model.getDateMaterialPolicy());
		setProductId(model.getM_Product_ID());
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

	public Timestamp getDateMaterialPolicy() {
		return dateMaterialPolicy;
	}

	public void setDateMaterialPolicy(Timestamp dateMaterialPolicy) {
		this.dateMaterialPolicy = dateMaterialPolicy;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
