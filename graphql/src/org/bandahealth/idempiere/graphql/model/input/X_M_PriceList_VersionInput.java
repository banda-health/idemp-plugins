package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PriceList_VersionInput extends MPriceListVersion implements I_M_PriceList_VersionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_DiscountSchema;
	private ForeignEntityInput mM_PriceList;
	private ForeignEntityInput mM_Pricelist_Version_Base;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_PriceList_Version_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_PriceList_VersionInput(@JsonProperty("UU") String UU) {
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
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public void setM_DiscountSchemaInput(ForeignEntityInput M_DiscountSchema) {
		this.mM_DiscountSchema = M_DiscountSchema;
		if (M_DiscountSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MDiscountSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(M_DiscountSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UU " + M_DiscountSchema.getUU());
			}
		} else {
			this.setM_DiscountSchema_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (M_PriceList != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(M_PriceList.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UU " + M_PriceList.getUU());
			}
		} else {
			this.setM_PriceList_ID(0);
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
		if (M_Pricelist_Version_Base != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceListVersion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList_Version", "M_PriceList_Version_UU=?", get_TrxName())
							.setParameters(M_Pricelist_Version_Base.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Pricelist_Version_Base_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList_Version with UU " + M_Pricelist_Version_Base.getUU());
			}
		} else {
			this.setM_Pricelist_Version_Base_ID(0);
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
	 * Set Price List Version.
	 *
	 * @param M_PriceList_Version_ID Identifies a unique instance of a Price List
	 */
	@JsonProperty("M_PriceList_Version_ID")
	public void setM_PriceList_Version_IDFromJson(int M_PriceList_Version_ID) {
		if (get_ID() == 0) {
			super.setM_PriceList_Version_ID(M_PriceList_Version_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_PriceList_Version_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_PriceList_Version_UU();
	}
}
