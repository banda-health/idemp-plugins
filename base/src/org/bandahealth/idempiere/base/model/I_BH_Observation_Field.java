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

/** Generated Interface for BH_Observation_Field
 *  @author iDempiere (generated) 
 *  @version Release 13
 */
@SuppressWarnings("all")
public interface I_BH_Observation_Field 
{

    /** TableName=BH_Observation_Field */
    public static final String Table_Name = "BH_Observation_Field";

    /** AD_Table_ID=1000045 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 4 - System 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

    /** Load Meta Data */

    /** Column name BH_BMI */
    public static final String COLUMNNAME_BH_BMI = "BH_BMI";

	/** Set BMI (kg/m²)	  */
	public void setBH_BMI (BigDecimal BH_BMI);

	/** Get BMI (kg/m²)	  */
	public BigDecimal getBH_BMI();

    /** Column name BH_ChiefComplaint */
    public static final String COLUMNNAME_BH_ChiefComplaint = "BH_ChiefComplaint";

	/** Set Chief Complaint	  */
	public void setBH_ChiefComplaint (String BH_ChiefComplaint);

	/** Get Chief Complaint	  */
	public String getBH_ChiefComplaint();

    /** Column name BH_ClinicalNotes */
    public static final String COLUMNNAME_BH_ClinicalNotes = "BH_ClinicalNotes";

	/** Set Clinical Notes	  */
	public void setBH_ClinicalNotes (String BH_ClinicalNotes);

	/** Get Clinical Notes	  */
	public String getBH_ClinicalNotes();

    /** Column name BH_Height */
    public static final String COLUMNNAME_BH_Height = "BH_Height";

	/** Set Height (cm)	  */
	public void setBH_Height (String BH_Height);

	/** Get Height (cm)	  */
	public String getBH_Height();

    /** Column name BH_LMP */
    public static final String COLUMNNAME_BH_LMP = "BH_LMP";

	/** Set Beginning of Last Menstrual Period	  */
	public void setBH_LMP (Timestamp BH_LMP);

	/** Get Beginning of Last Menstrual Period	  */
	public Timestamp getBH_LMP();

    /** Column name BH_LabNotes */
    public static final String COLUMNNAME_BH_LabNotes = "BH_LabNotes";

	/** Set Lab / Imaging Notes	  */
	public void setBH_LabNotes (String BH_LabNotes);

	/** Get Lab / Imaging Notes	  */
	public String getBH_LabNotes();

    /** Column name BH_MUAC */
    public static final String COLUMNNAME_BH_MUAC = "BH_MUAC";

	/** Set Mid-Upper Arm Circumference (mm)	  */
	public void setBH_MUAC (int BH_MUAC);

	/** Get Mid-Upper Arm Circumference (mm)	  */
	public int getBH_MUAC();

    /** Column name BH_OxygenSaturation */
    public static final String COLUMNNAME_BH_OxygenSaturation = "BH_OxygenSaturation";

	/** Set SPO² (%)	  */
	public void setBH_OxygenSaturation (BigDecimal BH_OxygenSaturation);

	/** Get SPO² (%)	  */
	public BigDecimal getBH_OxygenSaturation();

    /** Column name BH_Pulse */
    public static final String COLUMNNAME_BH_Pulse = "BH_Pulse";

	/** Set Pulse (BPM)	  */
	public void setBH_Pulse (String BH_Pulse);

	/** Get Pulse (BPM)	  */
	public String getBH_Pulse();

    /** Column name BH_RespiratoryRate */
    public static final String COLUMNNAME_BH_RespiratoryRate = "BH_RespiratoryRate";

	/** Set Respiratory Rate (RPM)	  */
	public void setBH_RespiratoryRate (String BH_RespiratoryRate);

	/** Get Respiratory Rate (RPM)	  */
	public String getBH_RespiratoryRate();

    /** Column name BH_Temperature */
    public static final String COLUMNNAME_BH_Temperature = "BH_Temperature";

	/** Set Temperature (°C)	  */
	public void setBH_Temperature (String BH_Temperature);

	/** Get Temperature (°C)	  */
	public String getBH_Temperature();

    /** Column name BH_Weight */
    public static final String COLUMNNAME_BH_Weight = "BH_Weight";

	/** Set Weight (kg)	  */
	public void setBH_Weight (String BH_Weight);

	/** Get Weight (kg)	  */
	public String getBH_Weight();

    /** Column name bh_diastolic_blood_pressure */
    public static final String COLUMNNAME_bh_diastolic_blood_pressure = "bh_diastolic_blood_pressure";

	/** Set bh_diastolic_blood_pressure	  */
	public void setbh_diastolic_blood_pressure (int bh_diastolic_blood_pressure);

	/** Get bh_diastolic_blood_pressure	  */
	public int getbh_diastolic_blood_pressure();

    /** Column name bh_systolic_blood_pressure */
    public static final String COLUMNNAME_bh_systolic_blood_pressure = "bh_systolic_blood_pressure";

	/** Set bh_systolic_blood_pressure	  */
	public void setbh_systolic_blood_pressure (int bh_systolic_blood_pressure);

	/** Get bh_systolic_blood_pressure	  */
	public int getbh_systolic_blood_pressure();
}
