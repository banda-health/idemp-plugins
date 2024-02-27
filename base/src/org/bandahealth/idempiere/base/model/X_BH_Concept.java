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

/** Generated Model for BH_Concept
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_Concept extends PO implements I_BH_Concept, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240227L;

    /** Standard Constructor */
    public X_BH_Concept (Properties ctx, int BH_Concept_ID, String trxName)
    {
      super (ctx, BH_Concept_ID, trxName);
      /** if (BH_Concept_ID == 0)
        {
			setBH_Concept_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Concept (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Concept[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set bh_concept_class.
		@param bh_concept_class bh_concept_class	  */
	public void setbh_concept_class (String bh_concept_class)
	{
		set_Value (COLUMNNAME_bh_concept_class, bh_concept_class);
	}

	/** Get bh_concept_class.
		@return bh_concept_class	  */
	public String getbh_concept_class () 
	{
		return (String)get_Value(COLUMNNAME_bh_concept_class);
	}

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

	/** Set BH_Concept_UU.
		@param BH_Concept_UU BH_Concept_UU	  */
	public void setBH_Concept_UU (String BH_Concept_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Concept_UU, BH_Concept_UU);
	}

	/** Get BH_Concept_UU.
		@return BH_Concept_UU	  */
	public String getBH_Concept_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_UU);
	}

	/** Set Display Locale.
		@param BH_Display_Locale Display Locale	  */
	public void setBH_Display_Locale (String BH_Display_Locale)
	{
		set_Value (COLUMNNAME_BH_Display_Locale, BH_Display_Locale);
	}

	/** Get Display Locale.
		@return Display Locale	  */
	public String getBH_Display_Locale () 
	{
		return (String)get_Value(COLUMNNAME_BH_Display_Locale);
	}

	/** Set Display Name.
		@param BH_Display_Name Display Name	  */
	public void setBH_Display_Name (int BH_Display_Name)
	{
		set_Value (COLUMNNAME_BH_Display_Name, Integer.valueOf(BH_Display_Name));
	}

	/** Get Display Name.
		@return Display Name	  */
	public int getBH_Display_Name () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Display_Name);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set OCL ID.
		@param BH_OCL_ID 
		A generic ID of type string
	  */
	public void setBH_OCL_ID (String BH_OCL_ID)
	{
		set_Value (COLUMNNAME_BH_OCL_ID, BH_OCL_ID);
	}

	/** Get OCL ID.
		@return A generic ID of type string
	  */
	public String getBH_OCL_ID () 
	{
		return (String)get_Value(COLUMNNAME_BH_OCL_ID);
	}

	/** Set BH_Owner.
		@param BH_Owner 
		BH_Owner
	  */
	public void setBH_Owner (String BH_Owner)
	{
		set_Value (COLUMNNAME_BH_Owner, BH_Owner);
	}

	/** Get BH_Owner.
		@return BH_Owner
	  */
	public String getBH_Owner () 
	{
		return (String)get_Value(COLUMNNAME_BH_Owner);
	}

	/** Set Source.
		@param BH_Source 
		Source
	  */
	public void setBH_Source (String BH_Source)
	{
		set_Value (COLUMNNAME_BH_Source, BH_Source);
	}

	/** Get Source.
		@return Source
	  */
	public String getBH_Source () 
	{
		return (String)get_Value(COLUMNNAME_BH_Source);
	}

	/** Set Data Type.
		@param DataType 
		Type of data
	  */
	public void setDataType (String DataType)
	{
		set_Value (COLUMNNAME_DataType, DataType);
	}

	/** Get Data Type.
		@return Type of data
	  */
	public String getDataType () 
	{
		return (String)get_Value(COLUMNNAME_DataType);
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

	/** Set URL.
		@param URL 
		Full URL address - e.g. http://www.idempiere.org
	  */
	public void setURL (String URL)
	{
		set_ValueNoCheck (COLUMNNAME_URL, URL);
	}

	/** Get URL.
		@return Full URL address - e.g. http://www.idempiere.org
	  */
	public String getURL () 
	{
		return (String)get_Value(COLUMNNAME_URL);
	}
}