package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Color;

/**
 * Generated Interface for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ColorInput extends I_AD_Color {

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
	 * Set ColorType_RL.
	 *
	 * @param ColorType_RL Color presentation for this color
	 */
	void setColorType_RL(I_AD_Ref_ListInput ColorType_RL);

	/**
	 * Get ColorType_RL.
	 *
	 * @return Color presentation for this color
	 */
	I_AD_Ref_ListInput getColorType_RL();

	/**
	 * Set StartPoint_RL.
	 *
	 * @param StartPoint_RL Start point of the gradient colors
	 */
	void setStartPoint_RL(I_AD_Ref_ListInput StartPoint_RL);

	/**
	 * Get StartPoint_RL.
	 *
	 * @return Start point of the gradient colors
	 */
	I_AD_Ref_ListInput getStartPoint_RL();
}
