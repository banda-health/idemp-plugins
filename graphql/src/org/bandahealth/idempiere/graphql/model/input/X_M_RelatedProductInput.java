package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_RelatedProduct;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_RelatedProductInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_RelatedProduct(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_RelatedProduct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && RelatedProduct != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(RelatedProduct.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRelatedProduct_ID(foreignEntity.get_ID());
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
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&RelatedProductType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RelatedProductType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRelatedProductType(foreignEntity.getValue());
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
