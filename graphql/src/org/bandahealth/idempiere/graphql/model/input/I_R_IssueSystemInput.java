package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_IssueSystem;

/**
 * Generated Interface for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
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
	 * Set SystemStatus.
	 *
	 * @param SystemStatus Status of the system - Support priority depends on system status
	 */
	void setSystemStatusInput(ForeignEntityInput SystemStatus);

	/**
	 * Get SystemStatus.
	 *
	 * @return Status of the system - Support priority depends on system status
	 */
	ForeignEntityInput SystemStatus();
}
