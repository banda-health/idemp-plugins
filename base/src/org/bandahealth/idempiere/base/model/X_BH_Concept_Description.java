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

/** Generated Model for BH_Concept_Description
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_Concept_Description extends PO implements I_BH_Concept_Description, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240227L;

    /** Standard Constructor */
    public X_BH_Concept_Description (Properties ctx, int BH_Concept_Description_ID, String trxName)
    {
      super (ctx, BH_Concept_Description_ID, trxName);
      /** if (BH_Concept_Description_ID == 0)
        {
			setBH_Concept_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Concept_Description (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Concept_Description[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Concept Description.
		@param BH_Concept_Description_ID Concept Description	  */
	public void setBH_Concept_Description_ID (int BH_Concept_Description_ID)
	{
		if (BH_Concept_Description_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Concept_Description_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Concept_Description_ID, Integer.valueOf(BH_Concept_Description_ID));
	}

	/** Get Concept Description.
		@return Concept Description	  */
	public int getBH_Concept_Description_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Concept_Description_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Concept Description Type.
		@param BH_Concept_Description_Type Concept Description Type	  */
	public void setBH_Concept_Description_Type (String BH_Concept_Description_Type)
	{
		set_Value (COLUMNNAME_BH_Concept_Description_Type, BH_Concept_Description_Type);
	}

	/** Get Concept Description Type.
		@return Concept Description Type	  */
	public String getBH_Concept_Description_Type () 
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Description_Type);
	}

	/** Set BH_Concept_Description_UU.
		@param BH_Concept_Description_UU BH_Concept_Description_UU	  */
	public void setBH_Concept_Description_UU (String BH_Concept_Description_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Concept_Description_UU, BH_Concept_Description_UU);
	}

	/** Get BH_Concept_Description_UU.
		@return BH_Concept_Description_UU	  */
	public String getBH_Concept_Description_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Description_UU);
	}

	public I_BH_Concept getBH_Concept() throws RuntimeException
    {
		return (I_BH_Concept)MTable.get(getCtx(), I_BH_Concept.Table_Name)
			.getPO(getBH_Concept_ID(), get_TrxName());	}

	/** Set Concept.
		@param BH_Concept_ID Concept	  */
	public void setBH_Concept_ID (int BH_Concept_ID)
	{
		if (BH_Concept_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Concept_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Concept_ID, Integer.valueOf(BH_Concept_ID));
	}

	/** Get Concept.
		@return Concept	  */
	public int getBH_Concept_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Concept Locale.
		@param BH_Concept_Locale Concept Locale	  */
	public void setBH_Concept_Locale (String BH_Concept_Locale)
	{
		set_Value (COLUMNNAME_BH_Concept_Locale, BH_Concept_Locale);
	}

	/** Get Concept Locale.
		@return Concept Locale	  */
	public String getBH_Concept_Locale () 
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Locale);
	}

	/** Set Concept Type.
		@param BH_Concept_Type Concept Type	  */
	public void setBH_Concept_Type (String BH_Concept_Type)
	{
		set_Value (COLUMNNAME_BH_Concept_Type, BH_Concept_Type);
	}

	/** Get Concept Type.
		@return Concept Type	  */
	public String getBH_Concept_Type () 
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Type);
	}

	/** Set BH_External_ID.
		@param BH_External_ID 
		BH_External_ID
	  */
	public void setBH_External_ID (String BH_External_ID)
	{
		set_Value (COLUMNNAME_BH_External_ID, BH_External_ID);
	}

	/** Get BH_External_ID.
		@return BH_External_ID
	  */
	public String getBH_External_ID () 
	{
		return (String)get_Value(COLUMNNAME_BH_External_ID);
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
}