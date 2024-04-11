package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_CtxHelp;

/**
 * Generated Interface for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_CtxHelpInput extends I_AD_CtxHelp {

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
	 * Set CtxType.
	 *
	 * @param CtxType Type of Context Help
	 */
	void setCtxTypeInput(ForeignEntityInput CtxType);

	/**
	 * Get CtxType.
	 *
	 * @return Type of Context Help
	 */
	ForeignEntityInput CtxType();
}
