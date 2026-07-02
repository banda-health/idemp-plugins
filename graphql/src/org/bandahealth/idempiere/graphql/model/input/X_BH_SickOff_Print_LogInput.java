package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHSickOff;
import org.bandahealth.idempiere.base.model.MBHSickOffPrintLog;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_SickOff_Print_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_SickOff_Print_LogInput extends MBHSickOffPrintLog implements I_BH_SickOff_Print_LogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_SickOff;
	private ForeignEntityInput mPrintedBy;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_SickOff_Print_Log_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_SickOff_Print_LogInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * Set Sick Off.
	 *
	 * @param BH_SickOff Sick Off
	 */
	@JsonProperty("BH_SickOff")
	public void setBH_SickOffInput(ForeignEntityInput BH_SickOff) {
		this.mBH_SickOff = BH_SickOff;
		if (!is_new()) {
			return;
		}
		if (BH_SickOff != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHSickOff foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_SickOff", "BH_SickOff_UU=?", get_TrxName())
							.setParameters(BH_SickOff.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_SickOff_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_SickOff with UU " + BH_SickOff.getUU());
			}
		} else {
			this.setBH_SickOff_ID(0);
		}
	}

	/**
	 * Get Sick Off.
	 *
	 * @return Sick Off
	 */
	@JsonProperty("BH_SickOff")
	public ForeignEntityInput BH_SickOff() {
		return mBH_SickOff;
	}

	/**
	 * Set Printed By.
	 *
	 * @param PrintedBy User who printed this record
	 */
	@JsonProperty("PrintedBy")
	public void setPrintedByInput(ForeignEntityInput PrintedBy) {
		this.mPrintedBy = PrintedBy;
		if (PrintedBy != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(PrintedBy.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPrintedBy(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + PrintedBy.getUU());
			}
		} else {
			this.setPrintedBy(0);
		}
	}

	/**
	 * Get Printed By.
	 *
	 * @return User who printed this record
	 */
	@JsonProperty("PrintedBy")
	public ForeignEntityInput PrintedBy() {
		return mPrintedBy;
	}

	/**
	 * Set BH_SickOff_Print_Log_ID.
	 *
	 * @param BH_SickOff_Print_Log_ID BH_SickOff_Print_Log_ID
	 */
	@JsonProperty("BH_SickOff_Print_Log_ID")
	public void setBH_SickOff_Print_Log_IDFromJson(int BH_SickOff_Print_Log_ID) {
		if (get_ID() == 0) {
			super.setBH_SickOff_Print_Log_ID(BH_SickOff_Print_Log_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_SickOff_Print_Log_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_SickOff_Print_Log_UU();
	}
}
