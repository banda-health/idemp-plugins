package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Invoice;

/**
 * Generated Interface for C_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_InvoiceInput extends I_C_Invoice {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

	/**
	 * Column name BH_NavButtons
	 */
	public static final String COLUMNNAME_BH_NavButtons = "BH_NavButtons";

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	public void setBH_NavButtons(Object BH_NavButtons);

	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	public Object getBH_NavButtons();

	/**
	 * Set BH_Visit.
	 *
	 * @param BH_Visit BH_Visit
	 */
	void setBH_Visit(I_BH_VisitInput BH_Visit);

	/**
	 * Get BH_Visit.
	 *
	 * @return BH_Visit
	 */
	I_BH_VisitInput getBH_Visit();

	/**
	 * Column name BH_Visit_ID
	 */
	public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */
	public void setBH_Visit_ID(int BH_Visit_ID);

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public int getBH_Visit_ID();

	/**
	 * Set BH_Voided_Reason.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason
	 */
	void setBH_Voided_Reason(I_BH_Voided_ReasonInput BH_Voided_Reason);

	/**
	 * Get BH_Voided_Reason.
	 *
	 * @return BH_Voided_Reason
	 */
	I_BH_Voided_ReasonInput getBH_Voided_Reason();

	/**
	 * Column name BH_Voided_Reason_ID
	 */
	public static final String COLUMNNAME_BH_Voided_Reason_ID = "BH_Voided_Reason_ID";

	/**
	 * Set BH_Voided_Reason_ID.
	 *
	 * @param BH_Voided_Reason_ID BH_Voided_Reason_ID
	 */
	public void setBH_Voided_Reason_ID(int BH_Voided_Reason_ID);

	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	public int getBH_Voided_Reason_ID();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_Activity(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput getC_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput getC_BPartner_Location();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_Campaign(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput getC_Campaign();

	/**
	 * Set C_CashLine.
	 *
	 * @param C_CashLine Cash Journal Line
	 */
	void setC_CashLine(I_C_CashLineInput C_CashLine);

	/**
	 * Get C_CashLine.
	 *
	 * @return Cash Journal Line
	 */
	I_C_CashLineInput getC_CashLine();

	/**
	 * Set C_CashPlanLine.
	 *
	 * @param C_CashPlanLine C_CashPlanLine
	 */
	void setC_CashPlanLine(I_C_CashPlanLineInput C_CashPlanLine);

	/**
	 * Get C_CashPlanLine.
	 *
	 * @return C_CashPlanLine
	 */
	I_C_CashPlanLineInput getC_CashPlanLine();

	/**
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_Charge(I_C_ChargeInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	I_C_ChargeInput getC_Charge();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionType(I_C_ConversionTypeInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	I_C_ConversionTypeInput getC_ConversionType();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocType(I_C_DocTypeInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	I_C_DocTypeInput getC_DocType();

	/**
	 * Set C_DocTypeTarget.
	 *
	 * @param C_DocTypeTarget Target document type for conversing documents
	 */
	void setC_DocTypeTarget(I_C_DocTypeInput C_DocTypeTarget);

	/**
	 * Get C_DocTypeTarget.
	 *
	 * @return Target document type for conversing documents
	 */
	I_C_DocTypeInput getC_DocTypeTarget();

	/**
	 * Set C_DunningLevel.
	 *
	 * @param C_DunningLevel C_DunningLevel
	 */
	void setC_DunningLevel(I_C_DunningLevelInput C_DunningLevel);

	/**
	 * Get C_DunningLevel.
	 *
	 * @return C_DunningLevel
	 */
	I_C_DunningLevelInput getC_DunningLevel();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_Order(I_C_OrderInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	I_C_OrderInput getC_Order();

	/**
	 * Set C_Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	void setC_Payment(I_C_PaymentInput C_Payment);

	/**
	 * Get C_Payment.
	 *
	 * @return Payment identifier
	 */
	I_C_PaymentInput getC_Payment();

	/**
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTerm(I_C_PaymentTermInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	I_C_PaymentTermInput getC_PaymentTerm();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

	/**
	 * Set DocAction_RL.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL);

	/**
	 * Get DocAction_RL.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput getDocAction_RL();

	/**
	 * Set DocStatus_RL.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL);

	/**
	 * Get DocStatus_RL.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput getDocStatus_RL();

	/**
	 * Set InvoiceCollectionType_RL.
	 *
	 * @param InvoiceCollectionType_RL Invoice Collection Status
	 */
	void setInvoiceCollectionType_RL(I_AD_Ref_ListInput InvoiceCollectionType_RL);

	/**
	 * Get InvoiceCollectionType_RL.
	 *
	 * @return Invoice Collection Status
	 */
	I_AD_Ref_ListInput getInvoiceCollectionType_RL();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceList(I_M_PriceListInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	I_M_PriceListInput getM_PriceList();

	/**
	 * Set M_RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	void setM_RMA(I_M_RMAInput M_RMA);

	/**
	 * Get M_RMA.
	 *
	 * @return Return Material Authorization
	 */
	I_M_RMAInput getM_RMA();

	/**
	 * Set RelatedInvoice.
	 *
	 * @param RelatedInvoice RelatedInvoice
	 */
	void setRelatedInvoice(I_C_InvoiceInput RelatedInvoice);

	/**
	 * Get RelatedInvoice.
	 *
	 * @return RelatedInvoice
	 */
	I_C_InvoiceInput getRelatedInvoice();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversal(I_C_InvoiceInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	I_C_InvoiceInput getReversal();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRep(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput getSalesRep();

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1(I_C_ElementValueInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	I_C_ElementValueInput getUser1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2(I_C_ElementValueInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	I_C_ElementValueInput getUser2();
}
