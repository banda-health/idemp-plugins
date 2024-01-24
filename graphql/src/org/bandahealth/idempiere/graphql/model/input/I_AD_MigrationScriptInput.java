package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_MigrationScript;

/**
 * Generated Interface for AD_MigrationScript - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_MigrationScriptInput extends I_AD_MigrationScript {

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
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set Status.
	 *
	 * @param Status Status of the currently running check
	 */
	void setStatusInput(I_AD_Ref_ListInput Status);

	/**
	 * Get Status.
	 *
	 * @return Status of the currently running check
	 */
	I_AD_Ref_ListInput Status();
}
