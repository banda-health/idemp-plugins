package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Message;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_MessageInput extends X_AD_Message implements I_AD_MessageInput {

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput MsgType_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_MessageInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}
	/**
	 * Set Message.
	 *
	 * @param AD_Message_ID System Message
	 */

	public void setAD_Message_ID(int AD_Message_ID) {
		if (get_ID() == 0) {
			super.setAD_Message_ID(AD_Message_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Message_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Message_UU();
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
			this.setEntityType(foreignEntity.getEntityType());
		} else {
			this.setEntityType(null);
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
	 * Set Entity Type.
	 *
	 * @param EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */

	public void setEntityType(String EntityType) {
		if (get_ID() == 0) {
			super.setEntityType(EntityType);
		}
	}

	/**
	 * Set Message Type.
	 *
	 * @param MsgType_RL Type of message (Informational, Menu or Error)
	 */
	public void setMsgType_RL(I_AD_Ref_ListInput MsgType_RL) {
		this.MsgType_RL = MsgType_RL;
		MRefList foreignEntity;
		if (MsgType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MsgType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMsgType(foreignEntity.getValue());
		} else {
			this.setMsgType(null);
		}
	}

	/**
	 * Get Message Type.
	 *
	 * @return Type of message (Informational, Menu or Error)
	 */
	public I_AD_Ref_ListInput getMsgType_RL() {
		return MsgType_RL;
	}
}
