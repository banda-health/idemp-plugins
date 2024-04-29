package org.bandahealth.idempiere.base.model;

import org.compiere.model.MProductCategory;

import java.sql.ResultSet;
import java.util.Properties;

public class MProductCategory_BH extends MProductCategory {

	/**
	 * Column name BH_Product_Category_Type
	 */
	public static final String COLUMNNAME_BH_Product_Category_Type = "BH_Product_Category_Type";

	/**
	 * Product = P
	 */
	public static final String BH_PRODUCT_CATEGORY_TYPE_Product = "P";
	/**
	 * Service = S
	 */
	public static final String BH_PRODUCT_CATEGORY_TYPE_Service = "S";

	public MProductCategory_BH(Properties ctx, String M_Product_Category_UU, String trxName) {
		super(ctx, M_Product_Category_UU, trxName);
	}

	public MProductCategory_BH(Properties ctx, int M_Product_Category_ID, String trxName) {
		super(ctx, M_Product_Category_ID, trxName);
	}

	public MProductCategory_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MProductCategory_BH(MProductCategory copy) {
		super(copy);
	}

	public MProductCategory_BH(Properties ctx, MProductCategory copy) {
		super(ctx, copy);
	}

	public MProductCategory_BH(Properties ctx, MProductCategory copy, String trxName) {
		super(ctx, copy, trxName);
	}

	/**
	 * Set BH Product Category Type.
	 *
	 * @param BH_Product_Category_Type Contains a character the is linked to a ref list to determine types of product
	 *                                  categories
	 */
	public void setBH_Product_Category_Type(String BH_Product_Category_Type) {

		set_Value(COLUMNNAME_BH_Product_Category_Type, BH_Product_Category_Type);
	}

	/**
	 * Get BH Product Category Type.
	 *
	 * @return Contains a character the is linked to a ref list to determine types of product categories
	 */
	public String getBH_Product_Category_Type() {
		return (String) get_Value(COLUMNNAME_BH_Product_Category_Type);
	}
}
