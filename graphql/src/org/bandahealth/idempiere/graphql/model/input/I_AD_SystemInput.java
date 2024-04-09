package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_System;

/**
 * Generated Interface for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_SystemInput extends I_AD_System {

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
	 * Set ReplicationType.
	 *
	 * @param ReplicationType Type of Data Replication
	 */
	void setReplicationTypeInput(I_AD_Ref_ListInput ReplicationType);

	/**
	 * Get ReplicationType.
	 *
	 * @return Type of Data Replication
	 */
	I_AD_Ref_ListInput ReplicationType();

	/**
	 * Set SystemStatus.
	 *
	 * @param SystemStatus Status of the system - Support priority depends on system status
	 */
	void setSystemStatusInput(I_AD_Ref_ListInput SystemStatus);

	/**
	 * Get SystemStatus.
	 *
	 * @return Status of the system - Support priority depends on system status
	 */
	I_AD_Ref_ListInput SystemStatus();
}
