package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_ProcessResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MOrg;
import org.compiere.model.MReportView;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ProcessInput extends MProcess_BH implements I_AD_ProcessInput {

	private ForeignEntityInput mAD_CtxHelp;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Form;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mAD_ReportView;
	private ForeignEntityInput mAD_Workflow;
	private ForeignEntityInput mAccessLevel;
	private ForeignEntityInput mAllowMultipleExecution;
	private ForeignEntityInput mExecutionType;
	private ForeignEntityInput mShowHelp;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Process_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ProcessInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel Access Level required
	 */
	@JsonProperty("AccessLevel")
	public void setAccessLevelInput(ForeignEntityInput AccessLevel) {
		this.mAccessLevel = AccessLevel;
		if (AccessLevel != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ProcessResolver.ACCESSLEVEL_UUIDS_BY_VALUE.containsValue(AccessLevel.getUU())) {
				throw new AdempiereException("The reference list UU of " + AccessLevel.getUU() +
						" is not in the list defined for the AccessLevel column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccessLevel.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccessLevel(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AccessLevel.getUU());
			}
		} else {
			this.setAccessLevel(null);
		}
	}

	/**
	 * Get Data Access Level.
	 *
	 * @return Access Level required
	 */
	@JsonProperty("AccessLevel")
	public ForeignEntityInput AccessLevel() {
		return mAccessLevel;
	}

	/**
	 * Set Context Help.
	 *
	 * @param AD_CtxHelp Context Help
	 */
	@JsonProperty("AD_CtxHelp")
	public void setAD_CtxHelpInput(ForeignEntityInput AD_CtxHelp) {
		this.mAD_CtxHelp = AD_CtxHelp;
		if (AD_CtxHelp != null) {
			// Since an entity was passed, make sure it's in the DB
			MCtxHelp foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_CtxHelp", "AD_CtxHelp_UU=?", get_TrxName())
							.setParameters(AD_CtxHelp.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_CtxHelp_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_CtxHelp with UU " + AD_CtxHelp.getUU());
			}
		} else {
			this.setAD_CtxHelp_ID(0);
		}
	}

	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	@JsonProperty("AD_CtxHelp")
	public ForeignEntityInput AD_CtxHelp() {
		return mAD_CtxHelp;
	}

	/**
	 * Set Special Form.
	 *
	 * @param AD_Form Special Form
	 */
	@JsonProperty("AD_Form")
	public void setAD_FormInput(ForeignEntityInput AD_Form) {
		this.mAD_Form = AD_Form;
		if (AD_Form != null) {
			// Since an entity was passed, make sure it's in the DB
			MForm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Form", "AD_Form_UU=?", get_TrxName())
							.setParameters(AD_Form.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Form_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Form with UU " + AD_Form.getUU());
			}
		} else {
			this.setAD_Form_ID(0);
		}
	}

	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	@JsonProperty("AD_Form")
	public ForeignEntityInput AD_Form() {
		return mAD_Form;
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
							.setParameters(AD_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + AD_PrintFormat.getUU());
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
	 * Set Process.
	 *
	 * @param AD_Process_ID Process or Report
	 */
	@JsonProperty("AD_Process_ID")
	public void setAD_Process_IDFromJson(int AD_Process_ID) {
		if (get_ID() == 0) {
			super.setAD_Process_ID(AD_Process_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Process_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Process_UU();
	}

	/**
	 * Set Report View.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	@JsonProperty("AD_ReportView")
	public void setAD_ReportViewInput(ForeignEntityInput AD_ReportView) {
		this.mAD_ReportView = AD_ReportView;
		if (AD_ReportView != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportView foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ReportView", "AD_ReportView_UU=?", get_TrxName())
							.setParameters(AD_ReportView.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_ReportView_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ReportView with UU " + AD_ReportView.getUU());
			}
		} else {
			this.setAD_ReportView_ID(0);
		}
	}

	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	@JsonProperty("AD_ReportView")
	public ForeignEntityInput AD_ReportView() {
		return mAD_ReportView;
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
							.setParameters(AD_Workflow.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Workflow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Workflow with UU " + AD_Workflow.getUU());
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
	 * Set Allow Concurrent Execution.
	 *
	 * @param AllowMultipleExecution Allow or disallow executing a process/report multiple times concurrently
	 */
	@JsonProperty("AllowMultipleExecution")
	public void setAllowMultipleExecutionInput(ForeignEntityInput AllowMultipleExecution) {
		this.mAllowMultipleExecution = AllowMultipleExecution;
		if (AllowMultipleExecution != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ProcessResolver.ALLOWMULTIPLEEXECUTION_UUIDS_BY_VALUE.containsValue(AllowMultipleExecution.getUU())) {
				throw new AdempiereException("The reference list UU of " + AllowMultipleExecution.getUU() +
						" is not in the list defined for the AllowMultipleExecution column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AllowMultipleExecution.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAllowMultipleExecution(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AllowMultipleExecution.getUU());
			}
		} else {
			this.setAllowMultipleExecution(null);
		}
	}

	/**
	 * Get Allow Concurrent Execution.
	 *
	 * @return Allow or disallow executing a process/report multiple times concurrently
	 */
	@JsonProperty("AllowMultipleExecution")
	public ForeignEntityInput AllowMultipleExecution() {
		return mAllowMultipleExecution;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
			}
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Execution Type.
	 *
	 * @param ExecutionType Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	@JsonProperty("ExecutionType")
	public void setExecutionTypeInput(ForeignEntityInput ExecutionType) {
		this.mExecutionType = ExecutionType;
		if (ExecutionType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ProcessResolver.EXECUTIONTYPE_UUIDS_BY_VALUE.containsValue(ExecutionType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ExecutionType.getUU() +
						" is not in the list defined for the ExecutionType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ExecutionType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setExecutionType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ExecutionType.getUU());
			}
		} else {
			this.setExecutionType(null);
		}
	}

	/**
	 * Get Execution Type.
	 *
	 * @return Execution Type defines whether the report/process will always run in background or foreground. 
	 */
	@JsonProperty("ExecutionType")
	public ForeignEntityInput ExecutionType() {
		return mExecutionType;
	}

	/**
	 * Set Show Help.
	 *
	 * @param ShowHelp Show Help
	 */
	@JsonProperty("ShowHelp")
	public void setShowHelpInput(ForeignEntityInput ShowHelp) {
		this.mShowHelp = ShowHelp;
		if (ShowHelp != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ProcessResolver.SHOWHELP_UUIDS_BY_VALUE.containsValue(ShowHelp.getUU())) {
				throw new AdempiereException("The reference list UU of " + ShowHelp.getUU() +
						" is not in the list defined for the ShowHelp column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ShowHelp.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setShowHelp(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ShowHelp.getUU());
			}
		} else {
			this.setShowHelp(null);
		}
	}

	/**
	 * Get Show Help.
	 *
	 * @return Show Help
	 */
	@JsonProperty("ShowHelp")
	public ForeignEntityInput ShowHelp() {
		return mShowHelp;
	}
}
