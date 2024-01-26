package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInOut_BH;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class InOut extends BaseMetadata {
	@JsonProperty("isSalesOrderTransaction")
	private boolean isSalesOrderTransaction;
	private String documentNumber;
	private String documentAction;
	private String documentStatus;
	@JsonIgnore
	private Integer documentTypeId;
	private DocumentType documentType;
	private String description;
	@JsonIgnore
	private Integer orderId;
	private Order order;
	private Timestamp dateOrdered;
	private String movementType;
	private Timestamp movementDate;
	@JsonIgnore
	private Integer businessPartnerId;
	private BusinessPartner businessPartner;
	@JsonIgnore
	private Integer warehouseId;
	private Warehouse warehouse;
	@JsonIgnore
	private Integer chargeId;
	private Charge charge;
	private BigDecimal chargeAmount;
	@JsonIgnore
	private Integer invoiceId;
	private Invoice invoice;
	@JsonIgnore
	private Integer userId;
	private User user;
	@JsonIgnore
	private Integer visitId;
	private Visit visit;
	private List<InOutLine> inOutLines = new ArrayList<>();

	// Blank constructor for deserialization
	public InOut() {
	}

	public InOut(MInOut_BH entity) {
		super(entity);

		setSalesOrderTransaction(entity.isSOTrx());
		setDocumentNumber(entity.getDocumentNo());
		setDocumentAction(entity.getDocAction());
		setDocumentStatus(entity.getDocStatus());
		setDocumentTypeId(entity.getC_DocType_ID());
		setDescription(entity.getDescription());
		setOrderId(entity.getC_Order_ID());
		setDateOrdered(entity.getDateOrdered());
		setMovementType((entity.getMovementType()));
		setMovementDate(entity.getMovementDate());
		setBusinessPartnerId(entity.getC_BPartner_ID());
		setChargeId(entity.getC_Charge_ID());
		setChargeAmount(entity.getChargeAmt());
		setVisitId(entity.getBH_Visit_ID());
	}

	@JsonProperty("isSalesOrderTransaction")
	public boolean isSalesOrderTransaction() {
		return isSalesOrderTransaction;
	}

	@JsonProperty("isSalesOrderTransaction")
	public void setSalesOrderTransaction(boolean salesOrderTransaction) {
		isSalesOrderTransaction = salesOrderTransaction;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDocumentAction() {
		return documentAction;
	}

	public void setDocumentAction(String documentAction) {
		this.documentAction = documentAction;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	@JsonIgnore
	public Integer getDocumentTypeId() {
		return documentTypeId;
	}

	@JsonIgnore
	public void setDocumentTypeId(Integer documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
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

	public Timestamp getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Timestamp dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public Timestamp getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(Timestamp movementDate) {
		this.movementDate = movementDate;
	}

	@JsonIgnore
	public Integer getBusinessPartnerId() {
		return businessPartnerId;
	}

	@JsonIgnore
	public void setBusinessPartnerId(Integer businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	@JsonIgnore
	public Integer getWarehouseId() {
		return warehouseId;
	}

	@JsonIgnore
	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
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

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	@JsonIgnore
	public Integer getInvoiceId() {
		return invoiceId;
	}

	@JsonIgnore
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@JsonIgnore
	public Integer getUserId() {
		return userId;
	}

	@JsonIgnore
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
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
}
