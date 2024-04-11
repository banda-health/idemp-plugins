package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Concept;

/**
 * Generated Interface for HR_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_HR_ConceptInput extends I_HR_Concept {

	/**
	 * Set AccountSign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	void setAccountSignInput(ForeignEntityInput AccountSign);

	/**
	 * Get AccountSign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	ForeignEntityInput AccountSign();

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
	 * Set AD_Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	void setAD_ReferenceInput(ForeignEntityInput AD_Reference);

	/**
	 * Get AD_Reference.
	 *
	 * @return System Reference and Validation
	 */
	ForeignEntityInput AD_Reference();

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
	 * Set HR_Concept_Category.
	 *
	 * @param HR_Concept_Category HR_Concept_Category
	 */
	void setHR_Concept_CategoryInput(ForeignEntityInput HR_Concept_Category);

	/**
	 * Get HR_Concept_Category.
	 *
	 * @return HR_Concept_Category
	 */
	ForeignEntityInput HR_Concept_Category();

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

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	void setTypeInput(ForeignEntityInput Type);

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	ForeignEntityInput Type();
}
