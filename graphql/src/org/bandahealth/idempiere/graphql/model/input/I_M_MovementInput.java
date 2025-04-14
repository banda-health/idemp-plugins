package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Movement;

/**
 * Generated Interface for M_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_MovementInput extends I_M_Movement {

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
	 * Set BH_From_Warehouse.
	 *
	 * @param BH_From_Warehouse BH_From_Warehouse_ID
	 */
	void setBH_From_WarehouseInput(ForeignEntityInput BH_From_Warehouse);

	/**
	 * Get BH_From_Warehouse.
	 *
	 * @return BH_From_Warehouse_ID
	 */
	ForeignEntityInput BH_From_Warehouse();

	/**
	 * Set BH_To_Warehouse.
	 *
	 * @param BH_To_Warehouse BH_To_Warehouse_ID
	 */
	void setBH_To_WarehouseInput(ForeignEntityInput BH_To_Warehouse);

	/**
	 * Get BH_To_Warehouse.
	 *
	 * @return BH_To_Warehouse_ID
	 */
	ForeignEntityInput BH_To_Warehouse();

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
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	ForeignEntityInput C_BPartner_Location();

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(ForeignEntityInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	ForeignEntityInput C_DocType();

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
	 * Set DD_Order.
	 *
	 * @param DD_Order DD_Order
	 */
	void setDD_OrderInput(ForeignEntityInput DD_Order);

	/**
	 * Get DD_Order.
	 *
	 * @return DD_Order
	 */
	ForeignEntityInput DD_Order();

	/**
	 * Set DeliveryRule.
	 *
	 * @param DeliveryRule Defines the timing of Delivery
	 */
	void setDeliveryRuleInput(ForeignEntityInput DeliveryRule);

	/**
	 * Get DeliveryRule.
	 *
	 * @return Defines the timing of Delivery
	 */
	ForeignEntityInput DeliveryRule();

	/**
	 * Set DeliveryViaRule.
	 *
	 * @param DeliveryViaRule How the order will be delivered
	 */
	void setDeliveryViaRuleInput(ForeignEntityInput DeliveryViaRule);

	/**
	 * Get DeliveryViaRule.
	 *
	 * @return How the order will be delivered
	 */
	ForeignEntityInput DeliveryViaRule();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(ForeignEntityInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	ForeignEntityInput DocAction();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(ForeignEntityInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	ForeignEntityInput DocStatus();

	/**
	 * Set FreightCostRule.
	 *
	 * @param FreightCostRule Method for charging Freight
	 */
	void setFreightCostRuleInput(ForeignEntityInput FreightCostRule);

	/**
	 * Get FreightCostRule.
	 *
	 * @return Method for charging Freight
	 */
	ForeignEntityInput FreightCostRule();

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
	 * Set M_Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	void setM_ShipperInput(ForeignEntityInput M_Shipper);

	/**
	 * Get M_Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	ForeignEntityInput M_Shipper();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(ForeignEntityInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	ForeignEntityInput M_Warehouse();

	/**
	 * Set M_WarehouseTo.
	 *
	 * @param M_WarehouseTo To Storage Warehouse and Service Point
	 */
	void setM_WarehouseToInput(ForeignEntityInput M_WarehouseTo);

	/**
	 * Get M_WarehouseTo.
	 *
	 * @return To Storage Warehouse and Service Point
	 */
	ForeignEntityInput M_WarehouseTo();

	/**
	 * Set PriorityRule.
	 *
	 * @param PriorityRule Priority of a document
	 */
	void setPriorityRuleInput(ForeignEntityInput PriorityRule);

	/**
	 * Get PriorityRule.
	 *
	 * @return Priority of a document
	 */
	ForeignEntityInput PriorityRule();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversalInput(ForeignEntityInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	ForeignEntityInput Reversal();

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
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1Input(ForeignEntityInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	ForeignEntityInput User1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2Input(ForeignEntityInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	ForeignEntityInput User2();
}
