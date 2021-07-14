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

/** Generated Model for BH_ChargeDefault
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_ChargeDefault extends PO implements I_BH_ChargeDefault, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210505L;

    /** Standard Constructor */
    public X_BH_ChargeDefault (Properties ctx, int BH_ChargeDefault_ID, String trxName)
    {
      super (ctx, BH_ChargeDefault_ID, trxName);
      /** if (BH_ChargeDefault_ID == 0)
        {
			setBH_ChargeDefault_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_BH_ChargeDefault (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_ChargeDefault[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set BH_ChargeDefault.
		@param BH_ChargeDefault_ID BH_ChargeDefault	  */
	public void setBH_ChargeDefault_ID (int BH_ChargeDefault_ID)
	{
		if (BH_ChargeDefault_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_ChargeDefault_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_ChargeDefault_ID, Integer.valueOf(BH_ChargeDefault_ID));
	}

	/** Get BH_ChargeDefault.
		@return BH_ChargeDefault	  */
	public int getBH_ChargeDefault_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_ChargeDefault_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_ChargeDefault_UU.
		@param BH_ChargeDefault_UU BH_ChargeDefault_UU	  */
	public void setBH_ChargeDefault_UU (String BH_ChargeDefault_UU)
	{
		set_Value (COLUMNNAME_BH_ChargeDefault_UU, BH_ChargeDefault_UU);
	}

	/** Get BH_ChargeDefault_UU.
		@return BH_ChargeDefault_UU	  */
	public String getBH_ChargeDefault_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_ChargeDefault_UU);
	}

	public I_BH_ChargeTypeDefault getBH_ChargeTypeDefault() throws RuntimeException
    {
		return (I_BH_ChargeTypeDefault)MTable.get(getCtx(), I_BH_ChargeTypeDefault.Table_Name)
			.getPO(getBH_ChargeTypeDefault_ID(), get_TrxName());	}

	/** Set Charge Type Default.
		@param BH_ChargeTypeDefault_ID Charge Type Default	  */
	public void setBH_ChargeTypeDefault_ID (int BH_ChargeTypeDefault_ID)
	{
		if (BH_ChargeTypeDefault_ID < 1) 
			set_Value (COLUMNNAME_BH_ChargeTypeDefault_ID, null);
		else 
			set_Value (COLUMNNAME_BH_ChargeTypeDefault_ID, Integer.valueOf(BH_ChargeTypeDefault_ID));
	}

	/** Get Charge Type Default.
		@return Charge Type Default	  */
	public int getBH_ChargeTypeDefault_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_ChargeTypeDefault_ID);
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

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}