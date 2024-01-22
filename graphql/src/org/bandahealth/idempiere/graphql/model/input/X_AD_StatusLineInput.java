package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MStatusLine;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_StatusLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StatusLineInput extends MStatusLine implements I_AD_StatusLineInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Message;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_StatusLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MStatusLine(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Message.
	 *
	 * @param AD_Message System Message
	 */
	@JsonProperty("AD_Message")
	public void setAD_MessageInput(ForeignEntityInput AD_Message) {
		this.mAD_Message = AD_Message;
		MMessage_BH foreignEntity;
		if (AD_Message != null &&
				(foreignEntity = new Query(getCtx(), "AD_Message", "AD_Message_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_Message() {
		return mAD_Message;
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
	 * Set Status Line.
	 *
	 * @param AD_StatusLine_ID Status Line
	 */

	public void setAD_StatusLine_ID(int AD_StatusLine_ID) {
		if (get_ID() == 0) {
			super.setAD_StatusLine_ID(AD_StatusLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_StatusLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_StatusLine_UU();
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
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
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
}
