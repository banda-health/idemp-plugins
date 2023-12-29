package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Window;

/**
 * Generated Interface for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_WindowInput extends I_AD_Window {

	/**
	 * Set AD_Color.
	 *
	 * @param AD_Color Color for backgrounds or indicators
	 */
	void setAD_Color(I_AD_ColorInput AD_Color);

	/**
	 * Get AD_Color.
	 *
	 * @return Color for backgrounds or indicators
	 */
	I_AD_ColorInput getAD_Color();

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	void setAD_Image(I_AD_ImageInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	I_AD_ImageInput getAD_Image();

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
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set WindowType_RL.
	 *
	 * @param WindowType_RL Type or classification of a Window
	 */
	void setWindowType_RL(I_AD_Ref_ListInput WindowType_RL);

	/**
	 * Get WindowType_RL.
	 *
	 * @return Type or classification of a Window
	 */
	I_AD_Ref_ListInput getWindowType_RL();
}
