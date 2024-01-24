package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_MovementConfirm;

/**
 * Generated Interface for M_MovementConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_MovementConfirmInput extends I_M_MovementConfirm {

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
}
