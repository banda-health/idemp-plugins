package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_DiscountSchemaLineResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MConversionType;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDiscountSchemaLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_DiscountSchemaLineInput extends MDiscountSchemaLine implements I_M_DiscountSchemaLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mLimit_Base;
	private ForeignEntityInput mLimit_Rounding;
	private ForeignEntityInput mList_Base;
	private ForeignEntityInput mList_Rounding;
	private ForeignEntityInput mM_DiscountSchema;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;
	private ForeignEntityInput mStd_Base;
	private ForeignEntityInput mStd_Rounding;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_DiscountSchemaLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_DiscountSchemaLineInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
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
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		if (C_ConversionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MConversionType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UU " + C_ConversionType.getUU());
			}
		} else {
			this.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public ForeignEntityInput C_ConversionType() {
		return mC_ConversionType;
	}

	/**
	 * Set Limit price Base.
	 *
	 * @param Limit_Base Base price for calculation of the new price
	 */
	@JsonProperty("Limit_Base")
	public void setLimit_BaseInput(ForeignEntityInput Limit_Base) {
		this.mLimit_Base = Limit_Base;
		if (Limit_Base != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_DiscountSchemaLineResolver.LIMIT_BASE_UUIDS_BY_VALUE.containsValue(Limit_Base.getUU())) {
				throw new AdempiereException("The reference list UU of " + Limit_Base.getUU() +
						" is not in the list defined for the Limit_Base column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Limit_Base.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLimit_Base(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Limit_Base.getUU());
			}
		} else {
			this.setLimit_Base(null);
		}
	}

	/**
	 * Get Limit price Base.
	 *
	 * @return Base price for calculation of the new price
	 */
	@JsonProperty("Limit_Base")
	public ForeignEntityInput Limit_Base() {
		return mLimit_Base;
	}

	/**
	 * Set Limit price Rounding.
	 *
	 * @param Limit_Rounding Rounding of the final result
	 */
	@JsonProperty("Limit_Rounding")
	public void setLimit_RoundingInput(ForeignEntityInput Limit_Rounding) {
		this.mLimit_Rounding = Limit_Rounding;
		if (Limit_Rounding != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_DiscountSchemaLineResolver.LIMIT_ROUNDING_UUIDS_BY_VALUE.containsValue(Limit_Rounding.getUU())) {
				throw new AdempiereException("The reference list UU of " + Limit_Rounding.getUU() +
						" is not in the list defined for the Limit_Rounding column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Limit_Rounding.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLimit_Rounding(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Limit_Rounding.getUU());
			}
		} else {
			this.setLimit_Rounding(null);
		}
	}

	/**
	 * Get Limit price Rounding.
	 *
	 * @return Rounding of the final result
	 */
	@JsonProperty("Limit_Rounding")
	public ForeignEntityInput Limit_Rounding() {
		return mLimit_Rounding;
	}

	/**
	 * Set List price Base.
	 *
	 * @param List_Base Price used as the basis for price list calculations
	 */
	@JsonProperty("List_Base")
	public void setList_BaseInput(ForeignEntityInput List_Base) {
		this.mList_Base = List_Base;
		if (List_Base != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_DiscountSchemaLineResolver.LIST_BASE_UUIDS_BY_VALUE.containsValue(List_Base.getUU())) {
				throw new AdempiereException("The reference list UU of " + List_Base.getUU() +
						" is not in the list defined for the List_Base column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(List_Base.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setList_Base(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + List_Base.getUU());
			}
		} else {
			this.setList_Base(null);
		}
	}

	/**
	 * Get List price Base.
	 *
	 * @return Price used as the basis for price list calculations
	 */
	@JsonProperty("List_Base")
	public ForeignEntityInput List_Base() {
		return mList_Base;
	}

	/**
	 * Set List price Rounding.
	 *
	 * @param List_Rounding Rounding rule for final list price
	 */
	@JsonProperty("List_Rounding")
	public void setList_RoundingInput(ForeignEntityInput List_Rounding) {
		this.mList_Rounding = List_Rounding;
		if (List_Rounding != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_DiscountSchemaLineResolver.LIST_ROUNDING_UUIDS_BY_VALUE.containsValue(List_Rounding.getUU())) {
				throw new AdempiereException("The reference list UU of " + List_Rounding.getUU() +
						" is not in the list defined for the List_Rounding column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(List_Rounding.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setList_Rounding(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + List_Rounding.getUU());
			}
		} else {
			this.setList_Rounding(null);
		}
	}

	/**
	 * Get List price Rounding.
	 *
	 * @return Rounding rule for final list price
	 */
	@JsonProperty("List_Rounding")
	public ForeignEntityInput List_Rounding() {
		return mList_Rounding;
	}

	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public void setM_DiscountSchemaInput(ForeignEntityInput M_DiscountSchema) {
		this.mM_DiscountSchema = M_DiscountSchema;
		if (!is_new()) {
			return;
		}
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
	 * Set Discount Price List.
	 *
	 * @param M_DiscountSchemaLine_ID Line of the price list trade discount schema
	 */
	@JsonProperty("M_DiscountSchemaLine_ID")
	public void setM_DiscountSchemaLine_IDFromJson(int M_DiscountSchemaLine_ID) {
		if (get_ID() == 0) {
			super.setM_DiscountSchemaLine_ID(M_DiscountSchemaLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_DiscountSchemaLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_DiscountSchemaLine_UU();
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category) {
		this.mM_Product_Category = M_Product_Category;
		if (M_Product_Category != null) {
			// Since an entity was passed, make sure it's in the DB
			MProductCategory_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
							.setParameters(M_Product_Category.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product_Category with UU " + M_Product_Category.getUU());
			}
		} else {
			this.setM_Product_Category_ID(0);
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public ForeignEntityInput M_Product_Category() {
		return mM_Product_Category;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
			}
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set Standard price Base.
	 *
	 * @param Std_Base Base price for calculating new standard price
	 */
	@JsonProperty("Std_Base")
	public void setStd_BaseInput(ForeignEntityInput Std_Base) {
		this.mStd_Base = Std_Base;
		if (Std_Base != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_DiscountSchemaLineResolver.STD_BASE_UUIDS_BY_VALUE.containsValue(Std_Base.getUU())) {
				throw new AdempiereException("The reference list UU of " + Std_Base.getUU() +
						" is not in the list defined for the Std_Base column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Std_Base.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setStd_Base(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Std_Base.getUU());
			}
		} else {
			this.setStd_Base(null);
		}
	}

	/**
	 * Get Standard price Base.
	 *
	 * @return Base price for calculating new standard price
	 */
	@JsonProperty("Std_Base")
	public ForeignEntityInput Std_Base() {
		return mStd_Base;
	}

	/**
	 * Set Standard price Rounding.
	 *
	 * @param Std_Rounding Rounding rule for calculated price
	 */
	@JsonProperty("Std_Rounding")
	public void setStd_RoundingInput(ForeignEntityInput Std_Rounding) {
		this.mStd_Rounding = Std_Rounding;
		if (Std_Rounding != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_DiscountSchemaLineResolver.STD_ROUNDING_UUIDS_BY_VALUE.containsValue(Std_Rounding.getUU())) {
				throw new AdempiereException("The reference list UU of " + Std_Rounding.getUU() +
						" is not in the list defined for the Std_Rounding column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Std_Rounding.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setStd_Rounding(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Std_Rounding.getUU());
			}
		} else {
			this.setStd_Rounding(null);
		}
	}

	/**
	 * Get Standard price Rounding.
	 *
	 * @return Rounding rule for calculated price
	 */
	@JsonProperty("Std_Rounding")
	public ForeignEntityInput Std_Rounding() {
		return mStd_Rounding;
	}
}
