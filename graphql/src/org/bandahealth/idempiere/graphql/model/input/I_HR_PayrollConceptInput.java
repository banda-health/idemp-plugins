package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_PayrollConcept;

/**
 * Generated Interface for HR_PayrollConcept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_HR_PayrollConceptInput extends I_HR_PayrollConcept {

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
	 * Set AD_Rule.
	 *
	 * @param AD_Rule AD_Rule
	 */
	void setAD_RuleInput(ForeignEntityInput AD_Rule);

	/**
	 * Get AD_Rule.
	 *
	 * @return AD_Rule
	 */
	ForeignEntityInput AD_Rule();

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
	 * Set HR_Payroll.
	 *
	 * @param HR_Payroll HR_Payroll
	 */
	void setHR_PayrollInput(ForeignEntityInput HR_Payroll);

	/**
	 * Get HR_Payroll.
	 *
	 * @return HR_Payroll
	 */
	ForeignEntityInput HR_Payroll();

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
