package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ProjectIssueMA;

/**
 * Generated Interface for C_ProjectIssueMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_ProjectIssueMAInput extends I_C_ProjectIssueMA {

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
	 * Set C_ProjectIssue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue);

	/**
	 * Get C_ProjectIssue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	ForeignEntityInput C_ProjectIssue();

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
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstance();
}
