package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RevenueRecog_Service;

/**
 * Generated Interface for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_RevenueRecog_ServiceInput extends I_C_RevenueRecog_Service {

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
	 * Set C_RevenueRecognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	void setC_RevenueRecognitionInput(ForeignEntityInput C_RevenueRecognition);

	/**
	 * Get C_RevenueRecognition.
	 *
	 * @return Method for recording revenue
	 */
	ForeignEntityInput C_RevenueRecognition();
}
