package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_CtxHelp;

/**
 * Generated Interface for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_CtxHelpInput extends I_AD_CtxHelp {

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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set CtxType_RL.
	 *
	 * @param CtxType_RL Type of Context Help
	 */
	void setCtxType_RL(I_AD_Ref_ListInput CtxType_RL);

	/**
	 * Get CtxType_RL.
	 *
	 * @return Type of Context Help
	 */
	I_AD_Ref_ListInput getCtxType_RL();
}
