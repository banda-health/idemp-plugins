package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_InOutLineConfirm;

/**
 * Generated Interface for I_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_I_InOutLineConfirmInput extends I_I_InOutLineConfirm {

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
	 * Set M_InOutLineConfirm.
	 *
	 * @param M_InOutLineConfirm Material Shipment or Receipt Confirmation Line
	 */
	void setM_InOutLineConfirmInput(ForeignEntityInput M_InOutLineConfirm);

	/**
	 * Get M_InOutLineConfirm.
	 *
	 * @return Material Shipment or Receipt Confirmation Line
	 */
	ForeignEntityInput M_InOutLineConfirm();
}
