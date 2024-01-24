package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Replication_Run;

/**
 * Generated Interface for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_Replication_RunInput extends I_AD_Replication_Run {

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
	 * Set AD_Replication.
	 *
	 * @param AD_Replication Data Replication Target
	 */
	void setAD_ReplicationInput(ForeignEntityInput AD_Replication);

	/**
	 * Get AD_Replication.
	 *
	 * @return Data Replication Target
	 */
	ForeignEntityInput AD_Replication();

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
