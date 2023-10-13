package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MInvoiceLine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation of iDempiere's MOrderLineItem (C_Order_line).
 * 
 * @author andrew
 *
 */
@XmlRootElement(name = "invoiceline")
@JsonInclude(value = Include.NON_NULL)
public class InvoiceLine extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer productId;
	private Product product;
	private String description;
	private Integer invoiceId;
	private BigDecimal price;
	private BigDecimal quantity;
	private BigDecimal lineNetAmount;
	@JsonIgnore
	private Integer attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;
	private Charge charge;
	@JsonIgnore
	private Integer orderLineId;
	private OrderLine orderLine;
	private List<BusinessPartnerSpecificPayerInformation> businessPartnerSpecificPayerInformationList =
			new ArrayList<>();

	public InvoiceLine() {
		orderLineId = 0;
	}

	public InvoiceLine(MInvoiceLine instance) {
		super(instance);

		this.invoiceId = instance.getC_Invoice_ID();
		this.price = instance.getPriceActual();
		this.quantity = instance.getQtyEntered();
		this.lineNetAmount = instance.getLineNetAmt();
		this.description = instance.getDescription();
		setOrderLineId(instance.getC_OrderLine_ID());
		setAttributeSetInstanceId(instance.getM_AttributeSetInstance_ID());
	}

	@XmlElement
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@XmlElement
	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
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
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public Integer getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(Integer attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public Integer getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Integer orderLineId) {
		this.orderLineId = orderLineId;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public List<BusinessPartnerSpecificPayerInformation> getBusinessPartnerSpecificPayerInformationList() {
		return businessPartnerSpecificPayerInformationList;
	}

	public void setBusinessPartnerSpecificPayerInformationList(
			List<BusinessPartnerSpecificPayerInformation> businessPartnerSpecificPayerInformationList) {
		this.businessPartnerSpecificPayerInformationList = businessPartnerSpecificPayerInformationList;
	}

	public AttributeSetInstance getAttributeSetInstance() {
		return attributeSetInstance;
	}

	public void setAttributeSetInstance(AttributeSetInstance attributeSetInstance) {
		this.attributeSetInstance = attributeSetInstance;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
