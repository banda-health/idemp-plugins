package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MDocTypeCounter;
import org.compiere.model.MOrg;
import org.compiere.model.MPayment;
import org.compiere.util.DB;

public class MPayment_BH extends MPayment {

	/**
	 * Bill Waiver = B
	 */
	public static final String TENDERTYPE_BillWaiver = "B";
	/**
	 * Linda Mama = i
	 */
	public static final String TENDERTYPE_LindaMama = "i";
	/**
	 * MPesa = M
	 */
	public static final String TENDERTYPE_MPesa = "M";
	/**
	 * M-Tiba = L
	 */
	public static final String TENDERTYPE_MTiba = "L";
	/**
	 * NHIF = N
	 */
	public static final String TENDERTYPE_NHIF = "N";
	/**
	 * Column name BH_C_Order_ID
	 */
	public static final String COLUMNNAME_BH_C_Order_ID = "BH_C_Order_ID";
	/**
	 * Column name BH_MPesaPhnTrx_Num
	 */
	public static final String COLUMNNAME_BH_MPesaPhnTrx_Num = "BH_MPesaPhnTrx_Num";
	/**
	 * Column name bh_nhif_relationship
	 */
	public static final String COLUMNNAME_bh_nhif_relationship = "bh_nhif_relationship";
	public static final String COLUMNNAME_BH_NHIF_MEMBER_NAME = "BH_NHIF_MEMBER_NAME";
	/**
	 * Column name NHIF_Number
	 */
	public static final String COLUMNNAME_NHIF_Number = "NHIF_Number";
	/**
	 * Column name bh_nhif_member_id
	 */
	public static final String COLUMNNAME_bh_nhif_member_id = "bh_nhif_member_id";
	/**
	 * Column name bh_nhif_member_name
	 */
	public static final String COLUMNNAME_bh_nhif_member_name = "bh_nhif_member_name";
	/**
	 * Column name BH_NHIF_Type
	 */
	public static final String COLUMNNAME_BH_NHIF_Type = "BH_NHIF_Type";
	public static final String COLUMNAME_TOTAL_OPEN_BALANCE = "TotalOpenBalance";
	public static final String COLUMNNAME_BH_PROCESSING = "BH_processing";
	public static final String COLUMNNAME_BH_TENDER_AMOUNT = "BH_tender_amount";
	public static final String COLUMNNAME_BH_REMAINING_INVOICE_AMOUNT = "BH_RmngInvcAmt";
	public static final String COLUMNNAME_BH_IsServiceDebt = "BH_IsServiceDebt";
	/**
	 * Column name bh_nhif_claim_number
	 */
	public static final String COLUMNNAME_bh_nhif_claim_number = "bh_nhif_claim_number";
	/**
	 * National Scheme = 10000002
	 */
	public static final String BH_NHIF_TYPE_NationalScheme = "10000002";
	/**
	 * Fixed FFS = 10000003
	 */
	public static final String BH_NHIF_TYPE_FixedFFS = "10000003";
	/**
	 * FFS = 10000004
	 */
	public static final String BH_NHIF_TYPE_FFS = "10000004";
	/**
	 * EduAfya FFS = 10000005
	 */
	public static final String BH_NHIF_TYPE_EduAfyaFFS = "10000005";
	/**
	 * Principal Member = P
	 */
	public static final String BH_NHIF_RELATIONSHIP_PrincipalMember = "P";
	/**
	 * Spouse = S
	 */
	public static final String BH_NHIF_RELATIONSHIP_Spouse = "S";
	/**
	 * Child = C
	 */
	public static final String BH_NHIF_RELATIONSHIP_Child = "C";
	private static final long serialVersionUID = 1L;

	public MPayment_BH(Properties ctx, int C_Payment_ID, String trxName) {
		super(ctx, C_Payment_ID, trxName);
	}

