package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ImpFormat_Row;

/**
 * Generated Interface for AD_ImpFormat_Row - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
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
