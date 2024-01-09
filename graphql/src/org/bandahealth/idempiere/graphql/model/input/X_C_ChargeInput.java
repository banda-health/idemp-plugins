package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTaxCategory;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChargeInput extends MCharge_BH implements I_C_ChargeInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mC_BPartner;
	 private ForeignEntityInput mC_ChargeType;
	 private ForeignEntityInput mC_TaxCategory;
	 private I_AD_Ref_ListInput mBH_SubType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ChargeInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	 * Set Sub Type.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	@JsonProperty("BH_SubType")
	public void setBH_SubTypeInput(I_AD_Ref_ListInput BH_SubType) {
		this.mBH_SubType = BH_SubType;
		MRefList_BH foreignEntity;
		if (BH_SubType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_SubType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_SubType(foreignEntity.getValue());
		} else {
			this.setBH_SubType(null);
		}
	}

	/**
	 * Get Sub Type.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	@JsonProperty("BH_SubType")
	public I_AD_Ref_ListInput BH_SubType() {
		return mBH_SubType;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Charge_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Charge_UU();
	}

	/**
	 * Set Charge Type.
	 *
	 * @param C_ChargeType Charge Type
	 */
	@JsonProperty("C_ChargeType")
	public void setC_ChargeTypeInput(ForeignEntityInput C_ChargeType) {
		this.mC_ChargeType = C_ChargeType;
		MChargeType_BH foreignEntity;
		if (C_ChargeType != null &&
				(foreignEntity = new Query(getCtx(), MChargeType_BH.Table_Name, MChargeType_BH.COLUMNNAME_C_ChargeType_UU + "=?", get_TrxName())
						.setParameters(C_ChargeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ChargeType_ID(foreignEntity.get_ID());
		} else {
			super.setC_ChargeType_ID(0);
		}
	}

	/**
	 * Get Charge Type.
	 *
	 * @return Charge Type
	 */
	@JsonProperty("C_ChargeType")
	public ForeignEntityInput C_ChargeType() {
		return mC_ChargeType;
	}

	/**
	 * Set Tax Category.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public void setC_TaxCategoryInput(ForeignEntityInput C_TaxCategory) {
		this.mC_TaxCategory = C_TaxCategory;
		MTaxCategory foreignEntity;
		if (C_TaxCategory != null &&
				(foreignEntity = new Query(getCtx(), MTaxCategory.Table_Name, MTaxCategory.COLUMNNAME_C_TaxCategory_UU + "=?", get_TrxName())
						.setParameters(C_TaxCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_TaxCategory_ID(foreignEntity.get_ID());
		} else {
			super.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public ForeignEntityInput C_TaxCategory() {
		return mC_TaxCategory;
	}
}
