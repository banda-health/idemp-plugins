package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MRule;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Concept_Category;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Movement;
import org.eevolution.model.X_HR_Process;
import org.eevolution.model.X_PP_Cost_Collector;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_MovementInput extends X_HR_Movement implements I_HR_MovementInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Rule;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BP_BankAccount;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_ProjectPhase;
	private ForeignEntityInput mC_ProjectTask;
	private ForeignEntityInput mHR_Concept;
	private ForeignEntityInput mHR_Concept_Category;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mHR_Job;
	private ForeignEntityInput mHR_Process;
	private ForeignEntityInput mPP_Cost_Collector;
	private ForeignEntityInput mUser1;
	private ForeignEntityInput mUser2;
	private I_AD_Ref_ListInput mAccountSign;
	private I_AD_Ref_ListInput mColumnType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The HR_Movement_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_MovementInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Account Sign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public void setAccountSignInput(I_AD_Ref_ListInput AccountSign) {
		this.mAccountSign = AccountSign;
		if (get_ID() != 0) {
			return;
		}
		if (AccountSign != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccountSign.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccountSign(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AccountSign.getUUID());
			}
		} else {
			this.setAccountSign(null);
		}
	}

	/**
	 * Get Account Sign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public I_AD_Ref_ListInput AccountSign() {
		return mAccountSign;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Rule.
	 *
	 * @param AD_Rule Rule
	 */
	@JsonProperty("AD_Rule")
	public void setAD_RuleInput(ForeignEntityInput AD_Rule) {
		this.mAD_Rule = AD_Rule;
		if (AD_Rule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Rule", "AD_Rule_UU=?", get_TrxName())
							.setParameters(AD_Rule.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Rule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Rule with UUID " + AD_Rule.getUUID());
			}
		} else {
			this.setAD_Rule_ID(0);
		}
	}

	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	@JsonProperty("AD_Rule")
	public ForeignEntityInput AD_Rule() {
		return mAD_Rule;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	@JsonProperty("C_Activity")
	public void setC_ActivityInput(ForeignEntityInput C_Activity) {
		this.mC_Activity = C_Activity;
		if (C_Activity != null) {
			// Since an entity was passed, make sure it's in the DB
			MActivity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Activity", "C_Activity_UU=?", get_TrxName())
							.setParameters(C_Activity.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UUID " + C_Activity.getUUID());
			}
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	@JsonProperty("C_Activity")
	public ForeignEntityInput C_Activity() {
		return mC_Activity;
	}

	/**
	 * Set Partner Bank Account.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	@JsonProperty("C_BP_BankAccount")
	public void setC_BP_BankAccountInput(ForeignEntityInput C_BP_BankAccount) {
		this.mC_BP_BankAccount = C_BP_BankAccount;
		if (get_ID() != 0) {
			return;
		}
		if (C_BP_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPBankAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_BankAccount", "C_BP_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BP_BankAccount.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BP_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_BankAccount with UUID " + C_BP_BankAccount.getUUID());
			}
		} else {
			this.setC_BP_BankAccount_ID(0);
		}
	}

	/**
	 * Get Partner Bank Account.
	 *
	 * @return Bank Account of the Business Partner
	 */
	@JsonProperty("C_BP_BankAccount")
	public ForeignEntityInput C_BP_BankAccount() {
		return mC_BP_BankAccount;
	}

	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		if (get_ID() != 0) {
			return;
		}
		if (C_BP_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPGroup_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
							.setParameters(C_BP_Group.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BP_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_Group with UUID " + C_BP_Group.getUUID());
			}
		} else {
			this.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public ForeignEntityInput C_BP_Group() {
		return mC_BP_Group;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(ForeignEntityInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		if (C_Campaign != null) {
			// Since an entity was passed, make sure it's in the DB
			MCampaign foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
							.setParameters(C_Campaign.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UUID " + C_Campaign.getUUID());
			}
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public ForeignEntityInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(ForeignEntityInput C_Project) {
		this.mC_Project = C_Project;
		if (C_Project != null) {
			// Since an entity was passed, make sure it's in the DB
			MProject foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UUID " + C_Project.getUUID());
			}
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public ForeignEntityInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public void setC_ProjectPhaseInput(ForeignEntityInput C_ProjectPhase) {
		this.mC_ProjectPhase = C_ProjectPhase;
		if (C_ProjectPhase != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectPhase foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectPhase", "C_ProjectPhase_UU=?", get_TrxName())
							.setParameters(C_ProjectPhase.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ProjectPhase_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectPhase with UUID " + C_ProjectPhase.getUUID());
			}
		} else {
			this.setC_ProjectPhase_ID(0);
		}
	}

	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public ForeignEntityInput C_ProjectPhase() {
		return mC_ProjectPhase;
	}

	/**
	 * Set Project Task.
	 *
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	@JsonProperty("C_ProjectTask")
	public void setC_ProjectTaskInput(ForeignEntityInput C_ProjectTask) {
		this.mC_ProjectTask = C_ProjectTask;
		if (C_ProjectTask != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectTask foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectTask", "C_ProjectTask_UU=?", get_TrxName())
							.setParameters(C_ProjectTask.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ProjectTask_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectTask with UUID " + C_ProjectTask.getUUID());
			}
		} else {
			this.setC_ProjectTask_ID(0);
		}
	}

	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	@JsonProperty("C_ProjectTask")
	public ForeignEntityInput C_ProjectTask() {
		return mC_ProjectTask;
	}

	/**
	 * Set Column Type.
	 *
	 * @param ColumnType Column Type
	 */
	@JsonProperty("ColumnType")
	public void setColumnTypeInput(I_AD_Ref_ListInput ColumnType) {
		this.mColumnType = ColumnType;
		if (ColumnType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ColumnType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setColumnType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ColumnType.getUUID());
			}
		} else {
			this.setColumnType(null);
		}
	}

	/**
	 * Get Column Type.
	 *
	 * @return Column Type
	 */
	@JsonProperty("ColumnType")
	public I_AD_Ref_ListInput ColumnType() {
		return mColumnType;
	}

	/**
	 * Set Payroll Concept Category.
	 *
	 * @param HR_Concept_Category Payroll Concept Category
	 */
	@JsonProperty("HR_Concept_Category")
	public void setHR_Concept_CategoryInput(ForeignEntityInput HR_Concept_Category) {
		this.mHR_Concept_Category = HR_Concept_Category;
		if (HR_Concept_Category != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Concept_Category foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Concept_Category", "HR_Concept_Category_UU=?", get_TrxName())
							.setParameters(HR_Concept_Category.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Concept_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Concept_Category with UUID " + HR_Concept_Category.getUUID());
			}
		} else {
			this.setHR_Concept_Category_ID(0);
		}
	}

	/**
	 * Get Payroll Concept Category.
	 *
	 * @return Payroll Concept Category
	 */
	@JsonProperty("HR_Concept_Category")
	public ForeignEntityInput HR_Concept_Category() {
		return mHR_Concept_Category;
	}

	/**
	 * Set Payroll Concept.
	 *
	 * @param HR_Concept Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public void setHR_ConceptInput(ForeignEntityInput HR_Concept) {
		this.mHR_Concept = HR_Concept;
		if (HR_Concept != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Concept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Concept", "HR_Concept_UU=?", get_TrxName())
							.setParameters(HR_Concept.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Concept with UUID " + HR_Concept.getUUID());
			}
		} else {
			this.setHR_Concept_ID(0);
		}
	}

	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public ForeignEntityInput HR_Concept() {
		return mHR_Concept;
	}

	/**
	 * Set Payroll Department.
	 *
	 * @param HR_Department Payroll Department
	 */
	@JsonProperty("HR_Department")
	public void setHR_DepartmentInput(ForeignEntityInput HR_Department) {
		this.mHR_Department = HR_Department;
		if (HR_Department != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Department foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Department", "HR_Department_UU=?", get_TrxName())
							.setParameters(HR_Department.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Department_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Department with UUID " + HR_Department.getUUID());
			}
		} else {
			this.setHR_Department_ID(0);
		}
	}

	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	@JsonProperty("HR_Department")
	public ForeignEntityInput HR_Department() {
		return mHR_Department;
	}

	/**
	 * Set Payroll Job.
	 *
	 * @param HR_Job Payroll Job
	 */
	@JsonProperty("HR_Job")
	public void setHR_JobInput(ForeignEntityInput HR_Job) {
		this.mHR_Job = HR_Job;
		if (HR_Job != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Job foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Job", "HR_Job_UU=?", get_TrxName())
							.setParameters(HR_Job.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Job_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Job with UUID " + HR_Job.getUUID());
			}
		} else {
			this.setHR_Job_ID(0);
		}
	}

	/**
	 * Get Payroll Job.
	 *
	 * @return Payroll Job
	 */
	@JsonProperty("HR_Job")
	public ForeignEntityInput HR_Job() {
		return mHR_Job;
	}
	/**
	 * Set Payroll Movement.
	 *
	 * @param HR_Movement_ID Payroll Movement
	 */

	public void setHR_Movement_ID(int HR_Movement_ID) {
		if (get_ID() == 0) {
			super.setHR_Movement_ID(HR_Movement_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setHR_Movement_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getHR_Movement_UU();
	}

	/**
	 * Set Payroll Process.
	 *
	 * @param HR_Process Payroll Process
	 */
	@JsonProperty("HR_Process")
	public void setHR_ProcessInput(ForeignEntityInput HR_Process) {
		this.mHR_Process = HR_Process;
		if (HR_Process != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Process foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Process", "HR_Process_UU=?", get_TrxName())
							.setParameters(HR_Process.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Process with UUID " + HR_Process.getUUID());
			}
		} else {
			this.setHR_Process_ID(0);
		}
	}

	/**
	 * Get Payroll Process.
	 *
	 * @return Payroll Process
	 */
	@JsonProperty("HR_Process")
	public ForeignEntityInput HR_Process() {
		return mHR_Process;
	}

	/**
	 * Set Manufacturing Cost Collector.
	 *
	 * @param PP_Cost_Collector Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public void setPP_Cost_CollectorInput(ForeignEntityInput PP_Cost_Collector) {
		this.mPP_Cost_Collector = PP_Cost_Collector;
		if (PP_Cost_Collector != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Cost_Collector foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Cost_Collector", "PP_Cost_Collector_UU=?", get_TrxName())
							.setParameters(PP_Cost_Collector.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPP_Cost_Collector_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Cost_Collector with UUID " + PP_Cost_Collector.getUUID());
			}
		} else {
			this.setPP_Cost_Collector_ID(0);
		}
	}

	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public ForeignEntityInput PP_Cost_Collector() {
		return mPP_Cost_Collector;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	@JsonProperty("User1")
	public void setUser1Input(ForeignEntityInput User1) {
		this.mUser1 = User1;
		if (User1 != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User1.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUser1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User1.getUUID());
			}
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	@JsonProperty("User1")
	public ForeignEntityInput User1() {
		return mUser1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	@JsonProperty("User2")
	public void setUser2Input(ForeignEntityInput User2) {
		this.mUser2 = User2;
		if (User2 != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User2.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUser2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User2.getUUID());
			}
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	@JsonProperty("User2")
	public ForeignEntityInput User2() {
		return mUser2;
	}
}
