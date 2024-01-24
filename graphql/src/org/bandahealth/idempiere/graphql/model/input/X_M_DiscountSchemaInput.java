package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DiscountSchemaInput extends MDiscountSchema implements I_M_DiscountSchemaInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mCumulativeLevel;
	private I_AD_Ref_ListInput mDiscountType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_DiscountSchemaInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MDiscountSchema(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
	 * Set Accumulation Level.
	 *
	 * @param CumulativeLevel Level for accumulative calculations
	 */
	@JsonProperty("CumulativeLevel")
	public void setCumulativeLevelInput(I_AD_Ref_ListInput CumulativeLevel) {
		this.mCumulativeLevel = CumulativeLevel;
		MRefList_BH foreignEntity;
		if (CumulativeLevel != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CumulativeLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCumulativeLevel(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (DiscountType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DiscountType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDiscountType(foreignEntity.getValue());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_DiscountSchema_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_DiscountSchema_UU();
	}
}
