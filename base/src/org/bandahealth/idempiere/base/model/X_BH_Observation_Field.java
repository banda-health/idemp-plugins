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

/** Generated Model for BH_Observation_Field
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="BH_Observation_Field")
public class X_BH_Observation_Field extends PO implements I_BH_Observation_Field, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250127L;

    /** Standard Constructor */
    public X_BH_Observation_Field (Properties ctx, String BH_Observation_Field_UU, String trxName)
    {
      super (ctx, BH_Observation_Field_UU, trxName);
      /** if (BH_Observation_Field_UU == null)
        {
        } */
    }

    /** Standard Constructor */
    public X_BH_Observation_Field (Properties ctx, String BH_Observation_Field_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Observation_Field_UU, trxName, virtualColumns);
      /** if (BH_Observation_Field_UU == null)
        {
        } */
    }

    /** Load Constructor */
    public X_BH_Observation_Field (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 4 - System
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
      StringBuilder sb = new StringBuilder ("X_BH_Observation_Field[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set BMI (kg/m²).
		@param BH_BMI BMI (kg/m²)
	*/
	public void setBH_BMI (BigDecimal BH_BMI)
	{
		set_Value (COLUMNNAME_BH_BMI, BH_BMI);
	}

	/** Get BMI (kg/m²).
		@return BMI (kg/m²)	  */
	public BigDecimal getBH_BMI()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_BMI);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Chief Complaint.
		@param BH_ChiefComplaint Chief Complaint
	*/
	public void setBH_ChiefComplaint (String BH_ChiefComplaint)
	{
		set_Value (COLUMNNAME_BH_ChiefComplaint, BH_ChiefComplaint);
	}

	/** Get Chief Complaint.
		@return Chief Complaint	  */
	public String getBH_ChiefComplaint()
	{
		return (String)get_Value(COLUMNNAME_BH_ChiefComplaint);
	}

	/** Set Clinical Notes.
		@param BH_ClinicalNotes Clinical Notes
	*/
	public void setBH_ClinicalNotes (String BH_ClinicalNotes)
	{
		set_Value (COLUMNNAME_BH_ClinicalNotes, BH_ClinicalNotes);
	}

	/** Get Clinical Notes.
		@return Clinical Notes	  */
	public String getBH_ClinicalNotes()
	{
		return (String)get_Value(COLUMNNAME_BH_ClinicalNotes);
	}

	/** Set Height (cm).
		@param BH_Height Height (cm)
	*/
	public void setBH_Height (String BH_Height)
	{
		set_Value (COLUMNNAME_BH_Height, BH_Height);
	}

	/** Get Height (cm).
		@return Height (cm)	  */
	public String getBH_Height()
	{
		return (String)get_Value(COLUMNNAME_BH_Height);
	}

	/** Set Beginning of Last Menstrual Period.
		@param BH_LMP Beginning of Last Menstrual Period
	*/
	public void setBH_LMP (Timestamp BH_LMP)
	{
		set_Value (COLUMNNAME_BH_LMP, BH_LMP);
	}

	/** Get Beginning of Last Menstrual Period.
		@return Beginning of Last Menstrual Period	  */
	public Timestamp getBH_LMP()
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_LMP);
	}

	/** Set Lab / Imaging Notes.
		@param BH_LabNotes Lab / Imaging Notes
	*/
	public void setBH_LabNotes (String BH_LabNotes)
	{
		set_Value (COLUMNNAME_BH_LabNotes, BH_LabNotes);
	}

	/** Get Lab / Imaging Notes.
		@return Lab / Imaging Notes	  */
	public String getBH_LabNotes()
	{
		return (String)get_Value(COLUMNNAME_BH_LabNotes);
	}

	/** Set Mid-Upper Arm Circumference (mm).
		@param BH_MUAC Mid-Upper Arm Circumference (mm)
	*/
	public void setBH_MUAC (int BH_MUAC)
	{
		set_Value (COLUMNNAME_BH_MUAC, Integer.valueOf(BH_MUAC));
	}

	/** Get Mid-Upper Arm Circumference (mm).
		@return Mid-Upper Arm Circumference (mm)	  */
	public int getBH_MUAC()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_MUAC);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set SPO² (%).
		@param BH_OxygenSaturation SPO² (%)
	*/
	public void setBH_OxygenSaturation (BigDecimal BH_OxygenSaturation)
	{
		set_Value (COLUMNNAME_BH_OxygenSaturation, BH_OxygenSaturation);
	}

	/** Get SPO² (%).
		@return SPO² (%)	  */
	public BigDecimal getBH_OxygenSaturation()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_OxygenSaturation);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Pulse (BPM).
		@param BH_Pulse Pulse (BPM)
	*/
	public void setBH_Pulse (String BH_Pulse)
	{
		set_Value (COLUMNNAME_BH_Pulse, BH_Pulse);
	}

	/** Get Pulse (BPM).
		@return Pulse (BPM)	  */
	public String getBH_Pulse()
	{
		return (String)get_Value(COLUMNNAME_BH_Pulse);
	}

	/** Set Respiratory Rate (RPM).
		@param BH_RespiratoryRate Respiratory Rate (RPM)
	*/
	public void setBH_RespiratoryRate (String BH_RespiratoryRate)
	{
		set_Value (COLUMNNAME_BH_RespiratoryRate, BH_RespiratoryRate);
	}

	/** Get Respiratory Rate (RPM).
		@return Respiratory Rate (RPM)	  */
	public String getBH_RespiratoryRate()
	{
		return (String)get_Value(COLUMNNAME_BH_RespiratoryRate);
	}

	/** Set Temperature (°C).
		@param BH_Temperature Temperature (°C)
	*/
	public void setBH_Temperature (String BH_Temperature)
	{
		set_Value (COLUMNNAME_BH_Temperature, BH_Temperature);
	}

	/** Get Temperature (°C).
		@return Temperature (°C)	  */
	public String getBH_Temperature()
	{
		return (String)get_Value(COLUMNNAME_BH_Temperature);
	}

	/** Set Weight (kg).
		@param BH_Weight Weight (kg)
	*/
	public void setBH_Weight (String BH_Weight)
	{
		set_Value (COLUMNNAME_BH_Weight, BH_Weight);
	}

	/** Get Weight (kg).
		@return Weight (kg)	  */
	public String getBH_Weight()
	{
		return (String)get_Value(COLUMNNAME_BH_Weight);
	}

	/** Set bh_diastolic_blood_pressure.
		@param bh_diastolic_blood_pressure bh_diastolic_blood_pressure
	*/
	public void setbh_diastolic_blood_pressure (int bh_diastolic_blood_pressure)
	{
		set_Value (COLUMNNAME_bh_diastolic_blood_pressure, Integer.valueOf(bh_diastolic_blood_pressure));
	}

	/** Get bh_diastolic_blood_pressure.
		@return bh_diastolic_blood_pressure	  */
	public int getbh_diastolic_blood_pressure()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_bh_diastolic_blood_pressure);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set bh_systolic_blood_pressure.
		@param bh_systolic_blood_pressure bh_systolic_blood_pressure
	*/
	public void setbh_systolic_blood_pressure (int bh_systolic_blood_pressure)
	{
		set_Value (COLUMNNAME_bh_systolic_blood_pressure, Integer.valueOf(bh_systolic_blood_pressure));
	}

	/** Get bh_systolic_blood_pressure.
		@return bh_systolic_blood_pressure	  */
	public int getbh_systolic_blood_pressure()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_bh_systolic_blood_pressure);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}