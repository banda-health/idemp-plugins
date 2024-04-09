package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_Budget;

/**
 * Generated Interface for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_GL_BudgetInput extends I_GL_Budget {

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
	 * Set BudgetStatus.
	 *
	 * @param BudgetStatus Indicates the current status of this budget
	 */
	void setBudgetStatusInput(I_AD_Ref_ListInput BudgetStatus);

	/**
	 * Get BudgetStatus.
	 *
	 * @return Indicates the current status of this budget
	 */
	I_AD_Ref_ListInput BudgetStatus();

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
}
