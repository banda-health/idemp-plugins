package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_IssueProject;

/**
 * Generated Interface for R_IssueProject - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_R_IssueProjectInput extends I_R_IssueProject {

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
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

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
	void setSystemStatusInput(I_AD_Ref_ListInput SystemStatus);

	/**
	 * Get SystemStatus.
	 *
	 * @return Status of the system - Support priority depends on system status
	 */
	I_AD_Ref_ListInput SystemStatus();
}
