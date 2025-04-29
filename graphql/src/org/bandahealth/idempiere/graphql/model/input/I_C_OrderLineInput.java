package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_OrderLine;

import java.math.BigDecimal;

/**
 * Generated Interface for C_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_OrderLineInput extends I_C_OrderLine {

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
	 * Column name BH_Instructions
	 */
	static final String COLUMNNAME_BH_Instructions = "BH_Instructions";

	/**
	 * Set BH_Instructions.
	 *
	 * @param BH_Instructions BH_Instructions
	 */
	void setBH_Instructions(String BH_Instructions);

	/**
	 * Get BH_Instructions.
	 *
	 * @return BH_Instructions
	 */
	String getBH_Instructions();

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
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

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
	 * Set C_ProjectPhase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	void setC_ProjectPhaseInput(ForeignEntityInput C_ProjectPhase);

	/**
	 * Get C_ProjectPhase.
	 *
	 * @return Phase of a Project
	 */
	ForeignEntityInput C_ProjectPhase();

	/**
	 * Set C_ProjectTask.
	 *
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	void setC_ProjectTaskInput(ForeignEntityInput C_ProjectTask);

	/**
	 * Get C_ProjectTask.
	 *
	 * @return Actual Project Task in a Phase
	 */
	ForeignEntityInput C_ProjectTask();

	/**
	 * Set C_Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	void setC_TaxInput(ForeignEntityInput C_Tax);

	/**
	 * Get C_Tax.
	 *
	 * @return Tax identifier
	 */
	ForeignEntityInput C_Tax();

	/**
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOMInput(ForeignEntityInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	ForeignEntityInput C_UOM();

	/**
	 * Set Included_OrderLine.
	 *
	 * @param Included_OrderLine Included_OrderLine
	 */
	void setIncluded_OrderLineInput(ForeignEntityInput Included_OrderLine);

	/**
	 * Get Included_OrderLine.
	 *
	 * @return Included_OrderLine
	 */
	ForeignEntityInput Included_OrderLine();

	/**
	 * Set Link_OrderLine.
	 *
	 * @param Link_OrderLine This field links a sales order line to the purchase order line that is generated from it.
	 */
	void setLink_OrderLineInput(ForeignEntityInput Link_OrderLine);

	/**
	 * Get Link_OrderLine.
	 *
	 * @return This field links a sales order line to the purchase order line that is generated from it.
	 */
	ForeignEntityInput Link_OrderLine();

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstance();

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
	 * Set PP_Cost_Collector.
	 *
	 * @param PP_Cost_Collector PP_Cost_Collector
	 */
	void setPP_Cost_CollectorInput(ForeignEntityInput PP_Cost_Collector);

	/**
	 * Get PP_Cost_Collector.
	 *
	 * @return PP_Cost_Collector
	 */
	ForeignEntityInput PP_Cost_Collector();

	/**
	 * Column name QtyAvailable
	 */
	static final String COLUMNNAME_QtyAvailable = "QtyAvailable";

	/**
	 * Set Available Quantity.
	 *
	 * @param QtyAvailable Available Quantity (On Hand - Reserved)
	 */
	void setQtyAvailable(BigDecimal QtyAvailable);

	/**
	 * Get Available Quantity.
	 *
	 * @return Available Quantity (On Hand - Reserved)
	 */
	BigDecimal getQtyAvailable();

	/**
	 * Set Ref_OrderLine.
	 *
	 * @param Ref_OrderLine Reference to corresponding Sales/Purchase Order
	 */
	void setRef_OrderLineInput(ForeignEntityInput Ref_OrderLine);

	/**
	 * Get Ref_OrderLine.
	 *
	 * @return Reference to corresponding Sales/Purchase Order
	 */
	ForeignEntityInput Ref_OrderLine();

	/**
	 * Set S_ResourceAssignment.
	 *
	 * @param S_ResourceAssignment Resource Assignment
	 */
	void setS_ResourceAssignmentInput(ForeignEntityInput S_ResourceAssignment);

	/**
	 * Get S_ResourceAssignment.
	 *
	 * @return Resource Assignment
	 */
	ForeignEntityInput S_ResourceAssignment();

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
