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
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_PrintColor.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	void setAD_PrintColorInput(I_AD_PrintColorInput AD_PrintColor);

	/**
	 * Get AD_PrintColor.
	 *
	 * @return Color used for printing and display
	 */
	I_AD_PrintColorInput AD_PrintColor();

	/**
	 * Set AD_PrintFont.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	void setAD_PrintFontInput(I_AD_PrintFontInput AD_PrintFont);

	/**
	 * Get AD_PrintFont.
	 *
	 * @return Maintain Print Font
	 */
	I_AD_PrintFontInput AD_PrintFont();

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
	 * Set POSKeyLayoutType.
	 *
	 * @param POSKeyLayoutType The type of Key Layout
	 */
	void setPOSKeyLayoutTypeInput(I_AD_Ref_ListInput POSKeyLayoutType);

	/**
	 * Get POSKeyLayoutType.
	 *
	 * @return The type of Key Layout
	 */
	I_AD_Ref_ListInput POSKeyLayoutType();
}
