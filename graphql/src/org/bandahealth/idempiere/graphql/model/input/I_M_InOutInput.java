package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_InOut;

/**
 * Generated Interface for M_InOut - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_InOutInput extends I_M_InOut {

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
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_InvoiceInput(I_C_InvoiceInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	I_C_InvoiceInput C_Invoice();

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
	 * Set FOB.
	 *
	 * @param FOB FOB
	 */
	void setFOBInput(I_AD_Ref_ListInput FOB);

	/**
	 * Get FOB.
	 *
	 * @return FOB
	 */
	I_AD_Ref_ListInput FOB();

	/**
	 * Set FreightCharges.
	 *
	 * @param FreightCharges FreightCharges
	 */
	void setFreightChargesInput(I_AD_Ref_ListInput FreightCharges);

	/**
	 * Get FreightCharges.
	 *
	 * @return FreightCharges
	 */
	I_AD_Ref_ListInput FreightCharges();

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
	 * Set Insurance.
	 *
	 * @param Insurance Insurance
	 */
	void setInsuranceInput(I_AD_Ref_ListInput Insurance);

	/**
	 * Get Insurance.
	 *
	 * @return Insurance
	 */
	I_AD_Ref_ListInput Insurance();

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
	 * Set MovementType.
	 *
	 * @param MovementType Method of moving the inventory
	 */
	void setMovementTypeInput(I_AD_Ref_ListInput MovementType);

	/**
	 * Get MovementType.
	 *
	 * @return Method of moving the inventory
	 */
	I_AD_Ref_ListInput MovementType();

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
	 * Set ReturnBPartner.
	 *
	 * @param ReturnBPartner ReturnBPartner
	 */
	void setReturnBPartnerInput(I_C_BPartnerInput ReturnBPartner);

	/**
	 * Get ReturnBPartner.
	 *
	 * @return ReturnBPartner
	 */
	I_C_BPartnerInput ReturnBPartner();

	/**
	 * Set ReturnLocation.
	 *
	 * @param ReturnLocation ReturnLocation
	 */
	void setReturnLocationInput(I_C_BPartner_LocationInput ReturnLocation);

	/**
	 * Get ReturnLocation.
	 *
	 * @return ReturnLocation
	 */
	I_C_BPartner_LocationInput ReturnLocation();

	/**
	 * Set ReturnUser.
	 *
	 * @param ReturnUser ReturnUser
	 */
	void setReturnUserInput(I_AD_UserInput ReturnUser);

	/**
	 * Get ReturnUser.
	 *
	 * @return ReturnUser
	 */
	I_AD_UserInput ReturnUser();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversalInput(I_M_InOutInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	I_M_InOutInput Reversal();

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
