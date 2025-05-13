package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MNote;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_BroadcastMessage;
import org.compiere.model.X_AD_WF_Activity;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_NoteInput extends MNote implements I_AD_NoteInput {

	private ForeignEntityInput mAD_BroadcastMessage;
	private ForeignEntityInput mAD_Message;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAD_WF_Activity;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Note_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_NoteInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Broadcast Message.
	 *
	 * @param AD_BroadcastMessage Broadcast Message
	 */
	@JsonProperty("AD_BroadcastMessage")
	public void setAD_BroadcastMessageInput(ForeignEntityInput AD_BroadcastMessage) {
		this.mAD_BroadcastMessage = AD_BroadcastMessage;
		if (AD_BroadcastMessage != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_BroadcastMessage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_BroadcastMessage", "AD_BroadcastMessage_UU=?", get_TrxName())
							.setParameters(AD_BroadcastMessage.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_BroadcastMessage_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_BroadcastMessage with UU " + AD_BroadcastMessage.getUU());
			}
		} else {
			this.setAD_BroadcastMessage_ID(0);
		}
	}

	/**
	 * Get Broadcast Message.
	 *
	 * @return Broadcast Message
	 */
	@JsonProperty("AD_BroadcastMessage")
	public ForeignEntityInput AD_BroadcastMessage() {
		return mAD_BroadcastMessage;
	}

	/**
	 * Set Message.
	 *
	 * @param AD_Message System Message
	 */
	@JsonProperty("AD_Message")
	public void setAD_MessageInput(ForeignEntityInput AD_Message) {
		this.mAD_Message = AD_Message;
		if (!is_new()) {
			return;
		}
		if (AD_Message != null) {
			// Since an entity was passed, make sure it's in the DB
			MMessage_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Message", "AD_Message_UU=?", get_TrxName())
							.setParameters(AD_Message.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Message_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Message with UU " + AD_Message.getUU());
			}
		} else {
			this.setAD_Message_ID(0);
		}
	}

	/**
	 * Get Message.
	 *
	 * @return System Message
	 */
	@JsonProperty("AD_Message")
	public ForeignEntityInput AD_Message() {
		return mAD_Message;
	}
	/**
	 * Set Notice.
	 *
	 * @param AD_Note_ID System Notice
	 */
	@JsonProperty("AD_Note_ID")
	public void setAD_Note_IDFromJson(int AD_Note_ID) {
		if (get_ID() == 0) {
			super.setAD_Note_ID(AD_Note_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Note_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Note_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
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
		if (!is_new()) {
			return;
		}
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
	 * Set Workflow Activity.
	 *
	 * @param AD_WF_Activity Workflow Activity
	 */
	@JsonProperty("AD_WF_Activity")
	public void setAD_WF_ActivityInput(ForeignEntityInput AD_WF_Activity) {
		this.mAD_WF_Activity = AD_WF_Activity;
		if (AD_WF_Activity != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Activity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Activity", "AD_WF_Activity_UU=?", get_TrxName())
							.setParameters(AD_WF_Activity.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_WF_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Activity with UU " + AD_WF_Activity.getUU());
			}
		} else {
			this.setAD_WF_Activity_ID(0);
		}
	}

	/**
	 * Get Workflow Activity.
	 *
	 * @return Workflow Activity
	 */
	@JsonProperty("AD_WF_Activity")
	public ForeignEntityInput AD_WF_Activity() {
		return mAD_WF_Activity;
	}
}
