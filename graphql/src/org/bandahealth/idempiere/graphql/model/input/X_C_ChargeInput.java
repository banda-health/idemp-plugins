package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput BH_SubType_RL;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_ChargeTypeInput C_ChargeType;
	 private I_C_TaxCategoryInput C_TaxCategory;

	/**
	 * Standard constructor
	 */
	public X_C_ChargeInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Sub Type.
	 *
	 * @param BH_SubType_RL Meant to be a sub-type of the charge type
	 */
	public void setBH_SubType_RL(I_AD_Ref_ListInput BH_SubType_RL) {
		this.BH_SubType_RL = BH_SubType_RL;
		MRefList foreignEntity;
		if (BH_SubType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_SubType_RL.getID())
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
	public I_AD_Ref_ListInput getBH_SubType_RL() {
		return BH_SubType_RL;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
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
	public void setC_ChargeType(I_C_ChargeTypeInput C_ChargeType) {
		this.C_ChargeType = C_ChargeType;
		MChargeType_BH foreignEntity;
		if (C_ChargeType != null &&
				(foreignEntity = new Query(getCtx(), MChargeType_BH.Table_Name, MChargeType_BH.COLUMNNAME_C_ChargeType_UU + "=?", get_TrxName())
						.setParameters(C_ChargeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ChargeType_ID(foreignEntity.get_ID());
		} else {
			this.setC_ChargeType_ID(0);
		}
	}

	/**
	 * Get Charge Type.
	 *
	 * @return Charge Type
	 */
	public I_C_ChargeTypeInput getC_ChargeType() {
		return C_ChargeType;
	}

	/**
	 * Set Tax Category.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	public void setC_TaxCategory(I_C_TaxCategoryInput C_TaxCategory) {
		this.C_TaxCategory = C_TaxCategory;
		MTaxCategory foreignEntity;
		if (C_TaxCategory != null &&
				(foreignEntity = new Query(getCtx(), MTaxCategory.Table_Name, MTaxCategory.COLUMNNAME_C_TaxCategory_UU + "=?", get_TrxName())
						.setParameters(C_TaxCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_TaxCategory_ID(foreignEntity.get_ID());
		} else {
			this.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public I_C_TaxCategoryInput getC_TaxCategory() {
		return C_TaxCategory;
	}
}
