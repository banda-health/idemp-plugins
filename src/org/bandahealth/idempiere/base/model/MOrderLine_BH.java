package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;

public class MOrderLine_BH extends MOrderLine {

	public static String COLUMNNAME_Expiration = "BH_Expiration";

	public MOrderLine_BH(MOrder order) {
		super(order);
		// TODO Auto-generated constructor stub
	}

	public MOrderLine_BH(Properties ctx, int C_OrderLine_ID, String trxName) {
		super(ctx, C_OrderLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MOrderLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Set Expire On.
	 * 
	 * @param Expiration
	 *            Expire On
	 */
	public void setExpiration(Timestamp Expiration) {
		set_Value(COLUMNNAME_Expiration, Expiration);
	}

	/**
	 * Get Expire On.
	 * 
	 * @return Expire On
	 */
	public Timestamp getExpiration() {
		return (Timestamp) get_Value(COLUMNNAME_Expiration);
	}
}
