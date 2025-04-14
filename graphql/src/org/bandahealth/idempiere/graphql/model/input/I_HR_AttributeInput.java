package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Attribute;

/**
 * Generated Interface for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_HR_AttributeInput extends I_HR_Attribute {

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
	 * Set ColumnType.
	 *
	 * @param ColumnType ColumnType
	 */
	void setColumnTypeInput(ForeignEntityInput ColumnType);

	/**
	 * Get ColumnType.
	 *
	 * @return ColumnType
	 */
	ForeignEntityInput ColumnType();

	/**
	 * Set HR_Attribute_A.
	 *
	 * @param HR_Attribute_A HR_Attribute_A
	 */
	void setHR_Attribute_AInput(ForeignEntityInput HR_Attribute_A);

	/**
	 * Get HR_Attribute_A.
	 *
	 * @return HR_Attribute_A
	 */
	ForeignEntityInput HR_Attribute_A();

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
	 * Set HR_Job.
	 *
	 * @param HR_Job HR_Job
	 */
	void setHR_JobInput(ForeignEntityInput HR_Job);

	/**
	 * Get HR_Job.
	 *
	 * @return HR_Job
	 */
	ForeignEntityInput HR_Job();

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
