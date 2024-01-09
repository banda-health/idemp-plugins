package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Org;

/**
 * Generated Interface for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_OrgInput extends I_AD_Org {

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
