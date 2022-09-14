package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MInvoiceLine;

import java.math.BigDecimal;

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
	private ExpenseCategory expenseCategory;
	private Product product;
	private String description;
	private Integer invoiceId;
	private BigDecimal price;
	private BigDecimal quantity;
	private BigDecimal lineNetAmount;
	private Integer attributeSetInstanceId;
	private Charge charge;

	public InvoiceLine() {
	}

	public InvoiceLine(MInvoiceLine instance) {
		super(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_InvoiceLine_UU(), instance.isActive(),
				DateUtil.parse(instance.getCreated()), instance.getCreatedBy());

		this.invoiceId = instance.getC_Invoice_ID();
		this.price = instance.getPriceActual();
		this.quantity = instance.getQtyEntered();
		this.lineNetAmount = instance.getLineNetAmt();
		this.description = instance.getDescription();
	}

	public InvoiceLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Integer invoiceId, Product product, BigDecimal price, BigDecimal quantity, BigDecimal lineNetAmount,
			String description) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.invoiceId = invoiceId;
		this.price = price;
		this.quantity = quantity;
		this.lineNetAmount = lineNetAmount;
		this.product = product;
		this.description = description;
	}

	public InvoiceLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			ExpenseCategory expenseCategory, Integer invoiceId, BigDecimal price, BigDecimal quantity,
			BigDecimal lineNetAmount, String description) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.expenseCategory = expenseCategory;
		this.invoiceId = invoiceId;
		this.price = price;
		this.quantity = quantity;
		this.lineNetAmount = lineNetAmount;
		this.description = description;
	}

	public InvoiceLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Integer invoiceId, Product product, BigDecimal price, BigDecimal quantity, String description) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.invoiceId = invoiceId;
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.description = description;
	}

	public InvoiceLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Integer invoiceId, ExpenseCategory expenseCategory, BigDecimal price, String description) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.invoiceId = invoiceId;
		this.expenseCategory = expenseCategory;
		this.price = price;
		this.description = description;
	}

	@XmlElement
	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(ExpenseCategory charge) {
		this.expenseCategory = charge;
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
}
