package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AlertProcessorLog;

/**
 * Generated Interface for AD_AlertProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
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
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();
}
