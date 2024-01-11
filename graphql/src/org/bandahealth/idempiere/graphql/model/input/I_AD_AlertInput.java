package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Alert;

/**
 * Generated Interface for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_AlertInput extends I_AD_Alert {

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
