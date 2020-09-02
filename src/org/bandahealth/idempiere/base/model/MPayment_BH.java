package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MPayment;

public class MPayment_BH extends MPayment {

	private static final long serialVersionUID = 1L;

	/** Bill Waiver = B */
	public static final String TENDERTYPE_BillWaiver = "B";
	/** Linda Mama = i */
	public static final String TENDERTYPE_LindaMama = "i";
	/** MPesa = M */
	public static final String TENDERTYPE_MPesa = "M";
	/** M-Tiba = L */
	public static final String TENDERTYPE_MTiba = "L";
	/** NHIF = N */
	public static final String TENDERTYPE_NHIF = "N";
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
	
	public static final String COLUMNAME_BH_NHIF_TYPE = "BH_NHIF_Type";
	
	public static final String COLUMNAME_TOTAL_OPEN_BALANCE = "TotalOpenBalance";
	
	public static final String COLUMNNAME_BH_PROCESSING = "BH_processing";
	
	public static final String COLUMNNAME_BH_TENDER_AMOUNT = "BH_tender_amount";
	
	public static final String COLUMNNAME_BH_REMAINING_INVOICE_AMOUNT = "BH_RmngInvcAmt";
	
	public static final String COLUMNNAME_BH_IsServiceDebt = "BH_IsServiceDebt";

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
	
	public void setBH_Processing(boolean processing) {
		set_Value(COLUMNNAME_BH_PROCESSING, processing);
	}
	
	public void setBH_TenderAmount(BigDecimal amount) {
		set_Value(COLUMNNAME_BH_TENDER_AMOUNT, amount);
	}
	
	public BigDecimal getBH_TenderAmount() {
		return (BigDecimal) get_Value(COLUMNNAME_BH_TENDER_AMOUNT);
	}
	
	public void setBH_IsServiceDebt (boolean BH_IsServiceDebt)
	{
		set_Value (COLUMNNAME_BH_IsServiceDebt, Boolean.valueOf(BH_IsServiceDebt));
	}

	public boolean isBH_IsServiceDebt ()
	{
		Object oo = get_Value(COLUMNNAME_BH_IsServiceDebt);
		if (oo != null)
		{
			if (oo instanceof Boolean)
				return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
}
