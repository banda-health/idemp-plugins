package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetInstanceInput extends MAttributeSetInstance_BH implements I_M_AttributeSetInstanceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSet;
	private ForeignEntityInput mM_Lot;
	private I_AD_Ref_ListInput mbh_update_reason;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeSetInstance_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_AttributeSetInstanceInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAttributeSetInstance_BH(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Guarantee Date String.
	 *
	 * @param BH_GuaranteeDateString String date when guarantee expires
	 */

	public void setBH_GuaranteeDateString(String BH_GuaranteeDateString) {
		if (get_ID() == 0) {
			super.setBH_GuaranteeDateString(BH_GuaranteeDateString);
		}
	}

	/**
	 * Set bh_update_reason.
	 *
	 * @param bh_update_reason bh_update_reason
	 */
	@JsonProperty("bh_update_reason")
	public void setbh_update_reasonInput(I_AD_Ref_ListInput bh_update_reason) {
		this.mbh_update_reason = bh_update_reason;
		MRefList_BH foreignEntity;
		if (bh_update_reason != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(bh_update_reason.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setbh_update_reason(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + bh_update_reason.getUUID());
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
	public I_AD_Ref_ListInput bh_update_reason() {
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
		MAttributeSet_BH foreignEntity;
		if (M_AttributeSet != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSet", "M_AttributeSet_UU=?", get_TrxName())
							.setParameters(M_AttributeSet.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSet with UUID " + M_AttributeSet.getUUID());
			}
		} else {
			super.setM_AttributeSet_ID(0);
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

	public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
		if (get_ID() == 0) {
			super.setM_AttributeSetInstance_ID(M_AttributeSetInstance_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_AttributeSetInstance_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		MLot foreignEntity;
		if (M_Lot != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Lot", "M_Lot_UU=?", get_TrxName())
							.setParameters(M_Lot.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Lot_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Lot with UUID " + M_Lot.getUUID());
			}
		} else {
			super.setM_Lot_ID(0);
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
