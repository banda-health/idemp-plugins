package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.compiere.model.MTransaction;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction extends BaseMetadata {
	private String movementType;
	@JsonIgnore
	private Integer locatorId;
	private Locator locator;
	@JsonIgnore
	private Integer productId;
	private Product product;
	private Timestamp movementDate;
	private BigDecimal movementQuantity;
	@JsonIgnore
	private Integer inventoryLineId;
	private InventoryLine inventoryLine;
	@JsonIgnore
	private Integer movementLineId;
	private MovementLine movementLine;
	@JsonIgnore
	private Integer inOutLineId;
	private InOutLine inOutLine;
	@JsonIgnore
	private Integer attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;

	// Blank constructor for deserialization
	public Transaction() {}

	public Transaction(MTransaction entity) {
		super(entity);

		setMovementType(entity.getMovementType());
		setLocatorId(entity.getM_Locator_ID());
		setProductId(entity.getM_Product_ID());
		setMovementDate(entity.getMovementDate());
		setMovementQuantity(entity.getMovementQty());
		setInventoryLineId(entity.getM_InventoryLine_ID());
		setMovementLineId(entity.getM_MovementLine_ID());
		setInOutLineId(entity.getM_InOutLine_ID());
		setAttributeSetInstanceId(entity.getM_AttributeSetInstance_ID());
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	@JsonIgnore
	public Integer getLocatorId() {
		return locatorId;
	}

	@JsonIgnore
	public void setLocatorId(Integer locatorId) {
		this.locatorId = locatorId;
	}

	public Locator getLocator() {
		return locator;
	}

	public void setLocator(Locator locator) {
		this.locator = locator;
	}

	@JsonIgnore
	public Integer getProductId() {
		return productId;
	}

	@JsonIgnore
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Timestamp getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(Timestamp movementDate) {
		this.movementDate = movementDate;
	}

	public BigDecimal getMovementQuantity() {
		return movementQuantity;
	}

	public void setMovementQuantity(BigDecimal movementQuantity) {
		this.movementQuantity = movementQuantity;
	}

	@JsonIgnore
	public Integer getInventoryLineId() {
		return inventoryLineId;
	}

	@JsonIgnore
	public void setInventoryLineId(Integer inventoryLineId) {
		this.inventoryLineId = inventoryLineId;
	}

	public InventoryLine getInventoryLine() {
		return inventoryLine;
	}

	public void setInventoryLine(InventoryLine inventoryLine) {
		this.inventoryLine = inventoryLine;
	}

	@JsonIgnore
	public Integer getMovementLineId() {
		return movementLineId;
	}

	@JsonIgnore
	public void setMovementLineId(Integer movementLineId) {
		this.movementLineId = movementLineId;
	}

	public MovementLine getMovementLine() {
		return movementLine;
	}

	public void setMovementLine(MovementLine movementLine) {
		this.movementLine = movementLine;
	}

	@JsonIgnore
	public Integer getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	@JsonIgnore
	public void setAttributeSetInstanceId(Integer attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public AttributeSetInstance getAttributeSetInstance() {
		return attributeSetInstance;
	}

	public void setAttributeSetInstance(AttributeSetInstance attributeSetInstance) {
		this.attributeSetInstance = attributeSetInstance;
	}

	@JsonIgnore
	public Integer getInOutLineId() {
		return inOutLineId;
	}

	@JsonIgnore
	public void setInOutLineId(Integer inOutLineId) {
		this.inOutLineId = inOutLineId;
	}

	public InOutLine getInOutLine() {
		return inOutLine;
	}

	public void setInOutLine(InOutLine inOutLine) {
		this.inOutLine = inOutLine;
	}
}
