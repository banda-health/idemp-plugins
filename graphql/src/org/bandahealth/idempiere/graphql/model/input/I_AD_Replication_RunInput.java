package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Replication_Run;

/**
 * Generated Interface for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_Replication_RunInput extends I_AD_Replication_Run {

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
}
