package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_PP_Order_NodeResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MTask;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Block;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Node;
import org.eevolution.model.X_PP_Order_Workflow;

import java.sql.ResultSet;

/**
 * Generated Model for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_Order_NodeInput extends X_PP_Order_Node implements I_PP_Order_NodeInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Form;
	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Task;
	private ForeignEntityInput mAD_WF_Block;
	private ForeignEntityInput mAD_WF_Node;
	private ForeignEntityInput mAD_WF_Responsible;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mAD_Workflow;
	private ForeignEntityInput mAction;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mDocAction;
	private ForeignEntityInput mDocStatus;
	private ForeignEntityInput mFinishMode;
	private ForeignEntityInput mJoinElement;
	private ForeignEntityInput mPP_Order;
	private ForeignEntityInput mPP_Order_Workflow;
	private ForeignEntityInput mS_Resource;
	private ForeignEntityInput mSplitElement;
	private ForeignEntityInput mStartMode;
	private ForeignEntityInput mSubflowExecution;
	private ForeignEntityInput mWorkflow;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PP_Order_Node_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_Order_NodeInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Action.
	 *
	 * @param Action Indicates the Action to be performed
	 */
	@JsonProperty("Action")
	public void setActionInput(ForeignEntityInput Action) {
		this.mAction = Action;
		if (Action != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_NodeResolver.ACTION_UUIDS_BY_VALUE.containsValue(Action.getUU())) {
				throw new AdempiereException("The reference list UU of " + Action.getUU() +
						" is not in the list defined for the Action column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Action.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Action.getUU());
			}
		} else {
			this.setAction(null);
		}
	}

	/**
	 * Get Action.
	 *
	 * @return Indicates the Action to be performed
	 */
	@JsonProperty("Action")
	public ForeignEntityInput Action() {
		return mAction;
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		if (AD_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UU " + AD_Column.getUU());
			}
		} else {
			this.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
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
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		if (AD_Image != null) {
			// Since an entity was passed, make sure it's in the DB
			MImage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
							.setParameters(AD_Image.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Image_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UU " + AD_Image.getUU());
			}
		} else {
			this.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(ForeignEntityInput AD_Process) {
		this.mAD_Process = AD_Process;
		if (AD_Process != null) {
			// Since an entity was passed, make sure it's in the DB
			MProcess_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
							.setParameters(AD_Process.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process with UU " + AD_Process.getUU());
			}
		} else {
			this.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	@JsonProperty("AD_Process")
	public ForeignEntityInput AD_Process() {
		return mAD_Process;
	}

	/**
	 * Set OS Task.
	 *
	 * @param AD_Task Operation System Task
	 */
	@JsonProperty("AD_Task")
	public void setAD_TaskInput(ForeignEntityInput AD_Task) {
		this.mAD_Task = AD_Task;
		if (AD_Task != null) {
			// Since an entity was passed, make sure it's in the DB
			MTask foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Task", "AD_Task_UU=?", get_TrxName())
							.setParameters(AD_Task.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Task_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Task with UU " + AD_Task.getUU());
			}
		} else {
			this.setAD_Task_ID(0);
		}
	}

	/**
	 * Get OS Task.
	 *
	 * @return Operation System Task
	 */
	@JsonProperty("AD_Task")
	public ForeignEntityInput AD_Task() {
		return mAD_Task;
	}

	/**
	 * Set Workflow Block.
	 *
	 * @param AD_WF_Block Workflow Transaction Execution Block
	 */
	@JsonProperty("AD_WF_Block")
	public void setAD_WF_BlockInput(ForeignEntityInput AD_WF_Block) {
		this.mAD_WF_Block = AD_WF_Block;
		if (AD_WF_Block != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Block foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Block", "AD_WF_Block_UU=?", get_TrxName())
							.setParameters(AD_WF_Block.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_WF_Block_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Block with UU " + AD_WF_Block.getUU());
			}
		} else {
			this.setAD_WF_Block_ID(0);
		}
	}

	/**
	 * Get Workflow Block.
	 *
	 * @return Workflow Transaction Execution Block
	 */
	@JsonProperty("AD_WF_Block")
	public ForeignEntityInput AD_WF_Block() {
		return mAD_WF_Block;
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
							.setParameters(AD_WF_Node.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(AD_WF_Responsible.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		if (AD_Window != null) {
			// Since an entity was passed, make sure it's in the DB
			MWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
							.setParameters(AD_Window.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Window_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Window with UU " + AD_Window.getUU());
			}
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public ForeignEntityInput AD_Window() {
		return mAD_Window;
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
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
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
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(ForeignEntityInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_NodeResolver.DOCACTION_UUIDS_BY_VALUE.containsValue(DocAction.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocAction.getUU() +
						" is not in the list defined for the DocAction column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocAction.getUU());
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
	public ForeignEntityInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(ForeignEntityInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_NodeResolver.DOCSTATUS_UUIDS_BY_VALUE.containsValue(DocStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocStatus.getUU() +
						" is not in the list defined for the DocStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocStatus.getUU());
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
	public ForeignEntityInput DocStatus() {
		return mDocStatus;
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
	 * Set Finish Mode.
	 *
	 * @param FinishMode Workflow Activity Finish Mode
	 */
	@JsonProperty("FinishMode")
	public void setFinishModeInput(ForeignEntityInput FinishMode) {
		this.mFinishMode = FinishMode;
		if (FinishMode != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_NodeResolver.FINISHMODE_UUIDS_BY_VALUE.containsValue(FinishMode.getUU())) {
				throw new AdempiereException("The reference list UU of " + FinishMode.getUU() +
						" is not in the list defined for the FinishMode column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FinishMode.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFinishMode(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + FinishMode.getUU());
			}
		} else {
			this.setFinishMode(null);
		}
	}

	/**
	 * Get Finish Mode.
	 *
	 * @return Workflow Activity Finish Mode
	 */
	@JsonProperty("FinishMode")
	public ForeignEntityInput FinishMode() {
		return mFinishMode;
	}

	/**
	 * Set Join Element.
	 *
	 * @param JoinElement Semantics for multiple incoming Transitions
	 */
	@JsonProperty("JoinElement")
	public void setJoinElementInput(ForeignEntityInput JoinElement) {
		this.mJoinElement = JoinElement;
		if (JoinElement != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_NodeResolver.JOINELEMENT_UUIDS_BY_VALUE.containsValue(JoinElement.getUU())) {
				throw new AdempiereException("The reference list UU of " + JoinElement.getUU() +
						" is not in the list defined for the JoinElement column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(JoinElement.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setJoinElement(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + JoinElement.getUU());
			}
		} else {
			this.setJoinElement(null);
		}
	}

	/**
	 * Get Join Element.
	 *
	 * @return Semantics for multiple incoming Transitions
	 */
	@JsonProperty("JoinElement")
	public ForeignEntityInput JoinElement() {
		return mJoinElement;
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(ForeignEntityInput PP_Order) {
		this.mPP_Order = PP_Order;
		if (!is_new()) {
			return;
		}
		if (PP_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
							.setParameters(PP_Order.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order with UU " + PP_Order.getUU());
			}
		} else {
			this.setPP_Order_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public ForeignEntityInput PP_Order() {
		return mPP_Order;
	}
	/**
	 * Set Manufacturing Order Activity.
	 *
	 * @param PP_Order_Node_ID Workflow Node (activity), step or process
	 */
	@JsonProperty("PP_Order_Node_ID")
	public void setPP_Order_Node_IDFromJson(int PP_Order_Node_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_Node_ID(PP_Order_Node_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPP_Order_Node_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getPP_Order_Node_UU();
	}

	/**
	 * Set Manufacturing Order Workflow.
	 *
	 * @param PP_Order_Workflow Manufacturing Order Workflow
	 */
	@JsonProperty("PP_Order_Workflow")
	public void setPP_Order_WorkflowInput(ForeignEntityInput PP_Order_Workflow) {
		this.mPP_Order_Workflow = PP_Order_Workflow;
		if (!is_new()) {
			return;
		}
		if (PP_Order_Workflow != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order_Workflow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order_Workflow", "PP_Order_Workflow_UU=?", get_TrxName())
							.setParameters(PP_Order_Workflow.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Order_Workflow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order_Workflow with UU " + PP_Order_Workflow.getUU());
			}
		} else {
			this.setPP_Order_Workflow_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Workflow.
	 *
	 * @return Manufacturing Order Workflow
	 */
	@JsonProperty("PP_Order_Workflow")
	public ForeignEntityInput PP_Order_Workflow() {
		return mPP_Order_Workflow;
	}

	/**
	 * Set Split Element.
	 *
	 * @param SplitElement Semantics for multiple outgoing Transitions
	 */
	@JsonProperty("SplitElement")
	public void setSplitElementInput(ForeignEntityInput SplitElement) {
		this.mSplitElement = SplitElement;
		if (SplitElement != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_NodeResolver.SPLITELEMENT_UUIDS_BY_VALUE.containsValue(SplitElement.getUU())) {
				throw new AdempiereException("The reference list UU of " + SplitElement.getUU() +
						" is not in the list defined for the SplitElement column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(SplitElement.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSplitElement(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + SplitElement.getUU());
			}
		} else {
			this.setSplitElement(null);
		}
	}

	/**
	 * Get Split Element.
	 *
	 * @return Semantics for multiple outgoing Transitions
	 */
	@JsonProperty("SplitElement")
	public ForeignEntityInput SplitElement() {
		return mSplitElement;
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
							.setParameters(S_Resource.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Start Mode.
	 *
	 * @param StartMode Workflow Activity Start Mode 
	 */
	@JsonProperty("StartMode")
	public void setStartModeInput(ForeignEntityInput StartMode) {
		this.mStartMode = StartMode;
		if (StartMode != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_NodeResolver.STARTMODE_UUIDS_BY_VALUE.containsValue(StartMode.getUU())) {
				throw new AdempiereException("The reference list UU of " + StartMode.getUU() +
						" is not in the list defined for the StartMode column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(StartMode.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setStartMode(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + StartMode.getUU());
			}
		} else {
			this.setStartMode(null);
		}
	}

	/**
	 * Get Start Mode.
	 *
	 * @return Workflow Activity Start Mode 
	 */
	@JsonProperty("StartMode")
	public ForeignEntityInput StartMode() {
		return mStartMode;
	}

	/**
	 * Set Subflow Execution.
	 *
	 * @param SubflowExecution Mode how the sub-workflow is executed
	 */
	@JsonProperty("SubflowExecution")
	public void setSubflowExecutionInput(ForeignEntityInput SubflowExecution) {
		this.mSubflowExecution = SubflowExecution;
		if (SubflowExecution != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_NodeResolver.SUBFLOWEXECUTION_UUIDS_BY_VALUE.containsValue(SubflowExecution.getUU())) {
				throw new AdempiereException("The reference list UU of " + SubflowExecution.getUU() +
						" is not in the list defined for the SubflowExecution column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(SubflowExecution.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSubflowExecution(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + SubflowExecution.getUU());
			}
		} else {
			this.setSubflowExecution(null);
		}
	}

	/**
	 * Get Subflow Execution.
	 *
	 * @return Mode how the sub-workflow is executed
	 */
	@JsonProperty("SubflowExecution")
	public ForeignEntityInput SubflowExecution() {
		return mSubflowExecution;
	}

	/**
	 * Set Workflow.
	 *
	 * @param Workflow Workflow or tasks
	 */
	@JsonProperty("Workflow")
	public void setWorkflowInput(ForeignEntityInput Workflow) {
		this.mWorkflow = Workflow;
		if (Workflow != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Workflow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Workflow", "AD_Workflow_UU=?", get_TrxName())
							.setParameters(Workflow.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setWorkflow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Workflow with UU " + Workflow.getUU());
			}
		} else {
			this.setWorkflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or tasks
	 */
	@JsonProperty("Workflow")
	public ForeignEntityInput Workflow() {
		return mWorkflow;
	}
}
