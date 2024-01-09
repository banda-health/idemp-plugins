package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PriceList_VersionInput extends MPriceListVersion implements I_M_PriceList_VersionInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mM_DiscountSchema;
	 private ForeignEntityInput mM_PriceList;
	 private ForeignEntityInput mM_Pricelist_Version_Base;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_PriceList_VersionInput(@JsonProperty("ID") String ID) {
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
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public void setM_DiscountSchemaInput(ForeignEntityInput M_DiscountSchema) {
		this.mM_DiscountSchema = M_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (M_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(M_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			super.setM_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public ForeignEntityInput M_DiscountSchema() {
		return mM_DiscountSchema;
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public void setM_PriceListInput(ForeignEntityInput M_PriceList) {
		this.mM_PriceList = M_PriceList;
		MPriceList foreignEntity;
		if (get_ID() == 0 &&M_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(M_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PriceList_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public ForeignEntityInput M_PriceList() {
		return mM_PriceList;
	}

	/**
	 * Set Base Price List.
	 *
	 * @param M_Pricelist_Version_Base Source for Price list calculations
	 */
	@JsonProperty("M_Pricelist_Version_Base")
	public void setM_Pricelist_Version_BaseInput(ForeignEntityInput M_Pricelist_Version_Base) {
		this.mM_Pricelist_Version_Base = M_Pricelist_Version_Base;
		MPriceListVersion foreignEntity;
		if (M_Pricelist_Version_Base != null &&
				(foreignEntity = new Query(getCtx(), MPriceListVersion.Table_Name, MPriceListVersion.COLUMNNAME_M_PriceList_Version_UU + "=?", get_TrxName())
						.setParameters(M_Pricelist_Version_Base.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Pricelist_Version_Base_ID(foreignEntity.get_ID());
		} else {
			super.setM_Pricelist_Version_Base_ID(0);
		}
	}

	/**
	 * Get Base Price List.
	 *
	 * @return Source for Price list calculations
	 */
	@JsonProperty("M_Pricelist_Version_Base")
	public ForeignEntityInput M_Pricelist_Version_Base() {
		return mM_Pricelist_Version_Base;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_PriceList_Version_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_PriceList_Version_UU();
	}
}
