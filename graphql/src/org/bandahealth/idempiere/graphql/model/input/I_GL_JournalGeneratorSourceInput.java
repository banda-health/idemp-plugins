package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_JournalGeneratorSource;

/**
 * Generated Interface for GL_JournalGeneratorSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_GL_JournalGeneratorSourceInput extends I_GL_JournalGeneratorSource {

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
	 * Set C_ElementValue.
	 *
	 * @param C_ElementValue Account Element
	 */
	void setC_ElementValueInput(ForeignEntityInput C_ElementValue);

	/**
	 * Get C_ElementValue.
	 *
	 * @return Account Element
	 */
	ForeignEntityInput C_ElementValue();

	/**
	 * Set GL_Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	void setGL_CategoryInput(ForeignEntityInput GL_Category);

	/**
	 * Get GL_Category.
	 *
	 * @return General Ledger Category
	 */
	ForeignEntityInput GL_Category();

	/**
	 * Set GL_JournalGeneratorLine.
	 *
	 * @param GL_JournalGeneratorLine GL_JournalGeneratorLine
	 */
	void setGL_JournalGeneratorLineInput(ForeignEntityInput GL_JournalGeneratorLine);

	/**
	 * Get GL_JournalGeneratorLine.
	 *
	 * @return GL_JournalGeneratorLine
	 */
	ForeignEntityInput GL_JournalGeneratorLine();

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
}
