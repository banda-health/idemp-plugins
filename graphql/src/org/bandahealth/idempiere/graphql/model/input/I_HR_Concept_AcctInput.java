package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Concept_Acct;

/**
 * Generated Interface for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_HR_Concept_AcctInput extends I_HR_Concept_Acct {

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
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_GroupInput(ForeignEntityInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	ForeignEntityInput C_BP_Group();

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
	 * Set HR_Concept.
	 *
	 * @param HR_Concept HR_Concept
	 */
	void setHR_ConceptInput(ForeignEntityInput HR_Concept);

	/**
	 * Get HR_Concept.
	 *
	 * @return HR_Concept
	 */
	ForeignEntityInput HR_Concept();

	/**
	 * Set HR_Expense_A.
	 *
	 * @param HR_Expense_A HR_Expense_A
	 */
	void setHR_Expense_AInput(ForeignEntityInput HR_Expense_A);

	/**
	 * Get HR_Expense_A.
	 *
	 * @return HR_Expense_A
	 */
	ForeignEntityInput HR_Expense_A();

	/**
	 * Set HR_Revenue_A.
	 *
	 * @param HR_Revenue_A HR_Revenue_A
	 */
	void setHR_Revenue_AInput(ForeignEntityInput HR_Revenue_A);

	/**
	 * Get HR_Revenue_A.
	 *
	 * @return HR_Revenue_A
	 */
	ForeignEntityInput HR_Revenue_A();

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1Input(ForeignEntityInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	ForeignEntityInput User1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2Input(ForeignEntityInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	ForeignEntityInput User2();
}
