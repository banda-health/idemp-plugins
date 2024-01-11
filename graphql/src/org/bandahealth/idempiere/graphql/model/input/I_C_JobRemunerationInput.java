package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_JobRemuneration;

/**
 * Generated Interface for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_JobRemunerationInput extends I_C_JobRemuneration {

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
	 * Set C_Job.
	 *
	 * @param C_Job Job Position
	 */
	void setC_JobInput(ForeignEntityInput C_Job);

	/**
	 * Get C_Job.
	 *
	 * @return Job Position
	 */
	ForeignEntityInput C_Job();

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
	 * Set C_Remuneration.
	 *
	 * @param C_Remuneration Wage or Salary
	 */
	void setC_RemunerationInput(ForeignEntityInput C_Remuneration);

	/**
	 * Get C_Remuneration.
	 *
	 * @return Wage or Salary
	 */
	ForeignEntityInput C_Remuneration();
}
