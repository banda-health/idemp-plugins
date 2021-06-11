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
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_Charge_Info
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_Charge_Info extends PO implements I_BH_Charge_Info, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210505L;

    /** Standard Constructor */
    public X_BH_Charge_Info (Properties ctx, int BH_Charge_Info_ID, String trxName)
    {
      super (ctx, BH_Charge_Info_ID, trxName);
      /** if (BH_Charge_Info_ID == 0)
        {
			setBH_Charge_Info_ID (0);
			setBH_ChargeInfoDataType (null);
// T
			setBH_FillFromPatient (false);
// N
			setC_Charge_ID (0);
			setLine (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_Charge_Info (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
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
      StringBuilder sb = new StringBuilder ("X_BH_Charge_Info[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Charge Info.
		@param BH_Charge_Info_ID Charge Info	  */
	public void setBH_Charge_Info_ID (int BH_Charge_Info_ID)
	{
		if (BH_Charge_Info_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Charge_Info_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Charge_Info_ID, Integer.valueOf(BH_Charge_Info_ID));
	}

	/** Get Charge Info.
		@return Charge Info	  */
	public int getBH_Charge_Info_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Charge_Info_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Charge_Info_UU.
		@param BH_Charge_Info_UU BH_Charge_Info_UU	  */
	public void setBH_Charge_Info_UU (String BH_Charge_Info_UU)
	{
		set_Value (COLUMNNAME_BH_Charge_Info_UU, BH_Charge_Info_UU);
	}

	/** Get BH_Charge_Info_UU.
		@return BH_Charge_Info_UU	  */
	public String getBH_Charge_Info_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Charge_Info_UU);
	}

	/** Text = T */
	public static final String BH_CHARGEINFODATATYPE_Text = "T";
	/** List = L */
	public static final String BH_CHARGEINFODATATYPE_List = "L";
	/** Set Charge Info Data Type.
		@param BH_ChargeInfoDataType Charge Info Data Type	  */
	public void setBH_ChargeInfoDataType (String BH_ChargeInfoDataType)
	{

		set_Value (COLUMNNAME_BH_ChargeInfoDataType, BH_ChargeInfoDataType);
	}

	/** Get Charge Info Data Type.
		@return Charge Info Data Type	  */
	public String getBH_ChargeInfoDataType () 
	{
		return (String)get_Value(COLUMNNAME_BH_ChargeInfoDataType);
	}

	/** Set Fill From Patient.
		@param BH_FillFromPatient Fill From Patient	  */
	public void setBH_FillFromPatient (boolean BH_FillFromPatient)
	{
		set_Value (COLUMNNAME_BH_FillFromPatient, Boolean.valueOf(BH_FillFromPatient));
	}

	/** Get Fill From Patient.
		@return Fill From Patient	  */
	public boolean isBH_FillFromPatient () 
	{
		Object oo = get_Value(COLUMNNAME_BH_FillFromPatient);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getC_Charge_ID(), get_TrxName());	}

	/** Set Charge.
		@param C_Charge_ID 
		Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Charge_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}

	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Line No.
		@param Line 
		Unique line for this document
	  */
	public void setLine (int Line)
	{
		set_Value (COLUMNNAME_Line, Integer.valueOf(Line));
	}

	/** Get Line No.
		@return Unique line for this document
	  */
	public int getLine () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
}