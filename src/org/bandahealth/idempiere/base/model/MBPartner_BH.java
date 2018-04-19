package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.I_C_Location;
import org.compiere.model.MBPartner;
import org.compiere.model.MTable;
import org.compiere.model.X_I_BPartner;

public class MBPartner_BH extends MBPartner {

	/**
	 * Column name BH_ApproximateYears
	 */
	public static final String COLUMNNAME_BH_ApproximateYears = "BH_ApproximateYears";
	/**
	 * Column name BH_Birthday
	 */
	public static final String COLUMNNAME_BH_Birthday = "BH_Birthday";
	/**
	 * Column name BH_C_Location_ID
	 */
	public static final String COLUMNNAME_BH_C_Location_ID = "BH_C_Location_ID";
	/**
	 * Column name BH_EMail
	 */
	public static final String COLUMNNAME_BH_EMail = "BH_EMail";
	/**
	 * Column name BH_IsPatient
	 */
	public static final String COLUMNNAME_BH_IsPatient = "BH_IsPatient";
	/**
	 * Column name BH_Phone
	 */
	public static final String COLUMNNAME_BH_Phone = "BH_Phone";

	public MBPartner_BH(Properties ctx) {
		super(ctx);
	}

	public MBPartner_BH(X_I_BPartner impBP) {
		super(impBP);
	}

	public MBPartner_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MBPartner_BH(Properties ctx, int C_BPartner_ID, String trxName) {
		super(ctx, C_BPartner_ID, trxName);
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		return super.afterSave(newRecord, success);
	}

	@Override
	protected boolean beforeDelete() {
		return super.beforeDelete();
	}

	@Override
	protected boolean afterDelete(boolean success) {
		return super.afterDelete(success);
	}

	/**
	 * Get Approximate Years.
	 *
	 * @return The approximate age of a person.
	 */
	public int getBH_ApproximateYears() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_ApproximateYears);
		if (ii == null) {
			return 0;
		}
		return ii;
	}

	/**
	 * Set Approximate Years.
	 *
	 * @param BH_ApproximateYears The approximate age of a person.
	 */
	public void setBH_ApproximateYears(int BH_ApproximateYears) {
		set_Value(COLUMNNAME_BH_ApproximateYears, BH_ApproximateYears);
	}

	/**
	 * Get Birthday.
	 *
	 * @return Birthday or Anniversary day
	 */
	public Timestamp getBH_Birthday() {
		return (Timestamp) get_Value(COLUMNNAME_BH_Birthday);
	}

	/**
	 * Set Birthday.
	 *
	 * @param BH_Birthday Birthday or Anniversary day
	 */
	public void setBH_Birthday(Timestamp BH_Birthday) {
		set_Value(COLUMNNAME_BH_Birthday, BH_Birthday);
	}

	public I_C_Location getBH_C_Location() throws RuntimeException {
		return (I_C_Location) MTable.get(getCtx(), I_C_Location.Table_Name)
				.getPO(getBH_C_Location_ID(), get_TrxName());
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public int getBH_C_Location_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_C_Location_ID);
		if (ii == null) {
			return 0;
		}
		return ii;
	}

	/**
	 * Set Address.
	 *
	 * @param BH_C_Location_ID Location or Address
	 */
	public void setBH_C_Location_ID(int BH_C_Location_ID) {
		if (BH_C_Location_ID < 1) {
			set_Value(COLUMNNAME_BH_C_Location_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_C_Location_ID, BH_C_Location_ID);
		}
	}

	/**
	 * Get EMail Address.
	 *
	 * @return Electronic Mail Address
	 */
	public String getBH_EMail() {
		return (String) get_Value(COLUMNNAME_BH_EMail);
	}

	/**
	 * Set EMail Address.
	 *
	 * @param BH_EMail Electronic Mail Address
	 */
	public void setBH_EMail(String BH_EMail) {
		set_Value(COLUMNNAME_BH_EMail, BH_EMail);
	}

	/**
	 * Get Patient/Customer.
	 *
	 * @return Indicates if this Business Partner is a Customer
	 */
	public boolean isBH_IsPatient() {
		Object oo = get_Value(COLUMNNAME_BH_IsPatient);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set Patient/Customer.
	 *
	 * @param BH_IsPatient Indicates if this Business Partner is a Customer
	 */
	public void setBH_IsPatient(boolean BH_IsPatient) {
		set_Value(COLUMNNAME_BH_IsPatient, Boolean.valueOf(BH_IsPatient));
	}

	/**
	 * Get Phone.
	 *
	 * @return Identifies a telephone number
	 */
	public String getBH_Phone() {
		return (String) get_Value(COLUMNNAME_BH_Phone);
	}

	/**
	 * Set Phone.
	 *
	 * @param BH_Phone Identifies a telephone number
	 */
	public void setBH_Phone(String BH_Phone) {
		set_Value(COLUMNNAME_BH_Phone, BH_Phone);
	}
}
