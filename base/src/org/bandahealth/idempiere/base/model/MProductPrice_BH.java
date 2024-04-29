package org.bandahealth.idempiere.base.model;

import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProductPrice;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

public class MProductPrice_BH extends MProductPrice {

	/**
	 * Column name ProductName
	 */
	public static final String COLUMNNAME_ProductName = "ProductName";

	public MProductPrice_BH(Properties ctx, String M_ProductPrice_UU, String trxName) {
		super(ctx, M_ProductPrice_UU, trxName);
	}

	public MProductPrice_BH(Properties ctx, int M_ProductPrice_ID, String trxName) {
		super(ctx, M_ProductPrice_ID, trxName);
	}

	public MProductPrice_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MProductPrice_BH(Properties ctx, int M_PriceList_Version_ID, int M_Product_ID, String trxName) {
		super(ctx, M_PriceList_Version_ID, M_Product_ID, trxName);
	}

	public MProductPrice_BH(Properties ctx, int M_PriceList_Version_ID, int M_Product_ID, BigDecimal PriceList,
			BigDecimal PriceStd, BigDecimal PriceLimit, String trxName) {
		super(ctx, M_PriceList_Version_ID, M_Product_ID, PriceList, PriceStd, PriceLimit, trxName);
	}

	public MProductPrice_BH(MPriceListVersion plv, int M_Product_ID, BigDecimal PriceList, BigDecimal PriceStd,
			BigDecimal PriceLimit) {
		super(plv, M_Product_ID, PriceList, PriceStd, PriceLimit);
	}

	public MProductPrice_BH(MProductPrice copy) {
		super(copy);
	}

	public MProductPrice_BH(Properties ctx, MProductPrice copy) {
		super(ctx, copy);
	}

	public MProductPrice_BH(Properties ctx, MProductPrice copy, String trxName) {
		super(ctx, copy, trxName);
	}

	/**
	 * Set Product Name.
	 *
	 * @param ProductName Name of the Product
	 */
	public void setProductName(String ProductName) {
		throw new IllegalArgumentException("ProductName is virtual column");
	}

	/**
	 * Get Product Name.
	 *
	 * @return Name of the Product
	 */
	public String getProductName() {
		return (String) get_Value(COLUMNNAME_ProductName);
	}
}
