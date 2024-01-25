package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_RelatedProduct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_RelatedProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RelatedProductInput extends X_M_RelatedProduct implements I_M_RelatedProductInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mRelatedProduct;
	private I_AD_Ref_ListInput mRelatedProductType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_RelatedProduct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_RelatedProductInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_M_RelatedProduct(null, (ResultSet) null, null),
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (get_ID() != 0) {
			return;
		}
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

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_RelatedProduct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_RelatedProduct_UU();
	}

	/**
	 * Set Related Product.
	 *
	 * @param RelatedProduct Related Product
	 */
	@JsonProperty("RelatedProduct")
	public void setRelatedProductInput(ForeignEntityInput RelatedProduct) {
		this.mRelatedProduct = RelatedProduct;
		if (get_ID() != 0) {
			return;
		}
		if (RelatedProduct != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(RelatedProduct.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRelatedProduct_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + RelatedProduct.getUUID());
			}
		} else {
			this.setRelatedProduct_ID(0);
		}
	}

	/**
	 * Get Related Product.
	 *
	 * @return Related Product
	 */
	@JsonProperty("RelatedProduct")
	public ForeignEntityInput RelatedProduct() {
		return mRelatedProduct;
	}

	/**
	 * Set Related Product Type.
	 *
	 * @param RelatedProductType Related Product Type
	 */
	@JsonProperty("RelatedProductType")
	public void setRelatedProductTypeInput(I_AD_Ref_ListInput RelatedProductType) {
		this.mRelatedProductType = RelatedProductType;
		if (get_ID() != 0) {
			return;
		}
		if (RelatedProductType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RelatedProductType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRelatedProductType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + RelatedProductType.getUUID());
			}
		} else {
			this.setRelatedProductType(null);
		}
	}

	/**
	 * Get Related Product Type.
	 *
	 * @return Related Product Type
	 */
	@JsonProperty("RelatedProductType")
	public I_AD_Ref_ListInput RelatedProductType() {
		return mRelatedProductType;
	}
}
