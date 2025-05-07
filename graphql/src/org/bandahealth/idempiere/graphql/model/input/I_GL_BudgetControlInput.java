package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_BudgetControl;

/**
 * Generated Interface for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_GL_BudgetControlInput extends I_GL_BudgetControl {

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
	 * Set BudgetControlScope.
	 *
	 * @param BudgetControlScope Scope of the Budget Control
	 */
	void setBudgetControlScopeInput(ForeignEntityInput BudgetControlScope);

	/**
	 * Get BudgetControlScope.
	 *
	 * @return Scope of the Budget Control
	 */
	ForeignEntityInput BudgetControlScope();

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
	 * Set CommitmentType.
	 *
	 * @param CommitmentType Create Commitment and/or Reservations for Budget Control
	 */
	void setCommitmentTypeInput(ForeignEntityInput CommitmentType);

	/**
	 * Get CommitmentType.
	 *
	 * @return Create Commitment and/or Reservations for Budget Control
	 */
	ForeignEntityInput CommitmentType();

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
	 * Set GL_Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	void setGL_BudgetInput(ForeignEntityInput GL_Budget);

	/**
	 * Get GL_Budget.
	 *
	 * @return General Ledger Budget
	 */
	ForeignEntityInput GL_Budget();
}
