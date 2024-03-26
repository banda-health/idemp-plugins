package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_BP_General_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_BP_General_Payer_InfoInput extends MBHBPGeneralPayerInfo implements I_BH_BP_General_Payer_InfoInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_BP_Payer_Info;
	private ForeignEntityInput mBH_Payer_Info_Fld;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_BP_General_Payer_Info_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_BP_General_Payer_InfoInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Business Partner General Payer Info.
	 *
	 * @param BH_BP_General_Payer_Info_ID Business Partner General Payer Info
	 */

	public void setBH_BP_General_Payer_Info_ID(int BH_BP_General_Payer_Info_ID) {
		if (get_ID() == 0) {
			super.setBH_BP_General_Payer_Info_ID(BH_BP_General_Payer_Info_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_BP_General_Payer_Info_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getBH_BP_General_Payer_Info_UU();
	}

	/**
	 * Set Business Partner Payer Information.
	 *
	 * @param BH_BP_Payer_Info Business Partner Payer Information
	 */
	@JsonProperty("BH_BP_Payer_Info")
	public void setBH_BP_Payer_InfoInput(ForeignEntityInput BH_BP_Payer_Info) {
		this.mBH_BP_Payer_Info = BH_BP_Payer_Info;
		if (get_ID() != 0) {
			return;
		}
		if (BH_BP_Payer_Info != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHBPPayerInfo foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_BP_Payer_Info", "BH_BP_Payer_Info_UU=?", get_TrxName())
							.setParameters(BH_BP_Payer_Info.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_BP_Payer_Info_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_BP_Payer_Info with UUID " + BH_BP_Payer_Info.getUUID());
			}
		} else {
			this.setBH_BP_Payer_Info_ID(0);
		}
	}

	/**
	 * Get Business Partner Payer Information.
	 *
	 * @return Business Partner Payer Information
	 */
	@JsonProperty("BH_BP_Payer_Info")
	public ForeignEntityInput BH_BP_Payer_Info() {
		return mBH_BP_Payer_Info;
	}

	/**
	 * Set Payer Info Field.
	 *
	 * @param BH_Payer_Info_Fld Payer Info Field
	 */
	@JsonProperty("BH_Payer_Info_Fld")
	public void setBH_Payer_Info_FldInput(ForeignEntityInput BH_Payer_Info_Fld) {
		this.mBH_Payer_Info_Fld = BH_Payer_Info_Fld;
		if (get_ID() != 0) {
			return;
		}
		if (BH_Payer_Info_Fld != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHPayerInfoFld foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Payer_Info_Fld", "BH_Payer_Info_Fld_UU=?", get_TrxName())
							.setParameters(BH_Payer_Info_Fld.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Payer_Info_Fld_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Payer_Info_Fld with UUID " + BH_Payer_Info_Fld.getUUID());
			}
		} else {
			this.setBH_Payer_Info_Fld_ID(0);
		}
	}

	/**
	 * Get Payer Info Field.
	 *
	 * @return Payer Info Field
	 */
	@JsonProperty("BH_Payer_Info_Fld")
	public ForeignEntityInput BH_Payer_Info_Fld() {
		return mBH_Payer_Info_Fld;
	}
}
