package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
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
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Workflow;

/**
 * Generated Model for PP_Order_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_WorkflowInput extends X_PP_Order_Workflow implements I_PP_Order_WorkflowInput {

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
	 private I_AD_WorkflowInput mAD_Workflow;
	 private I_AD_WorkflowProcessorInput mAD_WorkflowProcessor;
	 private I_PP_OrderInput mPP_Order;
	 private I_PP_Order_NodeInput mPP_Order_Node;
	 private I_S_ResourceInput mS_Resource;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PP_Order_WorkflowInput(@JsonProperty("ID") String ID) {
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
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
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
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public void setAD_WorkflowInput(I_AD_WorkflowInput AD_Workflow) {
		this.mAD_Workflow = AD_Workflow;
		X_AD_Workflow foreignEntity;
		if (AD_Workflow != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Workflow.Table_Name, X_AD_Workflow.COLUMNNAME_AD_Workflow_UU + "=?", get_TrxName())
						.setParameters(AD_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Workflow_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public I_AD_WorkflowInput AD_Workflow() {
		return mAD_Workflow;
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
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(I_PP_OrderInput PP_Order) {
		this.mPP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (get_ID() == 0 &&PP_Order != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order.Table_Name, X_PP_Order.COLUMNNAME_PP_Order_UU + "=?", get_TrxName())
						.setParameters(PP_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public I_PP_OrderInput PP_Order() {
		return mPP_Order;
	}

	/**
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("PP_Order_Node")
	public void setPP_Order_NodeInput(I_PP_Order_NodeInput PP_Order_Node) {
		this.mPP_Order_Node = PP_Order_Node;
		X_PP_Order_Node foreignEntity;
		if (PP_Order_Node != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_Node.Table_Name, X_PP_Order_Node.COLUMNNAME_PP_Order_Node_UU + "=?", get_TrxName())
						.setParameters(PP_Order_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Order_Node_ID(foreignEntity.get_ID());
		} else {
			super.setPP_Order_Node_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Activity.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("PP_Order_Node")
	public I_PP_Order_NodeInput PP_Order_Node() {
		return mPP_Order_Node;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_Order_Workflow_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Order_Workflow_UU();
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
