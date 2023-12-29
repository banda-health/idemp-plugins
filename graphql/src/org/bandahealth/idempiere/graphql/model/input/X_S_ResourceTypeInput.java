package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MResourceType;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for S_ResourceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceTypeInput extends MResourceType implements I_S_ResourceTypeInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_TaxCategoryInput C_TaxCategory;
	 private I_C_UOMInput C_UOM;
	 private I_M_Product_CategoryInput M_Product_Category;

	/**
	 * Standard constructor
	 */
	public X_S_ResourceTypeInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Tax Category.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	public void setC_TaxCategory(I_C_TaxCategoryInput C_TaxCategory) {
		this.C_TaxCategory = C_TaxCategory;
		MTaxCategory foreignEntity;
		if (C_TaxCategory != null &&
				(foreignEntity = new Query(getCtx(), MTaxCategory.Table_Name, MTaxCategory.COLUMNNAME_C_TaxCategory_UU + "=?", get_TrxName())
						.setParameters(C_TaxCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_TaxCategory_ID(foreignEntity.get_ID());
		} else {
			this.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public I_C_TaxCategoryInput getC_TaxCategory() {
		return C_TaxCategory;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	public void setC_UOM(I_C_UOMInput C_UOM) {
		this.C_UOM = C_UOM;
		MUOM foreignEntity;
		if (C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public I_C_UOMInput getC_UOM() {
		return C_UOM;
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	public void setM_Product_Category(I_M_Product_CategoryInput M_Product_Category) {
		this.M_Product_Category = M_Product_Category;
		MProductCategory_BH foreignEntity;
		if (M_Product_Category != null &&
				(foreignEntity = new Query(getCtx(), MProductCategory_BH.Table_Name, MProductCategory_BH.COLUMNNAME_M_Product_Category_UU + "=?", get_TrxName())
						.setParameters(M_Product_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_Category_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_Category_ID(0);
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public I_M_Product_CategoryInput getM_Product_Category() {
		return M_Product_Category;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setS_ResourceType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getS_ResourceType_UU();
	}
}
