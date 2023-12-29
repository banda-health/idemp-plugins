package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_POSKeyLayout;

/**
 * Generated Interface for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_POSKeyLayoutInput extends I_C_POSKeyLayout {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_PrintColor.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	void setAD_PrintColor(I_AD_PrintColorInput AD_PrintColor);

	/**
	 * Get AD_PrintColor.
	 *
	 * @return Color used for printing and display
	 */
	I_AD_PrintColorInput getAD_PrintColor();

	/**
	 * Set AD_PrintFont.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	void setAD_PrintFont(I_AD_PrintFontInput AD_PrintFont);

	/**
	 * Get AD_PrintFont.
	 *
	 * @return Maintain Print Font
	 */
	I_AD_PrintFontInput getAD_PrintFont();

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

	/**
	 * Set POSKeyLayoutType_RL.
	 *
	 * @param POSKeyLayoutType_RL The type of Key Layout
	 */
	void setPOSKeyLayoutType_RL(I_AD_Ref_ListInput POSKeyLayoutType_RL);

	/**
	 * Get POSKeyLayoutType_RL.
	 *
	 * @return The type of Key Layout
	 */
	I_AD_Ref_ListInput getPOSKeyLayoutType_RL();
}
