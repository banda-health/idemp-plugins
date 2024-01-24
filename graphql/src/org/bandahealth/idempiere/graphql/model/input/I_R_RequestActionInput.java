package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_RequestAction;

/**
 * Generated Interface for R_RequestAction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_R_RequestActionInput extends I_R_RequestAction {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(ForeignEntityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	ForeignEntityInput C_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_InvoiceInput(ForeignEntityInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	ForeignEntityInput C_Invoice();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(ForeignEntityInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	ForeignEntityInput C_Order();

	/**
	 * Set C_Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	void setC_PaymentInput(ForeignEntityInput C_Payment);

	/**
	 * Get C_Payment.
	 *
	 * @return Payment identifier
	 */
	ForeignEntityInput C_Payment();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

	/**
	 * Set ConfidentialType.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	void setConfidentialTypeInput(I_AD_Ref_ListInput ConfidentialType);

	/**
	 * Get ConfidentialType.
	 *
	 * @return Type of Confidentiality
	 */
	I_AD_Ref_ListInput ConfidentialType();

	/**
	 * Set IsEscalated.
	 *
	 * @param IsEscalated This request has been escalated
	 */
	void setIsEscalatedInput(I_AD_Ref_ListInput IsEscalated);

	/**
	 * Get IsEscalated.
	 *
	 * @return This request has been escalated
	 */
	I_AD_Ref_ListInput IsEscalated();

	/**
	 * Set IsSelfService.
	 *
	 * @param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
	 */
	void setIsSelfServiceInput(I_AD_Ref_ListInput IsSelfService);

	/**
	 * Get IsSelfService.
	 *
	 * @return This is a Self-Service entry or this entry can be changed via Self-Service
	 */
	I_AD_Ref_ListInput IsSelfService();

	/**
	 * Set M_InOut.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	void setM_InOutInput(ForeignEntityInput M_InOut);

	/**
	 * Get M_InOut.
	 *
	 * @return Material Shipment Document
	 */
	ForeignEntityInput M_InOut();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

	/**
	 * Set M_ProductSpent.
	 *
	 * @param M_ProductSpent Product/Resource/Service used in Request
	 */
	void setM_ProductSpentInput(ForeignEntityInput M_ProductSpent);

	/**
	 * Get M_ProductSpent.
	 *
	 * @return Product/Resource/Service used in Request
	 */
	ForeignEntityInput M_ProductSpent();

	/**
	 * Set M_RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	void setM_RMAInput(ForeignEntityInput M_RMA);

	/**
	 * Get M_RMA.
	 *
	 * @return Return Material Authorization
	 */
	ForeignEntityInput M_RMA();

	/**
	 * Set Priority.
	 *
	 * @param Priority Indicates if this request is of a high, medium or low priority.
	 */
	void setPriorityInput(I_AD_Ref_ListInput Priority);

	/**
	 * Get Priority.
	 *
	 * @return Indicates if this request is of a high, medium or low priority.
	 */
	I_AD_Ref_ListInput Priority();

	/**
	 * Set PriorityUser.
	 *
	 * @param PriorityUser Priority of the issue for the User
	 */
	void setPriorityUserInput(I_AD_Ref_ListInput PriorityUser);

	/**
	 * Get PriorityUser.
	 *
	 * @return Priority of the issue for the User
	 */
	I_AD_Ref_ListInput PriorityUser();

	/**
	 * Set R_Category.
	 *
	 * @param R_Category Request Category
	 */
	void setR_CategoryInput(ForeignEntityInput R_Category);

	/**
	 * Get R_Category.
	 *
	 * @return Request Category
	 */
	ForeignEntityInput R_Category();

	/**
	 * Set R_Group.
	 *
	 * @param R_Group Request Group
	 */
	void setR_GroupInput(ForeignEntityInput R_Group);

	/**
	 * Get R_Group.
	 *
	 * @return Request Group
	 */
	ForeignEntityInput R_Group();

	/**
	 * Set R_Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	void setR_RequestInput(ForeignEntityInput R_Request);

	/**
	 * Get R_Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	ForeignEntityInput R_Request();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set R_RequestType.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	void setR_RequestTypeInput(ForeignEntityInput R_RequestType);

	/**
	 * Get R_RequestType.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	ForeignEntityInput R_RequestType();

	/**
	 * Set R_Resolution.
	 *
	 * @param R_Resolution Request Resolution
	 */
	void setR_ResolutionInput(ForeignEntityInput R_Resolution);

	/**
	 * Get R_Resolution.
	 *
	 * @return Request Resolution
	 */
	ForeignEntityInput R_Resolution();

	/**
	 * Set R_Status.
	 *
	 * @param R_Status Request Status
	 */
	void setR_StatusInput(ForeignEntityInput R_Status);

	/**
	 * Get R_Status.
	 *
	 * @return Request Status
	 */
	ForeignEntityInput R_Status();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(ForeignEntityInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	ForeignEntityInput SalesRep();

	/**
	 * Set TaskStatus.
	 *
	 * @param TaskStatus Status of the Task
	 */
	void setTaskStatusInput(I_AD_Ref_ListInput TaskStatus);

	/**
	 * Get TaskStatus.
	 *
	 * @return Status of the Task
	 */
	I_AD_Ref_ListInput TaskStatus();
}
