package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AlertProcessorLog;

/**
 * Generated Interface for AD_AlertProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_AlertProcessorLogInput extends I_AD_AlertProcessorLog {

	/**
	 * Set AD_AlertProcessor.
	 *
	 * @param AD_AlertProcessor Alert Processor/Server Parameter
	 */
	void setAD_AlertProcessorInput(ForeignEntityInput AD_AlertProcessor);

	/**
	 * Get AD_AlertProcessor.
	 *
	 * @return Alert Processor/Server Parameter
	 */
	ForeignEntityInput AD_AlertProcessor();

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
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();
}
