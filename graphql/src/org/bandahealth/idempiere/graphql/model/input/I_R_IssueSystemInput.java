package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_IssueSystem;

/**
 * Generated Interface for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_R_IssueSystemInput extends I_R_IssueSystem {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

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
