package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payer_Info_Fld_Val;

/**
 * Generated Interface for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_BH_Payer_Info_Fld_ValInput extends I_BH_Payer_Info_Fld_Val {

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
}
