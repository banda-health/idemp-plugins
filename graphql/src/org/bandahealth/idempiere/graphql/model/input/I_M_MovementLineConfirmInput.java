package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_MovementLineConfirm;

/**
 * Generated Interface for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_MovementLineConfirmInput extends I_M_MovementLineConfirm {

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
	 * Set M_MovementConfirm.
	 *
	 * @param M_MovementConfirm Inventory Move Confirmation
	 */
	void setM_MovementConfirmInput(ForeignEntityInput M_MovementConfirm);

	/**
	 * Get M_MovementConfirm.
	 *
	 * @return Inventory Move Confirmation
	 */
	ForeignEntityInput M_MovementConfirm();

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
