package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;

public class MOrderLine_BH extends MOrderLine {

	/**
	 * Column name BH_Expiration
	 */
	public static final String COLUMNNAME_BH_Expiration = "BH_Expiration";

	/**
	 * Column name BH_RequiresExpiration
	 */
	public static final String COLUMNNAME_BH_RequiresExpiration = "BH_RequiresExpiration";

	public MOrderLine_BH(MOrder order) {
		super(order);
	}

	public MOrderLine_BH(Properties ctx, int C_OrderLine_ID, String trxName) {
		super(ctx, C_OrderLine_ID, trxName);
	}

	public MOrderLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Get Expire On.
	 *
	 * @return Expire On
	 */
	public Timestamp getBH_Expiration() {
		return (Timestamp) get_Value(COLUMNNAME_BH_Expiration);
	}

	/**
	 * Set Expire On.
	 *
	 * @param BH_Expiration Expire On
	 */
	public void setBH_Expiration(Timestamp BH_Expiration) {
		set_Value(COLUMNNAME_BH_Expiration, BH_Expiration);
	}

	/**
	 * Get Requires Expiration.
	 *
	 * @return Requires Expiration
	 */
	public boolean isBH_RequiresExpiration() {
		Object oo = get_Value(COLUMNNAME_BH_RequiresExpiration);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set Requires Expiration.
	 *
	 * @param BH_RequiresExpiration Requires Expiration
	 */
	public void setBH_RequiresExpiration(boolean BH_RequiresExpiration) {
		throw new IllegalArgumentException("BH_RequiresExpiration is virtual column");
	}
}
