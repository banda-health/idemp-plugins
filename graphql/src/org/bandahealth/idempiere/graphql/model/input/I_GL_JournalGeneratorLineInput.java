package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_JournalGeneratorLine;

/**
 * Generated Interface for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_GL_JournalGeneratorLineInput extends I_GL_JournalGeneratorLine {

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
	 * Set BPDimensionType.
	 *
	 * @param BPDimensionType BPDimensionType
	 */
	void setBPDimensionTypeInput(I_AD_Ref_ListInput BPDimensionType);

	/**
	 * Get BPDimensionType.
	 *
	 * @return BPDimensionType
	 */
	I_AD_Ref_ListInput BPDimensionType();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_ElementValueCR.
	 *
	 * @param C_ElementValueCR C_ElementValueCR
	 */
	void setC_ElementValueCRInput(ForeignEntityInput C_ElementValueCR);

	/**
	 * Get C_ElementValueCR.
	 *
	 * @return C_ElementValueCR
	 */
	ForeignEntityInput C_ElementValueCR();

	/**
	 * Set C_ElementValueDR.
	 *
	 * @param C_ElementValueDR C_ElementValueDR
	 */
	void setC_ElementValueDRInput(ForeignEntityInput C_ElementValueDR);

	/**
	 * Get C_ElementValueDR.
	 *
	 * @return C_ElementValueDR
	 */
	ForeignEntityInput C_ElementValueDR();

	/**
	 * Set GL_JournalGenerator.
	 *
	 * @param GL_JournalGenerator GL_JournalGenerator
	 */
	void setGL_JournalGeneratorInput(ForeignEntityInput GL_JournalGenerator);

	/**
	 * Get GL_JournalGenerator.
	 *
	 * @return GL_JournalGenerator
	 */
	ForeignEntityInput GL_JournalGenerator();

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
}
