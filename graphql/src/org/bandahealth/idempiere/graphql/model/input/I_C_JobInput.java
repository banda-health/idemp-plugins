package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Job;

/**
 * Generated Interface for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_JobInput extends I_C_Job {

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
	 * Set C_JobCategory.
	 *
	 * @param C_JobCategory Job Position Category
	 */
	void setC_JobCategoryInput(ForeignEntityInput C_JobCategory);

	/**
	 * Get C_JobCategory.
	 *
	 * @return Job Position Category
	 */
	ForeignEntityInput C_JobCategory();
}
