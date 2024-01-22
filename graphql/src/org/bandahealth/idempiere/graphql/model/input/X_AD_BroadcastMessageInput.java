package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_BroadcastMessage;
import org.compiere.model.X_AD_Role;

import java.sql.ResultSet;

/**
 * Generated Model for AD_BroadcastMessage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_BroadcastMessageInput extends X_AD_BroadcastMessage implements I_AD_BroadcastMessageInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_User;
	private I_AD_Ref_ListInput mBroadcastFrequency;
	private I_AD_Ref_ListInput mBroadcastType;
	private I_AD_Ref_ListInput mTarget;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_BroadcastMessageInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_BroadcastMessage(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}
	/**
	 * Set Broadcast Message.
	 *
	 * @param AD_BroadcastMessage_ID Broadcast Message
	 */

	public void setAD_BroadcastMessage_ID(int AD_BroadcastMessage_ID) {
		if (get_ID() == 0) {
			super.setAD_BroadcastMessage_ID(AD_BroadcastMessage_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_BroadcastMessage_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_BroadcastMessage_UU();
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
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
	 * Set Broadcast Frequency.
	 *
	 * @param BroadcastFrequency How Many Times Message Should be Broadcasted
	 */
	@JsonProperty("BroadcastFrequency")
	public void setBroadcastFrequencyInput(I_AD_Ref_ListInput BroadcastFrequency) {
		this.mBroadcastFrequency = BroadcastFrequency;
		MRefList_BH foreignEntity;
		if (BroadcastFrequency != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BroadcastFrequency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBroadcastFrequency(foreignEntity.getValue());
		} else {
			this.setBroadcastFrequency(null);
		}
	}

	/**
	 * Get Broadcast Frequency.
	 *
	 * @return How Many Times Message Should be Broadcasted
	 */
	@JsonProperty("BroadcastFrequency")
	public I_AD_Ref_ListInput BroadcastFrequency() {
		return mBroadcastFrequency;
	}

	/**
	 * Set Broadcast Type.
	 *
	 * @param BroadcastType Type of Broadcast
	 */
	@JsonProperty("BroadcastType")
	public void setBroadcastTypeInput(I_AD_Ref_ListInput BroadcastType) {
		this.mBroadcastType = BroadcastType;
		MRefList_BH foreignEntity;
		if (BroadcastType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BroadcastType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBroadcastType(foreignEntity.getValue());
		} else {
			this.setBroadcastType(null);
		}
	}

	/**
	 * Get Broadcast Type.
	 *
	 * @return Type of Broadcast
	 */
	@JsonProperty("BroadcastType")
	public I_AD_Ref_ListInput BroadcastType() {
		return mBroadcastType;
	}

	/**
	 * Set Target.
	 *
	 * @param Target Target client
	 */
	@JsonProperty("Target")
	public void setTargetInput(I_AD_Ref_ListInput Target) {
		this.mTarget = Target;
		MRefList_BH foreignEntity;
		if (Target != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Target.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTarget(foreignEntity.getValue());
		} else {
			this.setTarget(null);
		}
	}

	/**
	 * Get Target.
	 *
	 * @return Target client
	 */
	@JsonProperty("Target")
	public I_AD_Ref_ListInput Target() {
		return mTarget;
	}
}
