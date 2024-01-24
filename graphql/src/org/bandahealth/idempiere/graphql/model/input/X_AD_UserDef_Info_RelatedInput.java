package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MUserDefInfo;
import org.compiere.model.MUserDefInfoRelated;
import org.compiere.model.Query;
import org.compiere.model.X_AD_InfoRelated;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Info_Related - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_Info_RelatedInput extends MUserDefInfoRelated implements I_AD_UserDef_Info_RelatedInput {

	private ForeignEntityInput mAD_InfoRelated;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_UserDef_Info;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_UserDef_Info_RelatedInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUserDefInfoRelated(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set InfoRelated.
	 *
	 * @param AD_InfoRelated InfoRelated
	 */
	@JsonProperty("AD_InfoRelated")
	public void setAD_InfoRelatedInput(ForeignEntityInput AD_InfoRelated) {
		this.mAD_InfoRelated = AD_InfoRelated;
		X_AD_InfoRelated foreignEntity;
		if (get_ID() == 0 && AD_InfoRelated != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoRelated", "AD_InfoRelated_UU=?", get_TrxName())
						.setParameters(AD_InfoRelated.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_InfoRelated_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get InfoRelated.
	 *
	 * @return InfoRelated
	 */
	@JsonProperty("AD_InfoRelated")
	public ForeignEntityInput AD_InfoRelated() {
		return mAD_InfoRelated;
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
	 * Set User defined Info Window.
	 *
	 * @param AD_UserDef_Info User defined Info Window
	 */
	@JsonProperty("AD_UserDef_Info")
	public void setAD_UserDef_InfoInput(ForeignEntityInput AD_UserDef_Info) {
		this.mAD_UserDef_Info = AD_UserDef_Info;
		MUserDefInfo foreignEntity;
		if (get_ID() == 0 && AD_UserDef_Info != null &&
				(foreignEntity = new Query(getCtx(), "AD_UserDef_Info", "AD_UserDef_Info_UU=?", get_TrxName())
						.setParameters(AD_UserDef_Info.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_UserDef_Info_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get User defined Info Window.
	 *
	 * @return User defined Info Window
	 */
	@JsonProperty("AD_UserDef_Info")
	public ForeignEntityInput AD_UserDef_Info() {
		return mAD_UserDef_Info;
	}
	/**
	 * Set User defined Info Related.
	 *
	 * @param AD_UserDef_Info_Related_ID User defined Info Related
	 */

	public void setAD_UserDef_Info_Related_ID(int AD_UserDef_Info_Related_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Info_Related_ID(AD_UserDef_Info_Related_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_UserDef_Info_Related_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_UserDef_Info_Related_UU();
	}
}
