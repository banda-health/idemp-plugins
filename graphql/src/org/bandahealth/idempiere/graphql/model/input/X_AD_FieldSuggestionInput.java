package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_FieldSuggestion_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_FieldSuggestionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MFieldSuggestion(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Field != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
							.setParameters(AD_Field.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Field_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Field with UUID " + AD_Field.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_FieldSuggestion_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() == 0 && AD_Language != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
							.setParameters(AD_Language.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Language(foreignEntity.getAD_Language());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Language with UUID " + AD_Language.getUUID());
			}
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
	 * Set Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public void setAD_TabInput(ForeignEntityInput AD_Tab) {
		this.mAD_Tab = AD_Tab;
		MTab foreignEntity;
		if (get_ID() == 0 && AD_Tab != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
							.setParameters(AD_Tab.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tab with UUID " + AD_Tab.getUUID());
			}
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
		if (get_ID() == 0 && AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllUsers_V", "AD_AllUsers_V_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllUsers_V with UUID " + AD_User.getUUID());
			}
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
		if (get_ID() == 0 && AD_UserClient != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllClients_V", "AD_AllClients_V_UU=?", get_TrxName())
							.setParameters(AD_UserClient.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_UserClient_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllClients_V with UUID " + AD_UserClient.getUUID());
			}
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
		if (get_ID() == 0 && AD_Window != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
							.setParameters(AD_Window.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Window_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Window with UUID " + AD_Window.getUUID());
			}
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
		if (FieldSuggestionTarget != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FieldSuggestionTarget.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFieldSuggestionTarget(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + FieldSuggestionTarget.getUUID());
			}
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
