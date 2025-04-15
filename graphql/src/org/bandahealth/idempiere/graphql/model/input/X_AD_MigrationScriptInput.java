package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_MigrationScriptResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_MigrationScript;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_MigrationScript - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_MigrationScriptInput extends X_AD_MigrationScript implements I_AD_MigrationScriptInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_MigrationScript_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_MigrationScriptInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Migration Script.
	 *
	 * @param AD_MigrationScript_ID Table to check whether the migration script has been applied
	 */
	@JsonProperty("AD_MigrationScript_ID")
	public void setAD_MigrationScript_IDFromJson(int AD_MigrationScript_ID) {
		if (get_ID() == 0) {
			super.setAD_MigrationScript_ID(AD_MigrationScript_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_MigrationScript_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_MigrationScript_UU();
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
	 * Set Script.
	 *
	 * @param Script Dynamic Java Language Script to calculate result
	 */
	@JsonProperty("Script")
	public void setScriptFromJson(byte[] Script) {
		if (get_ID() == 0) {
			super.setScript(Script);
		}
	}

	/**
	 * Set Status.
	 *
	 * @param Status Status of the currently running check
	 */
	@JsonProperty("Status")
	public void setStatusInput(ForeignEntityInput Status) {
		this.mStatus = Status;
		if (get_ID() != 0) {
			return;
		}
		if (Status != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_MigrationScriptResolver.STATUS_UUIDS_BY_VALUE.containsValue(Status.getUU())) {
				throw new AdempiereException("The reference list UU of " + Status.getUU() +
						" is not in the list defined for the Status column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Status.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Status.getUU());
			}
		} else {
			this.setStatus(null);
		}
	}

	/**
	 * Get Status.
	 *
	 * @return Status of the currently running check
	 */
	@JsonProperty("Status")
	public ForeignEntityInput Status() {
		return mStatus;
	}
}
