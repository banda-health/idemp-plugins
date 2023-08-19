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

/** Generated Model for BH_BP_General_Payer_Info
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BH_BP_General_Payer_Info extends PO implements I_BH_BP_General_Payer_Info, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230815L;

    /** Standard Constructor */
    public X_BH_BP_General_Payer_Info (Properties ctx, int BH_BP_General_Payer_Info_ID, String trxName)
    {
      super (ctx, BH_BP_General_Payer_Info_ID, trxName);
      /** if (BH_BP_General_Payer_Info_ID == 0)
        {
			setBH_BP_General_Payer_Info_ID (0);
			setBH_BP_Payer_Info_ID (0);
			setBH_Payer_Info_Fld_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_BP_General_Payer_Info (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_BP_General_Payer_Info[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Business Partner General Payer Info.
		@param BH_BP_General_Payer_Info_ID Business Partner General Payer Info	  */
	public void setBH_BP_General_Payer_Info_ID (int BH_BP_General_Payer_Info_ID)
	{
		if (BH_BP_General_Payer_Info_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_BP_General_Payer_Info_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_BP_General_Payer_Info_ID, Integer.valueOf(BH_BP_General_Payer_Info_ID));
	}

	/** Get Business Partner General Payer Info.
		@return Business Partner General Payer Info	  */
	public int getBH_BP_General_Payer_Info_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_BP_General_Payer_Info_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_BP_General_Payer_Info_UU.
		@param BH_BP_General_Payer_Info_UU BH_BP_General_Payer_Info_UU	  */
	public void setBH_BP_General_Payer_Info_UU (String BH_BP_General_Payer_Info_UU)
	{
		set_Value (COLUMNNAME_BH_BP_General_Payer_Info_UU, BH_BP_General_Payer_Info_UU);
	}

	/** Get BH_BP_General_Payer_Info_UU.
		@return BH_BP_General_Payer_Info_UU	  */
	public String getBH_BP_General_Payer_Info_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_BP_General_Payer_Info_UU);
	}

	public I_BH_BP_Payer_Info getBH_BP_Payer_Info() throws RuntimeException
    {
		return (I_BH_BP_Payer_Info)MTable.get(getCtx(), I_BH_BP_Payer_Info.Table_Name)
			.getPO(getBH_BP_Payer_Info_ID(), get_TrxName());	}

	/** Set Business Partner Payer Information.
		@param BH_BP_Payer_Info_ID Business Partner Payer Information	  */
	public void setBH_BP_Payer_Info_ID (int BH_BP_Payer_Info_ID)
	{
		if (BH_BP_Payer_Info_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_BP_Payer_Info_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_BP_Payer_Info_ID, Integer.valueOf(BH_BP_Payer_Info_ID));
	}

	/** Get Business Partner Payer Information.
		@return Business Partner Payer Information	  */
	public int getBH_BP_Payer_Info_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_BP_Payer_Info_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_BH_Payer_Info_Fld getBH_Payer_Info_Fld() throws RuntimeException
    {
		return (I_BH_Payer_Info_Fld)MTable.get(getCtx(), I_BH_Payer_Info_Fld.Table_Name)
			.getPO(getBH_Payer_Info_Fld_ID(), get_TrxName());	}

	/** Set Payer Info Field.
		@param BH_Payer_Info_Fld_ID Payer Info Field	  */
	public void setBH_Payer_Info_Fld_ID (int BH_Payer_Info_Fld_ID)
	{
		if (BH_Payer_Info_Fld_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Payer_Info_Fld_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Payer_Info_Fld_ID, Integer.valueOf(BH_Payer_Info_Fld_ID));
	}

	/** Get Payer Info Field.
		@return Payer Info Field	  */
	public int getBH_Payer_Info_Fld_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payer_Info_Fld_ID);
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