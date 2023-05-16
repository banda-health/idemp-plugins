/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_Visit
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BH_Visit extends PO implements I_BH_Visit, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230427L;

    /** Standard Constructor */
    public X_BH_Visit (Properties ctx, int BH_Visit_ID, String trxName)
    {
      super (ctx, BH_Visit_ID, trxName);
      /** if (BH_Visit_ID == 0)
        {
			setBH_Visit_ID (0);
			setDocumentNo (null);
			setName (null);
			setPatient_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Visit (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_BH_Visit[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set BH_BloodPressure.
		@param BH_BloodPressure BH_BloodPressure	  */
	public void setBH_BloodPressure (String BH_BloodPressure)
	{
		set_Value (COLUMNNAME_BH_BloodPressure, BH_BloodPressure);
	}

	/** Get BH_BloodPressure.
		@return BH_BloodPressure	  */
	public String getBH_BloodPressure () 
	{
		return (String)get_Value(COLUMNNAME_BH_BloodPressure);
	}

	/** Set BH_ChiefComplaint.
		@param BH_ChiefComplaint BH_ChiefComplaint	  */
	public void setBH_ChiefComplaint (String BH_ChiefComplaint)
	{
		set_Value (COLUMNNAME_BH_ChiefComplaint, BH_ChiefComplaint);
	}

	/** Get BH_ChiefComplaint.
		@return BH_ChiefComplaint	  */
	public String getBH_ChiefComplaint () 
	{
		return (String)get_Value(COLUMNNAME_BH_ChiefComplaint);
	}

	/** Set Clinical Notes.
		@param BH_ClinicalNotes Clinical Notes	  */
	public void setBH_ClinicalNotes (String BH_ClinicalNotes)
	{
		set_Value (COLUMNNAME_BH_ClinicalNotes, BH_ClinicalNotes);
	}

	/** Get Clinical Notes.
		@return Clinical Notes	  */
	public String getBH_ClinicalNotes () 
	{
		return (String)get_Value(COLUMNNAME_BH_ClinicalNotes);
	}

	/** Set BH_Clinician_User_ID.
		@param BH_Clinician_User_ID 
		BH_Clinician_User_ID
	  */
	public void setBH_Clinician_User_ID (int BH_Clinician_User_ID)
	{
		if (BH_Clinician_User_ID < 1) 
			set_Value (COLUMNNAME_BH_Clinician_User_ID, null);
		else 
			set_Value (COLUMNNAME_BH_Clinician_User_ID, Integer.valueOf(BH_Clinician_User_ID));
	}

	/** Get BH_Clinician_User_ID.
		@return BH_Clinician_User_ID
	  */
	public int getBH_Clinician_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Clinician_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set bh_diastolic_blood_pressure.
		@param bh_diastolic_blood_pressure bh_diastolic_blood_pressure	  */
	public void setbh_diastolic_blood_pressure (int bh_diastolic_blood_pressure)
	{
		set_Value (COLUMNNAME_bh_diastolic_blood_pressure, Integer.valueOf(bh_diastolic_blood_pressure));
	}

	/** Get bh_diastolic_blood_pressure.
		@return bh_diastolic_blood_pressure	  */
	public int getbh_diastolic_blood_pressure () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_bh_diastolic_blood_pressure);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Height.
		@param BH_Height BH_Height	  */
	public void setBH_Height (String BH_Height)
	{
		set_Value (COLUMNNAME_BH_Height, BH_Height);
	}

	/** Get BH_Height.
		@return BH_Height	  */
	public String getBH_Height () 
	{
		return (String)get_Value(COLUMNNAME_BH_Height);
	}

	/** Set Lab Notes.
		@param BH_LabNotes Lab Notes	  */
	public void setBH_LabNotes (String BH_LabNotes)
	{
		set_Value (COLUMNNAME_BH_LabNotes, BH_LabNotes);
	}

	/** Get Lab Notes.
		@return Lab Notes	  */
	public String getBH_LabNotes () 
	{
		return (String)get_Value(COLUMNNAME_BH_LabNotes);
	}

	/** Set New Visit.
		@param BH_NewVisit New Visit	  */
	public void setBH_NewVisit (boolean BH_NewVisit)
	{
		set_Value (COLUMNNAME_BH_NewVisit, Boolean.valueOf(BH_NewVisit));
	}

	/** Get New Visit.
		@return New Visit	  */
	public boolean isBH_NewVisit () 
	{
		Object oo = get_Value(COLUMNNAME_BH_NewVisit);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Oxygen Saturation.
		@param BH_OxygenSaturation Oxygen Saturation	  */
	public void setBH_OxygenSaturation (BigDecimal BH_OxygenSaturation)
	{
		set_Value (COLUMNNAME_BH_OxygenSaturation, BH_OxygenSaturation);
	}

	/** Get Oxygen Saturation.
		@return Oxygen Saturation	  */
	public BigDecimal getBH_OxygenSaturation () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_OxygenSaturation);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Outpatient (OPD) = O */
	public static final String BH_PATIENTTYPE_OutpatientOPD = "O";
	/** Inpatient (IPD) = I */
	public static final String BH_PATIENTTYPE_InpatientIPD = "I";
	/** Antenatal (ANC) = A */
	public static final String BH_PATIENTTYPE_AntenatalANC = "A";
	/** Immunizations = Im */
	public static final String BH_PATIENTTYPE_Immunizations = "Im";
	/** Maternity = M */
	public static final String BH_PATIENTTYPE_Maternity = "M";
	/** Dental = D */
	public static final String BH_PATIENTTYPE_Dental = "D";
	/** Eye Clinic = E */
	public static final String BH_PATIENTTYPE_EyeClinic = "E";
	/** Surgery = S */
	public static final String BH_PATIENTTYPE_Surgery = "S";
	/** Over The Counter (OTC) = ot */
	public static final String BH_PATIENTTYPE_OverTheCounterOTC = "ot";
	/** Set Patient Type.
		@param BH_PatientType Patient Type	  */
	public void setBH_PatientType (String BH_PatientType)
	{

		set_Value (COLUMNNAME_BH_PatientType, BH_PatientType);
	}

	/** Get Patient Type.
		@return Patient Type	  */
	public String getBH_PatientType () 
	{
		return (String)get_Value(COLUMNNAME_BH_PatientType);
	}

	public I_BH_Coded_Diagnosis getBH_PrimaryCodedDiagnosis() throws RuntimeException
    {
		return (I_BH_Coded_Diagnosis)MTable.get(getCtx(), I_BH_Coded_Diagnosis.Table_Name)
			.getPO(getBH_PrimaryCodedDiagnosis_ID(), get_TrxName());	}

	/** Set BH_PrimaryCodedDiagnosis_ID.
		@param BH_PrimaryCodedDiagnosis_ID BH_PrimaryCodedDiagnosis_ID	  */
	public void setBH_PrimaryCodedDiagnosis_ID (int BH_PrimaryCodedDiagnosis_ID)
	{
		if (BH_PrimaryCodedDiagnosis_ID < 1) 
			set_Value (COLUMNNAME_BH_PrimaryCodedDiagnosis_ID, null);
		else 
			set_Value (COLUMNNAME_BH_PrimaryCodedDiagnosis_ID, Integer.valueOf(BH_PrimaryCodedDiagnosis_ID));
	}

	/** Get BH_PrimaryCodedDiagnosis_ID.
		@return BH_PrimaryCodedDiagnosis_ID	  */
	public int getBH_PrimaryCodedDiagnosis_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PrimaryCodedDiagnosis_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set bh_primaryuncodeddiagnosis.
		@param bh_primaryuncodeddiagnosis bh_primaryuncodeddiagnosis	  */
	public void setbh_primaryuncodeddiagnosis (String bh_primaryuncodeddiagnosis)
	{
		set_Value (COLUMNNAME_bh_primaryuncodeddiagnosis, bh_primaryuncodeddiagnosis);
	}

	/** Get bh_primaryuncodeddiagnosis.
		@return bh_primaryuncodeddiagnosis	  */
	public String getbh_primaryuncodeddiagnosis () 
	{
		return (String)get_Value(COLUMNNAME_bh_primaryuncodeddiagnosis);
	}

	/** Clinician = toclinician */
	public static final String BH_PROCESS_STAGE_Clinician = "toclinician";
	/** Cashier = tocashier */
	public static final String BH_PROCESS_STAGE_Cashier = "tocashier";
	/** Lab = tolab */
	public static final String BH_PROCESS_STAGE_Lab = "tolab";
	/** Pharmacy = topharmacy */
	public static final String BH_PROCESS_STAGE_Pharmacy = "topharmacy";
	/** Set BH_Process_Stage.
		@param BH_Process_Stage 
		Drop down field in visits for users to define the process stage
	  */
	public void setBH_Process_Stage (String BH_Process_Stage)
	{

		set_Value (COLUMNNAME_BH_Process_Stage, BH_Process_Stage);
	}

	/** Get BH_Process_Stage.
		@return Drop down field in visits for users to define the process stage
	  */
	public String getBH_Process_Stage () 
	{
		return (String)get_Value(COLUMNNAME_BH_Process_Stage);
	}

	/** Set BH_Pulse.
		@param BH_Pulse BH_Pulse	  */
	public void setBH_Pulse (String BH_Pulse)
	{
		set_Value (COLUMNNAME_BH_Pulse, BH_Pulse);
	}

	/** Get BH_Pulse.
		@return BH_Pulse	  */
	public String getBH_Pulse () 
	{
		return (String)get_Value(COLUMNNAME_BH_Pulse);
	}

	/** Referral from health facilities = hf */
	public static final String BH_REFERRAL_ReferralFromHealthFacilities = "hf";
	/** Referral to other health facility = OHF */
	public static final String BH_REFERRAL_ReferralToOtherHealthFacility = "OHF";
	/** Referral from Community Unit = fcu */
	public static final String BH_REFERRAL_ReferralFromCommunityUnit = "fcu";
	/** Referral to Community Unit = tcu */
	public static final String BH_REFERRAL_ReferralToCommunityUnit = "tcu";
	/** Set Referral.
		@param bh_referral Referral	  */
	public void setbh_referral (String bh_referral)
	{

		set_Value (COLUMNNAME_bh_referral, bh_referral);
	}

	/** Get Referral.
		@return Referral	  */
	public String getbh_referral () 
	{
		return (String)get_Value(COLUMNNAME_bh_referral);
	}

	/** Set Referred From/To.
		@param BH_ReferredFromTo Referred From/To	  */
	public void setBH_ReferredFromTo (String BH_ReferredFromTo)
	{
		set_Value (COLUMNNAME_BH_ReferredFromTo, BH_ReferredFromTo);
	}

	/** Get Referred From/To.
		@return Referred From/To	  */
	public String getBH_ReferredFromTo () 
	{
		return (String)get_Value(COLUMNNAME_BH_ReferredFromTo);
	}

	/** Set BH_RespiratoryRate.
		@param BH_RespiratoryRate BH_RespiratoryRate	  */
	public void setBH_RespiratoryRate (String BH_RespiratoryRate)
	{
		set_Value (COLUMNNAME_BH_RespiratoryRate, BH_RespiratoryRate);
	}

	/** Get BH_RespiratoryRate.
		@return BH_RespiratoryRate	  */
	public String getBH_RespiratoryRate () 
	{
		return (String)get_Value(COLUMNNAME_BH_RespiratoryRate);
	}

	public I_BH_Coded_Diagnosis getbh_secondarycodeddiagnosis() throws RuntimeException
    {
		return (I_BH_Coded_Diagnosis)MTable.get(getCtx(), I_BH_Coded_Diagnosis.Table_Name)
			.getPO(getbh_secondarycodeddiagnosis_ID(), get_TrxName());	}

	/** Set bh_secondarycodeddiagnosis_ID.
		@param bh_secondarycodeddiagnosis_ID bh_secondarycodeddiagnosis_ID	  */
	public void setbh_secondarycodeddiagnosis_ID (int bh_secondarycodeddiagnosis_ID)
	{
		if (bh_secondarycodeddiagnosis_ID < 1) 
			set_Value (COLUMNNAME_bh_secondarycodeddiagnosis_ID, null);
		else 
			set_Value (COLUMNNAME_bh_secondarycodeddiagnosis_ID, Integer.valueOf(bh_secondarycodeddiagnosis_ID));
	}

	/** Get bh_secondarycodeddiagnosis_ID.
		@return bh_secondarycodeddiagnosis_ID	  */
	public int getbh_secondarycodeddiagnosis_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_bh_secondarycodeddiagnosis_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set bh_secondaryuncodeddiagnosis.
		@param bh_secondaryuncodeddiagnosis bh_secondaryuncodeddiagnosis	  */
	public void setbh_secondaryuncodeddiagnosis (String bh_secondaryuncodeddiagnosis)
	{
		set_Value (COLUMNNAME_bh_secondaryuncodeddiagnosis, bh_secondaryuncodeddiagnosis);
	}

	/** Get bh_secondaryuncodeddiagnosis.
		@return bh_secondaryuncodeddiagnosis	  */
	public String getbh_secondaryuncodeddiagnosis () 
	{
		return (String)get_Value(COLUMNNAME_bh_secondaryuncodeddiagnosis);
	}

	/** Set bh_systolic_blood_pressure.
		@param bh_systolic_blood_pressure bh_systolic_blood_pressure	  */
	public void setbh_systolic_blood_pressure (int bh_systolic_blood_pressure)
	{
		set_Value (COLUMNNAME_bh_systolic_blood_pressure, Integer.valueOf(bh_systolic_blood_pressure));
	}

	/** Get bh_systolic_blood_pressure.
		@return bh_systolic_blood_pressure	  */
	public int getbh_systolic_blood_pressure () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_bh_systolic_blood_pressure);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Temperature.
		@param BH_Temperature BH_Temperature	  */
	public void setBH_Temperature (String BH_Temperature)
	{
		set_Value (COLUMNNAME_BH_Temperature, BH_Temperature);
	}

	/** Get BH_Temperature.
		@return BH_Temperature	  */
	public String getBH_Temperature () 
	{
		return (String)get_Value(COLUMNNAME_BH_Temperature);
	}

	/** Set Visit.
		@param BH_Visit_ID Visit	  */
	public void setBH_Visit_ID (int BH_Visit_ID)
	{
		if (BH_Visit_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Visit_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
	}

	/** Get Visit.
		@return Visit	  */
	public int getBH_Visit_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Visit_UU.
		@param BH_Visit_UU BH_Visit_UU	  */
	public void setBH_Visit_UU (String BH_Visit_UU)
	{
		set_Value (COLUMNNAME_BH_Visit_UU, BH_Visit_UU);
	}

	/** Get BH_Visit_UU.
		@return BH_Visit_UU	  */
	public String getBH_Visit_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Visit_UU);
	}

	/** Set Visit Date.
		@param BH_VisitDate Visit Date	  */
	public void setBH_VisitDate (Timestamp BH_VisitDate)
	{
		set_Value (COLUMNNAME_BH_VisitDate, BH_VisitDate);
	}

	/** Get Visit Date.
		@return Visit Date	  */
	public Timestamp getBH_VisitDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_VisitDate);
	}

	public I_BH_Voided_Reason getBH_Voided_Reason() throws RuntimeException
    {
		return (I_BH_Voided_Reason)MTable.get(getCtx(), I_BH_Voided_Reason.Table_Name)
			.getPO(getBH_Voided_Reason_ID(), get_TrxName());	}

	/** Set BH_Voided_Reason_ID.
		@param BH_Voided_Reason_ID BH_Voided_Reason_ID	  */
	public void setBH_Voided_Reason_ID (int BH_Voided_Reason_ID)
	{
		if (BH_Voided_Reason_ID < 1) 
			set_Value (COLUMNNAME_BH_Voided_Reason_ID, null);
		else 
			set_Value (COLUMNNAME_BH_Voided_Reason_ID, Integer.valueOf(BH_Voided_Reason_ID));
	}

	/** Get BH_Voided_Reason_ID.
		@return BH_Voided_Reason_ID	  */
	public int getBH_Voided_Reason_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Voided_Reason_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Weight.
		@param BH_Weight BH_Weight	  */
	public void setBH_Weight (String BH_Weight)
	{
		set_Value (COLUMNNAME_BH_Weight, BH_Weight);
	}

	/** Get BH_Weight.
		@return BH_Weight	  */
	public String getBH_Weight () 
	{
		return (String)get_Value(COLUMNNAME_BH_Weight);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	public org.compiere.model.I_C_BPartner getPatient() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getPatient_ID(), get_TrxName());	}

	/** Set Patient.
		@param Patient_ID 
		The Patient must be a valid business partner.
	  */
	public void setPatient_ID (int Patient_ID)
	{
		if (Patient_ID < 1) 
			set_Value (COLUMNNAME_Patient_ID, null);
		else 
			set_Value (COLUMNNAME_Patient_ID, Integer.valueOf(Patient_ID));
	}

	/** Get Patient.
		@return The Patient must be a valid business partner.
	  */
	public int getPatient_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Patient_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}