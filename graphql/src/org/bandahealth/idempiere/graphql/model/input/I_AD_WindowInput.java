package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Window;

/**
 * Generated Interface for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_WindowInput extends I_AD_Window {

	/**
	 * Set AD_Color.
	 *
	 * @param AD_Color Color for backgrounds or indicators
	 */
	void setAD_ColorInput(ForeignEntityInput AD_Color);

	/**
	 * Get AD_Color.
	 *
	 * @return Color for backgrounds or indicators
	 */
	ForeignEntityInput AD_Color();

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
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set WindowType.
	 *
	 * @param WindowType Type or classification of a Window
	 */
	void setWindowTypeInput(ForeignEntityInput WindowType);

	/**
	 * Get WindowType.
	 *
	 * @return Type or classification of a Window
	 */
	ForeignEntityInput WindowType();
}
