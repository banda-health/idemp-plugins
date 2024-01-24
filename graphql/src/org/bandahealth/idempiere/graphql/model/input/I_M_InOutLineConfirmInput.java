package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_InOutLineConfirm;

/**
 * Generated Interface for M_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_InOutLineConfirmInput extends I_M_InOutLineConfirm {

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
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	ForeignEntityInput C_InvoiceLine();

	/**
	 * Set M_InOutConfirm.
	 *
	 * @param M_InOutConfirm Material Shipment or Receipt Confirmation
	 */
	void setM_InOutConfirmInput(ForeignEntityInput M_InOutConfirm);

	/**
	 * Get M_InOutConfirm.
	 *
	 * @return Material Shipment or Receipt Confirmation
	 */
	ForeignEntityInput M_InOutConfirm();

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
}
