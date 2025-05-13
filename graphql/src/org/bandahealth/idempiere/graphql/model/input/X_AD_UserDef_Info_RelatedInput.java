package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MUserDefInfo;
import org.compiere.model.MUserDefInfoRelated;
import org.compiere.model.Query;
import org.compiere.model.X_AD_InfoRelated;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Info_Related - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_UserDef_Info_RelatedInput extends MUserDefInfoRelated implements I_AD_UserDef_Info_RelatedInput {

	private ForeignEntityInput mAD_InfoRelated;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_UserDef_Info;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_UserDef_Info_Related_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserDef_Info_RelatedInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Info Related.
	 *
	 * @param AD_InfoRelated Info Related
	 */
	@JsonProperty("AD_InfoRelated")
	public void setAD_InfoRelatedInput(ForeignEntityInput AD_InfoRelated) {
		this.mAD_InfoRelated = AD_InfoRelated;
		if (!is_new()) {
			return;
		}
		if (AD_InfoRelated != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_InfoRelated foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoRelated", "AD_InfoRelated_UU=?", get_TrxName())
							.setParameters(AD_InfoRelated.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_InfoRelated_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoRelated with UU " + AD_InfoRelated.getUU());
			}
		} else {
			this.setAD_InfoRelated_ID(0);
		}
	}

	/**
	 * Get Info Related.
	 *
	 * @return Info Related
	 */
	@JsonProperty("AD_InfoRelated")
	public ForeignEntityInput AD_InfoRelated() {
		return mAD_InfoRelated;
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
	 * Set User defined Info Window.
	 *
	 * @param AD_UserDef_Info User defined Info Window
	 */
	@JsonProperty("AD_UserDef_Info")
	public void setAD_UserDef_InfoInput(ForeignEntityInput AD_UserDef_Info) {
		this.mAD_UserDef_Info = AD_UserDef_Info;
		if (!is_new()) {
			return;
		}
		if (AD_UserDef_Info != null) {
			// Since an entity was passed, make sure it's in the DB
			MUserDefInfo foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_UserDef_Info", "AD_UserDef_Info_UU=?", get_TrxName())
							.setParameters(AD_UserDef_Info.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_UserDef_Info_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_UserDef_Info with UU " + AD_UserDef_Info.getUU());
			}
		} else {
			this.setAD_UserDef_Info_ID(0);
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
	@JsonProperty("AD_UserDef_Info_Related_ID")
	public void setAD_UserDef_Info_Related_IDFromJson(int AD_UserDef_Info_Related_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Info_Related_ID(AD_UserDef_Info_Related_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_UserDef_Info_Related_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_UserDef_Info_Related_UU();
	}
}
