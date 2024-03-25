package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Replication;

/**
 * Generated Interface for AD_Replication - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_ReplicationInput extends I_AD_Replication {

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
	 * Set AD_ReplicationStrategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	void setAD_ReplicationStrategyInput(ForeignEntityInput AD_ReplicationStrategy);

	/**
	 * Get AD_ReplicationStrategy.
	 *
	 * @return Data Replication Strategy
	 */
	ForeignEntityInput AD_ReplicationStrategy();
}
