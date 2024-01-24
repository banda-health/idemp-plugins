package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_Fact_Reconciliation;

/**
 * Generated Interface for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_Fact_ReconciliationInput extends I_Fact_Reconciliation {

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	void setAccountInput(ForeignEntityInput Account);

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	ForeignEntityInput Account();

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set Fact_Acct.
	 *
	 * @param Fact_Acct Fact_Acct
	 */
	void setFact_AcctInput(ForeignEntityInput Fact_Acct);

	/**
	 * Get Fact_Acct.
	 *
	 * @return Fact_Acct
	 */
	ForeignEntityInput Fact_Acct();

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
}
