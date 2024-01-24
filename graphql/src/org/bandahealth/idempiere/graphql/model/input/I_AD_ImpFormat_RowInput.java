package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ImpFormat_Row;

/**
 * Generated Interface for AD_ImpFormat_Row - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ImpFormat_RowInput extends I_AD_ImpFormat_Row {

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
	 * Set AD_ImpFormat.
	 *
	 * @param AD_ImpFormat AD_ImpFormat
	 */
	void setAD_ImpFormatInput(ForeignEntityInput AD_ImpFormat);

	/**
	 * Get AD_ImpFormat.
	 *
	 * @return AD_ImpFormat
	 */
	ForeignEntityInput AD_ImpFormat();

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

	/**
	 * Set DataType.
	 *
	 * @param DataType Type of data
	 */
	void setDataTypeInput(I_AD_Ref_ListInput DataType);

	/**
	 * Get DataType.
	 *
	 * @return Type of data
	 */
	I_AD_Ref_ListInput DataType();
}
