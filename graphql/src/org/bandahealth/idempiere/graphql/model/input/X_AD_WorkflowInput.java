package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.model.X_AD_Workflow;
import org.compiere.model.X_AD_WorkflowProcessor;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowInput extends X_AD_Workflow implements I_AD_WorkflowInput {

	 private I_AD_CtxHelpInput mAD_CtxHelp;
	 private I_AD_EntityTypeInput mAD_EntityType;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mAccessLevel;
	 private I_AD_Ref_ListInput mDurationUnit;
	 private I_AD_Ref_ListInput mProcessType;
	 private I_AD_Ref_ListInput mPublishStatus;
	 private I_AD_Ref_ListInput mWorkflowType;
	 private I_AD_TableInput mAD_Table;
	 private I_AD_WF_NodeInput mAD_WF_Node;
	 private I_AD_WF_ResponsibleInput mAD_WF_Responsible;
	 private I_AD_WorkflowProcessorInput mAD_WorkflowProcessor;
	 private I_S_ResourceInput mS_Resource;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WorkflowInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel Access Level required
	 */
	@JsonProperty("AccessLevel")
	public void setAccessLevelInput(I_AD_Ref_ListInput AccessLevel) {
		this.mAccessLevel = AccessLevel;
		MRefList_BH foreignEntity;
		if (AccessLevel != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccessLevel.getID())
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
	@JsonProperty("AccessLevel")
	public I_AD_Ref_ListInput AccessLevel() {
		return mAccessLevel;
	}

	/**
	 * Set Context Help.
	 *
	 * @param AD_CtxHelp Context Help
	 */
	@JsonProperty("AD_CtxHelp")
	public void setAD_CtxHelpInput(I_AD_CtxHelpInput AD_CtxHelp) {
		this.mAD_CtxHelp = AD_CtxHelp;
		MCtxHelp foreignEntity;
		if (AD_CtxHelp != null &&
				(foreignEntity = new Query(getCtx(), MCtxHelp.Table_Name, MCtxHelp.COLUMNNAME_AD_CtxHelp_UU + "=?", get_TrxName())
						.setParameters(AD_CtxHelp.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_CtxHelp_ID(foreignEntity.get_ID());
		} else {
			super.setAD_CtxHelp_ID(0);
		}
	}

	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	@JsonProperty("AD_CtxHelp")
	public I_AD_CtxHelpInput AD_CtxHelp() {
		return mAD_CtxHelp;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(I_AD_TableInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), MTable.Table_Name, MTable.COLUMNNAME_AD_Table_UU + "=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public I_AD_TableInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public void setAD_WF_NodeInput(I_AD_WF_NodeInput AD_WF_Node) {
		this.mAD_WF_Node = AD_WF_Node;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Node.Table_Name, X_AD_WF_Node.COLUMNNAME_AD_WF_Node_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Node_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public I_AD_WF_NodeInput AD_WF_Node() {
		return mAD_WF_Node;
	}

	/**
	 * Set Workflow Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	@JsonProperty("AD_WF_Responsible")
	public void setAD_WF_ResponsibleInput(I_AD_WF_ResponsibleInput AD_WF_Responsible) {
		this.mAD_WF_Responsible = AD_WF_Responsible;
		X_AD_WF_Responsible foreignEntity;
		if (AD_WF_Responsible != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Responsible.Table_Name, X_AD_WF_Responsible.COLUMNNAME_AD_WF_Responsible_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Responsible.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Responsible_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WF_Responsible_ID(0);
		}
	}

	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	@JsonProperty("AD_WF_Responsible")
	public I_AD_WF_ResponsibleInput AD_WF_Responsible() {
		return mAD_WF_Responsible;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Workflow_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Workflow_UU();
	}

	/**
	 * Set Workflow Processor.
	 *
	 * @param AD_WorkflowProcessor Workflow Processor Server
	 */
	@JsonProperty("AD_WorkflowProcessor")
	public void setAD_WorkflowProcessorInput(I_AD_WorkflowProcessorInput AD_WorkflowProcessor) {
		this.mAD_WorkflowProcessor = AD_WorkflowProcessor;
		X_AD_WorkflowProcessor foreignEntity;
		if (AD_WorkflowProcessor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WorkflowProcessor.Table_Name, X_AD_WorkflowProcessor.COLUMNNAME_AD_WorkflowProcessor_UU + "=?", get_TrxName())
						.setParameters(AD_WorkflowProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WorkflowProcessor_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WorkflowProcessor_ID(0);
		}
	}

	/**
	 * Get Workflow Processor.
	 *
	 * @return Workflow Processor Server
	 */
	@JsonProperty("AD_WorkflowProcessor")
	public I_AD_WorkflowProcessorInput AD_WorkflowProcessor() {
		return mAD_WorkflowProcessor;
	}

	/**
	 * Set Duration Unit.
	 *
	 * @param DurationUnit Unit of Duration
	 */
	@JsonProperty("DurationUnit")
	public void setDurationUnitInput(I_AD_Ref_ListInput DurationUnit) {
		this.mDurationUnit = DurationUnit;
		MRefList_BH foreignEntity;
		if (DurationUnit != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DurationUnit.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDurationUnit(foreignEntity.getValue());
		} else {
			this.setDurationUnit(null);
		}
	}

	/**
	 * Get Duration Unit.
	 *
	 * @return Unit of Duration
	 */
	@JsonProperty("DurationUnit")
	public I_AD_Ref_ListInput DurationUnit() {
		return mDurationUnit;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public I_AD_EntityTypeInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Process Type.
	 *
	 * @param ProcessType Process Type
	 */
	@JsonProperty("ProcessType")
	public void setProcessTypeInput(I_AD_Ref_ListInput ProcessType) {
		this.mProcessType = ProcessType;
		MRefList_BH foreignEntity;
		if (ProcessType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProcessType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setProcessType(foreignEntity.getValue());
		} else {
			this.setProcessType(null);
		}
	}

	/**
	 * Get Process Type.
	 *
	 * @return Process Type
	 */
	@JsonProperty("ProcessType")
	public I_AD_Ref_ListInput ProcessType() {
		return mProcessType;
	}

	/**
	 * Set Publication Status.
	 *
	 * @param PublishStatus Status of Publication
	 */
	@JsonProperty("PublishStatus")
	public void setPublishStatusInput(I_AD_Ref_ListInput PublishStatus) {
		this.mPublishStatus = PublishStatus;
		MRefList_BH foreignEntity;
		if (PublishStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PublishStatus.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPublishStatus(foreignEntity.getValue());
		} else {
			this.setPublishStatus(null);
		}
	}

	/**
	 * Get Publication Status.
	 *
	 * @return Status of Publication
	 */
	@JsonProperty("PublishStatus")
	public I_AD_Ref_ListInput PublishStatus() {
		return mPublishStatus;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	@JsonProperty("S_Resource")
	public void setS_ResourceInput(I_S_ResourceInput S_Resource) {
		this.mS_Resource = S_Resource;
		MResource foreignEntity;
		if (S_Resource != null &&
				(foreignEntity = new Query(getCtx(), MResource.Table_Name, MResource.COLUMNNAME_S_Resource_UU + "=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setS_Resource_ID(foreignEntity.get_ID());
		} else {
			super.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	@JsonProperty("S_Resource")
	public I_S_ResourceInput S_Resource() {
		return mS_Resource;
	}

	/**
	 * Set Workflow Type.
	 *
	 * @param WorkflowType Type of Workflow
	 */
	@JsonProperty("WorkflowType")
	public void setWorkflowTypeInput(I_AD_Ref_ListInput WorkflowType) {
		this.mWorkflowType = WorkflowType;
		MRefList_BH foreignEntity;
		if (WorkflowType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(WorkflowType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setWorkflowType(foreignEntity.getValue());
		} else {
			this.setWorkflowType(null);
		}
	}

	/**
	 * Get Workflow Type.
	 *
	 * @return Type of Workflow
	 */
	@JsonProperty("WorkflowType")
	public I_AD_Ref_ListInput WorkflowType() {
		return mWorkflowType;
	}
}
