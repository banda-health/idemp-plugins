package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Job;

/**
 * Generated Interface for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_JobInput extends I_C_Job {

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
