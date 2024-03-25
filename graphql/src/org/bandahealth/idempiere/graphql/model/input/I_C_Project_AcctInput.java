package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Project_Acct;

/**
 * Generated Interface for C_Project_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_Project_AcctInput extends I_C_Project_Acct {

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

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
	 * Set PJ_Asset_A.
	 *
	 * @param PJ_Asset_A Project Asset Account
	 */
	void setPJ_Asset_AInput(ForeignEntityInput PJ_Asset_A);

	/**
	 * Get PJ_Asset_A.
	 *
	 * @return Project Asset Account
	 */
	ForeignEntityInput PJ_Asset_A();

	/**
	 * Set PJ_WIP_A.
	 *
	 * @param PJ_WIP_A Account for Work in Progress
	 */
	void setPJ_WIP_AInput(ForeignEntityInput PJ_WIP_A);

	/**
	 * Get PJ_WIP_A.
	 *
	 * @return Account for Work in Progress
	 */
	ForeignEntityInput PJ_WIP_A();
}
