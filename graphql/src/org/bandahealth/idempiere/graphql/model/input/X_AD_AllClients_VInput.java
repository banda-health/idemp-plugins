package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_AllClients_V;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AllClients_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AllClients_VInput extends X_AD_AllClients_V implements I_AD_AllClients_VInput {

	private ForeignEntityInput mAD_Language;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_AllClients_V_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AllClients_VInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Tenant (All).
	 *
	 * @param AD_AllClients_V_ID Tenant (All)
	 */

	public void setAD_AllClients_V_ID(int AD_AllClients_V_ID) {
		if (get_ID() == 0) {
			super.setAD_AllClients_V_ID(AD_AllClients_V_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_AllClients_V_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_AllClients_V_UU();
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
	 * Set Description.
	 *
	 * @param Description Optional short description of the record
	 */

	public void setDescription(String Description) {
		if (get_ID() == 0) {
			super.setDescription(Description);
		}
	}
	/**
	 * Set Name.
	 *
	 * @param Name Alphanumeric identifier of the entity
	 */

	public void setName(String Name) {
		if (get_ID() == 0) {
			super.setName(Name);
		}
	}
	/**
	 * Set Search Key.
	 *
	 * @param Value Search key for the record in the format required - must be unique
	 */

	public void setValue(String Value) {
		if (get_ID() == 0) {
			super.setValue(Value);
		}
	}
}
