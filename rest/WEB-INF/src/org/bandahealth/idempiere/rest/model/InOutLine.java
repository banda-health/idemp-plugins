package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MInOutLine;

import java.math.BigDecimal;

public class InOutLine extends BaseMetadata {
	private Integer line;
	private String description;
	@JsonIgnore
	private Integer inOutId;
	private InOut inOut;
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
	private Integer uomId;
	private BigDecimal movementQuantity;
	@JsonProperty("isInvoiced")
	private boolean isInvoiced;
	@JsonIgnore
	private Integer attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;
	@JsonProperty("isDescription")
	private boolean isDescription;
	private BigDecimal confirmedQuantity;
	private BigDecimal pickedQuantity;
	private BigDecimal scrappedQuantity;
	private BigDecimal targetQuantity;
	@JsonIgnore
	private Integer referenceInOutLineId;
	private InOutLine referenceInOutLine;
	private boolean processed;
	private BigDecimal quantityEntered;
	@JsonIgnore
	private Integer chargeId;
	private Charge charge;
	@JsonIgnore
	private Integer projectId;
	@JsonIgnore
	private Integer projectPhaseId;
	@JsonIgnore
	private Integer projectTaskId;
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
	@JsonIgnore
	private Integer organizationTransactionId;
	@JsonIgnore
	private Integer rmaLinenId;
	@JsonIgnore
	private Integer reversalLineId;
	private InOutLine reversalLine;
	private BigDecimal quantityOverReceipt;

	// Blank constructor for deserialization
	public InOutLine() {}

	public InOutLine(MInOutLine entity) {
		setLine(entity.getLine());
		setDescription(entity.getDescription());
		setInOutId(entity.getM_InOut_ID());
		setOrderLineId(entity.getC_OrderLine_ID());
		setLocatorId(entity.getM_Locator_ID());
		setProductId(entity.getM_Product_ID());
		setUomId(entity.getC_UOM_ID());
		setMovementQuantity(entity.getMovementQty());
		setInvoiced(entity.isInvoiced());
		setAttributeSetInstanceId(entity.getM_AttributeSetInstance_ID());
		setDescription(entity.isDescription());
		setConfirmedQuantity(entity.getConfirmedQty());
		setPickedQuantity(entity.getPickedQty());
		setScrappedQuantity(entity.getScrappedQty());
		setTargetQuantity(entity.getTargetQty());
		setReferenceInOutLineId(entity.getRef_InOutLine_ID());
		setProcessed(entity.isProcessed());
		setQuantityEntered(entity.getQtyEntered());
		setChargeId(entity.getC_Charge_ID());
		setProjectId(entity.getC_Project_ID());
		setProjectPhaseId(entity.getC_ProjectPhase_ID());
		setProjectTaskId(entity.getC_ProjectTask_ID());
		setCampaignId(entity.getC_Campaign_ID());
		setActivityId(entity.getC_Activity_ID());
		setUser1Id(entity.getUser1_ID());
		setUser2Id(entity.getUser2_ID());
		setOrganizationTransactionId(entity.getAD_OrgTrx_ID());
		setRmaLinenId(entity.getM_RMALine_ID());
		setReversalLineId(entity.getReversalLine_ID());
		setQuantityOverReceipt(entity.getQtyOverReceipt());
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

	public InOut getInOut() {
		return inOut;
	}

	public void setInOut(InOut inOut) {
		this.inOut = inOut;
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
	public Integer getUomId() {
		return uomId;
	}

	@JsonIgnore
	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public BigDecimal getMovementQuantity() {
		return movementQuantity;
	}

	public void setMovementQuantity(BigDecimal movementQuantity) {
		this.movementQuantity = movementQuantity;
	}

	@JsonProperty("isInvoiced")
	public boolean isInvoiced() {
		return isInvoiced;
	}

	@JsonProperty("isInvoiced")
	public void setInvoiced(boolean invoiced) {
		isInvoiced = invoiced;
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

	@JsonProperty("isDescription")
	public boolean isDescription() {
		return isDescription;
	}

	@JsonProperty("isDescription")
	public void setDescription(boolean description) {
		isDescription = description;
	}

	public BigDecimal getConfirmedQuantity() {
		return confirmedQuantity;
	}

	public void setConfirmedQuantity(BigDecimal confirmedQuantity) {
		this.confirmedQuantity = confirmedQuantity;
	}

	public BigDecimal getPickedQuantity() {
		return pickedQuantity;
	}

	public void setPickedQuantity(BigDecimal pickedQuantity) {
		this.pickedQuantity = pickedQuantity;
	}

	public BigDecimal getScrappedQuantity() {
		return scrappedQuantity;
	}

	public void setScrappedQuantity(BigDecimal scrappedQuantity) {
		this.scrappedQuantity = scrappedQuantity;
	}

	public BigDecimal getTargetQuantity() {
		return targetQuantity;
	}

	public void setTargetQuantity(BigDecimal targetQuantity) {
		this.targetQuantity = targetQuantity;
	}

	@JsonIgnore
	public Integer getReferenceInOutLineId() {
		return referenceInOutLineId;
	}

	@JsonIgnore
	public void setReferenceInOutLineId(Integer referenceInOutLineId) {
		this.referenceInOutLineId = referenceInOutLineId;
	}

	public InOutLine getReferenceInOutLine() {
		return referenceInOutLine;
	}

	public void setReferenceInOutLine(InOutLine referenceInOutLine) {
		this.referenceInOutLine = referenceInOutLine;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public BigDecimal getQuantityEntered() {
		return quantityEntered;
	}

	public void setQuantityEntered(BigDecimal quantityEntered) {
		this.quantityEntered = quantityEntered;
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

	@JsonIgnore
	public Integer getProjectId() {
		return projectId;
	}

	@JsonIgnore
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonIgnore
	public Integer getProjectPhaseId() {
		return projectPhaseId;
	}

	@JsonIgnore
	public void setProjectPhaseId(Integer projectPhaseId) {
		this.projectPhaseId = projectPhaseId;
	}

	@JsonIgnore
	public Integer getProjectTaskId() {
		return projectTaskId;
	}

	@JsonIgnore
	public void setProjectTaskId(Integer projectTaskId) {
		this.projectTaskId = projectTaskId;
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

	@JsonIgnore
	public Integer getOrganizationTransactionId() {
		return organizationTransactionId;
	}

	@JsonIgnore
	public void setOrganizationTransactionId(Integer organizationTransactionId) {
		this.organizationTransactionId = organizationTransactionId;
	}

	@JsonIgnore
	public Integer getRmaLinenId() {
		return rmaLinenId;
	}

	@JsonIgnore
	public void setRmaLinenId(Integer rmaLinenId) {
		this.rmaLinenId = rmaLinenId;
	}

	@JsonIgnore
	public Integer getReversalLineId() {
		return reversalLineId;
	}

	@JsonIgnore
	public void setReversalLineId(Integer reversalLineId) {
		this.reversalLineId = reversalLineId;
	}

	public InOutLine getReversalLine() {
		return reversalLine;
	}

	public void setReversalLine(InOutLine reversalLine) {
		this.reversalLine = reversalLine;
	}

	public BigDecimal getQuantityOverReceipt() {
		return quantityOverReceipt;
	}

	public void setQuantityOverReceipt(BigDecimal quantityOverReceipt) {
		this.quantityOverReceipt = quantityOverReceipt;
	}
}
