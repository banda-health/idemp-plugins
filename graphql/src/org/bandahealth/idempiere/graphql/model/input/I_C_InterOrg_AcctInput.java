package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_InterOrg_Acct;

/**
 * Generated Interface for C_InterOrg_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_InterOrg_AcctInput extends I_C_InterOrg_Acct {

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
}
