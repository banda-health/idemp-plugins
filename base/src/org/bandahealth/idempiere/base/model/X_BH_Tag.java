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

/** Generated Model for BH_Tag
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Tag")
public class X_BH_Tag extends PO implements I_BH_Tag, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250508L;

    /** Standard Constructor */
    public X_BH_Tag (Properties ctx, int BH_Tag_ID, String trxName)
    {
      super (ctx, BH_Tag_ID, trxName);
      /** if (BH_Tag_ID == 0)
        {
			setBH_Tag_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Tag (Properties ctx, int BH_Tag_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Tag_ID, trxName, virtualColumns);
      /** if (BH_Tag_ID == 0)
        {
			setBH_Tag_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Tag (Properties ctx, String BH_Tag_UU, String trxName)
    {
      super (ctx, BH_Tag_UU, trxName);
      /** if (BH_Tag_UU == null)
        {
			setBH_Tag_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Tag (Properties ctx, String BH_Tag_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Tag_UU, trxName, virtualColumns);
      /** if (BH_Tag_UU == null)
        {
			setBH_Tag_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_Tag (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Tag[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set ColourCode.
		@param BH_ColourCode ColourCode
	*/
	public void setBH_ColourCode (String BH_ColourCode)
	{
		set_Value (COLUMNNAME_BH_ColourCode, BH_ColourCode);
	}

	/** Get ColourCode.
		@return ColourCode	  */
	public String getBH_ColourCode()
	{
		return (String)get_Value(COLUMNNAME_BH_ColourCode);
	}

	/** Set BH Tag.
		@param BH_Tag_ID BH Tag
	*/
	public void setBH_Tag_ID (int BH_Tag_ID)
	{
		if (BH_Tag_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Tag_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Tag_ID, Integer.valueOf(BH_Tag_ID));
	}

	/** Get BH Tag.
		@return BH Tag	  */
	public int getBH_Tag_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Tag_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Tag_UU.
		@param BH_Tag_UU BH_Tag_UU
	*/
	public void setBH_Tag_UU (String BH_Tag_UU)
	{
		set_Value (COLUMNNAME_BH_Tag_UU, BH_Tag_UU);
	}

	/** Get BH_Tag_UU.
		@return BH_Tag_UU	  */
	public String getBH_Tag_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Tag_UU);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
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