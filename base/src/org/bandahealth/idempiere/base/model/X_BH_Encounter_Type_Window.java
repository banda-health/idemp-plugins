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
 *  @version Release 7.1 - $Id$ */
public class X_BH_Encounter_Type_Window extends PO implements I_BH_Encounter_Type_Window, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230721L;

    /** Standard Constructor */
    public X_BH_Encounter_Type_Window (Properties ctx, int BH_Encounter_Type_Window_ID, String trxName)
    {
      super (ctx, BH_Encounter_Type_Window_ID, trxName);
      /** if (BH_Encounter_Type_Window_ID == 0)
        {
			setBH_Encounter_Type_Window_ID (0);
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
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Window getAD_Window() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Window)MTable.get(getCtx(), org.compiere.model.I_AD_Window.Table_Name)
			.getPO(getAD_Window_ID(), get_TrxName());	}

	/** Set Window.
		@param AD_Window_ID 
		Data entry or display window
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
	public int getAD_Window_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Window_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Immunizations = i */
	public static final String BH_ENCOUNTERTYPE_Immunizations = "i";
	/** Capture Vitals = l */
	public static final String BH_ENCOUNTERTYPE_CaptureVitals = "l";
	/** Diagnosis = m */
	public static final String BH_ENCOUNTERTYPE_Diagnosis = "m";
	/** Set Encounter Type.
		@param BH_EncounterType Encounter Type	  */
	public void setBH_EncounterType (String BH_EncounterType)
	{

		set_ValueNoCheck (COLUMNNAME_BH_EncounterType, BH_EncounterType);
	}

	/** Get Encounter Type.
		@return Encounter Type	  */
	public String getBH_EncounterType () 
	{
		return (String)get_Value(COLUMNNAME_BH_EncounterType);
	}

	/** Set Encounter Type Window.
		@param BH_Encounter_Type_Window_ID Encounter Type Window	  */
	public void setBH_Encounter_Type_Window_ID (int BH_Encounter_Type_Window_ID)
	{
		if (BH_Encounter_Type_Window_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Encounter_Type_Window_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Encounter_Type_Window_ID, Integer.valueOf(BH_Encounter_Type_Window_ID));
	}

	/** Get Encounter Type Window.
		@return Encounter Type Window	  */
	public int getBH_Encounter_Type_Window_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Encounter_Type_Window_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Encounter_Type_Window_UU.
		@param BH_Encounter_Type_Window_UU BH_Encounter_Type_Window_UU	  */
	public void setBH_Encounter_Type_Window_UU (String BH_Encounter_Type_Window_UU)
	{
		set_Value (COLUMNNAME_BH_Encounter_Type_Window_UU, BH_Encounter_Type_Window_UU);
	}

	/** Get BH_Encounter_Type_Window_UU.
		@return BH_Encounter_Type_Window_UU	  */
	public String getBH_Encounter_Type_Window_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Encounter_Type_Window_UU);
	}
}