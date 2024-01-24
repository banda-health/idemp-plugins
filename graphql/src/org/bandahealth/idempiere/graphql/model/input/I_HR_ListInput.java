package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_List;

/**
 * Generated Interface for HR_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_HR_ListInput extends I_HR_List {

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
	 * Set HR_Department.
	 *
	 * @param HR_Department HR_Department
	 */
	void setHR_DepartmentInput(ForeignEntityInput HR_Department);

	/**
	 * Get HR_Department.
	 *
	 * @return HR_Department
	 */
	ForeignEntityInput HR_Department();

	/**
	 * Set HR_Employee.
	 *
	 * @param HR_Employee HR_Employee
	 */
	void setHR_EmployeeInput(ForeignEntityInput HR_Employee);

	/**
	 * Get HR_Employee.
	 *
	 * @return HR_Employee
	 */
	ForeignEntityInput HR_Employee();

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
	 * Set HR_ListType.
	 *
	 * @param HR_ListType HR_ListType
	 */
	void setHR_ListTypeInput(ForeignEntityInput HR_ListType);

	/**
	 * Get HR_ListType.
	 *
	 * @return HR_ListType
	 */
	ForeignEntityInput HR_ListType();

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
}
