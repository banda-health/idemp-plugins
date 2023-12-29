package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_CtxHelpInput AD_CtxHelp;
	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput AccessLevel_RL;
	 private I_AD_Ref_ListInput DurationUnit_RL;
	 private I_AD_Ref_ListInput ProcessType_RL;
	 private I_AD_Ref_ListInput PublishStatus_RL;
	 private I_AD_Ref_ListInput WorkflowType_RL;
	 private I_AD_TableInput AD_Table;
	 private I_AD_WF_NodeInput AD_WF_Node;
	 private I_AD_WF_ResponsibleInput AD_WF_Responsible;
	 private I_AD_WorkflowProcessorInput AD_WorkflowProcessor;
	 private I_S_ResourceInput S_Resource;

	/**
	 * Standard constructor
	 */
	public X_AD_WorkflowInput(String ID) {
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	public void setAD_Table(I_AD_TableInput AD_Table) {
		this.AD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), MTable.Table_Name, MTable.COLUMNNAME_AD_Table_UU + "=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public I_AD_TableInput getAD_Table() {
		return AD_Table;
	}

	/**
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	public void setAD_WF_Node(I_AD_WF_NodeInput AD_WF_Node) {
		this.AD_WF_Node = AD_WF_Node;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Node.Table_Name, X_AD_WF_Node.COLUMNNAME_AD_WF_Node_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Node.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Node_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	public I_AD_WF_NodeInput getAD_WF_Node() {
		return AD_WF_Node;
	}

	/**
	 * Set Workflow Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	public void setAD_WF_Responsible(I_AD_WF_ResponsibleInput AD_WF_Responsible) {
		this.AD_WF_Responsible = AD_WF_Responsible;
		X_AD_WF_Responsible foreignEntity;
		if (AD_WF_Responsible != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Responsible.Table_Name, X_AD_WF_Responsible.COLUMNNAME_AD_WF_Responsible_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Responsible.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Responsible_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WF_Responsible_ID(0);
		}
	}

	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	public I_AD_WF_ResponsibleInput getAD_WF_Responsible() {
		return AD_WF_Responsible;
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
	public void setAD_WorkflowProcessor(I_AD_WorkflowProcessorInput AD_WorkflowProcessor) {
		this.AD_WorkflowProcessor = AD_WorkflowProcessor;
		X_AD_WorkflowProcessor foreignEntity;
		if (AD_WorkflowProcessor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WorkflowProcessor.Table_Name, X_AD_WorkflowProcessor.COLUMNNAME_AD_WorkflowProcessor_UU + "=?", get_TrxName())
						.setParameters(AD_WorkflowProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WorkflowProcessor_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WorkflowProcessor_ID(0);
		}
	}

	/**
	 * Get Workflow Processor.
	 *
	 * @return Workflow Processor Server
	 */
	public I_AD_WorkflowProcessorInput getAD_WorkflowProcessor() {
		return AD_WorkflowProcessor;
	}

	/**
	 * Set Duration Unit.
	 *
	 * @param DurationUnit_RL Unit of Duration
	 */
	public void setDurationUnit_RL(I_AD_Ref_ListInput DurationUnit_RL) {
		this.DurationUnit_RL = DurationUnit_RL;
		MRefList foreignEntity;
		if (DurationUnit_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DurationUnit_RL.getID())
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
	public I_AD_Ref_ListInput getDurationUnit_RL() {
		return DurationUnit_RL;
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
			this.setEntityType(foreignEntity.get_ID());
		} else {
			this.setEntityType(0);
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
	 * Set Process Type.
	 *
	 * @param ProcessType_RL Process Type
	 */
	public void setProcessType_RL(I_AD_Ref_ListInput ProcessType_RL) {
		this.ProcessType_RL = ProcessType_RL;
		MRefList foreignEntity;
		if (ProcessType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProcessType_RL.getID())
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
	public I_AD_Ref_ListInput getProcessType_RL() {
		return ProcessType_RL;
	}

	/**
	 * Set Publication Status.
	 *
	 * @param PublishStatus_RL Status of Publication
	 */
	public void setPublishStatus_RL(I_AD_Ref_ListInput PublishStatus_RL) {
		this.PublishStatus_RL = PublishStatus_RL;
		MRefList foreignEntity;
		if (PublishStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PublishStatus_RL.getID())
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
	public I_AD_Ref_ListInput getPublishStatus_RL() {
		return PublishStatus_RL;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	public void setS_Resource(I_S_ResourceInput S_Resource) {
		this.S_Resource = S_Resource;
		MResource foreignEntity;
		if (S_Resource != null &&
				(foreignEntity = new Query(getCtx(), MResource.Table_Name, MResource.COLUMNNAME_S_Resource_UU + "=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_Resource_ID(foreignEntity.get_ID());
		} else {
			this.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public I_S_ResourceInput getS_Resource() {
		return S_Resource;
	}

	/**
	 * Set Workflow Type.
	 *
	 * @param WorkflowType_RL Type of Workflow
	 */
	public void setWorkflowType_RL(I_AD_Ref_ListInput WorkflowType_RL) {
		this.WorkflowType_RL = WorkflowType_RL;
		MRefList foreignEntity;
		if (WorkflowType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(WorkflowType_RL.getID())
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
	public I_AD_Ref_ListInput getWorkflowType_RL() {
		return WorkflowType_RL;
	}
}
