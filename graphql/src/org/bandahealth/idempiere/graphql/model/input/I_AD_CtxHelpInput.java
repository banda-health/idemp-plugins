package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_CtxHelp;

/**
 * Generated Interface for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_CtxHelpInput extends I_AD_CtxHelp {

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
	 * Set CtxType.
	 *
	 * @param CtxType Type of Context Help
	 */
	void setCtxTypeInput(I_AD_Ref_ListInput CtxType);

	/**
	 * Get CtxType.
	 *
	 * @return Type of Context Help
	 */
	I_AD_Ref_ListInput CtxType();
}
