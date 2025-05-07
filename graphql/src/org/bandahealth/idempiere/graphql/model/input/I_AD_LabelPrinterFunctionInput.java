package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_LabelPrinterFunction;

/**
 * Generated Interface for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_LabelPrinterFunctionInput extends I_AD_LabelPrinterFunction {

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
	 * Set AD_LabelPrinter.
	 *
	 * @param AD_LabelPrinter Label Printer Definition
	 */
	void setAD_LabelPrinterInput(ForeignEntityInput AD_LabelPrinter);

	/**
	 * Get AD_LabelPrinter.
	 *
	 * @return Label Printer Definition
	 */
	ForeignEntityInput AD_LabelPrinter();

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
}
