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
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for BH_Encounter_Type_Window
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Encounter_Type_Window")
public class X_BH_Encounter_Type_Window extends PO implements I_BH_Encounter_Type_Window, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240326L;

    /** Standard Constructor */
    public X_BH_Encounter_Type_Window (Properties ctx, int BH_Encounter_Type_Window_ID, String trxName)
    {
      super (ctx, BH_Encounter_Type_Window_ID, trxName);
      /** if (BH_Encounter_Type_Window_ID == 0)
        {
			setAD_Window_ID (0);
			setBH_Encounter_Type (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter_Type_Window (Properties ctx, int BH_Encounter_Type_Window_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Encounter_Type_Window_ID, trxName, virtualColumns);
      /** if (BH_Encounter_Type_Window_ID == 0)
        {
			setAD_Window_ID (0);
			setBH_Encounter_Type (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter_Type_Window (Properties ctx, String BH_Encounter_Type_Window_UU, String trxName)
    {
      super (ctx, BH_Encounter_Type_Window_UU, trxName);
      /** if (BH_Encounter_Type_Window_UU == null)
        {
			setAD_Window_ID (0);
			setBH_Encounter_Type (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter_Type_Window (Properties ctx, String BH_Encounter_Type_Window_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Encounter_Type_Window_UU, trxName, virtualColumns);
      /** if (BH_Encounter_Type_Window_UU == null)
        {
			setAD_Window_ID (0);
			setBH_Encounter_Type (null);
        } */
    }

    /** Load Constructor */
    public X_BH_Encounter_Type_Window (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Encounter_Type_Window[")
        .append(get_UUID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Window getAD_Window() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Window)MTable.get(getCtx(), org.compiere.model.I_AD_Window.Table_ID)
			.getPO(getAD_Window_ID(), get_TrxName());
	}

	/** Set Window.
		@param AD_Window_ID Data entry or display window
	*/
	public void setAD_Window_ID (int AD_Window_ID)
	{
		if (AD_Window_ID < 1)
			set_Value (COLUMNNAME_AD_Window_ID, null);
		else
			set_Value (COLUMNNAME_AD_Window_ID, Integer.valueOf(AD_Window_ID));
	}

	/** Get Window.
		@return Data entry or display window
	  */
	public int getAD_Window_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Window_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Chief Complaint = C */
	public static final String BH_ENCOUNTER_TYPE_ChiefComplaint = "C";
	/** Clinical Details = D */
	public static final String BH_ENCOUNTER_TYPE_ClinicalDetails = "D";
	/** Immunizations = I */
	public static final String BH_ENCOUNTER_TYPE_Immunizations = "I";
	/** Diagnosis = m */
	public static final String BH_ENCOUNTER_TYPE_Diagnosis = "m";
	/** Capture Vitals = V */
	public static final String BH_ENCOUNTER_TYPE_CaptureVitals = "V";
	/** Set Encounter Type.
		@param BH_Encounter_Type Encounter Type
	*/
	public void setBH_Encounter_Type (String BH_Encounter_Type)
	{

		set_ValueNoCheck (COLUMNNAME_BH_Encounter_Type, BH_Encounter_Type);
	}

	/** Get Encounter Type.
		@return Encounter Type	  */
	public String getBH_Encounter_Type()
	{
		return (String)get_Value(COLUMNNAME_BH_Encounter_Type);
	}

	/** Set BH_Encounter_Type_Window_UU.
		@param BH_Encounter_Type_Window_UU BH_Encounter_Type_Window_UU
	*/
	public void setBH_Encounter_Type_Window_UU (String BH_Encounter_Type_Window_UU)
	{
		set_Value (COLUMNNAME_BH_Encounter_Type_Window_UU, BH_Encounter_Type_Window_UU);
	}

	/** Get BH_Encounter_Type_Window_UU.
		@return BH_Encounter_Type_Window_UU	  */
	public String getBH_Encounter_Type_Window_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Encounter_Type_Window_UU);
	}
}