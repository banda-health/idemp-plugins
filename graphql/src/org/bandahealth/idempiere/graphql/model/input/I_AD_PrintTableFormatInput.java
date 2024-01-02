package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintTableFormat;

/**
 * Generated Interface for AD_PrintTableFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_PrintTableFormatInput extends I_AD_PrintTableFormat {

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
	 * Set Funct_PrintFont.
	 *
	 * @param Funct_PrintFont Function row Font
	 */
	void setFunct_PrintFontInput(I_AD_PrintFontInput Funct_PrintFont);

	/**
	 * Get Funct_PrintFont.
	 *
	 * @return Function row Font
	 */
	I_AD_PrintFontInput Funct_PrintFont();

	/**
	 * Set FunctBG_PrintColor.
	 *
	 * @param FunctBG_PrintColor Function Background Color
	 */
	void setFunctBG_PrintColorInput(I_AD_PrintColorInput FunctBG_PrintColor);

	/**
	 * Get FunctBG_PrintColor.
	 *
	 * @return Function Background Color
	 */
	I_AD_PrintColorInput FunctBG_PrintColor();

	/**
	 * Set FunctFG_PrintColor.
	 *
	 * @param FunctFG_PrintColor Function Foreground Color
	 */
	void setFunctFG_PrintColorInput(I_AD_PrintColorInput FunctFG_PrintColor);

	/**
	 * Get FunctFG_PrintColor.
	 *
	 * @return Function Foreground Color
	 */
	I_AD_PrintColorInput FunctFG_PrintColor();

	/**
	 * Set Hdr_PrintFont.
	 *
	 * @param Hdr_PrintFont Header row Font
	 */
	void setHdr_PrintFontInput(I_AD_PrintFontInput Hdr_PrintFont);

	/**
	 * Get Hdr_PrintFont.
	 *
	 * @return Header row Font
	 */
	I_AD_PrintFontInput Hdr_PrintFont();

	/**
	 * Set HdrLine_PrintColor.
	 *
	 * @param HdrLine_PrintColor Table header row line color
	 */
	void setHdrLine_PrintColorInput(I_AD_PrintColorInput HdrLine_PrintColor);

	/**
	 * Get HdrLine_PrintColor.
	 *
	 * @return Table header row line color
	 */
	I_AD_PrintColorInput HdrLine_PrintColor();

	/**
	 * Set HdrStrokeType.
	 *
	 * @param HdrStrokeType Type of the Header Line Stroke
	 */
	void setHdrStrokeTypeInput(I_AD_Ref_ListInput HdrStrokeType);

	/**
	 * Get HdrStrokeType.
	 *
	 * @return Type of the Header Line Stroke
	 */
	I_AD_Ref_ListInput HdrStrokeType();

	/**
	 * Set HdrTextBG_PrintColor.
	 *
	 * @param HdrTextBG_PrintColor Background color of header row
	 */
	void setHdrTextBG_PrintColorInput(I_AD_PrintColorInput HdrTextBG_PrintColor);

	/**
	 * Get HdrTextBG_PrintColor.
	 *
	 * @return Background color of header row
	 */
	I_AD_PrintColorInput HdrTextBG_PrintColor();

	/**
	 * Set HdrTextFG_PrintColor.
	 *
	 * @param HdrTextFG_PrintColor Foreground color if the table header row
	 */
	void setHdrTextFG_PrintColorInput(I_AD_PrintColorInput HdrTextFG_PrintColor);

	/**
	 * Get HdrTextFG_PrintColor.
	 *
	 * @return Foreground color if the table header row
	 */
	I_AD_PrintColorInput HdrTextFG_PrintColor();

	/**
	 * Set Line_PrintColor.
	 *
	 * @param Line_PrintColor Table line color
	 */
	void setLine_PrintColorInput(I_AD_PrintColorInput Line_PrintColor);

	/**
	 * Get Line_PrintColor.
	 *
	 * @return Table line color
	 */
	I_AD_PrintColorInput Line_PrintColor();

	/**
	 * Set LineStrokeType.
	 *
	 * @param LineStrokeType Type of the Line Stroke
	 */
	void setLineStrokeTypeInput(I_AD_Ref_ListInput LineStrokeType);

	/**
	 * Get LineStrokeType.
	 *
	 * @return Type of the Line Stroke
	 */
	I_AD_Ref_ListInput LineStrokeType();
}
