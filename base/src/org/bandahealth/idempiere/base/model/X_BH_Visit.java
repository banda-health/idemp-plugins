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

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for BH_Visit
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="BH_Visit")
public class X_BH_Visit extends PO implements I_BH_Visit, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240326L;

    /** Standard Constructor */
    public X_BH_Visit (Properties ctx, int BH_Visit_ID, String trxName)
    {
      super (ctx, BH_Visit_ID, trxName);
      /** if (BH_Visit_ID == 0)
        {
			setBH_Visit_ID (0);
			setDocumentNo (null);
			setPatient_ID (0);
			setScheduled (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit (Properties ctx, int BH_Visit_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Visit_ID, trxName, virtualColumns);
      /** if (BH_Visit_ID == 0)
        {
			setBH_Visit_ID (0);
			setDocumentNo (null);
			setPatient_ID (0);
			setScheduled (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit (Properties ctx, String BH_Visit_UU, String trxName)
    {
      super (ctx, BH_Visit_UU, trxName);
      /** if (BH_Visit_UU == null)
        {
			setBH_Visit_ID (0);
			setDocumentNo (null);
			setPatient_ID (0);
			setScheduled (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit (Properties ctx, String BH_Visit_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Visit_UU, trxName, virtualColumns);
      /** if (BH_Visit_UU == null)
        {
			setBH_Visit_ID (0);
			setDocumentNo (null);
			setPatient_ID (0);
			setScheduled (false);
// N
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
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_User getBH_Clinician_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getBH_Clinician_User_ID(), get_TrxName());
	}

	/** Set BH_Clinician_User_ID.
		@param BH_Clinician_User_ID BH_Clinician_User_ID
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
	public int getBH_Clinician_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Clinician_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set New Visit.
		@param BH_NewVisit New Visit
	*/
	public void setBH_NewVisit (boolean BH_NewVisit)
	{
		set_Value (COLUMNNAME_BH_NewVisit, Boolean.valueOf(BH_NewVisit));
	}

	/** Get New Visit.
		@return New Visit	  */
	public boolean isBH_NewVisit()
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

	/** Antenatal (ANC) = A */
	public static final String BH_PATIENTTYPE_AntenatalANC = "A";
	/** Dental = D */
	public static final String BH_PATIENTTYPE_Dental = "D";
	/** Eye Clinic = E */
	public static final String BH_PATIENTTYPE_EyeClinic = "E";
	/** Inpatient (IPD) = I */
	public static final String BH_PATIENTTYPE_InpatientIPD = "I";
	/** Immunizations &amp; Well Child = Im */
	public static final String BH_PATIENTTYPE_ImmunizationsWellChild = "Im";
	/** Maternity = M */
	public static final String BH_PATIENTTYPE_Maternity = "M";
	/** Outpatient (OPD) = O */
	public static final String BH_PATIENTTYPE_OutpatientOPD = "O";
	/** Surgery = S */
	public static final String BH_PATIENTTYPE_Surgery = "S";
	/** Mental Health = Z */
	public static final String BH_PATIENTTYPE_MentalHealth = "Z";
	/** Over The Counter (OTC) = ot */
	public static final String BH_PATIENTTYPE_OverTheCounterOTC = "ot";
	/** Family Planning = u */
	public static final String BH_PATIENTTYPE_FamilyPlanning = "u";
	/** Follow-up = x */
	public static final String BH_PATIENTTYPE_Follow_Up = "x";
	/** PT/OT = y */
	public static final String BH_PATIENTTYPE_PTOT = "y";
	/** Home Visit = z */
	public static final String BH_PATIENTTYPE_HomeVisit = "z";
	/** Mental Health = Z */
	public static final String BH_PATIENTTYPE_MentalHealth = "Z";
	/** Set Patient Type.
		@param BH_PatientType Patient Type
	*/
	public void setBH_PatientType (String BH_PatientType)
	{

		set_Value (COLUMNNAME_BH_PatientType, BH_PatientType);
	}

	/** Get Patient Type.
		@return Patient Type	  */
	public String getBH_PatientType()
	{
		return (String)get_Value(COLUMNNAME_BH_PatientType);
	}

	/** Cashier / Registration = tocashier */
	public static final String BH_PROCESS_STAGE_CashierRegistration = "tocashier";
	/** Clinician / Dentist = toclinician */
	public static final String BH_PROCESS_STAGE_ClinicianDentist = "toclinician";
	/** Lab / Imaging = tolab */
	public static final String BH_PROCESS_STAGE_LabImaging = "tolab";
	/** Pharmacy = topharmacy */
	public static final String BH_PROCESS_STAGE_Pharmacy = "topharmacy";
	/** Triage / Vitals = totriage */
	public static final String BH_PROCESS_STAGE_TriageVitals = "totriage";
	/** Set BH_Process_Stage.
		@param BH_Process_Stage Drop down field in visits for users to define the process stage
	*/
	public void setBH_Process_Stage (String BH_Process_Stage)
	{

		set_Value (COLUMNNAME_BH_Process_Stage, BH_Process_Stage);
	}

	/** Get BH_Process_Stage.
		@return Drop down field in visits for users to define the process stage
	  */
	public String getBH_Process_Stage()
	{
		return (String)get_Value(COLUMNNAME_BH_Process_Stage);
	}

	/** Set Referred From/To.
		@param BH_ReferredFromTo Referred From/To
	*/
	public void setBH_ReferredFromTo (String BH_ReferredFromTo)
	{
		set_Value (COLUMNNAME_BH_ReferredFromTo, BH_ReferredFromTo);
	}

	/** Get Referred From/To.
		@return Referred From/To	  */
	public String getBH_ReferredFromTo()
	{
		return (String)get_Value(COLUMNNAME_BH_ReferredFromTo);
	}

	/** Set Visit Date.
		@param BH_VisitDate Visit Date
	*/
	public void setBH_VisitDate (Timestamp BH_VisitDate)
	{
		set_Value (COLUMNNAME_BH_VisitDate, BH_VisitDate);
	}

	/** Get Visit Date.
		@return Visit Date	  */
	public Timestamp getBH_VisitDate()
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_VisitDate);
	}

	/** Set Visit.
		@param BH_Visit_ID Visit
	*/
	public void setBH_Visit_ID (int BH_Visit_ID)
	{
		if (BH_Visit_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Visit_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
	}

	/** Get Visit.
		@return Visit	  */
	public int getBH_Visit_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Visit_UU.
		@param BH_Visit_UU BH_Visit_UU
	*/
	public void setBH_Visit_UU (String BH_Visit_UU)
	{
		set_Value (COLUMNNAME_BH_Visit_UU, BH_Visit_UU);
	}

	/** Get BH_Visit_UU.
		@return BH_Visit_UU	  */
	public String getBH_Visit_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Visit_UU);
	}

	public I_BH_Voided_Reason getBH_Voided_Reason() throws RuntimeException
	{
		return (I_BH_Voided_Reason)MTable.get(getCtx(), I_BH_Voided_Reason.Table_ID)
			.getPO(getBH_Voided_Reason_ID(), get_TrxName());
	}

	/** Set BH_Voided_Reason_ID.
		@param BH_Voided_Reason_ID BH_Voided_Reason_ID
	*/
	public void setBH_Voided_Reason_ID (int BH_Voided_Reason_ID)
	{
		if (BH_Voided_Reason_ID < 1)
			set_Value (COLUMNNAME_BH_Voided_Reason_ID, null);
		else
			set_Value (COLUMNNAME_BH_Voided_Reason_ID, Integer.valueOf(BH_Voided_Reason_ID));
	}

	/** Get BH_Voided_Reason_ID.
		@return BH_Voided_Reason_ID	  */
	public int getBH_Voided_Reason_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Voided_Reason_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Change Reason.
		@param Change_Reason The reason for changing this entity
	*/
	public void setChange_Reason (String Change_Reason)
	{
		set_Value (COLUMNNAME_Change_Reason, Change_Reason);
	}

	/** Get Change Reason.
		@return The reason for changing this entity
	  */
	public String getChange_Reason()
	{
		return (String)get_Value(COLUMNNAME_Change_Reason);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Document No.
		@param DocumentNo Document sequence number of the document
	*/
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo()
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	public org.compiere.model.I_C_BPartner getPatient() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getPatient_ID(), get_TrxName());
	}

	/** Set Patient.
		@param Patient_ID The Patient must be a valid business partner.
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
	public int getPatient_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Patient_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Scheduled.
		@param Scheduled Whether the entity was scheduled or not
	*/
	public void setScheduled (boolean Scheduled)
	{
		set_Value (COLUMNNAME_Scheduled, Boolean.valueOf(Scheduled));
	}

	/** Get Scheduled.
		@return Whether the entity was scheduled or not
	  */
	public boolean isScheduled()
	{
		Object oo = get_Value(COLUMNNAME_Scheduled);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
}