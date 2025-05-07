package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_FieldSuggestionResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MFieldSuggestion;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_AllClients_V;
import org.compiere.model.X_AD_AllUsers_V;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_FieldSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_FieldSuggestionInput extends MFieldSuggestion implements I_AD_FieldSuggestionInput {

	private ForeignEntityInput mAD_Field;
	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAD_UserClient;
	private ForeignEntityInput mFieldSuggestionTarget;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_FieldSuggestion_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_FieldSuggestionInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	@JsonProperty("AD_Field")
	public void setAD_FieldInput(ForeignEntityInput AD_Field) {
		this.mAD_Field = AD_Field;
		if (!is_new()) {
			return;
		}
		if (AD_Field != null) {
			// Since an entity was passed, make sure it's in the DB
			MField_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
							.setParameters(AD_Field.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Field_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Field with UU " + AD_Field.getUU());
			}
		} else {
			this.setAD_Field_ID(0);
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
	@JsonProperty("AD_FieldSuggestion_ID")
	public void setAD_FieldSuggestion_IDFromJson(int AD_FieldSuggestion_ID) {
		if (get_ID() == 0) {
			super.setAD_FieldSuggestion_ID(AD_FieldSuggestion_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_FieldSuggestion_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (!is_new()) {
			return;
		}
		if (AD_Language != null) {
			// Since an entity was passed, make sure it's in the DB
			MLanguage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
							.setParameters(AD_Language.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Language(foreignEntity.getAD_Language());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Language with UU " + AD_Language.getUU());
			}
		} else {
			this.setAD_Language(null);
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
	 * Set Tenant of User.
	 *
	 * @param AD_UserClient Tenant of User
	 */
	@JsonProperty("AD_UserClient")
	public void setAD_UserClientInput(ForeignEntityInput AD_UserClient) {
		this.mAD_UserClient = AD_UserClient;
		if (!is_new()) {
			return;
		}
		if (AD_UserClient != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_AllClients_V foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllClients_V", "AD_AllClients_V_UU=?", get_TrxName())
							.setParameters(AD_UserClient.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_UserClient_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllClients_V with UU " + AD_UserClient.getUU());
			}
		} else {
			this.setAD_UserClient_ID(0);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (!is_new()) {
			return;
		}
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_AllUsers_V foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllUsers_V", "AD_AllUsers_V_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllUsers_V with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
	 * Set Apply Suggestion To.
	 *
	 * @param FieldSuggestionTarget Apply Suggestion To
	 */
	@JsonProperty("FieldSuggestionTarget")
	public void setFieldSuggestionTargetInput(ForeignEntityInput FieldSuggestionTarget) {
		this.mFieldSuggestionTarget = FieldSuggestionTarget;
		if (FieldSuggestionTarget != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FieldSuggestionResolver.FIELDSUGGESTIONTARGET_UUIDS_BY_VALUE.containsValue(FieldSuggestionTarget.getUU())) {
				throw new AdempiereException("The reference list UU of " + FieldSuggestionTarget.getUU() +
						" is not in the list defined for the FieldSuggestionTarget column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FieldSuggestionTarget.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFieldSuggestionTarget(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + FieldSuggestionTarget.getUU());
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
	public ForeignEntityInput FieldSuggestionTarget() {
		return mFieldSuggestionTarget;
	}
}
