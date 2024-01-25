package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDiscountSchemaBreak;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_DiscountSchemaBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DiscountSchemaBreakInput extends MDiscountSchemaBreak implements I_M_DiscountSchemaBreakInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_DiscountSchema;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_DiscountSchemaBreak_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_DiscountSchemaBreakInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDiscountSchemaBreak(null, (ResultSet) null, null),
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (M_DiscountSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MDiscountSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(M_DiscountSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UUID " + M_DiscountSchema.getUUID());
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
	 * Set Discount Schema Break.
	 *
	 * @param M_DiscountSchemaBreak_ID Trade Discount Break
	 */

	public void setM_DiscountSchemaBreak_ID(int M_DiscountSchemaBreak_ID) {
		if (get_ID() == 0) {
			super.setM_DiscountSchemaBreak_ID(M_DiscountSchemaBreak_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_DiscountSchemaBreak_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_DiscountSchemaBreak_UU();
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
							.setParameters(M_Product_Category.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product_Category with UUID " + M_Product_Category.getUUID());
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
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
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
}
