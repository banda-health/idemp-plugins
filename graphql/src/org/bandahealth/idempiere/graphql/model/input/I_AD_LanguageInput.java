package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Language;

/**
 * Generated Interface for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_LanguageInput extends I_AD_Language {

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
	 * Set AD_PrintPaper.
	 *
	 * @param AD_PrintPaper Printer paper definition
	 */
	void setAD_PrintPaperInput(ForeignEntityInput AD_PrintPaper);

	/**
	 * Get AD_PrintPaper.
	 *
	 * @return Printer paper definition
	 */
	ForeignEntityInput AD_PrintPaper();
}
