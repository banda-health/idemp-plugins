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

/** Generated Model for BH_OrderLine_Charge_Info
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_OrderLine_Charge_Info extends PO implements I_BH_OrderLine_Charge_Info, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210531L;

    /** Standard Constructor */
    public X_BH_OrderLine_Charge_Info (Properties ctx, int BH_OrderLine_Charge_Info_ID, String trxName)
    {
      super (ctx, BH_OrderLine_Charge_Info_ID, trxName);
      /** if (BH_OrderLine_Charge_Info_ID == 0)
        {
			setBH_Charge_Info_ID (0);
			setBH_OrderLine_Charge_Info_ID (0);
			setC_OrderLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_OrderLine_Charge_Info (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_OrderLine_Charge_Info[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public I_BH_Charge_Info getBH_Charge_Info() throws RuntimeException
    {
		return (I_BH_Charge_Info)MTable.get(getCtx(), I_BH_Charge_Info.Table_Name)
			.getPO(getBH_Charge_Info_ID(), get_TrxName());	}

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

	/** Set Order Line Charge Information.
		@param BH_OrderLine_Charge_Info_ID Order Line Charge Information	  */
	public void setBH_OrderLine_Charge_Info_ID (int BH_OrderLine_Charge_Info_ID)
	{
		if (BH_OrderLine_Charge_Info_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_OrderLine_Charge_Info_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_OrderLine_Charge_Info_ID, Integer.valueOf(BH_OrderLine_Charge_Info_ID));
	}

	/** Get Order Line Charge Information.
		@return Order Line Charge Information	  */
	public int getBH_OrderLine_Charge_Info_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_OrderLine_Charge_Info_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_OrderLine_Charge_Info_UU.
		@param BH_OrderLine_Charge_Info_UU BH_OrderLine_Charge_Info_UU	  */
	public void setBH_OrderLine_Charge_Info_UU (String BH_OrderLine_Charge_Info_UU)
	{
		set_Value (COLUMNNAME_BH_OrderLine_Charge_Info_UU, BH_OrderLine_Charge_Info_UU);
	}

	/** Get BH_OrderLine_Charge_Info_UU.
		@return BH_OrderLine_Charge_Info_UU	  */
	public String getBH_OrderLine_Charge_Info_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_OrderLine_Charge_Info_UU);
	}

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
			.getPO(getC_OrderLine_ID(), get_TrxName());	}

	/** Set Sales Order Line.
		@param C_OrderLine_ID 
		Sales Order Line
	  */
	public void setC_OrderLine_ID (int C_OrderLine_ID)
	{
		if (C_OrderLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_OrderLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
	}

	/** Get Sales Order Line.
		@return Sales Order Line
	  */
	public int getC_OrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_OrderLine_ID);
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