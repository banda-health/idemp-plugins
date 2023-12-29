package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLot;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_M_AttributeSetInstance;
import org.compiere.util.Env;

/**
 * Generated Model for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetInstanceInput extends X_M_AttributeSetInstance implements I_M_AttributeSetInstanceInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput bh_update_reason_RL;
	 private I_M_AttributeSetInput M_AttributeSet;
	 private I_M_LotInput M_Lot;

	/**
	 * Standard constructor
	 */
	public X_M_AttributeSetInstanceInput(String ID) {
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
	 * Damaged products = p_dmg
	 */
	public static final String BH_UPDATE_REASON_DamagedProducts = "p_dmg";
	/**
	 * Product expired = p_exp
	 */
	public static final String BH_UPDATE_REASON_ProductExpired = "p_exp";
	/**
	 * Products used but not charged = p_unc
	 */
	public static final String BH_UPDATE_REASON_ProductsUsedButNotCharged = "p_unc";
	/**
	 * Lost or stolen products = p_los
	 */
	public static final String BH_UPDATE_REASON_LostOrStolenProducts = "p_los";
	/**
	 * System unavailable at sale = p_sna
	 */
	public static final String BH_UPDATE_REASON_SystemUnavailableAtSale = "p_sna";
	/**
	 * Wrong quantity received = p_bqt
	 */
	public static final String BH_UPDATE_REASON_WrongQuantityReceived = "p_bqt";
	/**
	 * Wrong expiration received = p_wer
	 */
	public static final String BH_UPDATE_REASON_WrongExpirationReceived = "p_wer";

	/**
	 * Set bh_update_reason.
	 *
	 * @param bh_update_reason bh_update_reason
	 */
	public void setbh_update_reason(String bh_update_reason) {

		set_Value(COLUMNNAME_bh_update_reason, bh_update_reason);
	}


	/**
	 * Get bh_update_reason.
	 *
	 * @return bh_update_reason
	 */
	public String getbh_update_reason() {
 		return (String) get_Value(COLUMNNAME_bh_update_reason);
	}


	/**
	 * Set bh_update_reason.
	 *
	 * @param bh_update_reason_RL bh_update_reason
	 */
	public void setbh_update_reason_RL(I_AD_Ref_ListInput bh_update_reason_RL) {
		this.bh_update_reason_RL = bh_update_reason_RL;
		MRefList foreignEntity;
		if (bh_update_reason_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(bh_update_reason_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setbh_update_reason(foreignEntity.getValue());
		} else {
			this.setbh_update_reason(null);
		}
	}

	/**
	 * Get bh_update_reason.
	 *
	 * @return bh_update_reason
	 */
	public I_AD_Ref_ListInput getbh_update_reason_RL() {
		return bh_update_reason_RL;
	}

	/**
	 * Set Attribute Set.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	public void setM_AttributeSet(I_M_AttributeSetInput M_AttributeSet) {
		this.M_AttributeSet = M_AttributeSet;
		MAttributeSet_BH foreignEntity;
		if (M_AttributeSet != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSet_BH.Table_Name, MAttributeSet_BH.COLUMNNAME_M_AttributeSet_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSet_ID(foreignEntity.get_ID());
		} else {
			this.setM_AttributeSet_ID(0);
		}
	}

	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	public I_M_AttributeSetInput getM_AttributeSet() {
		return M_AttributeSet;
	}
	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance_ID Product Attribute Set Instance
	 */

	public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
		if (get_ID() == 0) {
			super.setM_AttributeSetInstance_ID(M_AttributeSetInstance_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_AttributeSetInstance_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_AttributeSetInstance_UU();
	}

	/**
	 * Set Lot.
	 *
	 * @param M_Lot Product Lot Definition
	 */
	public void setM_Lot(I_M_LotInput M_Lot) {
		this.M_Lot = M_Lot;
		MLot foreignEntity;
		if (M_Lot != null &&
				(foreignEntity = new Query(getCtx(), MLot.Table_Name, MLot.COLUMNNAME_M_Lot_UU + "=?", get_TrxName())
						.setParameters(M_Lot.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Lot_ID(foreignEntity.get_ID());
		} else {
			this.setM_Lot_ID(0);
		}
	}

	/**
	 * Get Lot.
	 *
	 * @return Product Lot Definition
	 */
	public I_M_LotInput getM_Lot() {
		return M_Lot;
	}
}
