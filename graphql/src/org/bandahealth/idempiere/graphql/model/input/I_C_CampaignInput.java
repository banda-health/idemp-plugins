package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Campaign;

/**
 * Generated Interface for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_CampaignInput extends I_C_Campaign {

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
	 * Set C_Channel.
	 *
	 * @param C_Channel Sales Channel
	 */
	void setC_ChannelInput(ForeignEntityInput C_Channel);

	/**
	 * Get C_Channel.
	 *
	 * @return Sales Channel
	 */
	ForeignEntityInput C_Channel();
}
