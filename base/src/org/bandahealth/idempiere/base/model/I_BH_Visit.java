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
package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for BH_Visit
 *  @author iDempiere (generated) 
 *  @version Release 8.2
 */
@SuppressWarnings("all")
public interface I_BH_Visit 
{

    /** TableName=BH_Visit */
    public static final String Table_Name = "BH_Visit";

    /** AD_Table_ID=1000041 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name BH_BloodPressure */
    public static final String COLUMNNAME_BH_BloodPressure = "BH_BloodPressure";

	/** Set BH_BloodPressure	  */
	public void setBH_BloodPressure (String BH_BloodPressure);

	/** Get BH_BloodPressure	  */
	public String getBH_BloodPressure();

    /** Column name BH_ChiefComplaint */
    public static final String COLUMNNAME_BH_ChiefComplaint = "BH_ChiefComplaint";

	/** Set BH_ChiefComplaint	  */
	public void setBH_ChiefComplaint (String BH_ChiefComplaint);

	/** Get BH_ChiefComplaint	  */
	public String getBH_ChiefComplaint();

    /** Column name BH_ClinicalNotes */
    public static final String COLUMNNAME_BH_ClinicalNotes = "BH_ClinicalNotes";

	/** Set Clinical Notes	  */
	public void setBH_ClinicalNotes (String BH_ClinicalNotes);

	/** Get Clinical Notes	  */
	public String getBH_ClinicalNotes();

    /** Column name BH_Clinician_User_ID */
    public static final String COLUMNNAME_BH_Clinician_User_ID = "BH_Clinician_User_ID";

	/** Set BH_Clinician_User_ID.
	  * BH_Clinician_User_ID
	  */
	public void setBH_Clinician_User_ID (int BH_Clinician_User_ID);

	/** Get BH_Clinician_User_ID.
	  * BH_Clinician_User_ID
	  */
	public int getBH_Clinician_User_ID();

    /** Column name bh_diastolic_blood_pressure */
    public static final String COLUMNNAME_bh_diastolic_blood_pressure = "bh_diastolic_blood_pressure";

	/** Set bh_diastolic_blood_pressure	  */
	public void setbh_diastolic_blood_pressure (int bh_diastolic_blood_pressure);

	/** Get bh_diastolic_blood_pressure	  */
	public int getbh_diastolic_blood_pressure();

    /** Column name BH_Height */
    public static final String COLUMNNAME_BH_Height = "BH_Height";

	/** Set BH_Height	  */
	public void setBH_Height (String BH_Height);

	/** Get BH_Height	  */
	public String getBH_Height();

    /** Column name BH_LabNotes */
    public static final String COLUMNNAME_BH_LabNotes = "BH_LabNotes";

	/** Set Lab Notes	  */
	public void setBH_LabNotes (String BH_LabNotes);

	/** Get Lab Notes	  */
	public String getBH_LabNotes();

    /** Column name BH_NewVisit */
    public static final String COLUMNNAME_BH_NewVisit = "BH_NewVisit";

	/** Set New Visit	  */
	public void setBH_NewVisit (boolean BH_NewVisit);

	/** Get New Visit	  */
	public boolean isBH_NewVisit();

    /** Column name BH_OxygenSaturation */
    public static final String COLUMNNAME_BH_OxygenSaturation = "BH_OxygenSaturation";

	/** Set Oxygen Saturation	  */
	public void setBH_OxygenSaturation (BigDecimal BH_OxygenSaturation);

	/** Get Oxygen Saturation	  */
	public BigDecimal getBH_OxygenSaturation();

    /** Column name BH_PatientType */
    public static final String COLUMNNAME_BH_PatientType = "BH_PatientType";

	/** Set Patient Type	  */
	public void setBH_PatientType (String BH_PatientType);

	/** Get Patient Type	  */
	public String getBH_PatientType();

    /** Column name BH_PrimaryCodedDiagnosis_ID */
    public static final String COLUMNNAME_BH_PrimaryCodedDiagnosis_ID = "BH_PrimaryCodedDiagnosis_ID";

	/** Set BH_PrimaryCodedDiagnosis_ID	  */
	public void setBH_PrimaryCodedDiagnosis_ID (int BH_PrimaryCodedDiagnosis_ID);

	/** Get BH_PrimaryCodedDiagnosis_ID	  */
	public int getBH_PrimaryCodedDiagnosis_ID();

	public I_BH_Coded_Diagnosis getBH_PrimaryCodedDiagnosis() throws RuntimeException;

    /** Column name bh_primaryuncodeddiagnosis */
    public static final String COLUMNNAME_bh_primaryuncodeddiagnosis = "bh_primaryuncodeddiagnosis";

	/** Set bh_primaryuncodeddiagnosis	  */
	public void setbh_primaryuncodeddiagnosis (String bh_primaryuncodeddiagnosis);

	/** Get bh_primaryuncodeddiagnosis	  */
	public String getbh_primaryuncodeddiagnosis();

    /** Column name BH_Process_Stage */
    public static final String COLUMNNAME_BH_Process_Stage = "BH_Process_Stage";

	/** Set BH_Process_Stage.
	  * Drop down field in visits for users to define the process stage
	  */
	public void setBH_Process_Stage (String BH_Process_Stage);

