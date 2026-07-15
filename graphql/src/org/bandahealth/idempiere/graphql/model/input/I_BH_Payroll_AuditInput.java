package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payroll_Audit;

/**
 * Generated Interface for BH_Payroll_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Payroll_AuditInput extends I_BH_Payroll_Audit {

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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

	/**
	 * Set Action Type.
	 *
	 * @param BH_ActionType Action Type
	 */
	void setBH_ActionTypeInput(ForeignEntityInput BH_ActionType);

	/**
	 * Get Action Type.
	 *
	 * @return Action Type
	 */
	ForeignEntityInput BH_ActionType();

	/**
	 * Set Payroll Run.
	 *
	 * @param BH_Payroll_Run Payroll Run
	 */
	void setBH_Payroll_RunInput(ForeignEntityInput BH_Payroll_Run);

	/**
	 * Get Payroll Run.
	 *
	 * @return Payroll Run
	 */
	ForeignEntityInput BH_Payroll_Run();

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
