package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RevenueRecognition;

/**
 * Generated Interface for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_RevenueRecognitionInput extends I_C_RevenueRecognition {

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
	 * Set RecognitionFrequency.
	 *
	 * @param RecognitionFrequency RecognitionFrequency
	 */
	void setRecognitionFrequencyInput(I_AD_Ref_ListInput RecognitionFrequency);

	/**
	 * Get RecognitionFrequency.
	 *
	 * @return RecognitionFrequency
	 */
	I_AD_Ref_ListInput RecognitionFrequency();
}
