package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_FundRestriction;

/**
 * Generated Interface for GL_FundRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_GL_FundRestrictionInput extends I_GL_FundRestriction {

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
	 * Set C_ElementValue.
	 *
	 * @param C_ElementValue Account Element
	 */
	void setC_ElementValueInput(ForeignEntityInput C_ElementValue);

	/**
	 * Get C_ElementValue.
	 *
	 * @return Account Element
	 */
	ForeignEntityInput C_ElementValue();

	/**
	 * Set GL_Fund.
	 *
	 * @param GL_Fund General Ledger Funds Control
	 */
	void setGL_FundInput(ForeignEntityInput GL_Fund);

	/**
	 * Get GL_Fund.
	 *
	 * @return General Ledger Funds Control
	 */
	ForeignEntityInput GL_Fund();

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
}
