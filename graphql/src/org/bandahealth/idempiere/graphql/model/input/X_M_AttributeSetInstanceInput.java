package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_AttributeSetInstanceResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLot;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeSetInstanceInput extends MAttributeSetInstance_BH implements I_M_AttributeSetInstanceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSet;
	private ForeignEntityInput mM_Lot;
	private ForeignEntityInput mbh_update_reason;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_AttributeSetInstance_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_AttributeSetInstanceInput(@JsonProperty("UU") String UU) {
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
	 * Set bh_update_reason.
	 *
	 * @param bh_update_reason bh_update_reason
	 */
	@JsonProperty("bh_update_reason")
	public void setbh_update_reasonInput(ForeignEntityInput bh_update_reason) {
		this.mbh_update_reason = bh_update_reason;
		if (bh_update_reason != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_AttributeSetInstanceResolver.BH_UPDATE_REASON_UUIDS_BY_VALUE.containsValue(bh_update_reason.getUU())) {
				throw new AdempiereException("The reference list UU of " + bh_update_reason.getUU() +
						" is not in the list defined for the bh_update_reason column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(bh_update_reason.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setbh_update_reason(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + bh_update_reason.getUU());
			}
		} else {
			this.setbh_update_reason(null);
		}
	}

	/**
	 * Get bh_update_reason.
	 *
	 * @return bh_update_reason
	 */
	@JsonProperty("bh_update_reason")
	public ForeignEntityInput bh_update_reason() {
		return mbh_update_reason;
	}

	/**
	 * Set Attribute Set.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public void setM_AttributeSetInput(ForeignEntityInput M_AttributeSet) {
		this.mM_AttributeSet = M_AttributeSet;
		if (M_AttributeSet != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSet_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSet", "M_AttributeSet_UU=?", get_TrxName())
							.setParameters(M_AttributeSet.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSet with UU " + M_AttributeSet.getUU());
			}
		} else {
			this.setM_AttributeSet_ID(-1);
		}
	}

	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public ForeignEntityInput M_AttributeSet() {
		return mM_AttributeSet;
	}
	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance_ID Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance_ID")
	public void setM_AttributeSetInstance_IDFromJson(int M_AttributeSetInstance_ID) {
		if (get_ID() == 0) {
			super.setM_AttributeSetInstance_ID(M_AttributeSetInstance_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_AttributeSetInstance_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_AttributeSetInstance_UU();
	}

	/**
	 * Set Lot.
	 *
	 * @param M_Lot Product Lot Definition
	 */
	@JsonProperty("M_Lot")
	public void setM_LotInput(ForeignEntityInput M_Lot) {
		this.mM_Lot = M_Lot;
		if (M_Lot != null) {
			// Since an entity was passed, make sure it's in the DB
			MLot foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Lot", "M_Lot_UU=?", get_TrxName())
							.setParameters(M_Lot.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Lot_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Lot with UU " + M_Lot.getUU());
			}
		} else {
			this.setM_Lot_ID(0);
		}
	}

	/**
	 * Get Lot.
	 *
	 * @return Product Lot Definition
	 */
	@JsonProperty("M_Lot")
	public ForeignEntityInput M_Lot() {
		return mM_Lot;
	}
}
