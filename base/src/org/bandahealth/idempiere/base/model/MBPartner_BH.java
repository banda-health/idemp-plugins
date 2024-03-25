package org.bandahealth.idempiere.base.model;

import org.compiere.model.MBPartner;
import org.compiere.model.X_I_BPartner;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MBPartner_BH extends MBPartner {

	private static final long serialVersionUID = 1L;

	/**
	 * Column name BH_Birthday
	 */
	public static final String COLUMNNAME_BH_Birthday = "BH_Birthday";

	/**
	 * Column name BH_EMail
	 */
	public static final String COLUMNNAME_BH_EMail = "BH_EMail";

	/**
	 * Column name bh_gender
	 */
	public static final String COLUMNNAME_bh_gender = "bh_gender";

	/**
	 * Column name BH_IsApproximateDateOfBirth
	 */
	public static final String COLUMNNAME_BH_IsApproximateDateOfBirth = "BH_IsApproximateDateOfBirth";

	/**
	 * Column name bh_nextappointmentdate
	 */
	public static final String COLUMNNAME_bh_nextappointmentdate = "bh_nextappointmentdate";

	/**
	 * Column name bh_occupation
	 */
	public static final String COLUMNNAME_bh_occupation = "bh_occupation";

	/**
	 * Column name BH_PatientID
	 */
	public static final String COLUMNNAME_BH_PatientID = "BH_PatientID";

	/**
	 * Column name BH_Phone
	 */
	public static final String COLUMNNAME_BH_Phone = "BH_Phone";

	/**
	 * Column name NationalID
	 */
	public static final String COLUMNNAME_NationalID = "NationalID";

	/**
	 * Column name NextOfKin_Contact
	 */
	public static final String COLUMNNAME_NextOfKin_Contact = "NextOfKin_Contact";

	/**
	 * Column name NextOfKin_Name
	 */
	public static final String COLUMNNAME_NextOfKin_Name = "NextOfKin_Name";

	/**
	 * Column name BH_Local_PatientID
	 */
	public static final String COLUMNNAME_BH_Local_PatientID = "BH_Local_PatientID";

	/**
	 * Column name BH_Locked
	 */
	public static final String COLUMNNAME_BH_Locked = "BH_Locked";

	/**
	 * Female = female
	 */
	public static final String BH_GENDER_Female = "female";
	/**
	 * Male = male
	 */
	public static final String BH_GENDER_Male = "male";

	/**
	 * Column name BH_NeedAdditionalVisitInfo
	 */
	public static final String COLUMNNAME_BH_NeedAdditionalVisitInfo = "BH_NeedAdditionalVisitInfo";

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

	public MBPartner_BH(Properties ctx, String C_BPartner_UU, String trxName) {
		super(ctx, C_BPartner_UU, trxName);
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
	 * Set Birthday.
	 *
	 * @param BH_Birthday Birthday or Anniversary day
	 */
	public void setBH_Birthday(Timestamp BH_Birthday) {
		set_Value(COLUMNNAME_BH_Birthday, BH_Birthday);
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
	 * Set EMail Address.
	 *
	 * @param BH_EMail Electronic Mail Address
	 */
	public void setBH_EMail(String BH_EMail) {
		set_Value(COLUMNNAME_BH_EMail, BH_EMail);
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
	 * Set Gender.
	 *
	 * @param bh_gender Gender
	 */
	public void setbh_gender(String bh_gender) {

		set_Value(COLUMNNAME_bh_gender, bh_gender);
	}

	/**
	 * Get Gender.
	 *
	 * @return Gender
	 */
	public String getbh_gender() {
		return (String) get_Value(COLUMNNAME_bh_gender);
	}

	/**
	 * Set Next Appointment Date.
	 *
	 * @param bh_nextappointmentdate Next Appointment Date
	 */
	public void setbh_nextappointmentdate(Timestamp bh_nextappointmentdate) {
		set_Value(COLUMNNAME_bh_nextappointmentdate, bh_nextappointmentdate);
	}

	/**
	 * Get Next Appointment Date.
	 *
	 * @return Next Appointment Date
	 */
	public Timestamp getbh_nextappointmentdate() {
		return (Timestamp) get_Value(COLUMNNAME_bh_nextappointmentdate);
	}

	/**
	 * Set Occupation.
	 *
	 * @param bh_occupation Occupation
	 */
	public void setbh_occupation(String bh_occupation) {
		set_Value(COLUMNNAME_bh_occupation, bh_occupation);
	}

	/**
	 * Get Occupation.
	 *
	 * @return Occupation
	 */
	public String getbh_occupation() {
		return (String) get_Value(COLUMNNAME_bh_occupation);
	}

	/**
	 * Set Patient ID.
	 *
	 * @param BH_PatientID A unique identifier for users to manually enter
	 */
	public void setBH_PatientID(String BH_PatientID) {
		set_Value(COLUMNNAME_BH_PatientID, BH_PatientID);
	}

	/**
	 * Get Patient ID.
	 *
	 * @return A unique identifier for users to manually enter
	 */
	public String getBH_PatientID() {
		return (String) get_Value(COLUMNNAME_BH_PatientID);
	}

	/**
	 * Set Phone.
	 *
	 * @param BH_Phone Identifies a telephone number
	 */
	public void setBH_Phone(String BH_Phone) {
		set_Value(COLUMNNAME_BH_Phone, BH_Phone);
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
	 * Set NationalID.
	 *
	 * @param NationalID Patient Identity number
	 */
	public void setNationalID(String NationalID) {
		set_Value(COLUMNNAME_NationalID, NationalID);
	}

	/**
	 * Get NationalID.
	 *
	 * @return Patient Identity number
	 */
	public String getNationalID() {
		return (String) get_Value(COLUMNNAME_NationalID);
	}

	/**
	 * Set Next of Kin Contact.
	 *
	 * @param NextOfKin_Contact Next of Kin Contact
	 */
	public void setNextOfKin_Contact(String NextOfKin_Contact) {
		set_Value(COLUMNNAME_NextOfKin_Contact, NextOfKin_Contact);
	}

	/**
	 * Get Next of Kin Contact.
	 *
	 * @return Next of Kin Contact
	 */
	public String getNextOfKin_Contact() {
		return (String) get_Value(COLUMNNAME_NextOfKin_Contact);
	}

	/**
	 * Set Next of Kin Name.
	 *
	 * @param NextOfKin_Name Next of Kin Name
	 */
	public void setNextOfKin_Name(String NextOfKin_Name) {
		set_Value(COLUMNNAME_NextOfKin_Name, NextOfKin_Name);
	}

	/**
	 * Get Next of Kin Name.
	 *
	 * @return Next of Kin Name
	 */
	public String getNextOfKin_Name() {
		return (String) get_Value(COLUMNNAME_NextOfKin_Name);
	}

	/**
	 * Set Local Patient ID.
	 *
	 * @param BH_Local_PatientID A unique identifier for users to manually enter
	 */
	public void setBH_Local_PatientID(String BH_Local_PatientID) {
		set_Value(COLUMNNAME_BH_Local_PatientID, BH_Local_PatientID);
	}

	/**
	 * Get Patient ID.
	 *
	 * @return A unique identifier for users to manually enter
	 */
	public String getBH_Local_PatientID() {
		return (String) get_Value(COLUMNNAME_BH_Local_PatientID);
	}

	/**
	 * Set Is Approximate Date Of Birth.
	 *
	 * @param BH_IsApproximateDateOfBirth Is Approximate Date Of Birth
	 */
	public void setBH_IsApproximateDateOfBirth(boolean BH_IsApproximateDateOfBirth) {
		set_Value(COLUMNNAME_BH_IsApproximateDateOfBirth, Boolean.valueOf(BH_IsApproximateDateOfBirth));
	}

	/**
	 * Get Is Approximate Date Of Birth.
	 *
	 * @return Is Approximate Date Of Birth
	 */
	public boolean isBH_IsApproximateDateOfBirth() {
		Object oo = get_Value(COLUMNNAME_BH_IsApproximateDateOfBirth);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set Need Additional Visit Info.
	 *
	 * @param BH_NeedAdditionalVisitInfo Need Additional Visit Info
	 */
	public void setBH_NeedAdditionalVisitInfo(boolean BH_NeedAdditionalVisitInfo) {
		set_Value(COLUMNNAME_BH_NeedAdditionalVisitInfo, Boolean.valueOf(BH_NeedAdditionalVisitInfo));
	}

	/**
	 * Get Need Additional Visit Info.
	 *
	 * @return Need Additional Visit Info
	 */
	public boolean isBH_NeedAdditionalVisitInfo() {
		Object oo = get_Value(COLUMNNAME_BH_NeedAdditionalVisitInfo);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to
	 *                   read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked) {
		set_Value(COLUMNNAME_BH_Locked, Boolean.valueOf(BH_Locked));
	}

	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from
	 * this field)
	 */
	public boolean isBH_Locked() {
		Object oo = get_Value(COLUMNNAME_BH_Locked);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
}
