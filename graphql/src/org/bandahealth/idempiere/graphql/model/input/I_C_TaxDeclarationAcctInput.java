package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_TaxDeclarationAcct;

/**
 * Generated Interface for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_TaxDeclarationAcctInput extends I_C_TaxDeclarationAcct {

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
	 * Set C_TaxDeclaration.
	 *
	 * @param C_TaxDeclaration Define the declaration to the tax authorities
	 */
	void setC_TaxDeclarationInput(ForeignEntityInput C_TaxDeclaration);

	/**
	 * Get C_TaxDeclaration.
	 *
	 * @return Define the declaration to the tax authorities
	 */
	ForeignEntityInput C_TaxDeclaration();

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
}
