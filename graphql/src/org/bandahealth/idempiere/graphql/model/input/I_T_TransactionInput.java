package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_T_Transaction;

/**
 * Generated Interface for T_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_T_TransactionInput extends I_T_Transaction {

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
	 * Set AD_PInstance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	void setAD_PInstanceInput(ForeignEntityInput AD_PInstance);

	/**
	 * Get AD_PInstance.
	 *
	 * @return Instance of the process
	 */
	ForeignEntityInput AD_PInstance();

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
	 * Set C_ProjectIssue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue);

	/**
	 * Get C_ProjectIssue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	ForeignEntityInput C_ProjectIssue();

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
	 * Set M_InOutLine.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	void setM_InOutLineInput(ForeignEntityInput M_InOutLine);

	/**
	 * Get M_InOutLine.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	ForeignEntityInput M_InOutLine();

	/**
	 * Set M_Inventory.
	 *
	 * @param M_Inventory Parameters for a Physical Inventory
	 */
	void setM_InventoryInput(ForeignEntityInput M_Inventory);

	/**
	 * Get M_Inventory.
	 *
	 * @return Parameters for a Physical Inventory
	 */
	ForeignEntityInput M_Inventory();

	/**
	 * Set M_InventoryLine.
	 *
	 * @param M_InventoryLine Unique line in an Inventory document
	 */
	void setM_InventoryLineInput(ForeignEntityInput M_InventoryLine);

	/**
	 * Get M_InventoryLine.
	 *
	 * @return Unique line in an Inventory document
	 */
	ForeignEntityInput M_InventoryLine();

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
	 * Set M_Movement.
	 *
	 * @param M_Movement Movement of Inventory
	 */
	void setM_MovementInput(ForeignEntityInput M_Movement);

	/**
	 * Get M_Movement.
	 *
	 * @return Movement of Inventory
	 */
	ForeignEntityInput M_Movement();

	/**
	 * Set M_MovementLine.
	 *
	 * @param M_MovementLine Inventory Move document Line
	 */
	void setM_MovementLineInput(ForeignEntityInput M_MovementLine);

	/**
	 * Get M_MovementLine.
	 *
	 * @return Inventory Move document Line
	 */
	ForeignEntityInput M_MovementLine();

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
	 * Set M_Production.
	 *
	 * @param M_Production Plan for producing a product
	 */
	void setM_ProductionInput(ForeignEntityInput M_Production);

	/**
	 * Get M_Production.
	 *
	 * @return Plan for producing a product
	 */
	ForeignEntityInput M_Production();

	/**
	 * Set M_ProductionLine.
	 *
	 * @param M_ProductionLine Document Line representing a production
	 */
	void setM_ProductionLineInput(ForeignEntityInput M_ProductionLine);

	/**
	 * Get M_ProductionLine.
	 *
	 * @return Document Line representing a production
	 */
	ForeignEntityInput M_ProductionLine();

	/**
	 * Set M_Transaction.
	 *
	 * @param M_Transaction M_Transaction
	 */
	void setM_TransactionInput(ForeignEntityInput M_Transaction);

	/**
	 * Get M_Transaction.
	 *
	 * @return M_Transaction
	 */
	ForeignEntityInput M_Transaction();

	/**
	 * Set MovementType.
	 *
	 * @param MovementType Method of moving the inventory
	 */
	void setMovementTypeInput(ForeignEntityInput MovementType);

	/**
	 * Get MovementType.
	 *
	 * @return Method of moving the inventory
	 */
	ForeignEntityInput MovementType();

	/**
	 * Set Search_InOut.
	 *
	 * @param Search_InOut Material Shipment Document
	 */
	void setSearch_InOutInput(ForeignEntityInput Search_InOut);

	/**
	 * Get Search_InOut.
	 *
	 * @return Material Shipment Document
	 */
	ForeignEntityInput Search_InOut();

	/**
	 * Set Search_Invoice.
	 *
	 * @param Search_Invoice Search Invoice Identifier
	 */
	void setSearch_InvoiceInput(ForeignEntityInput Search_Invoice);

	/**
	 * Get Search_Invoice.
	 *
	 * @return Search Invoice Identifier
	 */
	ForeignEntityInput Search_Invoice();

	/**
	 * Set Search_Order.
	 *
	 * @param Search_Order Order Identifier
	 */
	void setSearch_OrderInput(ForeignEntityInput Search_Order);

	/**
	 * Get Search_Order.
	 *
	 * @return Order Identifier
	 */
	ForeignEntityInput Search_Order();

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
}
