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

/** Generated Model for BH_Concept_Name
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Concept_Name")
public class X_BH_Concept_Name extends PO implements I_BH_Concept_Name, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241003L;

    /** Standard Constructor */
    public X_BH_Concept_Name (Properties ctx, int BH_Concept_Name_ID, String trxName)
    {
      super (ctx, BH_Concept_Name_ID, trxName);
      /** if (BH_Concept_Name_ID == 0)
        {
			setBH_Concept_ID (0);
			setBH_Concept_Locale_Preferred (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Concept_Name (Properties ctx, int BH_Concept_Name_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Concept_Name_ID, trxName, virtualColumns);
      /** if (BH_Concept_Name_ID == 0)
        {
			setBH_Concept_ID (0);
			setBH_Concept_Locale_Preferred (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Concept_Name (Properties ctx, String BH_Concept_Name_UU, String trxName)
    {
      super (ctx, BH_Concept_Name_UU, trxName);
      /** if (BH_Concept_Name_UU == null)
        {
			setBH_Concept_ID (0);
			setBH_Concept_Locale_Preferred (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Concept_Name (Properties ctx, String BH_Concept_Name_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Concept_Name_UU, trxName, virtualColumns);
      /** if (BH_Concept_Name_UU == null)
        {
			setBH_Concept_ID (0);
			setBH_Concept_Locale_Preferred (false);
// N
        } */
    }

    /** Load Constructor */
    public X_BH_Concept_Name (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Concept_Name[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public I_BH_Concept getBH_Concept() throws RuntimeException
	{
		return (I_BH_Concept)MTable.get(getCtx(), I_BH_Concept.Table_ID)
			.getPO(getBH_Concept_ID(), get_TrxName());
	}

	/** Set Concept.
		@param BH_Concept_ID Concept
	*/
	public void setBH_Concept_ID (int BH_Concept_ID)
	{
		if (BH_Concept_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Concept_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Concept_ID, Integer.valueOf(BH_Concept_ID));
	}

	/** Get Concept.
		@return Concept	  */
	public int getBH_Concept_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Concept Locale.
		@param BH_Concept_Locale Concept Locale
	*/
	public void setBH_Concept_Locale (String BH_Concept_Locale)
	{
		set_Value (COLUMNNAME_BH_Concept_Locale, BH_Concept_Locale);
	}

	/** Get Concept Locale.
		@return Concept Locale	  */
	public String getBH_Concept_Locale()
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Locale);
	}

	/** Set Locale Preferred.
		@param BH_Concept_Locale_Preferred Locale Preferred
	*/
	public void setBH_Concept_Locale_Preferred (boolean BH_Concept_Locale_Preferred)
	{
		set_Value (COLUMNNAME_BH_Concept_Locale_Preferred, Boolean.valueOf(BH_Concept_Locale_Preferred));
	}

	/** Get Locale Preferred.
		@return Locale Preferred	  */
	public boolean isBH_Concept_Locale_Preferred()
	{
		Object oo = get_Value(COLUMNNAME_BH_Concept_Locale_Preferred);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Concept Name.
		@param BH_Concept_Name_ID Concept Name
	*/
	public void setBH_Concept_Name_ID (int BH_Concept_Name_ID)
	{
		if (BH_Concept_Name_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Concept_Name_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Concept_Name_ID, Integer.valueOf(BH_Concept_Name_ID));
	}

	/** Get Concept Name.
		@return Concept Name	  */
	public int getBH_Concept_Name_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Concept_Name_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Concept Name Type.
		@param BH_Concept_Name_Type Concept Name Type
	*/
	public void setBH_Concept_Name_Type (String BH_Concept_Name_Type)
	{
		set_Value (COLUMNNAME_BH_Concept_Name_Type, BH_Concept_Name_Type);
	}

	/** Get Concept Name Type.
		@return Concept Name Type	  */
	public String getBH_Concept_Name_Type()
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Name_Type);
	}

	/** Set BH_Concept_Name_UU.
		@param BH_Concept_Name_UU BH_Concept_Name_UU
	*/
	public void setBH_Concept_Name_UU (String BH_Concept_Name_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Concept_Name_UU, BH_Concept_Name_UU);
	}

	/** Get BH_Concept_Name_UU.
		@return BH_Concept_Name_UU	  */
	public String getBH_Concept_Name_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Name_UU);
	}

	/** Set Concept Type.
		@param BH_Concept_Type Concept Type
	*/
	public void setBH_Concept_Type (String BH_Concept_Type)
	{
		set_Value (COLUMNNAME_BH_Concept_Type, BH_Concept_Type);
	}

	/** Get Concept Type.
		@return Concept Type	  */
	public String getBH_Concept_Type()
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Type);
	}

	/** Set BH_ExternalID.
		@param BH_ExternalID BH_External_ID
	*/
	public void setBH_ExternalID (String BH_ExternalID)
	{
		set_Value (COLUMNNAME_BH_ExternalID, BH_ExternalID);
	}

	/** Get BH_ExternalID.
		@return BH_External_ID
	  */
	public String getBH_ExternalID()
	{
		return (String)get_Value(COLUMNNAME_BH_ExternalID);
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

	/** Set Ocl Uuid.
		@param Ocl_Uuid A UUID from the OCL System
	*/
	public void setOcl_Uuid (String Ocl_Uuid)
	{
		set_Value (COLUMNNAME_Ocl_Uuid, Ocl_Uuid);
	}

	/** Get Ocl Uuid.
		@return A UUID from the OCL System
	  */
	public String getOcl_Uuid()
	{
		return (String)get_Value(COLUMNNAME_Ocl_Uuid);
	}
}