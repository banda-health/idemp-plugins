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
	void setAD_ImageInput(I_AD_ImageInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	I_AD_ImageInput AD_Image();

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
	 * Set ColorType.
	 *
	 * @param ColorType Color presentation for this color
	 */
	void setColorTypeInput(I_AD_Ref_ListInput ColorType);

	/**
	 * Get ColorType.
	 *
	 * @return Color presentation for this color
	 */
	I_AD_Ref_ListInput ColorType();

	/**
	 * Set StartPoint.
	 *
	 * @param StartPoint Start point of the gradient colors
	 */
	void setStartPointInput(I_AD_Ref_ListInput StartPoint);

	/**
	 * Get StartPoint.
	 *
	 * @return Start point of the gradient colors
	 */
	I_AD_Ref_ListInput StartPoint();
}
