package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_LabelPrinterFunction;

/**
 * Generated Interface for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
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
