package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_EXP_FormatLine;

/**
 * Generated Interface for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
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
	 * Set AD_Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	void setAD_ReferenceInput(ForeignEntityInput AD_Reference);

	/**
	 * Get AD_Reference.
	 *
	 * @return System Reference and Validation
	 */
	ForeignEntityInput AD_Reference();

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
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	void setTypeInput(I_AD_Ref_ListInput Type);

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	I_AD_Ref_ListInput Type();
}
