package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Replication_Log;

/**
 * Generated Interface for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_Replication_LogInput extends I_AD_Replication_Log {

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
	 * Set AD_Replication_Run.
	 *
	 * @param AD_Replication_Run Data Replication Run
	 */
	void setAD_Replication_RunInput(ForeignEntityInput AD_Replication_Run);

	/**
	 * Get AD_Replication_Run.
	 *
	 * @return Data Replication Run
	 */
	ForeignEntityInput AD_Replication_Run();

	/**
	 * Set AD_ReplicationTable.
	 *
	 * @param AD_ReplicationTable Data Replication Strategy Table Info
	 */
	void setAD_ReplicationTableInput(ForeignEntityInput AD_ReplicationTable);

	/**
	 * Get AD_ReplicationTable.
	 *
	 * @return Data Replication Strategy Table Info
	 */
	ForeignEntityInput AD_ReplicationTable();
}
