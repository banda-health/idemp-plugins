package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_Fact_Reconciliation;

/**
 * Generated Interface for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_Fact_ReconciliationInput extends I_Fact_Reconciliation {

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
