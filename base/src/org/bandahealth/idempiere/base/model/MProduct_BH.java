package org.bandahealth.idempiere.base.model;

import org.compiere.model.MExpenseType;
import org.compiere.model.MProduct;
import org.compiere.model.MResource;
import org.compiere.model.MResourceType;
import org.compiere.model.X_I_Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MProduct_BH extends MProduct {

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

	/**
	 * Column name BH_NavButtons
	 */
	public static final String COLUMNNAME_BH_NavButtons = "BH_NavButtons";

	/**
	 * Column name DiscontinuedBy
	 */
	public static final String COLUMNNAME_DiscontinuedBy = "DiscontinuedBy";

	/**
	 * Column name DownloadURL
	 */
	public static final String COLUMNNAME_DownloadURL = "DownloadURL";

	/**
	 * Column name istoformule
	 */
	public static final String COLUMNNAME_istoformule = "istoformule";

	/**
	 * Column name QtyInStore
	 */
	public static final String COLUMNNAME_QtyInStore = "QtyInStore";

	public MProduct_BH(Properties ctx, String M_Product_UU, String trxName) {
		super(ctx, M_Product_UU, trxName);
	}

	public MProduct_BH(Properties ctx, int M_Product_ID, String trxName) {
		super(ctx, M_Product_ID, trxName);
	}

	public MProduct_BH(Properties ctx, int M_Product_ID, String trxName, String... virtualColumns) {
		super(ctx, M_Product_ID, trxName, virtualColumns);
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

	public MProduct_BH(MProduct copy) {
		super(copy);
	}

	public MProduct_BH(Properties ctx, MProduct copy) {
		super(ctx, copy);
	}

	public MProduct_BH(Properties ctx, MProduct copy, String trxName) {
		super(ctx, copy, trxName);
	}

	/**
	 * Set/Update Settings from import
	 *
	 * @param importProductQuantity import
	 */
	public void set(X_BH_I_Product_Quantity importProductQuantity) {
		setName(importProductQuantity.getName());
		if (importProductQuantity.getBH_SellPrice() != null) {
			setBH_SellPrice(importProductQuantity.getBH_SellPrice());
		}
		setbh_reorder_level(importProductQuantity.getbh_reorder_level());

		// Set the buy price based on the buying price of the lot with the expiration date farthest from today
		if (importProductQuantity.isBH_HasExpiration()) {
			if (importProductQuantity.getBH_BuyPrice() != null) {
				setBH_BuyPrice(importProductQuantity.getBH_BuyPrice());
			}
		} else {
			// Check lot 3
			BigDecimal buyPrice = null;
			Timestamp expirationDate = null;
			if (importProductQuantity.isBH_HasLot3()) {
				buyPrice = importProductQuantity.getBH_BuyPrice_Lot3();
				expirationDate = importProductQuantity.getBH_GuaranteeDate_Lot3();
			}
			if (importProductQuantity.isBH_HasLot2() && (expirationDate == null ||
					importProductQuantity.getBH_GuaranteeDate_Lot2().compareTo(expirationDate) > 0)) {
				buyPrice = importProductQuantity.getBH_BuyPrice_Lot2();
				expirationDate = importProductQuantity.getBH_GuaranteeDate_Lot2();
			}
			if ((expirationDate == null || importProductQuantity.getGuaranteeDate().compareTo(expirationDate) > 0)) {
				buyPrice = importProductQuantity.getBH_BuyPrice();
			}
			if (buyPrice != null) {
				setBH_BuyPrice(buyPrice);
			}
		}
	}  //	set

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

	/**
	 * Set istoformule.
	 *
	 * @param istoformule istoformule
	 */
	public void setistoformule(boolean istoformule) {
		set_Value(COLUMNNAME_istoformule, Boolean.valueOf(istoformule));
	}

	/**
	 * Get istoformule.
	 *
	 * @return istoformule
	 */
	public boolean istoformule() {
		Object oo = get_Value(COLUMNNAME_istoformule);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	public void setBH_NavButtons(Object BH_NavButtons) {
		set_Value(COLUMNNAME_BH_NavButtons, BH_NavButtons);
	}

	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	public Object getBH_NavButtons() {
		return get_Value(COLUMNNAME_BH_NavButtons);
	}

	/**
	 * Set Discontinued by.
	 *
	 * @param DiscontinuedBy Discontinued By
	 */
	public void setDiscontinuedBy(Timestamp DiscontinuedBy) {
		set_Value(COLUMNNAME_DiscontinuedBy, DiscontinuedBy);
	}

	/**
	 * Get Discontinued by.
	 *
	 * @return Discontinued By
	 */
	public Timestamp getDiscontinuedBy() {
		return (Timestamp) get_Value(COLUMNNAME_DiscontinuedBy);
	}

	/**
	 * Set Download URL.
	 *
	 * @param DownloadURL URL of the Download files
	 */
	public void setDownloadURL(String DownloadURL) {
		set_Value(COLUMNNAME_DownloadURL, DownloadURL);
	}

	/**
	 * Get Download URL.
	 *
	 * @return URL of the Download files
	 */
	public String getDownloadURL() {
		return (String) get_Value(COLUMNNAME_DownloadURL);
	}

	/**
	 * Set QtyInStore.
	 *
	 * @param QtyInStore Quantity In Store
	 */
	public void setQtyInStore(int QtyInStore) {
		throw new IllegalArgumentException("QtyInStore is virtual column");
	}

	/**
	 * Get QtyInStore.
	 *
	 * @return Quantity In Store
	 */
	public int getQtyInStore() {
		Integer ii = (Integer) get_Value(COLUMNNAME_QtyInStore);
		if (ii == null)
			return 0;
		return ii.intValue();
	}
}
