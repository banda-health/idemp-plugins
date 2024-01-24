package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 7.1 - $Id$
 */
public class X_AD_MigrationScriptInput extends X_AD_MigrationScript implements I_AD_MigrationScriptInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_MigrationScript_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_MigrationScriptInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_MigrationScript(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Migration Script.
	 *
	 * @param AD_MigrationScript_ID Table to check whether the migration script has been applied
	 */

	public void setAD_MigrationScript_ID(int AD_MigrationScript_ID) {
		if (get_ID() == 0) {
			super.setAD_MigrationScript_ID(AD_MigrationScript_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_MigrationScript_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_MigrationScript_UU();
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
	 * Set Script.
	 *
	 * @param Script Dynamic Java Language Script to calculate result
	 */

	public void setScript(byte[] Script) {
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
	public void setStatusInput(I_AD_Ref_ListInput Status) {
		this.mStatus = Status;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&Status != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Status.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Status.getUUID());
			}
		}
	}

	/**
	 * Get Status.
	 *
	 * @return Status of the currently running check
	 */
	@JsonProperty("Status")
	public I_AD_Ref_ListInput Status() {
		return mStatus;
	}
}
