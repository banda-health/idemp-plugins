package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_BudgetControl;

/**
 * Generated Interface for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_GL_BudgetControlInput extends I_GL_BudgetControl {

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
	 * Set BudgetControlScope.
	 *
	 * @param BudgetControlScope Scope of the Budget Control
	 */
	void setBudgetControlScopeInput(I_AD_Ref_ListInput BudgetControlScope);

	/**
	 * Get BudgetControlScope.
	 *
	 * @return Scope of the Budget Control
	 */
	I_AD_Ref_ListInput BudgetControlScope();

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
	void setCommitmentTypeInput(I_AD_Ref_ListInput CommitmentType);

	/**
	 * Get CommitmentType.
	 *
	 * @return Create Commitment and/or Reservations for Budget Control
	 */
	I_AD_Ref_ListInput CommitmentType();

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
