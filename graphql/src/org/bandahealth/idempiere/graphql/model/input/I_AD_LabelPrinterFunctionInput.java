package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_LabelPrinterFunction;

/**
 * Generated Interface for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_LabelPrinterFunctionInput extends I_AD_LabelPrinterFunction {

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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();
}
