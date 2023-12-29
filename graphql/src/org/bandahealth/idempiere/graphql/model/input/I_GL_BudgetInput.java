package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_Budget;

/**
 * Generated Interface for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_GL_BudgetInput extends I_GL_Budget {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set BudgetStatus_RL.
	 *
	 * @param BudgetStatus_RL Indicates the current status of this budget
	 */
	void setBudgetStatus_RL(I_AD_Ref_ListInput BudgetStatus_RL);

	/**
	 * Get BudgetStatus_RL.
	 *
	 * @return Indicates the current status of this budget
	 */
	I_AD_Ref_ListInput getBudgetStatus_RL();

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
}
