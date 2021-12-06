package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class MovementLine extends BaseEntity {

	private BigDecimal movementQuantity;
	@JsonIgnore
	private int productId;
	private Product product;
	private String movementUuid;
	@JsonIgnore
	private int attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;
	@JsonIgnore
	private int locatorId;
	private Locator locator;
	@JsonIgnore
	private int locatorToId;
	private Locator locatorTo;
	@JsonIgnore
	private int movementId;

	public MovementLine() {
	}

	public MovementLine(MMovementLine_BH entity) {
		super(entity, null, entity.getDescription(), entity.getValue());

		setMovementId(entity.getM_Movement_ID());
		setProductId(entity.getM_Product_ID());
		setMovementQuantity(entity.getMovementQty());
		setAttributeSetInstanceId(entity.getM_AttributeSetInstance_ID());
		setLocatorId(entity.getM_Locator_ID());
		setLocatorToId(entity.getM_LocatorTo_ID());
	}

	public BigDecimal getMovementQuantity() {
		return movementQuantity;
	}

	public void setMovementQuantity(BigDecimal movementQuantity) {
		this.movementQuantity = movementQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMovementUuid() {
		return movementUuid;
	}

	public void setMovementUuid(String movementUuid) {
		this.movementUuid = movementUuid;
	}

	public int getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(int attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public AttributeSetInstance getAttributeSetInstance() {
		return attributeSetInstance;
	}

	public void setAttributeSetInstance(AttributeSetInstance attributeSetInstance) {
		this.attributeSetInstance = attributeSetInstance;
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

	public int getLocatorToId() {
		return locatorToId;
	}

	public void setLocatorToId(int locatorToId) {
		this.locatorToId = locatorToId;
	}

	public Locator getLocatorTo() {
		return locatorTo;
	}

	public void setLocatorTo(Locator locatorTo) {
		this.locatorTo = locatorTo;
	}

	public int getMovementId() {
		return movementId;
	}

	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
