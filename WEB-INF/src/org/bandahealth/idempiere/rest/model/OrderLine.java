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
	private int chargeId;
	private int orderId;
	private Product product;
	private BigDecimal price;
	private BigDecimal quantity;

	public OrderLine() {
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			int chargeId, int orderId, Product product, BigDecimal price, BigDecimal quantity) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.chargeId = chargeId;
		this.orderId = orderId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, int orderId,
			Product product, BigDecimal price, BigDecimal quantity) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.orderId = orderId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, int orderId,
			int chargeId, BigDecimal price) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.orderId = orderId;
		this.chargeId = chargeId;
		this.price = price;
	}

	@XmlElement
	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	@XmlElement
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
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
}
