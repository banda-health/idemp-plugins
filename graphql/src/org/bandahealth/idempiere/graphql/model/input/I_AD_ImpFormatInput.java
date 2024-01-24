package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ImpFormat;

/**
 * Generated Interface for AD_ImpFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ImpFormatInput extends I_AD_ImpFormat {

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

	/**
	 * Set FormatType.
	 *
	 * @param FormatType Format of the data
	 */
	void setFormatTypeInput(I_AD_Ref_ListInput FormatType);

	/**
	 * Get FormatType.
	 *
	 * @return Format of the data
	 */
	I_AD_Ref_ListInput FormatType();
}
