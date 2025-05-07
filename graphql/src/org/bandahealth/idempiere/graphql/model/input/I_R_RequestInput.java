package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_Request;

/**
 * Generated Interface for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_R_RequestInput extends I_R_Request {

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
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

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
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(ForeignEntityInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	ForeignEntityInput C_Campaign();

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
	 * Set C_InvoiceRequest.
	 *
	 * @param C_InvoiceRequest The generated invoice for this request
	 */
	void setC_InvoiceRequestInput(ForeignEntityInput C_InvoiceRequest);

	/**
	 * Get C_InvoiceRequest.
	 *
	 * @return The generated invoice for this request
	 */
	ForeignEntityInput C_InvoiceRequest();

	/**
	 * Set ConfidentialType.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	void setConfidentialTypeInput(ForeignEntityInput ConfidentialType);

	/**
	 * Get ConfidentialType.
	 *
	 * @return Type of Confidentiality
	 */
	ForeignEntityInput ConfidentialType();

	/**
	 * Set ConfidentialTypeEntry.
	 *
	 * @param ConfidentialTypeEntry Confidentiality of the individual entry
	 */
	void setConfidentialTypeEntryInput(ForeignEntityInput ConfidentialTypeEntry);

	/**
	 * Get ConfidentialTypeEntry.
	 *
	 * @return Confidentiality of the individual entry
	 */
	ForeignEntityInput ConfidentialTypeEntry();

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
	 * Set DueType.
	 *
	 * @param DueType Status of the next action for this Request
	 */
	void setDueTypeInput(ForeignEntityInput DueType);

	/**
	 * Get DueType.
	 *
	 * @return Status of the next action for this Request
	 */
	ForeignEntityInput DueType();

	/**
	 * Set M_ChangeRequest.
	 *
	 * @param M_ChangeRequest BOM (Engineering) Change Request
	 */
	void setM_ChangeRequestInput(ForeignEntityInput M_ChangeRequest);

	/**
	 * Get M_ChangeRequest.
	 *
	 * @return BOM (Engineering) Change Request
	 */
	ForeignEntityInput M_ChangeRequest();

	/**
	 * Set M_FixChangeNotice.
	 *
	 * @param M_FixChangeNotice Fixed in Change Notice
	 */
	void setM_FixChangeNoticeInput(ForeignEntityInput M_FixChangeNotice);

	/**
	 * Get M_FixChangeNotice.
	 *
	 * @return Fixed in Change Notice
	 */
	ForeignEntityInput M_FixChangeNotice();

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
	 * Set NextAction.
	 *
	 * @param NextAction Next Action to be taken
	 */
	void setNextActionInput(ForeignEntityInput NextAction);

	/**
	 * Get NextAction.
	 *
	 * @return Next Action to be taken
	 */
	ForeignEntityInput NextAction();

	/**
	 * Set Priority.
	 *
	 * @param Priority Indicates if this request is of a high, medium or low priority.
	 */
	void setPriorityInput(ForeignEntityInput Priority);

	/**
	 * Get Priority.
	 *
	 * @return Indicates if this request is of a high, medium or low priority.
	 */
	ForeignEntityInput Priority();

	/**
	 * Set PriorityUser.
	 *
	 * @param PriorityUser Priority of the issue for the User
	 */
	void setPriorityUserInput(ForeignEntityInput PriorityUser);

	/**
	 * Get PriorityUser.
	 *
	 * @return Priority of the issue for the User
	 */
	ForeignEntityInput PriorityUser();

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
	 * Set R_MailText.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	void setR_MailTextInput(ForeignEntityInput R_MailText);

	/**
	 * Get R_MailText.
	 *
	 * @return Text templates for mailings
	 */
	ForeignEntityInput R_MailText();

	/**
	 * Set R_RequestRelated.
	 *
	 * @param R_RequestRelated Related Request (Master Issue, ..)
	 */
	void setR_RequestRelatedInput(ForeignEntityInput R_RequestRelated);

	/**
	 * Get R_RequestRelated.
	 *
	 * @return Related Request (Master Issue, ..)
	 */
	ForeignEntityInput R_RequestRelated();

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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

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
	 * Set R_StandardResponse.
	 *
	 * @param R_StandardResponse Request Standard Response 
	 */
	void setR_StandardResponseInput(ForeignEntityInput R_StandardResponse);

	/**
	 * Get R_StandardResponse.
	 *
	 * @return Request Standard Response 
	 */
	ForeignEntityInput R_StandardResponse();

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
	void setTaskStatusInput(ForeignEntityInput TaskStatus);

	/**
	 * Get TaskStatus.
	 *
	 * @return Status of the Task
	 */
	ForeignEntityInput TaskStatus();
}
