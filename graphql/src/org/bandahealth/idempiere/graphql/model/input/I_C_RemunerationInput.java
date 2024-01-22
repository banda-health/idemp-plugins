package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Remuneration;

/**
 * Generated Interface for C_Remuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_RemunerationInput extends I_C_Remuneration {

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
	 * Set RemunerationType.
	 *
	 * @param RemunerationType Type of Remuneration
	 */
	void setRemunerationTypeInput(I_AD_Ref_ListInput RemunerationType);

	/**
	 * Get RemunerationType.
	 *
	 * @return Type of Remuneration
	 */
	I_AD_Ref_ListInput RemunerationType();
}
