package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.MUserDefInfo;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_InfoInput extends MUserDefInfo implements I_AD_UserDef_InfoInput {

	private ForeignEntityInput mAD_InfoWindow;
	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_User;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_UserDef_InfoInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUserDefInfo(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Info Window.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow) {
		this.mAD_InfoWindow = AD_InfoWindow;
		MInfoWindow foreignEntity;
		if (get_ID() == 0 && AD_InfoWindow != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
						.setParameters(AD_InfoWindow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_InfoWindow_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public ForeignEntityInput AD_InfoWindow() {
		return mAD_InfoWindow;
	}

	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	@JsonProperty("AD_Language")
	public void setAD_LanguageInput(ForeignEntityInput AD_Language) {
		this.mAD_Language = AD_Language;
		MLanguage foreignEntity;
		if (AD_Language != null &&
				(foreignEntity = new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
						.setParameters(AD_Language.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Language(foreignEntity.getAD_Language());
		} else {
			super.setAD_Language(null);
		}
	}

	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	@JsonProperty("AD_Language")
	public ForeignEntityInput AD_Language() {
		return mAD_Language;
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
	 * Set User defined Info Window.
	 *
	 * @param AD_UserDef_Info_ID User defined Info Window
	 */

	public void setAD_UserDef_Info_ID(int AD_UserDef_Info_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Info_ID(AD_UserDef_Info_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_UserDef_Info_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_UserDef_Info_UU();
	}
}
