package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ImpFormat;

/**
 * Generated Interface for AD_ImpFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_ImpFormatInput extends I_AD_ImpFormat {

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
	void setFormatTypeInput(ForeignEntityInput FormatType);

	/**
	 * Get FormatType.
	 *
	 * @return Format of the data
	 */
	ForeignEntityInput FormatType();
}
