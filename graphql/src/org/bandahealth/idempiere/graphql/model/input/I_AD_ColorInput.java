package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Color;

/**
 * Generated Interface for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_ColorInput extends I_AD_Color {

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
	 * Set ColorType.
	 *
	 * @param ColorType Color presentation for this color
	 */
	void setColorTypeInput(ForeignEntityInput ColorType);

	/**
	 * Get ColorType.
	 *
	 * @return Color presentation for this color
	 */
	ForeignEntityInput ColorType();

	/**
	 * Set StartPoint.
	 *
	 * @param StartPoint Start point of the gradient colors
	 */
	void setStartPointInput(ForeignEntityInput StartPoint);

	/**
	 * Get StartPoint.
	 *
	 * @return Start point of the gradient colors
	 */
	ForeignEntityInput StartPoint();
}
