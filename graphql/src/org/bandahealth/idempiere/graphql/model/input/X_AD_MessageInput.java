package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_MessageInput extends MMessage_BH implements I_AD_MessageInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mMsgType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Message_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_MessageInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MMessage_BH(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Message_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Message_UU();
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
			}
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
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Message Type.
	 *
	 * @param MsgType Type of message (Informational, Menu or Error)
	 */
	@JsonProperty("MsgType")
	public void setMsgTypeInput(I_AD_Ref_ListInput MsgType) {
		this.mMsgType = MsgType;
		MRefList_BH foreignEntity;
		if (MsgType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MsgType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setMsgType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + MsgType.getUUID());
			}
		} else {
			this.setMsgType(null);
		}
	}

	/**
	 * Get Message Type.
	 *
	 * @return Type of message (Informational, Menu or Error)
	 */
	@JsonProperty("MsgType")
	public I_AD_Ref_ListInput MsgType() {
		return mMsgType;
	}
}
