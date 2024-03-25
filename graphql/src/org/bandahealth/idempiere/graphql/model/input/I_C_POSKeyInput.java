package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_POSKey;

/**
 * Generated Interface for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_POSKeyInput extends I_C_POSKey {

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	void setAD_ImageInput(ForeignEntityInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	ForeignEntityInput AD_Image();

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

	/**
	 * Set C_POSKeyLayout.
	 *
	 * @param C_POSKeyLayout POS Function Key Layout
	 */
	void setC_POSKeyLayoutInput(ForeignEntityInput C_POSKeyLayout);

	/**
	 * Get C_POSKeyLayout.
	 *
	 * @return POS Function Key Layout
	 */
	ForeignEntityInput C_POSKeyLayout();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

	/**
	 * Set SubKeyLayout.
	 *
	 * @param SubKeyLayout Key Layout to be displayed when this key is pressed
	 */
	void setSubKeyLayoutInput(ForeignEntityInput SubKeyLayout);

	/**
	 * Get SubKeyLayout.
	 *
	 * @return Key Layout to be displayed when this key is pressed
	 */
	ForeignEntityInput SubKeyLayout();
}
