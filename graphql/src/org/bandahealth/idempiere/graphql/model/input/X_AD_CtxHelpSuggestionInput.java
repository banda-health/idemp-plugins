package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MCtxHelpMsg;
import org.compiere.model.MCtxHelpSuggestion;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_AllClients_V;
import org.compiere.model.X_AD_AllUsers_V;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_CtxHelpSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_CtxHelpSuggestionInput extends MCtxHelpSuggestion implements I_AD_CtxHelpSuggestionInput {

	private ForeignEntityInput mAD_CtxHelp;
	private ForeignEntityInput mAD_CtxHelpMsg;
	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAD_UserClient;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_CtxHelpSuggestion_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_CtxHelpSuggestionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Context Help.
	 *
	 * @param AD_CtxHelp Context Help
	 */
	@JsonProperty("AD_CtxHelp")
	public void setAD_CtxHelpInput(ForeignEntityInput AD_CtxHelp) {
		this.mAD_CtxHelp = AD_CtxHelp;
		if (get_ID() != 0) {
			return;
		}
		if (AD_CtxHelp != null) {
			// Since an entity was passed, make sure it's in the DB
			MCtxHelp foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_CtxHelp", "AD_CtxHelp_UU=?", get_TrxName())
							.setParameters(AD_CtxHelp.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_CtxHelp_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_CtxHelp with UUID " + AD_CtxHelp.getUUID());
			}
		} else {
			this.setAD_CtxHelp_ID(0);
		}
	}

	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	@JsonProperty("AD_CtxHelp")
	public ForeignEntityInput AD_CtxHelp() {
		return mAD_CtxHelp;
	}

	/**
	 * Set Context Help Message.
	 *
	 * @param AD_CtxHelpMsg Context Help Message
	 */
	@JsonProperty("AD_CtxHelpMsg")
	public void setAD_CtxHelpMsgInput(ForeignEntityInput AD_CtxHelpMsg) {
		this.mAD_CtxHelpMsg = AD_CtxHelpMsg;
		if (get_ID() != 0) {
			return;
		}
		if (AD_CtxHelpMsg != null) {
			// Since an entity was passed, make sure it's in the DB
			MCtxHelpMsg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_CtxHelpMsg", "AD_CtxHelpMsg_UU=?", get_TrxName())
							.setParameters(AD_CtxHelpMsg.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_CtxHelpMsg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_CtxHelpMsg with UUID " + AD_CtxHelpMsg.getUUID());
			}
		} else {
			this.setAD_CtxHelpMsg_ID(0);
		}
	}

	/**
	 * Get Context Help Message.
	 *
	 * @return Context Help Message
	 */
	@JsonProperty("AD_CtxHelpMsg")
	public ForeignEntityInput AD_CtxHelpMsg() {
		return mAD_CtxHelpMsg;
	}
	/**
	 * Set Context Help Suggestion.
	 *
	 * @param AD_CtxHelpSuggestion_ID Context Help Suggestion
	 */

	public void setAD_CtxHelpSuggestion_ID(int AD_CtxHelpSuggestion_ID) {
		if (get_ID() == 0) {
			super.setAD_CtxHelpSuggestion_ID(AD_CtxHelpSuggestion_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_CtxHelpSuggestion_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_CtxHelpSuggestion_UU();
	}

	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	@JsonProperty("AD_Language")
	public void setAD_LanguageInput(ForeignEntityInput AD_Language) {
		this.mAD_Language = AD_Language;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Language != null) {
			// Since an entity was passed, make sure it's in the DB
			MLanguage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Language", "AD_Language_UU=?", get_TrxName())
							.setParameters(AD_Language.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Language(foreignEntity.getAD_Language());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Language with UUID " + AD_Language.getUUID());
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (get_ID() != 0) {
			return;
		}
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_AllUsers_V foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllUsers_V", "AD_AllUsers_V_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllUsers_V with UUID " + AD_User.getUUID());
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
	 * Set Tenant of User.
	 *
	 * @param AD_UserClient Tenant of User
	 */
	@JsonProperty("AD_UserClient")
	public void setAD_UserClientInput(ForeignEntityInput AD_UserClient) {
		this.mAD_UserClient = AD_UserClient;
		if (get_ID() != 0) {
			return;
		}
		if (AD_UserClient != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_AllClients_V foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllClients_V", "AD_AllClients_V_UU=?", get_TrxName())
							.setParameters(AD_UserClient.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_UserClient_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllClients_V with UUID " + AD_UserClient.getUUID());
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
}
