package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintLabel;

/**
 * Generated Interface for AD_PrintLabel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_PrintLabelInput extends I_AD_PrintLabel {

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
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();
}
