package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySelection;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Employee;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Payroll;
import org.eevolution.model.X_HR_Period;
import org.eevolution.model.X_HR_Process;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for HR_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ProcessInput extends X_HR_Process implements I_HR_ProcessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mAD_Workflow;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mC_DocTypeTarget;
	private ForeignEntityInput mC_PaySelection;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mHR_Employee;
	private ForeignEntityInput mHR_Job;
	private ForeignEntityInput mHR_Payroll;
	private ForeignEntityInput mHR_Period;
	private ForeignEntityInput mReversal;
	private I_AD_Ref_ListInput mDocAction;
	private I_AD_Ref_ListInput mDocStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The HR_Process_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_ProcessInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_HR_Process(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		if (AD_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormat.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + AD_PrintFormat.getUUID());
			}
		} else {
			this.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}

	/**
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public void setAD_WorkflowInput(ForeignEntityInput AD_Workflow) {
		this.mAD_Workflow = AD_Workflow;
		if (AD_Workflow != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Workflow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Workflow", "AD_Workflow_UU=?", get_TrxName())
							.setParameters(AD_Workflow.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Workflow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Workflow with UUID " + AD_Workflow.getUUID());
			}
		} else {
			this.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public ForeignEntityInput AD_Workflow() {
		return mAD_Workflow;
	}

	/**
	 * Set Business Partner .
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
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(ForeignEntityInput C_Charge) {
		this.mC_Charge = C_Charge;
		if (C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(C_Charge.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UUID " + C_Charge.getUUID());
			}
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public ForeignEntityInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		if (get_ID() != 0) {
			return;
		}
		if (C_DocType != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocType.getUUID());
			}
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set Target Document Type.
	 *
	 * @param C_DocTypeTarget Target document type for conversing documents
	 */
	@JsonProperty("C_DocTypeTarget")
	public void setC_DocTypeTargetInput(ForeignEntityInput C_DocTypeTarget) {
		this.mC_DocTypeTarget = C_DocTypeTarget;
		if (C_DocTypeTarget != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocTypeTarget.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocTypeTarget_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocTypeTarget.getUUID());
			}
		} else {
			this.setC_DocTypeTarget_ID(0);
		}
	}

	/**
	 * Get Target Document Type.
	 *
	 * @return Target document type for conversing documents
	 */
	@JsonProperty("C_DocTypeTarget")
	public ForeignEntityInput C_DocTypeTarget() {
		return mC_DocTypeTarget;
	}

	/**
	 * Set Payment Selection.
	 *
	 * @param C_PaySelection Payment Selection
	 */
	@JsonProperty("C_PaySelection")
	public void setC_PaySelectionInput(ForeignEntityInput C_PaySelection) {
		this.mC_PaySelection = C_PaySelection;
		if (C_PaySelection != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaySelection foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaySelection", "C_PaySelection_UU=?", get_TrxName())
							.setParameters(C_PaySelection.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_PaySelection_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaySelection with UUID " + C_PaySelection.getUUID());
			}
		} else {
			this.setC_PaySelection_ID(0);
		}
	}

	/**
	 * Get Payment Selection.
	 *
	 * @return Payment Selection
	 */
	@JsonProperty("C_PaySelection")
	public ForeignEntityInput C_PaySelection() {
		return mC_PaySelection;
	}
	/**
	 * Set Account Date.
	 *
	 * @param DateAcct Accounting Date
	 */

	public void setDateAcct(Timestamp DateAcct) {
		if (get_ID() == 0) {
			super.setDateAcct(DateAcct);
		}
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocAction.getUUID());
			}
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public I_AD_Ref_ListInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(I_AD_Ref_ListInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocStatus.getUUID());
			}
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public I_AD_Ref_ListInput DocStatus() {
		return mDocStatus;
	}
	/**
	 * Set Document No.
	 *
	 * @param DocumentNo Document sequence number of the document
	 */

	public void setDocumentNo(String DocumentNo) {
		if (get_ID() == 0) {
			super.setDocumentNo(DocumentNo);
		}
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
							.setParameters(HR_Department.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set Payroll Employee.
	 *
	 * @param HR_Employee Payroll Employee
	 */
	@JsonProperty("HR_Employee")
	public void setHR_EmployeeInput(ForeignEntityInput HR_Employee) {
		this.mHR_Employee = HR_Employee;
		if (HR_Employee != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Employee foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Employee", "HR_Employee_UU=?", get_TrxName())
							.setParameters(HR_Employee.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Employee_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Employee with UUID " + HR_Employee.getUUID());
			}
		} else {
			this.setHR_Employee_ID(0);
		}
	}

	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	@JsonProperty("HR_Employee")
	public ForeignEntityInput HR_Employee() {
		return mHR_Employee;
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
							.setParameters(HR_Job.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set Payroll.
	 *
	 * @param HR_Payroll Payroll
	 */
	@JsonProperty("HR_Payroll")
	public void setHR_PayrollInput(ForeignEntityInput HR_Payroll) {
		this.mHR_Payroll = HR_Payroll;
		if (get_ID() != 0) {
			return;
		}
		if (HR_Payroll != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Payroll foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Payroll", "HR_Payroll_UU=?", get_TrxName())
							.setParameters(HR_Payroll.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Payroll_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Payroll with UUID " + HR_Payroll.getUUID());
			}
		} else {
			this.setHR_Payroll_ID(0);
		}
	}

	/**
	 * Get Payroll.
	 *
	 * @return Payroll
	 */
	@JsonProperty("HR_Payroll")
	public ForeignEntityInput HR_Payroll() {
		return mHR_Payroll;
	}

	/**
	 * Set Payroll Period.
	 *
	 * @param HR_Period Payroll Period
	 */
	@JsonProperty("HR_Period")
	public void setHR_PeriodInput(ForeignEntityInput HR_Period) {
		this.mHR_Period = HR_Period;
		if (get_ID() != 0) {
			return;
		}
		if (HR_Period != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Period foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Period", "HR_Period_UU=?", get_TrxName())
							.setParameters(HR_Period.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Period with UUID " + HR_Period.getUUID());
			}
		} else {
			this.setHR_Period_ID(0);
		}
	}

	/**
	 * Get Payroll Period.
	 *
	 * @return Payroll Period
	 */
	@JsonProperty("HR_Period")
	public ForeignEntityInput HR_Period() {
		return mHR_Period;
	}
	/**
	 * Set Payroll Process.
	 *
	 * @param HR_Process_ID Payroll Process
	 */

	public void setHR_Process_ID(int HR_Process_ID) {
		if (get_ID() == 0) {
			super.setHR_Process_ID(HR_Process_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setHR_Process_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getHR_Process_UU();
	}
	/**
	 * Set Posted.
	 *
	 * @param Posted Posting status
	 */

	public void setPosted(boolean Posted) {
		if (get_ID() == 0) {
			super.setPosted(Posted);
		}
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	@JsonProperty("Reversal")
	public void setReversalInput(ForeignEntityInput Reversal) {
		this.mReversal = Reversal;
		if (Reversal != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Process foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Process", "HR_Process_UU=?", get_TrxName())
							.setParameters(Reversal.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setReversal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Process with UUID " + Reversal.getUUID());
			}
		} else {
			this.setReversal_ID(0);
		}
	}

	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	@JsonProperty("Reversal")
	public ForeignEntityInput Reversal() {
		return mReversal;
	}
}
