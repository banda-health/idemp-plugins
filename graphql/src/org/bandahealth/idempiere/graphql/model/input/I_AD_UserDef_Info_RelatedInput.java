package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserDef_Info_Related;

/**
 * Generated Interface for AD_UserDef_Info_Related - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_UserDef_Info_RelatedInput extends I_AD_UserDef_Info_Related {

	/**
	 * Set AD_InfoRelated.
	 *
	 * @param AD_InfoRelated AD_InfoRelated
	 */
	void setAD_InfoRelatedInput(ForeignEntityInput AD_InfoRelated);

	/**
	 * Get AD_InfoRelated.
	 *
	 * @return AD_InfoRelated
	 */
	ForeignEntityInput AD_InfoRelated();

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
	 * Set AD_UserDef_Info.
	 *
	 * @param AD_UserDef_Info AD_UserDef_Info
	 */
	void setAD_UserDef_InfoInput(ForeignEntityInput AD_UserDef_Info);

	/**
	 * Get AD_UserDef_Info.
	 *
	 * @return AD_UserDef_Info
	 */
	ForeignEntityInput AD_UserDef_Info();

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
