package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_MigrationScript;

/**
 * Generated Interface for AD_MigrationScript - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_MigrationScriptInput extends I_AD_MigrationScript {

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
	 * Set Status.
	 *
	 * @param Status Status of the currently running check
	 */
	void setStatusInput(ForeignEntityInput Status);

	/**
	 * Get Status.
	 *
	 * @return Status of the currently running check
	 */
	ForeignEntityInput Status();
}
