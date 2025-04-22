package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Payer_Info_FldResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payer_Info_Fld - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payer_Info_FldInput extends MBHPayerInfoFld implements I_BH_Payer_Info_FldInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payer;
	private ForeignEntityInput mBH_PayerInfoFieldDataType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Payer_Info_Fld_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Payer_Info_FldInput(@JsonProperty("UU") String UU) {
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
	 * Set Payer ID.
	 *
	 * @param BH_Payer Payer ID
	 */
	@JsonProperty("BH_Payer")
	public void setBH_PayerInput(ForeignEntityInput BH_Payer) {
		this.mBH_Payer = BH_Payer;
		if (get_ID() != 0) {
			return;
		}
		if (BH_Payer != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(BH_Payer.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Payer_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + BH_Payer.getUU());
			}
		} else {
			this.setBH_Payer_ID(0);
		}
	}

	/**
	 * Get Payer ID.
	 *
	 * @return Payer ID
	 */
	@JsonProperty("BH_Payer")
	public ForeignEntityInput BH_Payer() {
		return mBH_Payer;
	}
	/**
	 * Set Payer Info Field.
	 *
	 * @param BH_Payer_Info_Fld_ID Payer Info Field
	 */
	@JsonProperty("BH_Payer_Info_Fld_ID")
	public void setBH_Payer_Info_Fld_IDFromJson(int BH_Payer_Info_Fld_ID) {
		if (get_ID() == 0) {
			super.setBH_Payer_Info_Fld_ID(BH_Payer_Info_Fld_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Payer_Info_Fld_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Payer_Info_Fld_UU();
	}

	/**
	 * Set Payer Info Field Data Type.
	 *
	 * @param BH_PayerInfoFieldDataType Payer Info Field Data Type
	 */
	@JsonProperty("BH_PayerInfoFieldDataType")
	public void setBH_PayerInfoFieldDataTypeInput(ForeignEntityInput BH_PayerInfoFieldDataType) {
		this.mBH_PayerInfoFieldDataType = BH_PayerInfoFieldDataType;
		if (BH_PayerInfoFieldDataType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Payer_Info_FldResolver.BH_PAYERINFOFIELDDATATYPE_UUIDS_BY_VALUE.containsValue(BH_PayerInfoFieldDataType.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_PayerInfoFieldDataType.getUU() +
						" is not in the list defined for the BH_PayerInfoFieldDataType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_PayerInfoFieldDataType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_PayerInfoFieldDataType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_PayerInfoFieldDataType.getUU());
			}
		} else {
			this.setBH_PayerInfoFieldDataType(null);
		}
	}

	/**
	 * Get Payer Info Field Data Type.
	 *
	 * @return Payer Info Field Data Type
	 */
	@JsonProperty("BH_PayerInfoFieldDataType")
	public ForeignEntityInput BH_PayerInfoFieldDataType() {
		return mBH_PayerInfoFieldDataType;
	}
}
