package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_BP_General_Payer_Info;

/**
 * Generated Interface for BH_BP_General_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_BH_BP_General_Payer_InfoInput extends I_BH_BP_General_Payer_Info {

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
	 * Set BH_BP_Payer_Info.
	 *
	 * @param BH_BP_Payer_Info BH_BP_Payer_Info
	 */
	void setBH_BP_Payer_InfoInput(ForeignEntityInput BH_BP_Payer_Info);

	/**
	 * Get BH_BP_Payer_Info.
	 *
	 * @return BH_BP_Payer_Info
	 */
	ForeignEntityInput BH_BP_Payer_Info();

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
}
