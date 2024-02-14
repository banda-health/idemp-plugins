package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Encounter_Type_Window;

/**
 * Generated Interface for BH_Encounter_Type_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_BH_Encounter_Type_WindowInput extends I_BH_Encounter_Type_Window {

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
	void setBH_Encounter_TypeInput(I_AD_Ref_ListInput BH_Encounter_Type);

	/**
	 * Get BH_Encounter_Type.
	 *
	 * @return BH_Encounter_Type
	 */
	I_AD_Ref_ListInput BH_Encounter_Type();

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
