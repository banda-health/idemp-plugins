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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

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
	 * Set RecognitionFrequency_RL.
	 *
	 * @param RecognitionFrequency_RL RecognitionFrequency_RL
	 */
	void setRecognitionFrequency_RL(I_AD_Ref_ListInput RecognitionFrequency_RL);

	/**
	 * Get RecognitionFrequency_RL.
	 *
	 * @return RecognitionFrequency_RL
	 */
	I_AD_Ref_ListInput getRecognitionFrequency_RL();
}
