package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_POSKeyLayout;

/**
 * Generated Interface for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_POSKeyLayoutInput extends I_C_POSKeyLayout {

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
	 * Set AD_PrintColor.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor);

	/**
	 * Get AD_PrintColor.
	 *
	 * @return Color used for printing and display
	 */
	ForeignEntityInput AD_PrintColor();

	/**
	 * Set AD_PrintFont.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	void setAD_PrintFontInput(ForeignEntityInput AD_PrintFont);

	/**
	 * Get AD_PrintFont.
	 *
	 * @return Maintain Print Font
	 */
	ForeignEntityInput AD_PrintFont();

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
