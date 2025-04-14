package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Encounter_Type_Window;

/**
 * Generated Interface for BH_Encounter_Type_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_BH_Encounter_Type_WindowInput extends I_BH_Encounter_Type_Window {

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
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

	/**
	 * Set BH_Encounter_Type.
	 *
	 * @param BH_Encounter_Type BH_Encounter_Type
	 */
	void setBH_Encounter_TypeInput(ForeignEntityInput BH_Encounter_Type);

	/**
	 * Get BH_Encounter_Type.
	 *
	 * @return BH_Encounter_Type
	 */
	ForeignEntityInput BH_Encounter_Type();

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
