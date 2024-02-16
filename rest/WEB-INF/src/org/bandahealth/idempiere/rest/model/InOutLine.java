package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import org.compiere.model.MInOutLine;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InOutLine extends BaseMetadata {
	private Integer line;
	private String description;
	@JsonIgnore
	private Integer inOutId;
	@JsonIgnore
	private Integer orderLineId;
	private OrderLine orderLine;
	@JsonIgnore
	private Integer locatorId;
	private Locator locator;
	@JsonIgnore
	private Integer productId;
	private Product product;
	@JsonIgnore
	private Integer chargeId;
	private Charge charge;
	private BigDecimal movementQuantity;
	@JsonIgnore
	private Integer attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;

	// Blank constructor for deserialization
	public InOutLine() {
	}

	public InOutLine(MInOutLine entity) {
		super(entity);

		setId(entity.get_ID());
		setLine(entity.getLine());
		setDescription(entity.getDescription());
		setInOutId(entity.getM_InOut_ID());
		setOrderLineId(entity.getC_OrderLine_ID());
		setLocatorId(entity.getM_Locator_ID());
		setProductId(entity.getM_Product_ID());
		setChargeId(entity.getC_Charge_ID());
		setMovementQuantity(entity.getMovementQty());
		setAttributeSetInstanceId(entity.getM_AttributeSetInstance_ID());
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Integer getInOutId() {
		return inOutId;
	}

	@JsonIgnore
	public void setInOutId(Integer inOutId) {
		this.inOutId = inOutId;
	}

	@JsonIgnore
	public Integer getOrderLineId() {
		return orderLineId;
	}

	@JsonIgnore
	public void setOrderLineId(Integer orderLineId) {
		this.orderLineId = orderLineId;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
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

	@JsonIgnore
	public Integer getChargeId() {
		return chargeId;
	}

	@JsonIgnore
	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public BigDecimal getMovementQuantity() {
		return movementQuantity;
	}

	public void setMovementQuantity(BigDecimal movementQuantity) {
		this.movementQuantity = movementQuantity;
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
}