	public MPayment_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Copy a payment, typically meant to be done when a visit is reactivated and all old payments are reversed.
	 * Largely copied from {@link MPayment#createCounterDoc()}
	 * @param payment The payment to copy from
	 * @return The new, unsaved payment
	 */
	public MPayment_BH copy() {
		MPayment_BH newPayment = new MPayment_BH(getCtx(), 0, get_TrxName());

		//	Document Type
		int C_DocTypeTarget_ID = getC_DocType_ID();

		//	Deep Copy
		newPayment.setAD_Org_ID(getAD_Org_ID());
		newPayment.setC_BPartner_ID(getC_BPartner_ID());
		newPayment.setIsReceipt(!isReceipt());
		newPayment.setC_DocType_ID(C_DocTypeTarget_ID);
		newPayment.setTrxType(getTrxType());
		newPayment.setTenderType(getTenderType());
		//
		newPayment.setPayAmt(getPayAmt());
		newPayment.setDiscountAmt(getDiscountAmt());
		newPayment.setTaxAmt(getTaxAmt());
		newPayment.setWriteOffAmt(getWriteOffAmt());
		newPayment.setIsOverUnderPayment (isOverUnderPayment());
		newPayment.setOverUnderAmt(getOverUnderAmt());
		newPayment.setC_Currency_ID(getC_Currency_ID());
		newPayment.setC_ConversionType_ID(getC_ConversionType_ID());
		//
		newPayment.setDateTrx (getDateTrx());
		newPayment.setDateAcct (getDateAcct());
		newPayment.setRef_Payment_ID(getC_Payment_ID());
		//
		newPayment.setC_BankAccount_ID(getC_BankAccount_ID());

		//	References
		newPayment.setC_Activity_ID(getC_Activity_ID());
		newPayment.setC_Campaign_ID(getC_Campaign_ID());
		newPayment.setC_Project_ID(getC_Project_ID());
		newPayment.setUser1_ID(getUser1_ID());
		newPayment.setUser2_ID(getUser2_ID());
		newPayment.saveEx(get_TrxName());
		if (log.isLoggable(Level.FINE)) log.fine(newPayment.toString());
		setRef_Payment_ID(newPayment.getC_Payment_ID());

		// Document action typically set to complete, even though we may not be completing it yet
		newPayment.setDocAction(DOCACTION_Complete);

		newPayment.setBH_C_Order_ID(getBH_C_Order_ID());

		return newPayment;
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

	public BigDecimal getBH_TenderAmount() {
		return (BigDecimal) get_Value(COLUMNNAME_BH_TENDER_AMOUNT);
	}

	public void setBH_TenderAmount(BigDecimal amount) {
		set_Value(COLUMNNAME_BH_TENDER_AMOUNT, amount);
	}

	public boolean isBH_IsServiceDebt() {
		Object oo = get_Value(COLUMNNAME_BH_IsServiceDebt);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	public void setBH_IsServiceDebt(boolean BH_IsServiceDebt) {
		set_Value(COLUMNNAME_BH_IsServiceDebt, Boolean.valueOf(BH_IsServiceDebt));
	}

	/**
	 * Get NHIF Type.
	 *
	 * @return Select the type of NHIF the patient is registered with.
	 */
	public String getBH_NHIF_Type() {
		return (String) get_Value(COLUMNNAME_BH_NHIF_Type);
	}

	/**
	 * Set NHIF Type.
	 *
	 * @param BH_NHIF_Type Select the type of NHIF the patient is registered with.
	 */
	public void setBH_NHIF_Type(String BH_NHIF_Type) {

		set_Value(COLUMNNAME_BH_NHIF_Type, BH_NHIF_Type);
	}

	/**
	 * Set NHIF Relationship.
	 *
	 * @param bh_nhif_relationship NHIF Relationship
	 */
	public void setbh_nhif_relationship(String bh_nhif_relationship) {

		set_Value(COLUMNNAME_bh_nhif_relationship, bh_nhif_relationship);
	}

	/**
	 * Get NHIF Relationship.
	 *
	 * @return NHIF Relationship
	 */
	public String getbh_nhif_relationship() {
		return (String) get_Value(COLUMNNAME_bh_nhif_relationship);
	}

	/**
	 * Set NHIF notification/claim number.
	 *
	 * @param bh_nhif_claim_number NHIF notification/claim number
	 */
	public void setbh_nhif_claim_number(String bh_nhif_claim_number) {
		set_Value(COLUMNNAME_bh_nhif_claim_number, bh_nhif_claim_number);
	}

	/**
	 * Get NHIF notification/claim number.
	 *
	 * @return NHIF notification/claim number
	 */
	public String getbh_nhif_claim_number() {
		return (String) get_Value(COLUMNNAME_bh_nhif_claim_number);
	}

	/**
	 * Set Member's ID#.
	 *
	 * @param bh_nhif_member_id Member's ID#
	 */
	public void setbh_nhif_member_id(String bh_nhif_member_id) {
		set_Value(COLUMNNAME_bh_nhif_member_id, bh_nhif_member_id);
	}

	/**
	 * Get Member's ID#.
	 *
	 * @return Member's ID#
	 */
	public String getbh_nhif_member_id() {
		return (String) get_Value(COLUMNNAME_bh_nhif_member_id);
	}

	/**
	 * Set NHIF Member Name.
	 *
	 * @param bh_nhif_member_name NHIF Member Name
	 */
	public void setbh_nhif_member_name(String bh_nhif_member_name) {
		set_Value(COLUMNNAME_bh_nhif_member_name, bh_nhif_member_name);
	}

	/**
	 * Get NHIF Member Name.
	 *
	 * @return NHIF Member Name
	 */
	public String getbh_nhif_member_name() {
		return (String) get_Value(COLUMNNAME_bh_nhif_member_name);
	}

	/**
	 * Get NHIF Number.
	 *
	 * @return Patient National Hospital Insuarance Fund
	 */
	public String getNHIF_Number() {
		return (String) get_Value(COLUMNNAME_NHIF_Number);
	}

	/**
	 * Set NHIF Number.
	 *
	 * @param NHIF_Number Patient National Hospital Insuarance Fund
	 */
	public void setNHIF_Number(String NHIF_Number) {
		set_Value(COLUMNNAME_NHIF_Number, NHIF_Number);
	}
}
