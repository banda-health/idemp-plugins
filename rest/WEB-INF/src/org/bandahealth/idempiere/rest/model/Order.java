package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation of iDempiere's MOrder (C_Order).
 *
 * @author andrew
 */
@JsonInclude(value = Include.NON_NULL)
public class Order extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private BusinessPartner businessPartner;
	private String dateOrdered;
	private BigDecimal grandTotal;
	private boolean isSalesOrderTransaction;
	private Boolean isExpense;
	private String description;
	private List<OrderLine> orderLines;
	private List<Payment> payments;
	// iDempiere's DocStatus i.e Drafted, InProgress, Completed, Voided etc
	private String docStatus;
	private VoidedReason voidedReason;
	private Warehouse warehouse;

	public Order() {
	}

	public Order(MOrder_BH model) {
		super(model);

		this.businessPartner = new BusinessPartner();
		this.dateOrdered = DateUtil.parseDateOnly(model.getDateOrdered());
		this.grandTotal = model.getGrandTotal();
		this.isSalesOrderTransaction = model.isSOTrx();
		this.description = model.getDescription();
		this.docStatus = model.getDocStatus();
		this.orderLines = new ArrayList<>();
		this.payments = new ArrayList<>();
	}

	public Order(MOrder_BH model, BusinessPartner businessPartner, List<OrderLine> orderLines, List<Payment> payments) {
		this(model);

		this.businessPartner = businessPartner == null ? new BusinessPartner() : businessPartner;
		this.orderLines = orderLines == null ? new ArrayList<>() : orderLines;
		this.payments = payments == null ? new ArrayList<>() : payments;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateOrdered, BigDecimal grandTotal, boolean isSalesOrderTransaction,
			String description, List<OrderLine> orderLines, List<Payment> payments, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.grandTotal = grandTotal;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.description = description;
		this.orderLines = orderLines;
		this.payments = payments;
		this.docStatus = docStatus;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateOrdered, boolean isSalesOrderTransaction,
			List<OrderLine> orderLines, List<Payment> payments, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.orderLines = orderLines;
		this.payments = payments;
		this.docStatus = docStatus;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateOrdered, boolean isSalesOrderTransaction,
			List<OrderLine> orderLines, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.orderLines = orderLines;
		this.docStatus = docStatus;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateOrdered, boolean isSalesOrderTransaction, String docStatus,
			BigDecimal grandTotal) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.docStatus = docStatus;
		this.grandTotal = grandTotal;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	@XmlElement
	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	@XmlElement
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	@JsonIgnore
	public boolean isIsSalesOrderTransaction() {
		return isSalesOrderTransaction;
	}

	public void setIsSalesOrderTransaction(boolean isSalesOrderTransaction) {
		this.isSalesOrderTransaction = isSalesOrderTransaction;
	}

	@JsonIgnore
	public Boolean isExpense() {
		return isExpense;
	}

	public void setExpense(Boolean isExpense) {
		this.isExpense = isExpense;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@XmlElement
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@XmlElement
	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public VoidedReason getVoidedReason() {
		return voidedReason;
	}

	public void setVoidedReason(VoidedReason voidedReason) {
		this.voidedReason = voidedReason;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
}
