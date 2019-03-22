package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MPayment;

public class MPayment_BH extends MPayment {

	private static final long serialVersionUID = 1L;
	/**
	 * Column name BH_C_Order_ID
	 */
	public static final String COLUMNNAME_BH_C_Order_ID = "BH_C_Order_ID";
	/**
	 * Column name BH_MPesaPhnTrx_Num
	 */
	public static final String COLUMNNAME_BH_MPesaPhnTrx_Num = "BH_MPesaPhnTrx_Num";
	
	public static final String COLUMNNAME_BH_NHIF_RELATIONSHIP = "BH_NHIF_RELATIONSHIP";
	
	public static final String COLUMNNAME_BH_NHIF_MEMBER_NAME = "BH_NHIF_MEMBER_NAME";
	
	public static final String COLUMNNAME_NHIF_NUMBER = "NHIF_NUMBER";
	
	public static final String COLUMNNAME_BH_NHIF_MEMBER_ID = "BH_NHIF_MEMBER_ID";
	
	public static final String COLUMNAME_TOTAL_OPEN_BALANCE = "TotalOpenBalance";

	public MPayment_BH(Properties ctx, int C_Payment_ID, String trxName) {
		super(ctx, C_Payment_ID, trxName);
	}

	public MPayment_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Get BH_C_Order_ID.
	 *
	 * @return BH_C_Order_ID
	 */
	public int getBH_C_Order_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_C_Order_ID);
		if (ii == null) {
			return 0;
		}
		return ii.intValue();
	}

	/**
	 * Set BH_C_Order_ID.
	 *
	 * @param BH_C_Order_ID BH_C_Order_ID
	 */
	public void setBH_C_Order_ID(int BH_C_Order_ID) {
		if (BH_C_Order_ID < 1) {
			set_Value(COLUMNNAME_BH_C_Order_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_C_Order_ID, Integer.valueOf(BH_C_Order_ID));
		}
	}
	
	public void setDefaultBH_C_Order_ID() {
		set_Value(COLUMNNAME_BH_C_Order_ID, 0);
	}

	/**
	 * Get BH_MPesaPhnTrx_Num.
	 *
	 * @return Phone number or M-Pesa transaction number
	 */
	public String getBH_MPesaPhnTrx_Num() {
		return (String) get_Value(COLUMNNAME_BH_MPesaPhnTrx_Num);
	}

	/**
	 * Set BH_MPesaPhnTrx_Num.
	 *
	 * @param BH_MPesaPhnTrx_Num Phone number or M-Pesa transaction number
	 */
	public void setBH_MPesaPhnTrx_Num(String BH_MPesaPhnTrx_Num) {
		set_Value(COLUMNNAME_BH_MPesaPhnTrx_Num, BH_MPesaPhnTrx_Num);
	}
}
