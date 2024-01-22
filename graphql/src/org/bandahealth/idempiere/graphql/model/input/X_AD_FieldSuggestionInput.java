package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MFieldSuggestion;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_AllClients_V;
import org.compiere.model.X_AD_AllUsers_V;

import java.sql.ResultSet;

/**
 * Generated Model for AD_FieldSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_FieldSuggestionInput extends MFieldSuggestion implements I_AD_FieldSuggestionInput {

	private ForeignEntityInput mAD_Field;
	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAD_UserClient;
	private ForeignEntityInput mAD_Window;
	private I_AD_Ref_ListInput mFieldSuggestionTarget;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_FieldSuggestionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MFieldSuggestion(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	@JsonProperty("AD_Field")
	public void setAD_FieldInput(ForeignEntityInput AD_Field) {
		this.mAD_Field = AD_Field;
		MField_BH foreignEntity;
		if (get_ID() == 0 && AD_Field != null &&
				(foreignEntity = new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
						.setParameters(AD_Field.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Field_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Field.
	 *
	 * @return Field on a database table
	 */
	@JsonProperty("AD_Field")
	public ForeignEntityInput AD_Field() {
		return mAD_Field;
	}
	/**
	 * Set Field Suggestions.
	 *
	 * @param AD_FieldSuggestion_ID Field Suggestions
	 */

	public void setAD_FieldSuggestion_ID(int AD_FieldSuggestion_ID) {
		if (get_ID() == 0) {
			super.setAD_FieldSuggestion_ID(AD_FieldSuggestion_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_FieldSuggestion_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_FieldSuggestion_UU();
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
		if (get_ID() == 0 && AD_Language != null &&
				(foreignEntity = new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
						.setParameters(AD_Language.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Language(foreignEntity.getAD_Language());
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
	 * Set Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public void setAD_TabInput(ForeignEntityInput AD_Tab) {
		this.mAD_Tab = AD_Tab;
		MTab foreignEntity;
		if (get_ID() == 0 && AD_Tab != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
						.setParameters(AD_Tab.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tab_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public ForeignEntityInput AD_Tab() {
		return mAD_Tab;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		X_AD_AllUsers_V foreignEntity;
		if (get_ID() == 0 && AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_AllUsers_V", "AD_AllUsers_V_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
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
	 * Set Tenant of User.
	 *
	 * @param AD_UserClient Tenant of User
	 */
	@JsonProperty("AD_UserClient")
	public void setAD_UserClientInput(ForeignEntityInput AD_UserClient) {
		this.mAD_UserClient = AD_UserClient;
		X_AD_AllClients_V foreignEntity;
		if (get_ID() == 0 && AD_UserClient != null &&
				(foreignEntity = new Query(getCtx(), "AD_AllClients_V", "AD_AllClients_V_UU=?", get_TrxName())
						.setParameters(AD_UserClient.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_UserClient_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Tenant of User.
	 *
	 * @return Tenant of User
	 */
	@JsonProperty("AD_UserClient")
	public ForeignEntityInput AD_UserClient() {
		return mAD_UserClient;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		MWindow foreignEntity;
		if (get_ID() == 0 && AD_Window != null &&
				(foreignEntity = new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public ForeignEntityInput AD_Window() {
		return mAD_Window;
	}

	/**
	 * Set Apply Suggestion To.
	 *
	 * @param FieldSuggestionTarget Apply Suggestion To
	 */
	@JsonProperty("FieldSuggestionTarget")
	public void setFieldSuggestionTargetInput(I_AD_Ref_ListInput FieldSuggestionTarget) {
		this.mFieldSuggestionTarget = FieldSuggestionTarget;
		MRefList_BH foreignEntity;
		if (FieldSuggestionTarget != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FieldSuggestionTarget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFieldSuggestionTarget(foreignEntity.getValue());
		} else {
			this.setFieldSuggestionTarget(null);
		}
	}

	/**
	 * Get Apply Suggestion To.
	 *
	 * @return Apply Suggestion To
	 */
	@JsonProperty("FieldSuggestionTarget")
	public I_AD_Ref_ListInput FieldSuggestionTarget() {
		return mFieldSuggestionTarget;
	}
}
