package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
	private Timestamp dateOrdered;
	private Timestamp dateAccount;
	private BigDecimal grandTotal;
	private boolean isSalesOrderTransaction;
	private Boolean isExpense;
	private String description;
	private List<OrderLine> orderLines;
	// iDempiere's DocStatus i.e Drafted, InProgress, Completed, Voided etc
	private String docStatus;
	private VoidedReason voidedReason;
	private Warehouse warehouse;
	@JsonIgnore
	private int documentTypeTargetId;

	public Order() {
	}

	public Order(MOrder_BH model) {
		super(model);

		this.businessPartner = new BusinessPartner();
		this.dateOrdered = model.getDateOrdered();
		this.grandTotal = model.getGrandTotal();
		this.isSalesOrderTransaction = model.isSOTrx();
		this.description = model.getDescription();
		this.docStatus = model.getDocStatus();
		this.orderLines = new ArrayList<>();
		this.documentTypeTargetId = model.getC_DocTypeTarget_ID();
	}

	public Order(MOrder_BH model, BusinessPartner businessPartner, List<OrderLine> orderLines) {
		this(model);

		this.businessPartner = businessPartner == null ? new BusinessPartner() : businessPartner;
		this.orderLines = orderLines == null ? new ArrayList<>() : orderLines;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, Timestamp dateOrdered, boolean isSalesOrderTransaction,
			List<OrderLine> orderLines, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.orderLines = orderLines;
		this.docStatus = docStatus;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, Timestamp dateOrdered, boolean isSalesOrderTransaction, String docStatus,
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
	public Timestamp getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Timestamp dateOrdered) {
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

	public int getDocumentTypeTargetId() {
		return documentTypeTargetId;
	}

	public void setDocumentTypeTargetId(int documentTypeTargetId) {
		this.documentTypeTargetId = documentTypeTargetId;
	}

	public Timestamp getDateAccount() {
		return dateAccount;
	}

	public void setDateAccount(Timestamp dateAccount) {
		this.dateAccount = dateAccount;
	}
}
