package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Process;

/**
 * Generated Interface for HR_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_HR_ProcessInput extends I_HR_Process {

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

	/**
	 * Set AD_Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	void setAD_WorkflowInput(ForeignEntityInput AD_Workflow);

	/**
	 * Get AD_Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	ForeignEntityInput AD_Workflow();

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(ForeignEntityInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	ForeignEntityInput C_DocType();

	/**
	 * Set C_DocTypeTarget.
	 *
	 * @param C_DocTypeTarget Target document type for conversing documents
	 */
	void setC_DocTypeTargetInput(ForeignEntityInput C_DocTypeTarget);

	/**
	 * Get C_DocTypeTarget.
	 *
	 * @return Target document type for conversing documents
	 */
	ForeignEntityInput C_DocTypeTarget();

	/**
	 * Set C_PaySelection.
	 *
	 * @param C_PaySelection Payment Selection
	 */
	void setC_PaySelectionInput(ForeignEntityInput C_PaySelection);

	/**
	 * Get C_PaySelection.
	 *
	 * @return Payment Selection
	 */
	ForeignEntityInput C_PaySelection();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(I_AD_Ref_ListInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput DocAction();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(I_AD_Ref_ListInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput DocStatus();

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

	/**
	 * Set HR_Period.
	 *
	 * @param HR_Period HR_Period
	 */
	void setHR_PeriodInput(ForeignEntityInput HR_Period);

	/**
	 * Get HR_Period.
	 *
	 * @return HR_Period
	 */
	ForeignEntityInput HR_Period();

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
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversalInput(ForeignEntityInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	ForeignEntityInput Reversal();
}
