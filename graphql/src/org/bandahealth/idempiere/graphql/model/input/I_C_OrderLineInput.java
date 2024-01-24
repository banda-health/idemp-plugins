package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.I_C_OrderLine;

/**
 * Generated Interface for C_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_OrderLineInput extends I_C_OrderLine {

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
	 * Column name BH_Expiration
	 */
	static final String COLUMNNAME_BH_Expiration = "BH_Expiration";

	/**
	 * Set Expire On.
	 *
	 * @param BH_Expiration Expire On
	 */
	void setBH_Expiration(Timestamp BH_Expiration);

	/**
	 * Get Expire On.
	 *
	 * @return Expire On
	 */
	Timestamp getBH_Expiration();

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
	 * Column name BH_NavButtons
	 */
	static final String COLUMNNAME_BH_NavButtons = "BH_NavButtons";

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	void setBH_NavButtons(Object BH_NavButtons);

	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	Object getBH_NavButtons();

	/**
	 * Column name BH_NumOrderLines
	 */
	static final String COLUMNNAME_BH_NumOrderLines = "BH_NumOrderLines";

	/**
	 * Set Number of Order Lines.
	 *
	 * @param BH_NumOrderLines The number of order lines on an order
	 */
	void setBH_NumOrderLines(int BH_NumOrderLines);

	/**
	 * Get Number of Order Lines.
	 *
	 * @return The number of order lines on an order
	 */
	int getBH_NumOrderLines();

	/**
	 * Column name BH_OrderDocStatus
	 */
	static final String COLUMNNAME_BH_OrderDocStatus = "BH_OrderDocStatus";

	/**
	 * Set Document Status.
	 *
	 * @param BH_OrderDocStatus The current status of the document
	 */
	void setBH_OrderDocStatus(String BH_OrderDocStatus);

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	String getBH_OrderDocStatus();

	/**
	 * Column name BH_RequiresExpiration
	 */
	static final String COLUMNNAME_BH_RequiresExpiration = "BH_RequiresExpiration";

	/**
	 * Set Requires Expiration.
	 *
	 * @param BH_RequiresExpiration Requires Expiration
	 */
	void setBH_RequiresExpiration(boolean BH_RequiresExpiration);

	/**
	 * Get Requires Expiration.
	 *
	 * @return Requires Expiration
	 */
	boolean isBH_RequiresExpiration();

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
	 * Set M_Promotion.
	 *
	 * @param M_Promotion M_Promotion
	 */
	void setM_PromotionInput(ForeignEntityInput M_Promotion);

	/**
	 * Get M_Promotion.
	 *
	 * @return M_Promotion
	 */
	ForeignEntityInput M_Promotion();

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
