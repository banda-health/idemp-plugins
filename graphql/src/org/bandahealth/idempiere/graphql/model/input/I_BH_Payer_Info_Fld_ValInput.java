package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payer_Info_Fld_Val;

/**
 * Generated Interface for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_BH_Payer_Info_Fld_ValInput extends I_BH_Payer_Info_Fld_Val {

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
	 * Set BH_Payer_Info_Fld.
	 *
	 * @param BH_Payer_Info_Fld BH_Payer_Info_Fld
	 */
	void setBH_Payer_Info_FldInput(ForeignEntityInput BH_Payer_Info_Fld);

	/**
	 * Get BH_Payer_Info_Fld.
	 *
	 * @return BH_Payer_Info_Fld
	 */
	ForeignEntityInput BH_Payer_Info_Fld();

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
