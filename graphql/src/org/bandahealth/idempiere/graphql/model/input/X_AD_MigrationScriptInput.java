package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_MigrationScript;

import java.sql.ResultSet;

/**
 * Generated Model for AD_MigrationScript - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_MigrationScriptInput extends X_AD_MigrationScript implements I_AD_MigrationScriptInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mStatus;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_MigrationScriptInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_MigrationScript(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_MigrationScript_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		if (get_ID() == 0 &&Status != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Status.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setStatus(foreignEntity.getValue());
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
