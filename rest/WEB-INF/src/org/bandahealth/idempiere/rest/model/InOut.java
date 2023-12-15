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
	@JsonProperty("isPosted")
	private boolean isPosted;
	@JsonProperty("isProcessing")
	private boolean isProcessing;
	@JsonProperty("isProcessed")
	private boolean isProcessed;
	@JsonIgnore
	private Integer documentTypeId;
	private DocumentType documentType;
	private String description;
	@JsonIgnore
	private Integer orderId;
	private Order order;
	private Timestamp dateOrdered;
	@JsonProperty("isPrinted")
	private boolean isPrinted;
	private String movementType;
	private Timestamp movementDate;
	private Timestamp dateAccount;
	@JsonIgnore
	private Integer businessPartnerId;
	private BusinessPartner businessPartner;
	@JsonIgnore
	private Integer businessPartnerLocationId;
	private BusinessPartnerLocation businessPartnerLocation;
	@JsonIgnore
	private Integer warehouseId;
	private Warehouse warehouse;
	private String purchaseOrderReference;
	@JsonIgnore
	private String deliveryRuleValue;
	private ReferenceList deliveryRule;
	@JsonIgnore
	private String freightCostRuleValue;
	private ReferenceList freightCostRule;
	private BigDecimal freightAmount;
	@JsonIgnore
	private String deliveryViaRuleValue;
	private ReferenceList deliveryViaRule;
	@JsonIgnore
	private Integer shipperId;
	@JsonIgnore
	private Integer chargeId;
	private Charge charge;
	private BigDecimal chargeAmount;
	@JsonIgnore
	private String priorityRuleValue;
	private ReferenceList priorityRule;
	private Timestamp datePrinted;
	@JsonIgnore
	private Integer invoiceId;
	private Invoice invoice;
	private String createFrom;
	private String generateTo;
	private boolean sendEmail;
	@JsonIgnore
	private Integer userId;
	private User user;
	@JsonIgnore
	private Integer salesRepresentativeId;
	private User salesRepresentative;
	private Integer numberOfPackages;
	private Timestamp pickDate;
	private Timestamp shipDate;
	private String trackingNumber;
	@JsonIgnore
	private Integer organizationTransactionId;
	@JsonIgnore
	private Integer projectId;
	@JsonIgnore
	private Integer campaignId;
	@JsonIgnore
	private Integer activityId;
	@JsonIgnore
	private Integer user1Id;
	private User user1;
	@JsonIgnore
	private Integer user2Id;
	private User user2;
	private Timestamp dateReceived;
	@JsonProperty("isInTransit")
	private boolean isInTransit;
	@JsonIgnore
	private Integer referenceInOutId;
	private InOut referenceInOut;
	private String createConfirm;
	private String createPackage;
	@JsonProperty("isApproved")
	private boolean isApproved;
	@JsonProperty("isInDispute")
	private boolean isInDispute;
	private BigDecimal volume;
	private BigDecimal weight;
	@JsonIgnore
	private Integer rmaId;
	@JsonIgnore
	private Integer reversalId;
	private InOut reversal;
	@JsonProperty("isDropShip")
	private boolean isDropShip;
	@JsonIgnore
	private Integer dropShipBusinessPartnerId;
	private BusinessPartner dropShipBusinessPartner;
	@JsonIgnore
	private Integer dropShipBusinessPartnerLocationId;
	private BusinessPartnerLocation dropShipBusinessPartnerLocation;
	@JsonIgnore
	private Integer dropShipUserId;
	private User dropShipUser;
	private BigDecimal processedOn;
	private String freightCharges;
	private String shipperAccount;
	private String insurance;
	private String fob;
	@JsonProperty("isAlternateReturnAddress")
	private boolean isAlternateReturnAddress;
	@JsonIgnore
	private Integer returnBusinessPartnerId;
	private BusinessPartner returnBusinessPartner;
	@JsonIgnore
	private Integer returnBusinessPartnerLocationId;
	private BusinessPartnerLocation returnBusinessPartnerLocation;
	@JsonIgnore
	private Integer returnUserId;
	private User returnUser;
	@JsonIgnore
	private Integer visitId;
	private Visit visit;
	private List<InOutLine> inOutLines = new ArrayList<>();

	// Blank constructor for deserialization
	public InOut() {}

	public InOut(MInOut_BH entity) {
		super(entity);

		setSalesOrderTransaction(entity.isSOTrx());
		setDocumentNumber(entity.getDocumentNo());
		setDocumentAction(entity.getDocAction());
		setDocumentStatus(entity.getDocStatus());
		setPosted(entity.isPosted());
		setProcessing(entity.isProcessing());
		setProcessed(entity.isProcessed());
		setDocumentTypeId(entity.getC_DocType_ID());
		setDescription(entity.getDescription());
		setOrderId(entity.getC_Order_ID());
		setDateOrdered(entity.getDateOrdered());
		setPrinted(entity.isPrinted());
		setMovementType((entity.getMovementType()));
		setMovementDate(entity.getMovementDate());
		setDateAccount(entity.getDateAcct());
		setBusinessPartnerId(entity.getC_BPartner_ID());
		setBusinessPartnerLocationId(entity.getC_BPartner_Location_ID());
		setPurchaseOrderReference(entity.getPOReference());
		setDeliveryRuleValue(entity.getDeliveryRule());
		setFreightCostRuleValue(entity.getFreightCostRule());
		setFreightAmount(entity.getFreightAmt());
		setDeliveryViaRuleValue(entity.getDeliveryViaRule());
		setShipperId(entity.getM_Shipper_ID());
		setChargeId(entity.getC_Charge_ID());
		setChargeAmount(entity.getChargeAmt());
		setPriorityRuleValue(entity.getPriorityRule());
		setDatePrinted(entity.getDatePrinted());
		setInvoiceId(entity.getC_Invoice_ID());
		setCreateFrom(entity.getCreateFrom());
		setGenerateTo(entity.getGenerateTo());
		setSendEmail(entity.isSendEMail());
		setUserId(entity.getAD_User_ID());
		setSalesRepresentativeId(entity.getSalesRep_ID());
		setNumberOfPackages(entity.getNoPackages());
		setPickDate(entity.getPickDate());
		setShipDate(entity.getShipDate());
		setTrackingNumber(entity.getTrackingNo());
		setOrganizationTransactionId(entity.getAD_OrgTrx_ID());
		setProjectId(entity.getC_Project_ID());
		setCampaignId(entity.getC_Campaign_ID());
		setActivityId(entity.getC_Activity_ID());
		setUser1Id(entity.getUser1_ID());
		setUser2Id(entity.getUser2_ID());
		setDateReceived(entity.getDateReceived());
		setInTransit(entity.isInTransit());
		setReferenceInOutId(entity.getRef_InOut_ID());
		setCreateConfirm(entity.getCreateConfirm());
		setCreatePackage(entity.getCreatePackage());
		setApproved(entity.isApproved());
		setInDispute(entity.isInDispute());
		setVolume(entity.getVolume());
		setWeight(entity.getWeight());
		setRmaId(entity.getM_RMA_ID());
		setReversalId(entity.getReversal_ID());
		setDropShip(entity.isDropShip());
		setDropShipBusinessPartnerId(entity.getDropShip_BPartner_ID());
		setDropShipBusinessPartnerLocationId(entity.getDropShip_Location_ID());
		setDropShipUserId(entity.getDropShip_User_ID());
		setProcessedOn(entity.getProcessedOn());
		setFreightCharges(entity.getFreightCharges());
		setShipperAccount(entity.getShipperAccount());
		setInsurance(entity.getInsurance());
		setFob(entity.getFOB());
		setAlternateReturnAddress(entity.isAlternateReturnAddress());
		setReturnBusinessPartnerId(entity.getReturnBPartner_ID());
		setReturnBusinessPartnerLocationId(entity.getReturnLocation_ID());
		setReturnUserId(entity.getReturnUser_ID());
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

	@JsonProperty("isPosted")
	public boolean isPosted() {
		return isPosted;
	}

	@JsonProperty("isPosted")
	public void setPosted(boolean posted) {
		isPosted = posted;
	}

	@JsonProperty("isProcessing")
	public boolean isProcessing() {
		return isProcessing;
	}

	@JsonProperty("isProcessing")
	public void setProcessing(boolean processing) {
		isProcessing = processing;
	}

	@JsonProperty("isProcessed")
	public boolean isProcessed() {
		return isProcessed;
	}

	@JsonProperty("isProcessed")
	public void setProcessed(boolean processed) {
		isProcessed = processed;
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

	@JsonProperty("isPrinted")
	public boolean isPrinted() {
		return isPrinted;
	}

	@JsonProperty("isPrinted")
	public void setPrinted(boolean printed) {
		isPrinted = printed;
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

	public Timestamp getDateAccount() {
		return dateAccount;
	}

	public void setDateAccount(Timestamp dateAccount) {
		this.dateAccount = dateAccount;
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
	public Integer getBusinessPartnerLocationId() {
		return businessPartnerLocationId;
	}

	@JsonIgnore
	public void setBusinessPartnerLocationId(Integer businessPartnerLocationId) {
		this.businessPartnerLocationId = businessPartnerLocationId;
	}

	public BusinessPartnerLocation getBusinessPartnerLocation() {
		return businessPartnerLocation;
	}

	public void setBusinessPartnerLocation(BusinessPartnerLocation businessPartnerLocation) {
		this.businessPartnerLocation = businessPartnerLocation;
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

	public String getPurchaseOrderReference() {
		return purchaseOrderReference;
	}

	public void setPurchaseOrderReference(String purchaseOrderReference) {
		this.purchaseOrderReference = purchaseOrderReference;
	}

	@JsonIgnore
	public String getDeliveryRuleValue() {
		return deliveryRuleValue;
	}

	@JsonIgnore
	public void setDeliveryRuleValue(String deliveryRuleValue) {
		this.deliveryRuleValue = deliveryRuleValue;
	}

	public ReferenceList getDeliveryRule() {
		return deliveryRule;
	}

	public void setDeliveryRule(ReferenceList deliveryRule) {
		this.deliveryRule = deliveryRule;
	}

	@JsonIgnore
	public String getFreightCostRuleValue() {
		return freightCostRuleValue;
	}

	@JsonIgnore
	public void setFreightCostRuleValue(String freightCostRuleValue) {
		this.freightCostRuleValue = freightCostRuleValue;
	}

	public ReferenceList getFreightCostRule() {
		return freightCostRule;
	}

	public void setFreightCostRule(ReferenceList freightCostRule) {
		this.freightCostRule = freightCostRule;
	}

	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(BigDecimal freightAmount) {
		this.freightAmount = freightAmount;
	}

	@JsonIgnore
	public String getDeliveryViaRuleValue() {
		return deliveryViaRuleValue;
	}

	@JsonIgnore
	public void setDeliveryViaRuleValue(String deliveryViaRuleValue) {
		this.deliveryViaRuleValue = deliveryViaRuleValue;
	}

	public ReferenceList getDeliveryViaRule() {
		return deliveryViaRule;
	}

	public void setDeliveryViaRule(ReferenceList deliveryViaRule) {
		this.deliveryViaRule = deliveryViaRule;
	}

	@JsonIgnore
	public Integer getShipperId() {
		return shipperId;
	}

	@JsonIgnore
	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
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
	public String getPriorityRuleValue() {
		return priorityRuleValue;
	}

	@JsonIgnore
	public void setPriorityRuleValue(String priorityRuleValue) {
		this.priorityRuleValue = priorityRuleValue;
	}

	public ReferenceList getPriorityRule() {
		return priorityRule;
	}

	public void setPriorityRule(ReferenceList priorityRule) {
		this.priorityRule = priorityRule;
	}

	public Timestamp getDatePrinted() {
		return datePrinted;
	}

	public void setDatePrinted(Timestamp datePrinted) {
		this.datePrinted = datePrinted;
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

	public String getCreateFrom() {
		return createFrom;
	}

	public void setCreateFrom(String createFrom) {
		this.createFrom = createFrom;
	}

	public String getGenerateTo() {
		return generateTo;
	}

	public void setGenerateTo(String generateTo) {
		this.generateTo = generateTo;
	}

	public boolean isSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(boolean sendEmail) {
		this.sendEmail = sendEmail;
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
	public Integer getSalesRepresentativeId() {
		return salesRepresentativeId;
	}

	@JsonIgnore
	public void setSalesRepresentativeId(Integer salesRepresentativeId) {
		this.salesRepresentativeId = salesRepresentativeId;
	}

	public User getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(User salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	public Integer getNumberOfPackages() {
		return numberOfPackages;
	}

	public void setNumberOfPackages(Integer numberOfPackages) {
		this.numberOfPackages = numberOfPackages;
	}

	public Timestamp getPickDate() {
		return pickDate;
	}

	public void setPickDate(Timestamp pickDate) {
		this.pickDate = pickDate;
	}

	public Timestamp getShipDate() {
		return shipDate;
	}

	public void setShipDate(Timestamp shipDate) {
		this.shipDate = shipDate;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@JsonIgnore
	public Integer getOrganizationTransactionId() {
		return organizationTransactionId;
	}

	@JsonIgnore
	public void setOrganizationTransactionId(Integer organizationTransactionId) {
		this.organizationTransactionId = organizationTransactionId;
	}

	@JsonIgnore
	public Integer getProjectId() {
		return projectId;
	}

	@JsonIgnore
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonIgnore
	public Integer getCampaignId() {
		return campaignId;
	}

	@JsonIgnore
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	@JsonIgnore
	public Integer getActivityId() {
		return activityId;
	}

	@JsonIgnore
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	@JsonIgnore
	public Integer getUser1Id() {
		return user1Id;
	}

	@JsonIgnore
	public void setUser1Id(Integer user1Id) {
		this.user1Id = user1Id;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	@JsonIgnore
	public Integer getUser2Id() {
		return user2Id;
	}

	@JsonIgnore
	public void setUser2Id(Integer user2Id) {
		this.user2Id = user2Id;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public Timestamp getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Timestamp dateReceived) {
		this.dateReceived = dateReceived;
	}

	@JsonProperty("isInTransit")
	public boolean isInTransit() {
		return isInTransit;
	}

	@JsonProperty("isInTransit")
	public void setInTransit(boolean inTransit) {
		isInTransit = inTransit;
	}

	@JsonIgnore
	public Integer getReferenceInOutId() {
		return referenceInOutId;
	}

	@JsonIgnore
	public void setReferenceInOutId(Integer referenceInOutId) {
		this.referenceInOutId = referenceInOutId;
	}

	public InOut getReferenceInOut() {
		return referenceInOut;
	}

	public void setReferenceInOut(InOut referenceInOut) {
		this.referenceInOut = referenceInOut;
	}

	public String getCreateConfirm() {
		return createConfirm;
	}

	public void setCreateConfirm(String createConfirm) {
		this.createConfirm = createConfirm;
	}

	public String getCreatePackage() {
		return createPackage;
	}

	public void setCreatePackage(String createPackage) {
		this.createPackage = createPackage;
	}

	@JsonProperty("isApproved")
	public boolean isApproved() {
		return isApproved;
	}

	@JsonProperty("isApproved")
	public void setApproved(boolean approved) {
		isApproved = approved;
	}

	@JsonProperty("isInDispute")
	public boolean isInDispute() {
		return isInDispute;
	}

	@JsonProperty("isInDispute")
	public void setInDispute(boolean inDispute) {
		isInDispute = inDispute;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	@JsonIgnore
	public Integer getRmaId() {
		return rmaId;
	}

	@JsonIgnore
	public void setRmaId(Integer rmaId) {
		this.rmaId = rmaId;
	}

	@JsonIgnore
	public Integer getReversalId() {
		return reversalId;
	}

	@JsonIgnore
	public void setReversalId(Integer reversalId) {
		this.reversalId = reversalId;
	}

	public InOut getReversal() {
		return reversal;
	}

	public void setReversal(InOut reversal) {
		this.reversal = reversal;
	}

	@JsonProperty("isDropShip")
	public boolean isDropShip() {
		return isDropShip;
	}

	@JsonProperty("isDropShip")
	public void setDropShip(boolean dropShip) {
		isDropShip = dropShip;
	}

	@JsonIgnore
	public Integer getDropShipBusinessPartnerId() {
		return dropShipBusinessPartnerId;
	}

	@JsonIgnore
	public void setDropShipBusinessPartnerId(Integer dropShipBusinessPartnerId) {
		this.dropShipBusinessPartnerId = dropShipBusinessPartnerId;
	}

	public BusinessPartner getDropShipBusinessPartner() {
		return dropShipBusinessPartner;
	}

	public void setDropShipBusinessPartner(BusinessPartner dropShipBusinessPartner) {
		this.dropShipBusinessPartner = dropShipBusinessPartner;
	}

	@JsonIgnore
	public Integer getDropShipBusinessPartnerLocationId() {
		return dropShipBusinessPartnerLocationId;
	}

	@JsonIgnore
	public void setDropShipBusinessPartnerLocationId(Integer dropShipBusinessPartnerLocationId) {
		this.dropShipBusinessPartnerLocationId = dropShipBusinessPartnerLocationId;
	}

	public BusinessPartnerLocation getDropShipBusinessPartnerLocation() {
		return dropShipBusinessPartnerLocation;
	}

	public void setDropShipBusinessPartnerLocation(
			BusinessPartnerLocation dropShipBusinessPartnerLocation) {
		this.dropShipBusinessPartnerLocation = dropShipBusinessPartnerLocation;
	}

	@JsonIgnore
	public Integer getDropShipUserId() {
		return dropShipUserId;
	}

	@JsonIgnore
	public void setDropShipUserId(Integer dropShipUserId) {
		this.dropShipUserId = dropShipUserId;
	}

	public User getDropShipUser() {
		return dropShipUser;
	}

	public void setDropShipUser(User dropShipUser) {
		this.dropShipUser = dropShipUser;
	}

	public BigDecimal getProcessedOn() {
		return processedOn;
	}

	public void setProcessedOn(BigDecimal processedOn) {
		this.processedOn = processedOn;
	}

	public String getFreightCharges() {
		return freightCharges;
	}

	public void setFreightCharges(String freightCharges) {
		this.freightCharges = freightCharges;
	}

	public String getShipperAccount() {
		return shipperAccount;
	}

	public void setShipperAccount(String shipperAccount) {
		this.shipperAccount = shipperAccount;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getFob() {
		return fob;
	}

	public void setFob(String fob) {
		this.fob = fob;
	}

	@JsonProperty("isAlternateReturnAddress")
	public boolean isAlternateReturnAddress() {
		return isAlternateReturnAddress;
	}

	@JsonProperty("isAlternateReturnAddress")
	public void setAlternateReturnAddress(boolean alternateReturnAddress) {
		isAlternateReturnAddress = alternateReturnAddress;
	}

	@JsonIgnore
	public Integer getReturnBusinessPartnerId() {
		return returnBusinessPartnerId;
	}

	@JsonIgnore
	public void setReturnBusinessPartnerId(Integer returnBusinessPartnerId) {
		this.returnBusinessPartnerId = returnBusinessPartnerId;
	}

	public BusinessPartner getReturnBusinessPartner() {
		return returnBusinessPartner;
	}

	public void setReturnBusinessPartner(BusinessPartner returnBusinessPartner) {
		this.returnBusinessPartner = returnBusinessPartner;
	}

	@JsonIgnore
	public Integer getReturnBusinessPartnerLocationId() {
		return returnBusinessPartnerLocationId;
	}

	@JsonIgnore
	public void setReturnBusinessPartnerLocationId(Integer returnBusinessPartnerLocationId) {
		this.returnBusinessPartnerLocationId = returnBusinessPartnerLocationId;
	}

	public BusinessPartnerLocation getReturnBusinessPartnerLocation() {
		return returnBusinessPartnerLocation;
	}

	public void setReturnBusinessPartnerLocation(
			BusinessPartnerLocation returnBusinessPartnerLocation) {
		this.returnBusinessPartnerLocation = returnBusinessPartnerLocation;
	}

	@JsonIgnore
	public Integer getReturnUserId() {
		return returnUserId;
	}

	@JsonIgnore
	public void setReturnUserId(Integer returnUserId) {
		this.returnUserId = returnUserId;
	}

	public User getReturnUser() {
		return returnUser;
	}

	public void setReturnUser(User returnUser) {
		this.returnUser = returnUser;
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
