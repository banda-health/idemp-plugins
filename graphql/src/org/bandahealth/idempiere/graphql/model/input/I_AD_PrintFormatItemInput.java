package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintFormatItem;

/**
 * Generated Interface for AD_PrintFormatItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_PrintFormatItemInput extends I_AD_PrintFormatItem {

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

	/**
	 * Set AD_FieldStyle.
	 *
	 * @param AD_FieldStyle Field CSS Style 
	 */
	void setAD_FieldStyleInput(ForeignEntityInput AD_FieldStyle);

	/**
	 * Get AD_FieldStyle.
	 *
	 * @return Field CSS Style 
	 */
	ForeignEntityInput AD_FieldStyle();

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

	/**
	 * Set AD_PrintFormatChild.
	 *
	 * @param AD_PrintFormatChild Print format that is included here.
	 */
	void setAD_PrintFormatChildInput(ForeignEntityInput AD_PrintFormatChild);

	/**
	 * Get AD_PrintFormatChild.
	 *
	 * @return Print format that is included here.
	 */
	ForeignEntityInput AD_PrintFormatChild();

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
	 * Set AD_PrintGraph.
	 *
	 * @param AD_PrintGraph Graph included in Reports
	 */
	void setAD_PrintGraphInput(ForeignEntityInput AD_PrintGraph);

	/**
	 * Get AD_PrintGraph.
	 *
	 * @return Graph included in Reports
	 */
	ForeignEntityInput AD_PrintGraph();

	/**
	 * Set BarcodeType.
	 *
	 * @param BarcodeType Type of barcode
	 */
	void setBarcodeTypeInput(I_AD_Ref_ListInput BarcodeType);

	/**
	 * Get BarcodeType.
	 *
	 * @return Type of barcode
	 */
	I_AD_Ref_ListInput BarcodeType();

	/**
	 * Set FieldAlignmentType.
	 *
	 * @param FieldAlignmentType Field Text Alignment
	 */
	void setFieldAlignmentTypeInput(I_AD_Ref_ListInput FieldAlignmentType);

	/**
	 * Get FieldAlignmentType.
	 *
	 * @return Field Text Alignment
	 */
	I_AD_Ref_ListInput FieldAlignmentType();

	/**
	 * Set LineAlignmentType.
	 *
	 * @param LineAlignmentType Line Alignment
	 */
	void setLineAlignmentTypeInput(I_AD_Ref_ListInput LineAlignmentType);

	/**
	 * Get LineAlignmentType.
	 *
	 * @return Line Alignment
	 */
	I_AD_Ref_ListInput LineAlignmentType();

	/**
	 * Set PrintAreaType.
	 *
	 * @param PrintAreaType Print Area
	 */
	void setPrintAreaTypeInput(I_AD_Ref_ListInput PrintAreaType);

	/**
	 * Get PrintAreaType.
	 *
	 * @return Print Area
	 */
	I_AD_Ref_ListInput PrintAreaType();

	/**
	 * Set PrintFormatType.
	 *
	 * @param PrintFormatType Print Format Type
	 */
	void setPrintFormatTypeInput(I_AD_Ref_ListInput PrintFormatType);

	/**
	 * Get PrintFormatType.
	 *
	 * @return Print Format Type
	 */
	I_AD_Ref_ListInput PrintFormatType();

	/**
	 * Set ShapeType.
	 *
	 * @param ShapeType Type of the shape to be painted
	 */
	void setShapeTypeInput(I_AD_Ref_ListInput ShapeType);

	/**
	 * Get ShapeType.
	 *
	 * @return Type of the shape to be painted
	 */
	I_AD_Ref_ListInput ShapeType();
}
