package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class InventoryTransaction extends BaseMetadata {

	@JsonIgnore
	private Integer transactionId;
	private Transaction transaction;
	@JsonIgnore
	private Integer orderId;
	private Order order;
	@JsonIgnore
	private Integer movementId;
	private Movement movement;
	@JsonIgnore
	private Integer visitId;
	private Visit visit;
	@JsonIgnore
	private Integer locatorId;
	private Locator locator;
	@JsonIgnore
	private Integer productId;
	private Product product;
	private BigDecimal movementQuantity;
	@JsonIgnore
	private Integer attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;
	private User user;
	private BigDecimal runningTotal;
	private String transactionType;

	// Blank constructor for deserialization
	public InventoryTransaction() {
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	@JsonIgnore
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Integer getOrderId() {
		return orderId;
	}

	@JsonIgnore
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getMovementId() {
		return movementId;
	}

	@JsonIgnore
	public void setMovementId(Integer movementId) {
		this.movementId = movementId;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public Integer getVisitId() {
		return visitId;
	}

	@JsonIgnore
	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public BigDecimal getRunningTotal() {
		return runningTotal;
	}

	public void setRunningTotal(BigDecimal runningTotal) {
		this.runningTotal = runningTotal;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
