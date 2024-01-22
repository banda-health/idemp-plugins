package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_FundingMode_Acct;

/**
 * Generated Interface for A_FundingMode_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_A_FundingMode_AcctInput extends I_A_FundingMode_Acct {

	/**
	 * Set A_FundingMode_A.
	 *
	 * @param A_FundingMode_A A_FundingMode_A
	 */
	void setA_FundingMode_AInput(ForeignEntityInput A_FundingMode_A);

	/**
	 * Get A_FundingMode_A.
	 *
	 * @return A_FundingMode_A
	 */
	ForeignEntityInput A_FundingMode_A();

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
	 * Set A_FundingMode.
	 *
	 * @param A_FundingMode A_FundingMode
	 */
	void setA_FundingModeInput(ForeignEntityInput A_FundingMode);

	/**
	 * Get A_FundingMode.
	 *
	 * @return A_FundingMode
	 */
	ForeignEntityInput A_FundingMode();

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
}
