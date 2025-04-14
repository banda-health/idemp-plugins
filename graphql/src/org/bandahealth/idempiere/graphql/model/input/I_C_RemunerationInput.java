package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Remuneration;

/**
 * Generated Interface for C_Remuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_RemunerationInput extends I_C_Remuneration {

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
	 * Set RemunerationType.
	 *
	 * @param RemunerationType Type of Remuneration
	 */
	void setRemunerationTypeInput(ForeignEntityInput RemunerationType);

	/**
	 * Get RemunerationType.
	 *
	 * @return Type of Remuneration
	 */
	ForeignEntityInput RemunerationType();
}
