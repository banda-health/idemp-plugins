package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Alert;

/**
 * Generated Interface for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_AlertInput extends I_AD_Alert {

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
