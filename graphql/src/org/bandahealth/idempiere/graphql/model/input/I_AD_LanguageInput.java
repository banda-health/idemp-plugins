package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Language;

/**
 * Generated Interface for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_LanguageInput extends I_AD_Language {

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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_PrintPaper.
	 *
	 * @param AD_PrintPaper Printer paper definition
	 */
	void setAD_PrintPaper(I_AD_PrintPaperInput AD_PrintPaper);

	/**
	 * Get AD_PrintPaper.
	 *
	 * @return Printer paper definition
	 */
	I_AD_PrintPaperInput getAD_PrintPaper();
}
