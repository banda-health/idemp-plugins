package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RevenueRecognition;

/**
 * Generated Interface for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_RevenueRecognitionInput extends I_C_RevenueRecognition {

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
