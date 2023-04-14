package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.I_C_Location;
import org.compiere.model.MBPartner;
import org.compiere.model.MTable;
import org.compiere.model.X_I_BPartner;
import org.compiere.util.Env;

public class MBPartner_BH extends MBPartner {

	private static final long serialVersionUID = 1L;

	/** Column name BH_ApproximateYears */
	public static final String COLUMNNAME_BH_ApproximateYears = "BH_ApproximateYears";

	/** Column name BH_Birthday */
	public static final String COLUMNNAME_BH_Birthday = "BH_Birthday";

	/** Column name BH_C_Location_ID */
	public static final String COLUMNNAME_BH_C_Location_ID = "BH_C_Location_ID";

	/** Column name BH_EMail */
	public static final String COLUMNNAME_BH_EMail = "BH_EMail";

	/** Column name bh_gender */
	public static final String COLUMNNAME_bh_gender = "bh_gender";
	
	/** Column name BH_IsApproximateDateOfBirth */
	public static final String COLUMNNAME_BH_IsApproximateDateOfBirth = "BH_IsApproximateDateOfBirth";

	/** Column name BH_IsPatient */
	public static final String COLUMNNAME_BH_IsPatient = "BH_IsPatient";
	
	/** Column name bh_nextappointmentdate */
	public static final String COLUMNNAME_bh_nextappointmentdate = "bh_nextappointmentdate";

	/** Column name bh_nhif_member_name */
	public static final String COLUMNNAME_bh_nhif_member_name = "bh_nhif_member_name";

	/** Column name bh_nhif_relationship */
	public static final String COLUMNNAME_bh_nhif_relationship = "bh_nhif_relationship";

	/** Column name BH_NHIF_Type */
	public static final String COLUMNNAME_BH_NHIF_Type = "BH_NHIF_Type";

	/** Column name bh_occupation */
	public static final String COLUMNNAME_bh_occupation = "bh_occupation";

	/** Column name bh_patient_notes */
	public static final String COLUMNNAME_bh_patient_notes = "bh_patient_notes";

	/** Column name BH_PatientID */
	public static final String COLUMNNAME_BH_PatientID = "BH_PatientID";

	/** Column name BH_Phone */
	public static final String COLUMNNAME_BH_Phone = "BH_Phone";

	/** Column name NationalID */
	public static final String COLUMNNAME_NationalID = "NationalID";

	/** Column name NextOfKin_Contact */
	public static final String COLUMNNAME_NextOfKin_Contact = "NextOfKin_Contact";

	/** Column name NextOfKin_Name */
	public static final String COLUMNNAME_NextOfKin_Name = "NextOfKin_Name";

	/** Column name NHIF_Number */
	public static final String COLUMNNAME_NHIF_Number = "NHIF_Number";
	
	/** Column name BH_Local_PatientID */
	public static final String COLUMNNAME_BH_Local_PatientID = "BH_Local_PatientID";
	
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

