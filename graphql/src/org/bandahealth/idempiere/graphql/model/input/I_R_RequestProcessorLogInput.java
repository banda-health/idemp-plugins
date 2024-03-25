package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_RequestProcessorLog;

/**
 * Generated Interface for R_RequestProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_R_RequestProcessorLogInput extends I_R_RequestProcessorLog {

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
	 * Set R_RequestProcessor.
	 *
	 * @param R_RequestProcessor Processor for Requests
	 */
	void setR_RequestProcessorInput(ForeignEntityInput R_RequestProcessor);

	/**
	 * Get R_RequestProcessor.
	 *
	 * @return Processor for Requests
	 */
	ForeignEntityInput R_RequestProcessor();

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
