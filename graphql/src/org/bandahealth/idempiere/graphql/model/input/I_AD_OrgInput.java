package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Org;

/**
 * Generated Interface for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_AD_OrgInput extends I_AD_Org {

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
