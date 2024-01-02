package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Activity;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ActivityInput extends X_AD_WF_Activity implements I_AD_WF_ActivityInput {

	 private I_AD_MessageInput mAD_Message;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mWFState;
	 private I_AD_TableInput mAD_Table;
	 private I_AD_UserInput mAD_User;
	 private I_AD_WF_NodeInput mAD_WF_Node;
	 private I_AD_WF_ProcessInput mAD_WF_Process;
	 private I_AD_WF_ResponsibleInput mAD_WF_Responsible;
	 private I_AD_WorkflowInput mAD_Workflow;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WF_ActivityInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Message.
	 *
	 * @param AD_Message System Message
	 */
	@JsonProperty("AD_Message")
	public void setAD_MessageInput(I_AD_MessageInput AD_Message) {
		this.mAD_Message = AD_Message;
		MMessage_BH foreignEntity;
		if (AD_Message != null &&
				(foreignEntity = new Query(getCtx(), MMessage_BH.Table_Name, MMessage_BH.COLUMNNAME_AD_Message_UU + "=?", get_TrxName())
						.setParameters(AD_Message.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Message_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Message_ID(0);
		}
	}

	/**
	 * Get Message.
	 *
	 * @return System Message
	 */
	@JsonProperty("AD_Message")
	public I_AD_MessageInput AD_Message() {
		return mAD_Message;
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(I_AD_UserInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public I_AD_UserInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_Activity_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_Activity_UU();
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
	 * Set Workflow Process.
	 *
	 * @param AD_WF_Process Actual Workflow Process Instance
	 */
	@JsonProperty("AD_WF_Process")
	public void setAD_WF_ProcessInput(I_AD_WF_ProcessInput AD_WF_Process) {
		this.mAD_WF_Process = AD_WF_Process;
		X_AD_WF_Process foreignEntity;
		if (get_ID() == 0 &&AD_WF_Process != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Process.Table_Name, X_AD_WF_Process.COLUMNNAME_AD_WF_Process_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Process_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Workflow Process.
	 *
	 * @return Actual Workflow Process Instance
	 */
	@JsonProperty("AD_WF_Process")
	public I_AD_WF_ProcessInput AD_WF_Process() {
		return mAD_WF_Process;
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
	 * Set Workflow State.
	 *
	 * @param WFState State of the execution of the workflow
	 */
	@JsonProperty("WFState")
	public void setWFStateInput(I_AD_Ref_ListInput WFState) {
		this.mWFState = WFState;
		MRefList_BH foreignEntity;
		if (WFState != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(WFState.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setWFState(foreignEntity.getValue());
		} else {
			this.setWFState(null);
		}
	}

	/**
	 * Get Workflow State.
	 *
	 * @return State of the execution of the workflow
	 */
	@JsonProperty("WFState")
	public I_AD_Ref_ListInput WFState() {
		return mWFState;
	}
}
