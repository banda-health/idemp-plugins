package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTaxCategory;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChargeInput extends MCharge_BH implements I_C_ChargeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_ChargeType;
	private ForeignEntityInput mC_TaxCategory;
	private I_AD_Ref_ListInput mBH_SubType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Charge_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_ChargeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
	 * Set Sub Type.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	@JsonProperty("BH_SubType")
	public void setBH_SubTypeInput(I_AD_Ref_ListInput BH_SubType) {
		this.mBH_SubType = BH_SubType;
		if (BH_SubType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_SubType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_SubType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BH_SubType.getUUID());
			}
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
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}
	/**
	 * Set Charge.
	 *
	 * @param C_Charge_ID Additional document charges
	 */

	public void setC_Charge_ID(int C_Charge_ID) {
		if (get_ID() == 0) {
			super.setC_Charge_ID(C_Charge_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Charge_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (C_ChargeType != null) {
			// Since an entity was passed, make sure it's in the DB
			MChargeType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ChargeType", "C_ChargeType_UU=?", get_TrxName())
							.setParameters(C_ChargeType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ChargeType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ChargeType with UUID " + C_ChargeType.getUUID());
			}
		} else {
			this.setC_ChargeType_ID(0);
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
		if (C_TaxCategory != null) {
			// Since an entity was passed, make sure it's in the DB
			MTaxCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxCategory", "C_TaxCategory_UU=?", get_TrxName())
							.setParameters(C_TaxCategory.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_TaxCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxCategory with UUID " + C_TaxCategory.getUUID());
			}
		} else {
			this.setC_TaxCategory_ID(0);
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
