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
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput AD_User();

	/**
	 * Set BH_Visit.
	 *
	 * @param BH_Visit BH_Visit
	 */
	void setBH_VisitInput(I_BH_VisitInput BH_Visit);

	/**
	 * Get BH_Visit.
	 *
	 * @return BH_Visit
	 */
	I_BH_VisitInput BH_Visit();

	/**
	 * Set BH_Voided_Reason.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason
	 */
	void setBH_Voided_ReasonInput(I_BH_Voided_ReasonInput BH_Voided_Reason);

	/**
	 * Get BH_Voided_Reason.
	 *
	 * @return BH_Voided_Reason
	 */
	I_BH_Voided_ReasonInput BH_Voided_Reason();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput C_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput C_BPartner_Location();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput C_Campaign();

	/**
	 * Set C_CashLine.
	 *
	 * @param C_CashLine Cash Journal Line
	 */
	void setC_CashLineInput(I_C_CashLineInput C_CashLine);

	/**
	 * Get C_CashLine.
	 *
	 * @return Cash Journal Line
	 */
	I_C_CashLineInput C_CashLine();

	/**
	 * Set C_CashPlanLine.
	 *
	 * @param C_CashPlanLine C_CashPlanLine
	 */
	void setC_CashPlanLineInput(I_C_CashPlanLineInput C_CashPlanLine);

	/**
	 * Get C_CashPlanLine.
	 *
	 * @return C_CashPlanLine
	 */
	I_C_CashPlanLineInput C_CashPlanLine();

	/**
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(I_C_ChargeInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	I_C_ChargeInput C_Charge();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionTypeInput(I_C_ConversionTypeInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	I_C_ConversionTypeInput C_ConversionType();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput C_Currency();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(I_C_DocTypeInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	I_C_DocTypeInput C_DocType();

	/**
	 * Set C_DocTypeTarget.
	 *
	 * @param C_DocTypeTarget Target document type for conversing documents
	 */
	void setC_DocTypeTargetInput(I_C_DocTypeInput C_DocTypeTarget);

	/**
	 * Get C_DocTypeTarget.
	 *
	 * @return Target document type for conversing documents
	 */
	I_C_DocTypeInput C_DocTypeTarget();

	/**
	 * Set C_DunningLevel.
	 *
	 * @param C_DunningLevel C_DunningLevel
	 */
	void setC_DunningLevelInput(I_C_DunningLevelInput C_DunningLevel);

	/**
	 * Get C_DunningLevel.
	 *
	 * @return C_DunningLevel
	 */
	I_C_DunningLevelInput C_DunningLevel();

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
	void setC_OrderInput(I_C_OrderInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	I_C_OrderInput C_Order();

	/**
	 * Set C_Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	void setC_PaymentInput(I_C_PaymentInput C_Payment);

	/**
	 * Get C_Payment.
	 *
	 * @return Payment identifier
	 */
	I_C_PaymentInput C_Payment();

	/**
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTermInput(I_C_PaymentTermInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	I_C_PaymentTermInput C_PaymentTerm();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput C_Project();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(I_AD_Ref_ListInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput DocAction();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(I_AD_Ref_ListInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput DocStatus();

	/**
	 * Set InvoiceCollectionType.
	 *
	 * @param InvoiceCollectionType Invoice Collection Status
	 */
	void setInvoiceCollectionTypeInput(I_AD_Ref_ListInput InvoiceCollectionType);

	/**
	 * Get InvoiceCollectionType.
	 *
	 * @return Invoice Collection Status
	 */
	I_AD_Ref_ListInput InvoiceCollectionType();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceListInput(I_M_PriceListInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	I_M_PriceListInput M_PriceList();

	/**
	 * Set M_RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	void setM_RMAInput(I_M_RMAInput M_RMA);

	/**
	 * Get M_RMA.
	 *
	 * @return Return Material Authorization
	 */
	I_M_RMAInput M_RMA();

	/**
	 * Set RelatedInvoice.
	 *
	 * @param RelatedInvoice RelatedInvoice
	 */
	void setRelatedInvoiceInput(I_C_InvoiceInput RelatedInvoice);

	/**
	 * Get RelatedInvoice.
	 *
	 * @return RelatedInvoice
	 */
	I_C_InvoiceInput RelatedInvoice();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversalInput(I_C_InvoiceInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	I_C_InvoiceInput Reversal();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput SalesRep();

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1Input(I_C_ElementValueInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	I_C_ElementValueInput User1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2Input(I_C_ElementValueInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	I_C_ElementValueInput User2();
}
