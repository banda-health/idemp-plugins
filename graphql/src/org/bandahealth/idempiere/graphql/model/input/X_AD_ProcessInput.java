package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MReportView;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_Process;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ProcessInput extends X_AD_Process implements I_AD_ProcessInput {

	 private I_AD_CtxHelpInput AD_CtxHelp;
	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_FormInput AD_Form;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintFormatInput AD_PrintFormat;
	 private I_AD_Ref_ListInput AccessLevel_RL;
	 private I_AD_Ref_ListInput AllowMultipleExecution_RL;
	 private I_AD_Ref_ListInput ExecutionType_RL;
	 private I_AD_Ref_ListInput ShowHelp_RL;
	 private I_AD_ReportViewInput AD_ReportView;
	 private I_AD_WorkflowInput AD_Workflow;

	/**
	 * Standard constructor
	 */
	public X_AD_ProcessInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel_RL Access Level required
	 */
	public void setAccessLevel_RL(I_AD_Ref_ListInput AccessLevel_RL) {
		this.AccessLevel_RL = AccessLevel_RL;
		MRefList foreignEntity;
		if (AccessLevel_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccessLevel_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccessLevel(foreignEntity.getValue());
		} else {
			this.setAccessLevel(null);
		}
	}

	/**
	 * Get Data Access Level.
	 *
	 * @return Access Level required
	 */
	public I_AD_Ref_ListInput getAccessLevel_RL() {
		return AccessLevel_RL;
	}

	/**
	 * Set Context Help.
	 *
	 * @param AD_CtxHelp Context Help
	 */
	public void setAD_CtxHelp(I_AD_CtxHelpInput AD_CtxHelp) {
		this.AD_CtxHelp = AD_CtxHelp;
		MCtxHelp foreignEntity;
		if (AD_CtxHelp != null &&
				(foreignEntity = new Query(getCtx(), MCtxHelp.Table_Name, MCtxHelp.COLUMNNAME_AD_CtxHelp_UU + "=?", get_TrxName())
						.setParameters(AD_CtxHelp.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_CtxHelp_ID(foreignEntity.get_ID());
		} else {
			this.setAD_CtxHelp_ID(0);
		}
	}

	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	public I_AD_CtxHelpInput getAD_CtxHelp() {
		return AD_CtxHelp;
	}

	/**
	 * Set Special Form.
	 *
	 * @param AD_Form Special Form
	 */
	public void setAD_Form(I_AD_FormInput AD_Form) {
		this.AD_Form = AD_Form;
		MForm foreignEntity;
		if (AD_Form != null &&
				(foreignEntity = new Query(getCtx(), MForm.Table_Name, MForm.COLUMNNAME_AD_Form_UU + "=?", get_TrxName())
						.setParameters(AD_Form.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Form_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Form_ID(0);
		}
	}

	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public I_AD_FormInput getAD_Form() {
		return AD_Form;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	public void setAD_PrintFormat(I_AD_PrintFormatInput AD_PrintFormat) {
		this.AD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFormat.Table_Name, X_AD_PrintFormat.COLUMNNAME_AD_PrintFormat_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public I_AD_PrintFormatInput getAD_PrintFormat() {
		return AD_PrintFormat;
	}
	/**
	 * Set Process.
	 *
	 * @param AD_Process_ID Process or Report
	 */

	public void setAD_Process_ID(int AD_Process_ID) {
		if (get_ID() == 0) {
			super.setAD_Process_ID(AD_Process_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Process_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Process_UU();
	}

	/**
	 * Set Report View.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	public void setAD_ReportView(I_AD_ReportViewInput AD_ReportView) {
		this.AD_ReportView = AD_ReportView;
		MReportView foreignEntity;
		if (AD_ReportView != null &&
				(foreignEntity = new Query(getCtx(), MReportView.Table_Name, MReportView.COLUMNNAME_AD_ReportView_UU + "=?", get_TrxName())
						.setParameters(AD_ReportView.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_ReportView_ID(foreignEntity.get_ID());
		} else {
			this.setAD_ReportView_ID(0);
		}
	}

	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	public I_AD_ReportViewInput getAD_ReportView() {
		return AD_ReportView;
	}

	/**
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	public void setAD_Workflow(I_AD_WorkflowInput AD_Workflow) {
		this.AD_Workflow = AD_Workflow;
		X_AD_Workflow foreignEntity;
		if (AD_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Workflow.Table_Name, X_AD_Workflow.COLUMNNAME_AD_Workflow_UU + "=?", get_TrxName())
						.setParameters(AD_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Workflow_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public I_AD_WorkflowInput getAD_Workflow() {
		return AD_Workflow;
	}

	/**
	 * Set Multiple Execution.
	 *
	 * @param AllowMultipleExecution_RL Allow or disallow executing a process/report multiple times.
	 */
	public void setAllowMultipleExecution_RL(I_AD_Ref_ListInput AllowMultipleExecution_RL) {
		this.AllowMultipleExecution_RL = AllowMultipleExecution_RL;
		MRefList foreignEntity;
		if (AllowMultipleExecution_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AllowMultipleExecution_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAllowMultipleExecution(foreignEntity.getValue());
		} else {
			this.setAllowMultipleExecution(null);
		}
	}

	/**
	 * Get Multiple Execution.
	 *
	 * @return Allow or disallow executing a process/report multiple times.
	 */
	public I_AD_Ref_ListInput getAllowMultipleExecution_RL() {
		return AllowMultipleExecution_RL;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.getEntityType());
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}
	/**
	 * Set Entity Type.
	 *
	 * @param EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */

	public void setEntityType(String EntityType) {
		if (get_ID() == 0) {
			super.setEntityType(EntityType);
		}
	}

	/**
	 * Set Execution Type.
	 *
	 * @param ExecutionType_RL Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	public void setExecutionType_RL(I_AD_Ref_ListInput ExecutionType_RL) {
		this.ExecutionType_RL = ExecutionType_RL;
		MRefList foreignEntity;
		if (ExecutionType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ExecutionType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setExecutionType(foreignEntity.getValue());
		} else {
			this.setExecutionType(null);
		}
	}

	/**
	 * Get Execution Type.
	 *
	 * @return Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	public I_AD_Ref_ListInput getExecutionType_RL() {
		return ExecutionType_RL;
	}

	/**
	 * Set Show Help.
	 *
	 * @param ShowHelp_RL Show Help
	 */
	public void setShowHelp_RL(I_AD_Ref_ListInput ShowHelp_RL) {
		this.ShowHelp_RL = ShowHelp_RL;
		MRefList foreignEntity;
		if (ShowHelp_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ShowHelp_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setShowHelp(foreignEntity.getValue());
		} else {
			this.setShowHelp(null);
		}
	}

	/**
	 * Get Show Help.
	 *
	 * @return Show Help
	 */
	public I_AD_Ref_ListInput getShowHelp_RL() {
		return ShowHelp_RL;
	}
}
