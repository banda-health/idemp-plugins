package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintTableFormat;

/**
 * Generated Interface for AD_PrintTableFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_PrintTableFormatInput extends I_AD_PrintTableFormat {

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
	 * Set Funct_PrintFont.
	 *
	 * @param Funct_PrintFont Function row Font
	 */
	void setFunct_PrintFontInput(ForeignEntityInput Funct_PrintFont);

	/**
	 * Get Funct_PrintFont.
	 *
	 * @return Function row Font
	 */
	ForeignEntityInput Funct_PrintFont();

	/**
	 * Set FunctBG_PrintColor.
	 *
	 * @param FunctBG_PrintColor Function Background Color
	 */
	void setFunctBG_PrintColorInput(ForeignEntityInput FunctBG_PrintColor);

	/**
	 * Get FunctBG_PrintColor.
	 *
	 * @return Function Background Color
	 */
	ForeignEntityInput FunctBG_PrintColor();

	/**
	 * Set FunctFG_PrintColor.
	 *
	 * @param FunctFG_PrintColor Function Foreground Color
	 */
	void setFunctFG_PrintColorInput(ForeignEntityInput FunctFG_PrintColor);

	/**
	 * Get FunctFG_PrintColor.
	 *
	 * @return Function Foreground Color
	 */
	ForeignEntityInput FunctFG_PrintColor();

	/**
	 * Set Hdr_PrintFont.
	 *
	 * @param Hdr_PrintFont Header row Font
	 */
	void setHdr_PrintFontInput(ForeignEntityInput Hdr_PrintFont);

	/**
	 * Get Hdr_PrintFont.
	 *
	 * @return Header row Font
	 */
	ForeignEntityInput Hdr_PrintFont();

	/**
	 * Set HdrLine_PrintColor.
	 *
	 * @param HdrLine_PrintColor Table header row line color
	 */
	void setHdrLine_PrintColorInput(ForeignEntityInput HdrLine_PrintColor);

	/**
	 * Get HdrLine_PrintColor.
	 *
	 * @return Table header row line color
	 */
	ForeignEntityInput HdrLine_PrintColor();

	/**
	 * Set HdrStrokeType.
	 *
	 * @param HdrStrokeType Type of the Header Line Stroke
	 */
	void setHdrStrokeTypeInput(ForeignEntityInput HdrStrokeType);

	/**
	 * Get HdrStrokeType.
	 *
	 * @return Type of the Header Line Stroke
	 */
	ForeignEntityInput HdrStrokeType();

	/**
	 * Set HdrTextBG_PrintColor.
	 *
	 * @param HdrTextBG_PrintColor Background color of header row
	 */
	void setHdrTextBG_PrintColorInput(ForeignEntityInput HdrTextBG_PrintColor);

	/**
	 * Get HdrTextBG_PrintColor.
	 *
	 * @return Background color of header row
	 */
	ForeignEntityInput HdrTextBG_PrintColor();

	/**
	 * Set HdrTextFG_PrintColor.
	 *
	 * @param HdrTextFG_PrintColor Foreground color if the table header row
	 */
	void setHdrTextFG_PrintColorInput(ForeignEntityInput HdrTextFG_PrintColor);

	/**
	 * Get HdrTextFG_PrintColor.
	 *
	 * @return Foreground color if the table header row
	 */
	ForeignEntityInput HdrTextFG_PrintColor();

	/**
	 * Set Line_PrintColor.
	 *
	 * @param Line_PrintColor Table line color
	 */
	void setLine_PrintColorInput(ForeignEntityInput Line_PrintColor);

	/**
	 * Get Line_PrintColor.
	 *
	 * @return Table line color
	 */
	ForeignEntityInput Line_PrintColor();

	/**
	 * Set LineStrokeType.
	 *
	 * @param LineStrokeType Type of the Line Stroke
	 */
	void setLineStrokeTypeInput(ForeignEntityInput LineStrokeType);

	/**
	 * Get LineStrokeType.
	 *
	 * @return Type of the Line Stroke
	 */
	ForeignEntityInput LineStrokeType();
}
