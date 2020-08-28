package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Representation of iDempiere's MOrderLineItem (C_Order_line).
 * 
 * @author andrew
 *
 */
@XmlRootElement(name = "orderline")
@JsonInclude(value = Include.NON_NULL)
public class OrderLine extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private ExpenseCategory expenseCategory;
	private Integer orderId;
	private Product product;
	private BigDecimal price;
	private BigDecimal quantity;
	private BigDecimal lineNetAmount;
	private Integer attributeSetInstanceId;
	private String expiration;

	public OrderLine() {
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Integer orderId, Product product, BigDecimal price, BigDecimal quantity, BigDecimal lineNetAmount,
			String expiration) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.orderId = orderId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.lineNetAmount = lineNetAmount;
		this.expiration = expiration;
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
									 ExpenseCategory expenseCategory, Integer orderId, BigDecimal price, BigDecimal quantity, BigDecimal lineNetAmount) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.expenseCategory = expenseCategory;
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
		this.lineNetAmount = lineNetAmount;
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Integer orderId, Product product, BigDecimal price, BigDecimal quantity) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.orderId = orderId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
									 Integer orderId, ExpenseCategory expenseCategory, BigDecimal price) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.orderId = orderId;
		this.expenseCategory = expenseCategory;
		this.price = price;
	}

	@XmlElement
	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(ExpenseCategory charge) {
		this.expenseCategory = charge;
	}

	@XmlElement
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@XmlElement
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@XmlElement
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@XmlElement
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@XmlElement
	public BigDecimal getLineNetAmount() {
		return lineNetAmount;
	}

	public void setLineNetAmount(BigDecimal lineNetAmount) {
		this.lineNetAmount = lineNetAmount;
	}

	@XmlElement
	public Integer getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(Integer attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	@XmlElement
	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

}
