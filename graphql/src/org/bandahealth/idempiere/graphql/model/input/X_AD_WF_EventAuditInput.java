package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_EventAudit;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WF_Process;
import org.compiere.model.X_AD_WF_Responsible;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WF_EventAudit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_EventAuditInput extends X_AD_WF_EventAudit implements I_AD_WF_EventAuditInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAD_WF_Node;
	private ForeignEntityInput mAD_WF_Process;
	private ForeignEntityInput mAD_WF_Responsible;
	private I_AD_Ref_ListInput mEventType;
	private I_AD_Ref_ListInput mWFState;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WF_EventAuditInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_WF_EventAudit(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
	/**
	 * Set Workflow Event Audit.
	 *
	 * @param AD_WF_EventAudit_ID Workflow Process Activity Event Audit Information
	 */

	public void setAD_WF_EventAudit_ID(int AD_WF_EventAudit_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_EventAudit_ID(AD_WF_EventAudit_ID);
		}
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
	@JsonProperty("AD_WF_Node")
	public void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node) {
		this.mAD_WF_Node = AD_WF_Node;
		X_AD_WF_Node foreignEntity;
		if (AD_WF_Node != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Node", "AD_WF_Node_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_WF_Node() {
		return mAD_WF_Node;
	}

	/**
	 * Set Workflow Process.
	 *
	 * @param AD_WF_Process Actual Workflow Process Instance
	 */
	@JsonProperty("AD_WF_Process")
	public void setAD_WF_ProcessInput(ForeignEntityInput AD_WF_Process) {
		this.mAD_WF_Process = AD_WF_Process;
		X_AD_WF_Process foreignEntity;
		if (AD_WF_Process != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Process", "AD_WF_Process_UU=?", get_TrxName())
						.setParameters(AD_WF_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_WF_Process_ID(foreignEntity.get_ID());
		} else {
			super.setAD_WF_Process_ID(0);
		}
	}

	/**
	 * Get Workflow Process.
	 *
	 * @return Actual Workflow Process Instance
	 */
	@JsonProperty("AD_WF_Process")
	public ForeignEntityInput AD_WF_Process() {
		return mAD_WF_Process;
	}

	/**
	 * Set Workflow Responsible.
	 *
	 * @param AD_WF_Responsible Responsible for Workflow Execution
	 */
	@JsonProperty("AD_WF_Responsible")
	public void setAD_WF_ResponsibleInput(ForeignEntityInput AD_WF_Responsible) {
		this.mAD_WF_Responsible = AD_WF_Responsible;
		X_AD_WF_Responsible foreignEntity;
		if (AD_WF_Responsible != null &&
				(foreignEntity = new Query(getCtx(), "AD_WF_Responsible", "AD_WF_Responsible_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_WF_Responsible() {
		return mAD_WF_Responsible;
	}

	/**
	 * Set Event Type.
	 *
	 * @param EventType Type of Event
	 */
	@JsonProperty("EventType")
	public void setEventTypeInput(I_AD_Ref_ListInput EventType) {
		this.mEventType = EventType;
		MRefList_BH foreignEntity;
		if (EventType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(EventType.getID())
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
	@JsonProperty("EventType")
	public I_AD_Ref_ListInput EventType() {
		return mEventType;
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
