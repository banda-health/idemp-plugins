package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Employee_Component;

/**
 * Generated Interface for BH_Employee_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Employee_ComponentInput extends I_BH_Employee_Component {

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
	 * Set Payroll Component.
	 *
	 * @param BH_Payroll_Component Payroll Component
	 */
	void setBH_Payroll_ComponentInput(ForeignEntityInput BH_Payroll_Component);

	/**
	 * Get Payroll Component.
	 *
	 * @return Payroll Component
	 */
	ForeignEntityInput BH_Payroll_Component();

	/**
	 * Set Payroll Employee.
	 *
	 * @param HR_Employee Payroll Employee
	 */
	void setHR_EmployeeInput(ForeignEntityInput HR_Employee);

	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	ForeignEntityInput HR_Employee();

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
