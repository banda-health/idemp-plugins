package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DiscountSchemaInput extends MDiscountSchema implements I_M_DiscountSchemaInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mCumulativeLevel;
	private I_AD_Ref_ListInput mDiscountType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_DiscountSchema_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_DiscountSchemaInput(@JsonProperty("UU") String UU) {
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
	 * Set Accumulation Level.
	 *
	 * @param CumulativeLevel Level for accumulative calculations
	 */
	@JsonProperty("CumulativeLevel")
	public void setCumulativeLevelInput(I_AD_Ref_ListInput CumulativeLevel) {
		this.mCumulativeLevel = CumulativeLevel;
		if (CumulativeLevel != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CumulativeLevel.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCumulativeLevel(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + CumulativeLevel.getUU());
			}
		} else {
			this.setCumulativeLevel(null);
		}
	}

	/**
	 * Get Accumulation Level.
	 *
	 * @return Level for accumulative calculations
	 */
	@JsonProperty("CumulativeLevel")
	public I_AD_Ref_ListInput CumulativeLevel() {
		return mCumulativeLevel;
	}

	/**
	 * Set Discount Type.
	 *
	 * @param DiscountType Type of trade discount calculation
	 */
	@JsonProperty("DiscountType")
	public void setDiscountTypeInput(I_AD_Ref_ListInput DiscountType) {
		this.mDiscountType = DiscountType;
		if (DiscountType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DiscountType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDiscountType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DiscountType.getUU());
			}
		} else {
			this.setDiscountType(null);
		}
	}

	/**
	 * Get Discount Type.
	 *
	 * @return Type of trade discount calculation
	 */
	@JsonProperty("DiscountType")
	public I_AD_Ref_ListInput DiscountType() {
		return mDiscountType;
	}
	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema_ID Schema to calculate the trade discount percentage
	 */

	public void setM_DiscountSchema_ID(int M_DiscountSchema_ID) {
		if (get_ID() == 0) {
			super.setM_DiscountSchema_ID(M_DiscountSchema_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_DiscountSchema_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_DiscountSchema_UU();
	}
}
