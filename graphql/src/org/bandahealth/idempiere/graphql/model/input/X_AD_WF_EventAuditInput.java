package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_EventAudit;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_EventAudit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_EventAuditInput extends X_AD_WF_EventAudit implements I_AD_WF_EventAuditInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput EventType_RL;
	 private I_AD_Ref_ListInput WFState_RL;
	 private I_AD_TableInput AD_Table;
	 private I_AD_UserInput AD_User;
	 private I_AD_WF_NodeInput AD_WF_Node;
	 private I_AD_WF_ProcessInput AD_WF_Process;
	 private I_AD_WF_ResponsibleInput AD_WF_Responsible;

	/**
	 * Standard constructor
	 */
	public X_AD_WF_EventAuditInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_EventAudit_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_EventAudit_UU();
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
	 * Set Workflow Process.
	 *
	 * @param AD_WF_Process Actual Workflow Process Instance
	 */
	public void setAD_WF_Process(I_AD_WF_ProcessInput AD_WF_Process) {
		this.AD_WF_Process = AD_WF_Process;
		X_AD_WF_Process foreignEntity;
		if (AD_WF_Process != null &&
				(foreignEntity = new Query(getCtx(), X_AD_WF_Process.Table_Name, X_AD_WF_Process.COLUMNNAME_AD_WF_Process_UU + "=?", get_TrxName())
						.setParameters(AD_WF_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_WF_Process_ID(foreignEntity.get_ID());
		} else {
			this.setAD_WF_Process_ID(0);
		}
	}

	/**
	 * Get Workflow Process.
	 *
	 * @return Actual Workflow Process Instance
	 */
	public I_AD_WF_ProcessInput getAD_WF_Process() {
		return AD_WF_Process;
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
	 * Set Event Type.
	 *
	 * @param EventType_RL Type of Event
	 */
	public void setEventType_RL(I_AD_Ref_ListInput EventType_RL) {
		this.EventType_RL = EventType_RL;
		MRefList foreignEntity;
		if (EventType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(EventType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEventType(foreignEntity.getValue());
		} else {
			this.setEventType(null);
		}
	}

	/**
	 * Get Event Type.
	 *
	 * @return Type of Event
	 */
	public I_AD_Ref_ListInput getEventType_RL() {
		return EventType_RL;
	}

	/**
	 * Set Workflow State.
	 *
	 * @param WFState_RL State of the execution of the workflow
	 */
	public void setWFState_RL(I_AD_Ref_ListInput WFState_RL) {
		this.WFState_RL = WFState_RL;
		MRefList foreignEntity;
		if (WFState_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(WFState_RL.getID())
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
	public I_AD_Ref_ListInput getWFState_RL() {
		return WFState_RL;
	}
}
