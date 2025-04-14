package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Campaign;

/**
 * Generated Interface for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_CampaignInput extends I_C_Campaign {

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
