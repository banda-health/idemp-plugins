package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payroll_Run;

/**
 * Generated Interface for BH_Payroll_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Payroll_RunInput extends I_BH_Payroll_Run {

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(ForeignEntityInput DocAction);

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	ForeignEntityInput DocAction();

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(ForeignEntityInput DocStatus);

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	ForeignEntityInput DocStatus();

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