	/** Get BH_Process_Stage.
	  * Drop down field in visits for users to define the process stage
	  */
	public String getBH_Process_Stage();

    /** Column name BH_Pulse */
    public static final String COLUMNNAME_BH_Pulse = "BH_Pulse";

	/** Set BH_Pulse	  */
	public void setBH_Pulse (String BH_Pulse);

	/** Get BH_Pulse	  */
	public String getBH_Pulse();

    /** Column name bh_referral */
    public static final String COLUMNNAME_bh_referral = "bh_referral";

	/** Set Referral	  */
	public void setbh_referral (String bh_referral);

	/** Get Referral	  */
	public String getbh_referral();

    /** Column name BH_ReferredFromTo */
    public static final String COLUMNNAME_BH_ReferredFromTo = "BH_ReferredFromTo";

	/** Set Referred From/To	  */
	public void setBH_ReferredFromTo (String BH_ReferredFromTo);

	/** Get Referred From/To	  */
	public String getBH_ReferredFromTo();

    /** Column name BH_RespiratoryRate */
    public static final String COLUMNNAME_BH_RespiratoryRate = "BH_RespiratoryRate";

	/** Set BH_RespiratoryRate	  */
	public void setBH_RespiratoryRate (String BH_RespiratoryRate);

	/** Get BH_RespiratoryRate	  */
	public String getBH_RespiratoryRate();

    /** Column name bh_secondarycodeddiagnosis_ID */
    public static final String COLUMNNAME_bh_secondarycodeddiagnosis_ID = "bh_secondarycodeddiagnosis_ID";

	/** Set bh_secondarycodeddiagnosis_ID	  */
	public void setbh_secondarycodeddiagnosis_ID (int bh_secondarycodeddiagnosis_ID);

	/** Get bh_secondarycodeddiagnosis_ID	  */
	public int getbh_secondarycodeddiagnosis_ID();

	public I_BH_Coded_Diagnosis getbh_secondarycodeddiagnosis() throws RuntimeException;

    /** Column name bh_secondaryuncodeddiagnosis */
    public static final String COLUMNNAME_bh_secondaryuncodeddiagnosis = "bh_secondaryuncodeddiagnosis";

	/** Set bh_secondaryuncodeddiagnosis	  */
	public void setbh_secondaryuncodeddiagnosis (String bh_secondaryuncodeddiagnosis);

	/** Get bh_secondaryuncodeddiagnosis	  */
	public String getbh_secondaryuncodeddiagnosis();

    /** Column name bh_systolic_blood_pressure */
    public static final String COLUMNNAME_bh_systolic_blood_pressure = "bh_systolic_blood_pressure";

	/** Set bh_systolic_blood_pressure	  */
	public void setbh_systolic_blood_pressure (int bh_systolic_blood_pressure);

	/** Get bh_systolic_blood_pressure	  */
	public int getbh_systolic_blood_pressure();

    /** Column name BH_Temperature */
    public static final String COLUMNNAME_BH_Temperature = "BH_Temperature";

	/** Set BH_Temperature	  */
	public void setBH_Temperature (String BH_Temperature);

	/** Get BH_Temperature	  */
	public String getBH_Temperature();

    /** Column name BH_Visit_ID */
    public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";

	/** Set Visit	  */
	public void setBH_Visit_ID (int BH_Visit_ID);

	/** Get Visit	  */
	public int getBH_Visit_ID();

    /** Column name BH_Visit_UU */
    public static final String COLUMNNAME_BH_Visit_UU = "BH_Visit_UU";

	/** Set BH_Visit_UU	  */
	public void setBH_Visit_UU (String BH_Visit_UU);

	/** Get BH_Visit_UU	  */
	public String getBH_Visit_UU();

    /** Column name BH_VisitDate */
    public static final String COLUMNNAME_BH_VisitDate = "BH_VisitDate";

	/** Set Visit Date	  */
	public void setBH_VisitDate (Timestamp BH_VisitDate);

	/** Get Visit Date	  */
	public Timestamp getBH_VisitDate();

    /** Column name BH_Voided_Reason_ID */
    public static final String COLUMNNAME_BH_Voided_Reason_ID = "BH_Voided_Reason_ID";

	/** Set BH_Voided_Reason_ID	  */
	public void setBH_Voided_Reason_ID (int BH_Voided_Reason_ID);

	/** Get BH_Voided_Reason_ID	  */
	public int getBH_Voided_Reason_ID();

	public I_BH_Voided_Reason getBH_Voided_Reason() throws RuntimeException;

    /** Column name BH_Weight */
    public static final String COLUMNNAME_BH_Weight = "BH_Weight";

	/** Set BH_Weight	  */
	public void setBH_Weight (String BH_Weight);

	/** Get BH_Weight	  */
	public String getBH_Weight();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Patient_ID */
    public static final String COLUMNNAME_Patient_ID = "Patient_ID";

	/** Set Patient.
	  * The Patient must be a valid business partner.
	  */
	public void setPatient_ID (int Patient_ID);

	/** Get Patient.
	  * The Patient must be a valid business partner.
	  */
	public int getPatient_ID();

	public org.compiere.model.I_C_BPartner getPatient() throws RuntimeException;

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
