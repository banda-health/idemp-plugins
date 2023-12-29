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
	 * Set Bill_BPartner.
	 *
	 * @param Bill_BPartner Business Partner to be invoiced
	 */
	void setBill_BPartner(I_C_BPartnerInput Bill_BPartner);

	/**
	 * Get Bill_BPartner.
	 *
	 * @return Business Partner to be invoiced
	 */
	I_C_BPartnerInput getBill_BPartner();

	/**
	 * Set Bill_Location.
	 *
	 * @param Bill_Location Business Partner Location for invoicing
	 */
	void setBill_Location(I_C_BPartner_LocationInput Bill_Location);

	/**
	 * Get Bill_Location.
	 *
	 * @return Business Partner Location for invoicing
	 */
	I_C_BPartner_LocationInput getBill_Location();

	/**
	 * Set Bill_User.
	 *
	 * @param Bill_User Business Partner Contact for invoicing
	 */
	void setBill_User(I_AD_UserInput Bill_User);

	/**
	 * Get Bill_User.
	 *
	 * @return Business Partner Contact for invoicing
	 */
	I_AD_UserInput getBill_User();

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
	 * Set C_Opportunity.
	 *
	 * @param C_Opportunity C_Opportunity
	 */
	void setC_Opportunity(I_C_OpportunityInput C_Opportunity);

	/**
	 * Get C_Opportunity.
	 *
	 * @return C_Opportunity
	 */
	I_C_OpportunityInput getC_Opportunity();

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
	void setC_OrderSource(I_C_OrderSourceInput C_OrderSource);

	/**
	 * Get C_OrderSource.
	 *
	 * @return C_OrderSource
	 */
	I_C_OrderSourceInput getC_OrderSource();

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
	 * Set C_POS.
	 *
	 * @param C_POS Point of Sales Terminal
	 */
	void setC_POS(I_C_POSInput C_POS);

	/**
	 * Get C_POS.
	 *
	 * @return Point of Sales Terminal
	 */
	I_C_POSInput getC_POS();

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
	 * Set DeliveryRule_RL.
	 *
	 * @param DeliveryRule_RL Defines the timing of Delivery
	 */
	void setDeliveryRule_RL(I_AD_Ref_ListInput DeliveryRule_RL);

	/**
	 * Get DeliveryRule_RL.
	 *
	 * @return Defines the timing of Delivery
	 */
	I_AD_Ref_ListInput getDeliveryRule_RL();

	/**
	 * Set DeliveryViaRule_RL.
	 *
	 * @param DeliveryViaRule_RL How the order will be delivered
	 */
	void setDeliveryViaRule_RL(I_AD_Ref_ListInput DeliveryViaRule_RL);

	/**
	 * Get DeliveryViaRule_RL.
	 *
	 * @return How the order will be delivered
	 */
	I_AD_Ref_ListInput getDeliveryViaRule_RL();

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
	 * Set DropShip_BPartner.
	 *
	 * @param DropShip_BPartner Business Partner to ship to
	 */
	void setDropShip_BPartner(I_C_BPartnerInput DropShip_BPartner);

	/**
	 * Get DropShip_BPartner.
	 *
	 * @return Business Partner to ship to
	 */
	I_C_BPartnerInput getDropShip_BPartner();

	/**
	 * Set DropShip_Location.
	 *
	 * @param DropShip_Location Business Partner Location for shipping to
	 */
	void setDropShip_Location(I_C_BPartner_LocationInput DropShip_Location);

	/**
	 * Get DropShip_Location.
	 *
	 * @return Business Partner Location for shipping to
	 */
	I_C_BPartner_LocationInput getDropShip_Location();

	/**
	 * Set DropShip_User.
	 *
	 * @param DropShip_User Business Partner Contact for drop shipment
	 */
	void setDropShip_User(I_AD_UserInput DropShip_User);

	/**
	 * Get DropShip_User.
	 *
	 * @return Business Partner Contact for drop shipment
	 */
	I_AD_UserInput getDropShip_User();

	/**
	 * Set FreightCostRule_RL.
	 *
	 * @param FreightCostRule_RL Method for charging Freight
	 */
	void setFreightCostRule_RL(I_AD_Ref_ListInput FreightCostRule_RL);

	/**
	 * Get FreightCostRule_RL.
	 *
	 * @return Method for charging Freight
	 */
	I_AD_Ref_ListInput getFreightCostRule_RL();

	/**
	 * Set InvoiceRule_RL.
	 *
	 * @param InvoiceRule_RL Frequency and method of invoicing 
	 */
	void setInvoiceRule_RL(I_AD_Ref_ListInput InvoiceRule_RL);

	/**
	 * Get InvoiceRule_RL.
	 *
	 * @return Frequency and method of invoicing 
	 */
	I_AD_Ref_ListInput getInvoiceRule_RL();

	/**
	 * Set Link_Order.
	 *
	 * @param Link_Order This field links a sales order to the purchase order that is generated from it.
	 */
	void setLink_Order(I_C_OrderInput Link_Order);

	/**
	 * Get Link_Order.
	 *
	 * @return This field links a sales order to the purchase order that is generated from it.
	 */
	I_C_OrderInput getLink_Order();

	/**
	 * Set M_FreightCategory.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	void setM_FreightCategory(I_M_FreightCategoryInput M_FreightCategory);

	/**
	 * Get M_FreightCategory.
	 *
	 * @return Category of the Freight
	 */
	I_M_FreightCategoryInput getM_FreightCategory();

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
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_Shipper(I_M_ShipperInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	I_M_ShipperInput getM_Shipper();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_Warehouse(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput getM_Warehouse();

	/**
	 * Set PriorityRule_RL.
	 *
	 * @param PriorityRule_RL Priority of a document
	 */
	void setPriorityRule_RL(I_AD_Ref_ListInput PriorityRule_RL);

	/**
	 * Get PriorityRule_RL.
	 *
	 * @return Priority of a document
	 */
	I_AD_Ref_ListInput getPriorityRule_RL();

	/**
	 * Set QuotationOrder.
	 *
	 * @param QuotationOrder Quotation used for generating this order
	 */
	void setQuotationOrder(I_C_OrderInput QuotationOrder);

	/**
	 * Get QuotationOrder.
	 *
	 * @return Quotation used for generating this order
	 */
	I_C_OrderInput getQuotationOrder();

	/**
	 * Set Ref_Order.
	 *
	 * @param Ref_Order Reference to corresponding Sales/Purchase Order
	 */
	void setRef_Order(I_C_OrderInput Ref_Order);

	/**
	 * Get Ref_Order.
	 *
	 * @return Reference to corresponding Sales/Purchase Order
	 */
	I_C_OrderInput getRef_Order();

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
