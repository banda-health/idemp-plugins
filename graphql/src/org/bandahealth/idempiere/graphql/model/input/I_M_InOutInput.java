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
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_Invoice(I_C_InvoiceInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	I_C_InvoiceInput getC_Invoice();

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
	 * Set FOB_RL.
	 *
	 * @param FOB_RL FOB_RL
	 */
	void setFOB_RL(I_AD_Ref_ListInput FOB_RL);

	/**
	 * Get FOB_RL.
	 *
	 * @return FOB_RL
	 */
	I_AD_Ref_ListInput getFOB_RL();

	/**
	 * Set FreightCharges_RL.
	 *
	 * @param FreightCharges_RL FreightCharges_RL
	 */
	void setFreightCharges_RL(I_AD_Ref_ListInput FreightCharges_RL);

	/**
	 * Get FreightCharges_RL.
	 *
	 * @return FreightCharges_RL
	 */
	I_AD_Ref_ListInput getFreightCharges_RL();

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
	 * Set Insurance_RL.
	 *
	 * @param Insurance_RL Insurance_RL
	 */
	void setInsurance_RL(I_AD_Ref_ListInput Insurance_RL);

	/**
	 * Get Insurance_RL.
	 *
	 * @return Insurance_RL
	 */
	I_AD_Ref_ListInput getInsurance_RL();

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
	void setM_RMA(I_M_RMAInput M_RMA);

	/**
	 * Get M_RMA.
	 *
	 * @return Return Material Authorization
	 */
	I_M_RMAInput getM_RMA();

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
	 * Set MovementType_RL.
	 *
	 * @param MovementType_RL Method of moving the inventory
	 */
	void setMovementType_RL(I_AD_Ref_ListInput MovementType_RL);

	/**
	 * Get MovementType_RL.
	 *
	 * @return Method of moving the inventory
	 */
	I_AD_Ref_ListInput getMovementType_RL();

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
	 * Set ReturnBPartner.
	 *
	 * @param ReturnBPartner ReturnBPartner
	 */
	void setReturnBPartner(I_C_BPartnerInput ReturnBPartner);

	/**
	 * Get ReturnBPartner.
	 *
	 * @return ReturnBPartner
	 */
	I_C_BPartnerInput getReturnBPartner();

	/**
	 * Set ReturnLocation.
	 *
	 * @param ReturnLocation ReturnLocation
	 */
	void setReturnLocation(I_C_BPartner_LocationInput ReturnLocation);

	/**
	 * Get ReturnLocation.
	 *
	 * @return ReturnLocation
	 */
	I_C_BPartner_LocationInput getReturnLocation();

	/**
	 * Set ReturnUser.
	 *
	 * @param ReturnUser ReturnUser
	 */
	void setReturnUser(I_AD_UserInput ReturnUser);

	/**
	 * Get ReturnUser.
	 *
	 * @return ReturnUser
	 */
	I_AD_UserInput getReturnUser();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversal(I_M_InOutInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	I_M_InOutInput getReversal();

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
