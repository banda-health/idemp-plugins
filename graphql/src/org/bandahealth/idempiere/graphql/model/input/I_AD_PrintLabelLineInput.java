package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintLabelLine;

/**
 * Generated Interface for AD_PrintLabelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_PrintLabelLineInput extends I_AD_PrintLabelLine {

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
	 * Set AD_LabelPrinterFunction.
	 *
	 * @param AD_LabelPrinterFunction Function of Label Printer
	 */
	void setAD_LabelPrinterFunctionInput(ForeignEntityInput AD_LabelPrinterFunction);

	/**
	 * Get AD_LabelPrinterFunction.
	 *
	 * @return Function of Label Printer
	 */
	ForeignEntityInput AD_LabelPrinterFunction();

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
	 * Set AD_PrintLabel.
	 *
	 * @param AD_PrintLabel Label Format to print
	 */
	void setAD_PrintLabelInput(ForeignEntityInput AD_PrintLabel);

	/**
	 * Get AD_PrintLabel.
	 *
	 * @return Label Format to print
	 */
	ForeignEntityInput AD_PrintLabel();

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
	 * Set LabelFormatType.
	 *
	 * @param LabelFormatType Label Format Type
	 */
	void setLabelFormatTypeInput(ForeignEntityInput LabelFormatType);

	/**
	 * Get LabelFormatType.
	 *
	 * @return Label Format Type
	 */
	ForeignEntityInput LabelFormatType();
}
