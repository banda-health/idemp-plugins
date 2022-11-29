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

/** Generated Model for BH_BPartner_Charge_Info
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BH_BPartner_Charge_Info extends PO implements I_BH_BPartner_Charge_Info, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210521L;

    /** Standard Constructor */
    public X_BH_BPartner_Charge_Info (Properties ctx, int BH_BPartner_Charge_Info_ID, String trxName)
    {
      super (ctx, BH_BPartner_Charge_Info_ID, trxName);
      /** if (BH_BPartner_Charge_Info_ID == 0)
        {
			setBH_BPartner_Charge_ID (0);
			setBH_BPartner_Charge_Info_ID (0);
			setBH_Charge_Info_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_BPartner_Charge_Info (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_BPartner_Charge_Info[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public I_BH_BPartner_Charge getBH_BPartner_Charge() throws RuntimeException
    {
		return (I_BH_BPartner_Charge)MTable.get(getCtx(), I_BH_BPartner_Charge.Table_Name)
			.getPO(getBH_BPartner_Charge_ID(), get_TrxName());	}

	/** Set Business Partner Charges.
		@param BH_BPartner_Charge_ID Business Partner Charges	  */
	public void setBH_BPartner_Charge_ID (int BH_BPartner_Charge_ID)
	{
		if (BH_BPartner_Charge_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_BPartner_Charge_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_BPartner_Charge_ID, Integer.valueOf(BH_BPartner_Charge_ID));
	}

	/** Get Business Partner Charges.
		@return Business Partner Charges	  */
	public int getBH_BPartner_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_BPartner_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Business Partner Charge Info.
		@param BH_BPartner_Charge_Info_ID Business Partner Charge Info	  */
	public void setBH_BPartner_Charge_Info_ID (int BH_BPartner_Charge_Info_ID)
	{
		if (BH_BPartner_Charge_Info_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_BPartner_Charge_Info_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_BPartner_Charge_Info_ID, Integer.valueOf(BH_BPartner_Charge_Info_ID));
	}

	/** Get Business Partner Charge Info.
		@return Business Partner Charge Info	  */
	public int getBH_BPartner_Charge_Info_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_BPartner_Charge_Info_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_BPartner_Charge_Info_UU.
		@param BH_BPartner_Charge_Info_UU BH_BPartner_Charge_Info_UU	  */
	public void setBH_BPartner_Charge_Info_UU (String BH_BPartner_Charge_Info_UU)
	{
		set_Value (COLUMNNAME_BH_BPartner_Charge_Info_UU, BH_BPartner_Charge_Info_UU);
	}

	/** Get BH_BPartner_Charge_Info_UU.
		@return BH_BPartner_Charge_Info_UU	  */
	public String getBH_BPartner_Charge_Info_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_BPartner_Charge_Info_UU);
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