package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MExpenseType;
import org.compiere.model.MProduct;
import org.compiere.model.MResource;
import org.compiere.model.MResourceType;
import org.compiere.model.X_I_Product;

public class MProduct_BH extends MProduct {

	/**
	 * Column name BH_HasExpiration
	 */
	public static final String COLUMNNAME_BH_HasExpiration = "BH_HasExpiration";
	/**
	 * Column name bh_reorder_level
	 */
	public static final String COLUMNNAME_bh_reorder_level = "bh_reorder_level";
	/**
	 * Column name bh_reorder_quantity
	 */
	public static final String COLUMNNAME_bh_reorder_quantity = "bh_reorder_quantity";
	public static String COLUMNNAME_BH_BuyPrice = "BH_BuyPrice";
	public static String COLUMNNAME_BH_SellPrice = "BH_SellPrice";
	public static String COLUMNNAME_BH_PriceMargin = "BH_PriceMargin";

	public MProduct_BH(Properties ctx, int M_Product_ID, String trxName) {
		super(ctx, M_Product_ID, trxName);
	}

	public MProduct_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MProduct_BH(MExpenseType et) {
		super(et);
	}

	public MProduct_BH(MResource resource, MResourceType resourceType) {
		super(resource, resourceType);
	}

	public MProduct_BH(X_I_Product impP) {
		super(impP);
	}

	/**
	 * Get Has Expiration.
	 *
	 * @return Has Expiration
	 */
	public boolean isBH_HasExpiration() {
		Object oo = get_Value(COLUMNNAME_BH_HasExpiration);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set Has Expiration.
	 *
	 * @param BH_HasExpiration Has Expiration
	 */
	public void setBH_HasExpiration(boolean BH_HasExpiration) {
		set_Value(COLUMNNAME_BH_HasExpiration, Boolean.valueOf(BH_HasExpiration));
	}

	public BigDecimal getBH_BuyPrice() {
		BigDecimal value = (BigDecimal) get_Value(COLUMNNAME_BH_BuyPrice);
		if (value == null) {
			return null;
		}

		return value;
	}

	public void setBH_BuyPrice(BigDecimal BH_BuyPrice) {
		set_Value(COLUMNNAME_BH_BuyPrice, BH_BuyPrice);
	}

	public BigDecimal getBH_SellPrice() {
		BigDecimal value = (BigDecimal) get_Value(COLUMNNAME_BH_SellPrice);
		if (value == null) {
			return null;
		}

		return value;
	}

	public void setBH_SellPrice(BigDecimal BH_SellPrice) {
		set_Value(COLUMNNAME_BH_SellPrice, BH_SellPrice);
	}

	public BigDecimal getBH_PriceMargin() {
		BigDecimal value = (BigDecimal) get_Value(COLUMNNAME_BH_PriceMargin);
		if (value == null) {
			return null;
		}

		return value;
	}

	public void setBH_PriceMargin(BigDecimal BH_PriceMargin) {
		set_Value(COLUMNNAME_BH_PriceMargin, BH_PriceMargin);
	}

	/**
	 * Set Re-order Level.
	 *
	 * @param bh_reorder_level Re-order Level
	 */
	public void setbh_reorder_level(int bh_reorder_level) {
		set_Value(COLUMNNAME_bh_reorder_level, Integer.valueOf(bh_reorder_level));
	}

	/**
	 * Get Re-order Level.
	 *
	 * @return Re-order Level
	 */
	public int getbh_reorder_level() {
		Integer ii = (Integer) get_Value(COLUMNNAME_bh_reorder_level);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set Re-order Quantity.
	 *
	 * @param bh_reorder_quantity How much quantity you want to re-order
	 */
	public void setbh_reorder_quantity(int bh_reorder_quantity) {
		set_Value(COLUMNNAME_bh_reorder_quantity, Integer.valueOf(bh_reorder_quantity));
	}

	/**
	 * Get Re-order Quantity.
	 *
	 * @return How much quantity you want to re-order
	 */
	public int getbh_reorder_quantity() {
		Integer ii = (Integer) get_Value(COLUMNNAME_bh_reorder_quantity);
		if (ii == null)
			return 0;
		return ii.intValue();
	}
}
