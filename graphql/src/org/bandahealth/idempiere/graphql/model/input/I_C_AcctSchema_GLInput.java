package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AcctSchema_GL;

/**
 * Generated Interface for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_AcctSchema_GLInput extends I_C_AcctSchema_GL {

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
	 * Set CommitmentOffset_A.
	 *
	 * @param CommitmentOffset_A Budgetary Commitment Offset Account
	 */
	void setCommitmentOffset_AInput(ForeignEntityInput CommitmentOffset_A);

	/**
	 * Get CommitmentOffset_A.
	 *
	 * @return Budgetary Commitment Offset Account
	 */
	ForeignEntityInput CommitmentOffset_A();

	/**
	 * Set CommitmentOffsetSales_A.
	 *
	 * @param CommitmentOffsetSales_A Budgetary Commitment Offset Account for Sales
	 */
	void setCommitmentOffsetSales_AInput(ForeignEntityInput CommitmentOffsetSales_A);

	/**
	 * Get CommitmentOffsetSales_A.
	 *
	 * @return Budgetary Commitment Offset Account for Sales
	 */
	ForeignEntityInput CommitmentOffsetSales_A();

	/**
	 * Set CurrencyBalancing_A.
	 *
	 * @param CurrencyBalancing_A Account used when a currency is out of balance
	 */
	void setCurrencyBalancing_AInput(ForeignEntityInput CurrencyBalancing_A);

	/**
	 * Get CurrencyBalancing_A.
	 *
	 * @return Account used when a currency is out of balance
	 */
	ForeignEntityInput CurrencyBalancing_A();

	/**
	 * Set IntercompanyDueFrom_A.
	 *
	 * @param IntercompanyDueFrom_A Intercompany Due From / Receivables Account
	 */
	void setIntercompanyDueFrom_AInput(ForeignEntityInput IntercompanyDueFrom_A);

	/**
	 * Get IntercompanyDueFrom_A.
	 *
	 * @return Intercompany Due From / Receivables Account
	 */
	ForeignEntityInput IntercompanyDueFrom_A();

	/**
	 * Set IntercompanyDueTo_A.
	 *
	 * @param IntercompanyDueTo_A Intercompany Due To / Payable Account
	 */
	void setIntercompanyDueTo_AInput(ForeignEntityInput IntercompanyDueTo_A);

	/**
	 * Get IntercompanyDueTo_A.
	 *
	 * @return Intercompany Due To / Payable Account
	 */
	ForeignEntityInput IntercompanyDueTo_A();

	/**
	 * Set PPVOffset_A.
	 *
	 * @param PPVOffset_A Purchase Price Variance Offset Account
	 */
	void setPPVOffset_AInput(ForeignEntityInput PPVOffset_A);

	/**
	 * Get PPVOffset_A.
	 *
	 * @return Purchase Price Variance Offset Account
	 */
	ForeignEntityInput PPVOffset_A();

	/**
	 * Set SuspenseBalancing_A.
	 *
	 * @param SuspenseBalancing_A SuspenseBalancing_A
	 */
	void setSuspenseBalancing_AInput(ForeignEntityInput SuspenseBalancing_A);

	/**
	 * Get SuspenseBalancing_A.
	 *
	 * @return SuspenseBalancing_A
	 */
	ForeignEntityInput SuspenseBalancing_A();
}