	/** Get Approx. Years.
	 @return The approximate age of a person.
	 */
	public BigDecimal getBH_ApproximateYears ()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_ApproximateYears);
		if (bd == null)
			return Env.ZERO;
		return bd;
	}

	/** Set Birthday.
	 @param BH_Birthday
	 Birthday or Anniversary day
	 */
	public void setBH_Birthday (Timestamp BH_Birthday)
	{
		set_Value (COLUMNNAME_BH_Birthday, BH_Birthday);
	}

	/** Get Birthday.
	 @return Birthday or Anniversary day
	 */
	public Timestamp getBH_Birthday ()
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_Birthday);
	}

	public I_C_Location getBH_C_Location() throws RuntimeException
	{
		return (I_C_Location)MTable.get(getCtx(), I_C_Location.Table_Name)
				.getPO(getBH_C_Location_ID(), get_TrxName());	}

	/** Set Address.
	 @param BH_C_Location_ID
	 Location or Address
	 */
	public void setBH_C_Location_ID (int BH_C_Location_ID)
	{
		if (BH_C_Location_ID < 1)
			set_Value (COLUMNNAME_BH_C_Location_ID, null);
		else
			set_Value (COLUMNNAME_BH_C_Location_ID, Integer.valueOf(BH_C_Location_ID));
	}

	/** Get Address.
	 @return Location or Address
	 */
	public int getBH_C_Location_ID ()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_C_Location_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/** Set EMail Address.
	 @param BH_EMail
	 Electronic Mail Address
	 */
	public void setBH_EMail (String BH_EMail)
	{
		set_Value (COLUMNNAME_BH_EMail, BH_EMail);
	}

	/** Get EMail Address.
	 @return Electronic Mail Address
	 */
	public String getBH_EMail ()
	{
		return (String)get_Value(COLUMNNAME_BH_EMail);
	}

	/** Set Gender.
	 @param bh_gender Gender	  */
	public void setbh_gender (String bh_gender)
	{

		set_Value (COLUMNNAME_bh_gender, bh_gender);
	}

	/** Get Gender.
	 @return Gender	  */
	public String getbh_gender ()
	{
		return (String)get_Value(COLUMNNAME_bh_gender);
	}

	/** Set Patient/Customer.
	 @param BH_IsPatient
	 Indicates if this Business Partner is a Customer
	 */
	public void setBH_IsPatient (boolean BH_IsPatient)
	{
		set_Value (COLUMNNAME_BH_IsPatient, Boolean.valueOf(BH_IsPatient));
	}

	/** Get Patient/Customer.
	 @return Indicates if this Business Partner is a Customer
	 */
	public boolean isBH_IsPatient ()
	{
		Object oo = get_Value(COLUMNNAME_BH_IsPatient);
		if (oo != null)
		{
			if (oo instanceof Boolean)
				return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Next Appointment Date.
	 @param bh_nextappointmentdate Next Appointment Date	  */
	public void setbh_nextappointmentdate (Timestamp bh_nextappointmentdate)
	{
		set_Value (COLUMNNAME_bh_nextappointmentdate, bh_nextappointmentdate);
	}

	/** Get Next Appointment Date.
	 @return Next Appointment Date	  */
	public Timestamp getbh_nextappointmentdate ()
	{
		return (Timestamp)get_Value(COLUMNNAME_bh_nextappointmentdate);
	}

	/** Set NHIF Member Name.
	 @param bh_nhif_member_name NHIF Member Name	  */
	public void setbh_nhif_member_name (String bh_nhif_member_name)
	{
		set_Value (COLUMNNAME_bh_nhif_member_name, bh_nhif_member_name);
	}

	/** Get NHIF Member Name.
	 @return NHIF Member Name	  */
	public String getbh_nhif_member_name ()
	{
		return (String)get_Value(COLUMNNAME_bh_nhif_member_name);
	}

	/** Set NHIF Relationship.
	 @param bh_nhif_relationship NHIF Relationship	  */
	public void setbh_nhif_relationship (String bh_nhif_relationship)
	{

		set_Value (COLUMNNAME_bh_nhif_relationship, bh_nhif_relationship);
	}

	/** Get NHIF Relationship.
	 @return NHIF Relationship	  */
	public String getbh_nhif_relationship ()
	{
		return (String)get_Value(COLUMNNAME_bh_nhif_relationship);
	}

	/** Set NHIF Type.
	 @param BH_NHIF_Type
	 Select the type of NHIF the patient is registered with.
	 */
	public void setBH_NHIF_Type (String BH_NHIF_Type)
	{

		set_Value (COLUMNNAME_BH_NHIF_Type, BH_NHIF_Type);
	}

	/** Get NHIF Type.
	 @return Select the type of NHIF the patient is registered with.
	 */
	public String getBH_NHIF_Type ()
	{
		return (String)get_Value(COLUMNNAME_BH_NHIF_Type);
	}

	/** Set Occupation.
	 @param bh_occupation Occupation	  */
	public void setbh_occupation (String bh_occupation)
	{
		set_Value (COLUMNNAME_bh_occupation, bh_occupation);
	}

	/** Get Occupation.
	 @return Occupation	  */
	public String getbh_occupation ()
	{
		return (String)get_Value(COLUMNNAME_bh_occupation);
	}

	/** Set Patient Notes.
	 @param bh_patient_notes
	 Optional additional user defined information
	 */
	public void setbh_patient_notes (String bh_patient_notes)
	{
		set_Value (COLUMNNAME_bh_patient_notes, bh_patient_notes);
	}

	/** Get Patient Notes.
	 @return Optional additional user defined information
	 */
	public String getbh_patient_notes ()
	{
		return (String)get_Value(COLUMNNAME_bh_patient_notes);
	}

	/** Set Patient ID.
	 @param BH_PatientID
	 A unique identifier for users to manually enter
	 */
	public void setBH_PatientID (String BH_PatientID)
	{
		set_Value (COLUMNNAME_BH_PatientID, BH_PatientID);
	}

	/** Get Patient ID.
	 @return A unique identifier for users to manually enter
	 */
	public String getBH_PatientID ()
	{
		return (String)get_Value(COLUMNNAME_BH_PatientID);
	}

	/** Set Phone.
	 @param BH_Phone
	 Identifies a telephone number
	 */
	public void setBH_Phone (String BH_Phone)
	{
		set_Value (COLUMNNAME_BH_Phone, BH_Phone);
	}

	/** Get Phone.
	 @return Identifies a telephone number
	 */
	public String getBH_Phone ()
	{
		return (String)get_Value(COLUMNNAME_BH_Phone);
	}

	/** Set NationalID.
	 @param NationalID
	 Patient Identity number
	 */
	public void setNationalID(String NationalID)
	{
		set_Value (COLUMNNAME_NationalID, NationalID);
	}

	/** Get NationalID.
	 @return Patient Identity number
	 */
	public String getNationalID()
	{
		return (String)get_Value(COLUMNNAME_NationalID);
	}

	/** Set Next of Kin Contact.
	 @param NextOfKin_Contact Next of Kin Contact	  */
	public void setNextOfKin_Contact (String NextOfKin_Contact)
	{
		set_Value (COLUMNNAME_NextOfKin_Contact, NextOfKin_Contact);
	}

	/** Get Next of Kin Contact.
	 @return Next of Kin Contact	  */
	public String getNextOfKin_Contact ()
	{
		return (String)get_Value(COLUMNNAME_NextOfKin_Contact);
	}

	/** Set Next of Kin Name.
	 @param NextOfKin_Name Next of Kin Name	  */
	public void setNextOfKin_Name (String NextOfKin_Name)
	{
		set_Value (COLUMNNAME_NextOfKin_Name, NextOfKin_Name);
	}

	/** Get Next of Kin Name.
	 @return Next of Kin Name	  */
	public String getNextOfKin_Name ()
	{
		return (String)get_Value(COLUMNNAME_NextOfKin_Name);
	}

	/** Set NHIF Number.
	 @param NHIF_Number
	 Patient National Hospital Insuarance Fund
	 */
	public void setNHIF_Number (String NHIF_Number)
	{
		set_Value (COLUMNNAME_NHIF_Number, NHIF_Number);
	}

	/** Get NHIF Number.
	 @return Patient National Hospital Insuarance Fund
	 */
	public String getNHIF_Number ()
	{
		return (String)get_Value(COLUMNNAME_NHIF_Number);
	}
	
	/** Set Local Patient ID.
	 @param BH_Local_PatientID
	 A unique identifier for users to manually enter
	 */
	public void setBH_Local_PatientID (String BH_Local_PatientID)
	{
		set_Value (COLUMNNAME_BH_Local_PatientID, BH_Local_PatientID);
	}

	/** Get Patient ID.
	 @return A unique identifier for users to manually enter
	 */
	public String getBH_Local_PatientID ()
	{
		return (String)get_Value(COLUMNNAME_BH_Local_PatientID);
	}
	
	/** Set Is Approximate Date Of Birth.
	@param BH_IsApproximateDateOfBirth Is Approximate Date Of Birth	  */
	public void setBH_IsApproximateDateOfBirth (boolean BH_IsApproximateDateOfBirth)
	{
		set_Value (COLUMNNAME_BH_IsApproximateDateOfBirth, Boolean.valueOf(BH_IsApproximateDateOfBirth));
	}

	/** Get Is Approximate Date Of Birth.
		@return Is Approximate Date Of Birth	  */
	public boolean isBH_IsApproximateDateOfBirth () 
	{
		Object oo = get_Value(COLUMNNAME_BH_IsApproximateDateOfBirth);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}
