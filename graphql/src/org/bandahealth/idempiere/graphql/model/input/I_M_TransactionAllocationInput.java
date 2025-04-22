package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_TransactionAllocation;

/**
 * Generated Interface for M_TransactionAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_TransactionAllocationInput extends I_M_TransactionAllocation {

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
	 * Set AllocationStrategyType.
	 *
	 * @param AllocationStrategyType Allocation Strategy
	 */
	void setAllocationStrategyTypeInput(ForeignEntityInput AllocationStrategyType);

	/**
	 * Get AllocationStrategyType.
	 *
	 * @return Allocation Strategy
	 */
	ForeignEntityInput AllocationStrategyType();

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
	 * Set Out_M_InOutLine.
	 *
	 * @param Out_M_InOutLine Outgoing Shipment/Receipt
	 */
	void setOut_M_InOutLineInput(ForeignEntityInput Out_M_InOutLine);

	/**
	 * Get Out_M_InOutLine.
	 *
	 * @return Outgoing Shipment/Receipt
	 */
	ForeignEntityInput Out_M_InOutLine();

	/**
	 * Set Out_M_InventoryLine.
	 *
	 * @param Out_M_InventoryLine Outgoing Inventory Line
	 */
	void setOut_M_InventoryLineInput(ForeignEntityInput Out_M_InventoryLine);

	/**
	 * Get Out_M_InventoryLine.
	 *
	 * @return Outgoing Inventory Line
	 */
	ForeignEntityInput Out_M_InventoryLine();

	/**
	 * Set Out_M_ProductionLine.
	 *
	 * @param Out_M_ProductionLine Outgoing Production Line
	 */
	void setOut_M_ProductionLineInput(ForeignEntityInput Out_M_ProductionLine);

	/**
	 * Get Out_M_ProductionLine.
	 *
	 * @return Outgoing Production Line
	 */
	ForeignEntityInput Out_M_ProductionLine();

	/**
	 * Set Out_M_Transaction.
	 *
	 * @param Out_M_Transaction Outgoing Transaction
	 */
	void setOut_M_TransactionInput(ForeignEntityInput Out_M_Transaction);

	/**
	 * Get Out_M_Transaction.
	 *
	 * @return Outgoing Transaction
	 */
	ForeignEntityInput Out_M_Transaction();
}
