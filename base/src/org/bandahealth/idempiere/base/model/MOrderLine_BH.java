package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.util.Env;

public class MOrderLine_BH extends MOrderLine {
	
	/** Column name QtyAvailable */
    public static final String COLUMNNAME_QtyAvailable = "QtyAvailable";
    
    public static final String COLUMNNAME_BH_Instructions = "BH_Instructions";

	public MOrderLine_BH(MOrder order) {
		super(order);
	}

	public MOrderLine_BH(Properties ctx, int C_OrderLine_ID, String trxName) {
		super(ctx, C_OrderLine_ID, trxName);
	}

	public MOrderLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	/** Set BH_AvailableQuantity.
	@param QtyAvailable 
	Available Quantity (On Hand - Reserved)
  */
	public void setQtyAvailable(BigDecimal QtyAvailable) {
		set_ValueNoCheck(COLUMNNAME_QtyAvailable, QtyAvailable);
	}

	/**
	 * Get BH_AvailableQuantity.
	 * 
	 * @return Available Quantity (On Hand - Reserved)
	 */
	public BigDecimal getQtyAvailable() {
		BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_QtyAvailable);
		if (bd == null)
			return Env.ZERO;
		return bd;
	}
	
	public void setBH_Instructions (String BH_Instructions)
	{
		set_Value (COLUMNNAME_BH_Instructions, BH_Instructions);
	}

	public String getBH_Instructions ()
	{
		return (String)get_Value(COLUMNNAME_BH_Instructions);
	}
}
