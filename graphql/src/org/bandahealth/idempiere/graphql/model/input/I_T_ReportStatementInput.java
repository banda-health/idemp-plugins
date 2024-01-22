package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_T_ReportStatement;

/**
 * Generated Interface for T_ReportStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_T_ReportStatementInput extends I_T_ReportStatement {

	/**
	 * Set AD_PInstance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	void setAD_PInstanceInput(ForeignEntityInput AD_PInstance);

	/**
	 * Get AD_PInstance.
	 *
	 * @return Instance of the process
	 */
	ForeignEntityInput AD_PInstance();

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
