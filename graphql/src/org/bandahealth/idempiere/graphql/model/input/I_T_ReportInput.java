package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_T_Report;

/**
 * Generated Interface for T_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_T_ReportInput extends I_T_Report {

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
	 * Set PA_ReportLine.
	 *
	 * @param PA_ReportLine PA_ReportLine
	 */
	void setPA_ReportLineInput(ForeignEntityInput PA_ReportLine);

	/**
	 * Get PA_ReportLine.
	 *
	 * @return PA_ReportLine
	 */
	ForeignEntityInput PA_ReportLine();

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
