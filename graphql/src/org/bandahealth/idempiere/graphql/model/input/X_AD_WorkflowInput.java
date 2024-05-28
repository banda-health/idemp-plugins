package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_WorkflowResolver;
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

import java.sql.ResultSet;

/**
 * Generated Model for AD_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WorkflowInput extends X_AD_Workflow implements I_AD_WorkflowInput {

	private ForeignEntityInput mAD_CtxHelp;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_WF_Node;
	private ForeignEntityInput mAD_WF_Responsible;
	private ForeignEntityInput mAD_WorkflowProcessor;
	private ForeignEntityInput mAccessLevel;
	private ForeignEntityInput mDurationUnit;
	private ForeignEntityInput mProcessType;
	private ForeignEntityInput mPublishStatus;
	private ForeignEntityInput mS_Resource;
	private ForeignEntityInput mWorkflowType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Workflow_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_WorkflowInput(@JsonProperty("UU") String UU) {
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
			if (!X_AD_WorkflowResolver.ACCESSLEVEL_UUIDS_BY_VALUE.containsValue(AccessLevel.getUU())) {
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
							.setParameters(AD_CtxHelp.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node) {
		this.mAD_WF_Node = AD_WF_Node;
		if (AD_WF_Node != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Node foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Node", "AD_WF_Node_UU=?", get_TrxName())
							.setParameters(AD_WF_Node.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_WF_Node_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Node with UU " + AD_WF_Node.getUU());
			}
		} else {
			this.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public ForeignEntityInput AD_WF_Node() {
		return mAD_WF_Node;
	}

	/**
	 * Set Workflow Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	@JsonProperty("AD_WF_Responsible")
	public void setAD_WF_ResponsibleInput(ForeignEntityInput AD_WF_Responsible) {
		this.mAD_WF_Responsible = AD_WF_Responsible;
		if (AD_WF_Responsible != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Responsible foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Responsible", "AD_WF_Responsible_UU=?", get_TrxName())
							.setParameters(AD_WF_Responsible.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_WF_Responsible_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Responsible with UU " + AD_WF_Responsible.getUU());
			}
		} else {
			this.setAD_WF_Responsible_ID(0);
		}
	}

	/**
	 * Get Workflow Responsible.
	 *
	 * @return Responsible for Workflow Execution
	 */
	@JsonProperty("AD_WF_Responsible")
	public ForeignEntityInput AD_WF_Responsible() {
		return mAD_WF_Responsible;
	}
	/**
	 * Set Workflow.
	 *
	 * @param AD_Workflow_ID Workflow or combination of tasks
	 */

	public void setAD_Workflow_ID(int AD_Workflow_ID) {
		if (get_ID() == 0) {
			super.setAD_Workflow_ID(AD_Workflow_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Workflow_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Workflow_UU();
	}

	/**
	 * Set Workflow Processor.
	 *
	 * @param AD_WorkflowProcessor Workflow Processor Server
	 */
	@JsonProperty("AD_WorkflowProcessor")
	public void setAD_WorkflowProcessorInput(ForeignEntityInput AD_WorkflowProcessor) {
		this.mAD_WorkflowProcessor = AD_WorkflowProcessor;
		if (AD_WorkflowProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WorkflowProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WorkflowProcessor", "AD_WorkflowProcessor_UU=?", get_TrxName())
							.setParameters(AD_WorkflowProcessor.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_WorkflowProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WorkflowProcessor with UU " + AD_WorkflowProcessor.getUU());
			}
		} else {
			this.setAD_WorkflowProcessor_ID(0);
		}
	}

	/**
	 * Get Workflow Processor.
	 *
	 * @return Workflow Processor Server
	 */
	@JsonProperty("AD_WorkflowProcessor")
	public ForeignEntityInput AD_WorkflowProcessor() {
		return mAD_WorkflowProcessor;
	}

	/**
	 * Set Duration Unit.
	 *
	 * @param DurationUnit Unit of Duration
	 */
	@JsonProperty("DurationUnit")
	public void setDurationUnitInput(ForeignEntityInput DurationUnit) {
		this.mDurationUnit = DurationUnit;
		if (DurationUnit != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_WorkflowResolver.DURATIONUNIT_UUIDS_BY_VALUE.containsValue(DurationUnit.getUU())) {
				throw new AdempiereException("The reference list UU of " + DurationUnit.getUU() +
						" is not in the list defined for the DurationUnit column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DurationUnit.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDurationUnit(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DurationUnit.getUU());
			}
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
	public ForeignEntityInput DurationUnit() {
		return mDurationUnit;
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
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Process Type.
	 *
	 * @param ProcessType Process Type
	 */
	@JsonProperty("ProcessType")
	public void setProcessTypeInput(ForeignEntityInput ProcessType) {
		this.mProcessType = ProcessType;
		if (ProcessType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_WorkflowResolver.PROCESSTYPE_UUIDS_BY_VALUE.containsValue(ProcessType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ProcessType.getUU() +
						" is not in the list defined for the ProcessType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ProcessType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setProcessType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ProcessType.getUU());
			}
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
	public ForeignEntityInput ProcessType() {
		return mProcessType;
	}

	/**
	 * Set Publication Status.
	 *
	 * @param PublishStatus Status of Publication
	 */
	@JsonProperty("PublishStatus")
	public void setPublishStatusInput(ForeignEntityInput PublishStatus) {
		this.mPublishStatus = PublishStatus;
		if (PublishStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_WorkflowResolver.PUBLISHSTATUS_UUIDS_BY_VALUE.containsValue(PublishStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + PublishStatus.getUU() +
						" is not in the list defined for the PublishStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PublishStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPublishStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PublishStatus.getUU());
			}
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
	public ForeignEntityInput PublishStatus() {
		return mPublishStatus;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	@JsonProperty("S_Resource")
	public void setS_ResourceInput(ForeignEntityInput S_Resource) {
		this.mS_Resource = S_Resource;
		if (S_Resource != null) {
			// Since an entity was passed, make sure it's in the DB
			MResource foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "S_Resource", "S_Resource_UU=?", get_TrxName())
							.setParameters(S_Resource.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setS_Resource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_Resource with UU " + S_Resource.getUU());
			}
		} else {
			this.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	@JsonProperty("S_Resource")
	public ForeignEntityInput S_Resource() {
		return mS_Resource;
	}

	/**
	 * Set Workflow Type.
	 *
	 * @param WorkflowType Type of Workflow
	 */
	@JsonProperty("WorkflowType")
	public void setWorkflowTypeInput(ForeignEntityInput WorkflowType) {
		this.mWorkflowType = WorkflowType;
		if (WorkflowType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_WorkflowResolver.WORKFLOWTYPE_UUIDS_BY_VALUE.containsValue(WorkflowType.getUU())) {
				throw new AdempiereException("The reference list UU of " + WorkflowType.getUU() +
						" is not in the list defined for the WorkflowType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(WorkflowType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setWorkflowType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + WorkflowType.getUU());
			}
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
	public ForeignEntityInput WorkflowType() {
		return mWorkflowType;
	}
}
