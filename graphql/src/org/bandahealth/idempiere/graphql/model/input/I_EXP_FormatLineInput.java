package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_EXP_FormatLine;

/**
 * Generated Interface for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_EXP_FormatLineInput extends I_EXP_FormatLine {

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
	 * Set EXP_EmbeddedFormat.
	 *
	 * @param EXP_EmbeddedFormat EXP_EmbeddedFormat
	 */
	void setEXP_EmbeddedFormatInput(ForeignEntityInput EXP_EmbeddedFormat);

	/**
	 * Get EXP_EmbeddedFormat.
	 *
	 * @return EXP_EmbeddedFormat
	 */
	ForeignEntityInput EXP_EmbeddedFormat();

	/**
	 * Set EXP_Format.
	 *
	 * @param EXP_Format EXP_Format
	 */
	void setEXP_FormatInput(ForeignEntityInput EXP_Format);

	/**
	 * Get EXP_Format.
	 *
	 * @return EXP_Format
	 */
	ForeignEntityInput EXP_Format();

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
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	void setTypeInput(ForeignEntityInput Type);

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	ForeignEntityInput Type();
}
