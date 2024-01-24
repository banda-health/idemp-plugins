package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_M_DiscountSchemaLineInput extends MDiscountSchemaLine implements I_M_DiscountSchemaLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mM_DiscountSchema;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;
	private I_AD_Ref_ListInput mLimit_Base;
	private I_AD_Ref_ListInput mLimit_Rounding;
	private I_AD_Ref_ListInput mList_Base;
	private I_AD_Ref_ListInput mList_Rounding;
	private I_AD_Ref_ListInput mStd_Base;
	private I_AD_Ref_ListInput mStd_Rounding;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_DiscountSchemaLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_DiscountSchemaLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDiscountSchemaLine(null, (ResultSet) null, null),
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
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
		MConversionType foreignEntity;
		if (C_ConversionType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UUID " + C_ConversionType.getUUID());
			}
		} else {
			super.setC_ConversionType_ID(0);
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
	public void setLimit_BaseInput(I_AD_Ref_ListInput Limit_Base) {
		this.mLimit_Base = Limit_Base;
		MRefList_BH foreignEntity;
		if (Limit_Base != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Limit_Base.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLimit_Base(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Limit_Base.getUUID());
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
	public I_AD_Ref_ListInput Limit_Base() {
		return mLimit_Base;
	}

	/**
	 * Set Limit price Rounding.
	 *
	 * @param Limit_Rounding Rounding of the final result
	 */
	@JsonProperty("Limit_Rounding")
	public void setLimit_RoundingInput(I_AD_Ref_ListInput Limit_Rounding) {
		this.mLimit_Rounding = Limit_Rounding;
		MRefList_BH foreignEntity;
		if (Limit_Rounding != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Limit_Rounding.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLimit_Rounding(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Limit_Rounding.getUUID());
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
	public I_AD_Ref_ListInput Limit_Rounding() {
		return mLimit_Rounding;
	}

	/**
	 * Set List price Base.
	 *
	 * @param List_Base Price used as the basis for price list calculations
	 */
	@JsonProperty("List_Base")
	public void setList_BaseInput(I_AD_Ref_ListInput List_Base) {
		this.mList_Base = List_Base;
		MRefList_BH foreignEntity;
		if (List_Base != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(List_Base.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setList_Base(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + List_Base.getUUID());
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
	public I_AD_Ref_ListInput List_Base() {
		return mList_Base;
	}

	/**
	 * Set List price Rounding.
	 *
	 * @param List_Rounding Rounding rule for final list price
	 */
	@JsonProperty("List_Rounding")
	public void setList_RoundingInput(I_AD_Ref_ListInput List_Rounding) {
		this.mList_Rounding = List_Rounding;
		MRefList_BH foreignEntity;
		if (List_Rounding != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(List_Rounding.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setList_Rounding(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + List_Rounding.getUUID());
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
	public I_AD_Ref_ListInput List_Rounding() {
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
		MDiscountSchema foreignEntity;
		if (get_ID() == 0 && M_DiscountSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(M_DiscountSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UUID " + M_DiscountSchema.getUUID());
			}
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
	 * Set Discount Pricelist.
	 *
	 * @param M_DiscountSchemaLine_ID Line of the pricelist trade discount schema
	 */

	public void setM_DiscountSchemaLine_ID(int M_DiscountSchemaLine_ID) {
		if (get_ID() == 0) {
			super.setM_DiscountSchemaLine_ID(M_DiscountSchemaLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_DiscountSchemaLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		MProductCategory_BH foreignEntity;
		if (M_Product_Category != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
							.setParameters(M_Product_Category.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product_Category with UUID " + M_Product_Category.getUUID());
			}
		} else {
			super.setM_Product_Category_ID(0);
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
		MProduct_BH foreignEntity;
		if (M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			super.setM_Product_ID(0);
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
	public void setStd_BaseInput(I_AD_Ref_ListInput Std_Base) {
		this.mStd_Base = Std_Base;
		MRefList_BH foreignEntity;
		if (Std_Base != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Std_Base.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setStd_Base(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Std_Base.getUUID());
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
	public I_AD_Ref_ListInput Std_Base() {
		return mStd_Base;
	}

	/**
	 * Set Standard price Rounding.
	 *
	 * @param Std_Rounding Rounding rule for calculated price
	 */
	@JsonProperty("Std_Rounding")
	public void setStd_RoundingInput(I_AD_Ref_ListInput Std_Rounding) {
		this.mStd_Rounding = Std_Rounding;
		MRefList_BH foreignEntity;
		if (Std_Rounding != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Std_Rounding.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setStd_Rounding(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Std_Rounding.getUUID());
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
	public I_AD_Ref_ListInput Std_Rounding() {
		return mStd_Rounding;
	}
}
