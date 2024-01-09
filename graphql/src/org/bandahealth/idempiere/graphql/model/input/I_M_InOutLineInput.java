package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_InOutLine;

/**
 * Generated Interface for M_InOutLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_InOutLineInput extends I_M_InOutLine {

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
	 * Set C_OrderLine.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	void setC_OrderLineInput(ForeignEntityInput C_OrderLine);

	/**
	 * Get C_OrderLine.
	 *
	 * @return Sales Order Line
	 */
	ForeignEntityInput C_OrderLine();

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
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_LocatorInput(ForeignEntityInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	ForeignEntityInput M_Locator();

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
	 * Set M_RMALine.
	 *
	 * @param M_RMALine Return Material Authorization Line
	 */
	void setM_RMALineInput(ForeignEntityInput M_RMALine);

	/**
	 * Get M_RMALine.
	 *
	 * @return Return Material Authorization Line
	 */
	ForeignEntityInput M_RMALine();

	/**
	 * Set ReversalLine.
	 *
	 * @param ReversalLine Use to keep the reversal line ID for reversing costing purpose
	 */
	void setReversalLineInput(ForeignEntityInput ReversalLine);

	/**
	 * Get ReversalLine.
	 *
	 * @return Use to keep the reversal line ID for reversing costing purpose
	 */
	ForeignEntityInput ReversalLine();

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
