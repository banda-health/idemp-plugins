package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Movement;

/**
 * Generated Interface for HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_HR_MovementInput extends I_HR_Movement {

	/**
	 * Set AccountSign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	void setAccountSignInput(I_AD_Ref_ListInput AccountSign);

	/**
	 * Get AccountSign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	I_AD_Ref_ListInput AccountSign();

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
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(ForeignEntityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	ForeignEntityInput C_Activity();

	/**
	 * Set C_BP_BankAccount.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	void setC_BP_BankAccountInput(ForeignEntityInput C_BP_BankAccount);

	/**
	 * Get C_BP_BankAccount.
	 *
	 * @return Bank Account of the Business Partner
	 */
	ForeignEntityInput C_BP_BankAccount();

	/**
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_GroupInput(ForeignEntityInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	ForeignEntityInput C_BP_Group();

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
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(ForeignEntityInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	ForeignEntityInput C_Campaign();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

	/**
	 * Set C_ProjectPhase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	void setC_ProjectPhaseInput(ForeignEntityInput C_ProjectPhase);

	/**
	 * Get C_ProjectPhase.
	 *
	 * @return Phase of a Project
	 */
	ForeignEntityInput C_ProjectPhase();

	/**
	 * Set C_ProjectTask.
	 *
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	void setC_ProjectTaskInput(ForeignEntityInput C_ProjectTask);

	/**
	 * Get C_ProjectTask.
	 *
	 * @return Actual Project Task in a Phase
	 */
	ForeignEntityInput C_ProjectTask();

	/**
	 * Set ColumnType.
	 *
	 * @param ColumnType ColumnType
	 */
	void setColumnTypeInput(I_AD_Ref_ListInput ColumnType);

	/**
	 * Get ColumnType.
	 *
	 * @return ColumnType
	 */
	I_AD_Ref_ListInput ColumnType();

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

	/**
	 * Set HR_Process.
	 *
	 * @param HR_Process HR_Process
	 */
	void setHR_ProcessInput(ForeignEntityInput HR_Process);

	/**
	 * Get HR_Process.
	 *
	 * @return HR_Process
	 */
	ForeignEntityInput HR_Process();

	/**
	 * Set PP_Cost_Collector.
	 *
	 * @param PP_Cost_Collector PP_Cost_Collector
	 */
	void setPP_Cost_CollectorInput(ForeignEntityInput PP_Cost_Collector);

	/**
	 * Get PP_Cost_Collector.
	 *
	 * @return PP_Cost_Collector
	 */
	ForeignEntityInput PP_Cost_Collector();

	/**
	 * Set User1.
	 *
	 * @param User1 User defined list element #1
	 */
	void setUser1Input(ForeignEntityInput User1);

	/**
	 * Get User1.
	 *
	 * @return User defined list element #1
	 */
	ForeignEntityInput User1();

	/**
	 * Set User2.
	 *
	 * @param User2 User defined list element #2
	 */
	void setUser2Input(ForeignEntityInput User2);

	/**
	 * Get User2.
	 *
	 * @return User defined list element #2
	 */
	ForeignEntityInput User2();
}
