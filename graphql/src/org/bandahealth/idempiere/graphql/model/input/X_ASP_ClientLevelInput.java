package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_ClientLevel;
import org.compiere.model.X_ASP_Level;
import org.compiere.model.X_ASP_Module;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_ClientLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_ClientLevelInput extends X_ASP_ClientLevel implements I_ASP_ClientLevelInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mASP_Level;
	private ForeignEntityInput mASP_Module;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The ASP_ClientLevel_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_ASP_ClientLevelInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_ASP_ClientLevel(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Client Level.
	 *
	 * @param ASP_ClientLevel_ID Client Level
	 */

	public void setASP_ClientLevel_ID(int ASP_ClientLevel_ID) {
		if (get_ID() == 0) {
			super.setASP_ClientLevel_ID(ASP_ClientLevel_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setASP_ClientLevel_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getASP_ClientLevel_UU();
	}

	/**
	 * Set ASP Level.
	 *
	 * @param ASP_Level ASP Level
	 */
	@JsonProperty("ASP_Level")
	public void setASP_LevelInput(ForeignEntityInput ASP_Level) {
		this.mASP_Level = ASP_Level;
		if (ASP_Level != null) {
			// Since an entity was passed, make sure it's in the DB
			X_ASP_Level foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "ASP_Level", "ASP_Level_UU=?", get_TrxName())
							.setParameters(ASP_Level.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setASP_Level_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table ASP_Level with UUID " + ASP_Level.getUUID());
			}
		} else {
			this.setASP_Level_ID(0);
		}
	}

	/**
	 * Get ASP Level.
	 *
	 * @return ASP Level
	 */
	@JsonProperty("ASP_Level")
	public ForeignEntityInput ASP_Level() {
		return mASP_Level;
	}

	/**
	 * Set ASP Module.
	 *
	 * @param ASP_Module ASP Module
	 */
	@JsonProperty("ASP_Module")
	public void setASP_ModuleInput(ForeignEntityInput ASP_Module) {
		this.mASP_Module = ASP_Module;
		if (ASP_Module != null) {
			// Since an entity was passed, make sure it's in the DB
			X_ASP_Module foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "ASP_Module", "ASP_Module_UU=?", get_TrxName())
							.setParameters(ASP_Module.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setASP_Module_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table ASP_Module with UUID " + ASP_Module.getUUID());
			}
		} else {
			this.setASP_Module_ID(0);
		}
	}

	/**
	 * Get ASP Module.
	 *
	 * @return ASP Module
	 */
	@JsonProperty("ASP_Module")
	public ForeignEntityInput ASP_Module() {
		return mASP_Module;
	}
}
