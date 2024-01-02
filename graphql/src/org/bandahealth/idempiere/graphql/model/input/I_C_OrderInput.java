package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Order;

/**
 * Generated Interface for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_OrderInput extends I_C_Order {

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
	 * Set Bill_BPartner.
	 *
	 * @param Bill_BPartner Business Partner to be invoiced
	 */
	void setBill_BPartnerInput(I_C_BPartnerInput Bill_BPartner);

	/**
	 * Get Bill_BPartner.
	 *
	 * @return Business Partner to be invoiced
	 */
	I_C_BPartnerInput Bill_BPartner();

	/**
	 * Set Bill_Location.
	 *
	 * @param Bill_Location Business Partner Location for invoicing
	 */
	void setBill_LocationInput(I_C_BPartner_LocationInput Bill_Location);

	/**
	 * Get Bill_Location.
	 *
	 * @return Business Partner Location for invoicing
	 */
	I_C_BPartner_LocationInput Bill_Location();

	/**
	 * Set Bill_User.
	 *
	 * @param Bill_User Business Partner Contact for invoicing
	 */
	void setBill_UserInput(I_AD_UserInput Bill_User);

	/**
	 * Get Bill_User.
	 *
	 * @return Business Partner Contact for invoicing
	 */
	I_AD_UserInput Bill_User();

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
	 * Set C_Opportunity.
	 *
	 * @param C_Opportunity C_Opportunity
	 */
	void setC_OpportunityInput(I_C_OpportunityInput C_Opportunity);

	/**
	 * Get C_Opportunity.
	 *
	 * @return C_Opportunity
	 */
	I_C_OpportunityInput C_Opportunity();

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
	 * Set C_OrderSource.
	 *
	 * @param C_OrderSource C_OrderSource
	 */
	void setC_OrderSourceInput(I_C_OrderSourceInput C_OrderSource);

	/**
	 * Get C_OrderSource.
	 *
	 * @return C_OrderSource
	 */
	I_C_OrderSourceInput C_OrderSource();

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
	 * Set C_POS.
	 *
	 * @param C_POS Point of Sales Terminal
	 */
	void setC_POSInput(I_C_POSInput C_POS);

	/**
	 * Get C_POS.
	 *
	 * @return Point of Sales Terminal
	 */
	I_C_POSInput C_POS();

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
	 * Set DeliveryRule.
	 *
	 * @param DeliveryRule Defines the timing of Delivery
	 */
	void setDeliveryRuleInput(I_AD_Ref_ListInput DeliveryRule);

	/**
	 * Get DeliveryRule.
	 *
	 * @return Defines the timing of Delivery
	 */
	I_AD_Ref_ListInput DeliveryRule();

	/**
	 * Set DeliveryViaRule.
	 *
	 * @param DeliveryViaRule How the order will be delivered
	 */
	void setDeliveryViaRuleInput(I_AD_Ref_ListInput DeliveryViaRule);

	/**
	 * Get DeliveryViaRule.
	 *
	 * @return How the order will be delivered
	 */
	I_AD_Ref_ListInput DeliveryViaRule();

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
	 * Set DropShip_BPartner.
	 *
	 * @param DropShip_BPartner Business Partner to ship to
	 */
	void setDropShip_BPartnerInput(I_C_BPartnerInput DropShip_BPartner);

	/**
	 * Get DropShip_BPartner.
	 *
	 * @return Business Partner to ship to
	 */
	I_C_BPartnerInput DropShip_BPartner();

	/**
	 * Set DropShip_Location.
	 *
	 * @param DropShip_Location Business Partner Location for shipping to
	 */
	void setDropShip_LocationInput(I_C_BPartner_LocationInput DropShip_Location);

	/**
	 * Get DropShip_Location.
	 *
	 * @return Business Partner Location for shipping to
	 */
	I_C_BPartner_LocationInput DropShip_Location();

	/**
	 * Set DropShip_User.
	 *
	 * @param DropShip_User Business Partner Contact for drop shipment
	 */
	void setDropShip_UserInput(I_AD_UserInput DropShip_User);

	/**
	 * Get DropShip_User.
	 *
	 * @return Business Partner Contact for drop shipment
	 */
	I_AD_UserInput DropShip_User();

	/**
	 * Set FreightCostRule.
	 *
	 * @param FreightCostRule Method for charging Freight
	 */
	void setFreightCostRuleInput(I_AD_Ref_ListInput FreightCostRule);

	/**
	 * Get FreightCostRule.
	 *
	 * @return Method for charging Freight
	 */
	I_AD_Ref_ListInput FreightCostRule();

	/**
	 * Set InvoiceRule.
	 *
	 * @param InvoiceRule Frequency and method of invoicing 
	 */
	void setInvoiceRuleInput(I_AD_Ref_ListInput InvoiceRule);

	/**
	 * Get InvoiceRule.
	 *
	 * @return Frequency and method of invoicing 
	 */
	I_AD_Ref_ListInput InvoiceRule();

	/**
	 * Set Link_Order.
	 *
	 * @param Link_Order This field links a sales order to the purchase order that is generated from it.
	 */
	void setLink_OrderInput(I_C_OrderInput Link_Order);

	/**
	 * Get Link_Order.
	 *
	 * @return This field links a sales order to the purchase order that is generated from it.
	 */
	I_C_OrderInput Link_Order();

	/**
	 * Set M_FreightCategory.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	void setM_FreightCategoryInput(I_M_FreightCategoryInput M_FreightCategory);

	/**
	 * Get M_FreightCategory.
	 *
	 * @return Category of the Freight
	 */
	I_M_FreightCategoryInput M_FreightCategory();

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
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_ShipperInput(I_M_ShipperInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	I_M_ShipperInput M_Shipper();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput M_Warehouse();

	/**
	 * Set PriorityRule.
	 *
	 * @param PriorityRule Priority of a document
	 */
	void setPriorityRuleInput(I_AD_Ref_ListInput PriorityRule);

	/**
	 * Get PriorityRule.
	 *
	 * @return Priority of a document
	 */
	I_AD_Ref_ListInput PriorityRule();

	/**
	 * Set QuotationOrder.
	 *
	 * @param QuotationOrder Quotation used for generating this order
	 */
	void setQuotationOrderInput(I_C_OrderInput QuotationOrder);

	/**
	 * Get QuotationOrder.
	 *
	 * @return Quotation used for generating this order
	 */
	I_C_OrderInput QuotationOrder();

	/**
	 * Set Ref_Order.
	 *
	 * @param Ref_Order Reference to corresponding Sales/Purchase Order
	 */
	void setRef_OrderInput(I_C_OrderInput Ref_Order);

	/**
	 * Get Ref_Order.
	 *
	 * @return Reference to corresponding Sales/Purchase Order
	 */
	I_C_OrderInput Ref_Order();

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
