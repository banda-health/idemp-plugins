package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_RfQ_Topic;

/**
 * Generated Interface for C_RfQ_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_RfQ_TopicInput extends I_C_RfQ_Topic {

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

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
