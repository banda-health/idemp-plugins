package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MStatusLine;
import org.compiere.model.MStyle;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_StatusLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_StatusLineInput extends MStatusLine implements I_AD_StatusLineInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Message;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Style;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_StatusLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_StatusLineInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Message.
	 *
	 * @param AD_Message System Message
	 */
	@JsonProperty("AD_Message")
	public void setAD_MessageInput(ForeignEntityInput AD_Message) {
		this.mAD_Message = AD_Message;
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
	 * Set Status Line.
	 *
	 * @param AD_StatusLine_ID Status Line
	 */
	@JsonProperty("AD_StatusLine_ID")
	public void setAD_StatusLine_IDFromJson(int AD_StatusLine_ID) {
		if (get_ID() == 0) {
			super.setAD_StatusLine_ID(AD_StatusLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_StatusLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_StatusLine_UU();
	}

	/**
	 * Set Style.
	 *
	 * @param AD_Style CSS style for field and label
	 */
	@JsonProperty("AD_Style")
	public void setAD_StyleInput(ForeignEntityInput AD_Style) {
		this.mAD_Style = AD_Style;
		if (AD_Style != null) {
			// Since an entity was passed, make sure it's in the DB
			MStyle foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
							.setParameters(AD_Style.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Style_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Style with UU " + AD_Style.getUU());
			}
		} else {
			this.setAD_Style_ID(0);
		}
	}

	/**
	 * Get Style.
	 *
	 * @return CSS style for field and label
	 */
	@JsonProperty("AD_Style")
	public ForeignEntityInput AD_Style() {
		return mAD_Style;
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
}
