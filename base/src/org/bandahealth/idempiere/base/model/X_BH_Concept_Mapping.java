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

/** Generated Model for BH_Concept_Mapping
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Concept_Mapping")
public class X_BH_Concept_Mapping extends PO implements I_BH_Concept_Mapping, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241003L;

    /** Standard Constructor */
    public X_BH_Concept_Mapping (Properties ctx, int BH_Concept_Mapping_ID, String trxName)
    {
      super (ctx, BH_Concept_Mapping_ID, trxName);
      /** if (BH_Concept_Mapping_ID == 0)
        {
			setFrom_BH_Concept_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Concept_Mapping (Properties ctx, int BH_Concept_Mapping_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Concept_Mapping_ID, trxName, virtualColumns);
      /** if (BH_Concept_Mapping_ID == 0)
        {
			setFrom_BH_Concept_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Concept_Mapping (Properties ctx, String BH_Concept_Mapping_UU, String trxName)
    {
      super (ctx, BH_Concept_Mapping_UU, trxName);
      /** if (BH_Concept_Mapping_UU == null)
        {
			setFrom_BH_Concept_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Concept_Mapping (Properties ctx, String BH_Concept_Mapping_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Concept_Mapping_UU, trxName, virtualColumns);
      /** if (BH_Concept_Mapping_UU == null)
        {
			setFrom_BH_Concept_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Concept_Mapping (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Concept_Mapping[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Concept Mapping.
		@param BH_Concept_Mapping_ID Concept Mapping
	*/
	public void setBH_Concept_Mapping_ID (int BH_Concept_Mapping_ID)
	{
		if (BH_Concept_Mapping_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Concept_Mapping_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Concept_Mapping_ID, Integer.valueOf(BH_Concept_Mapping_ID));
	}

	/** Get Concept Mapping.
		@return Concept Mapping	  */
	public int getBH_Concept_Mapping_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Concept_Mapping_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Concept_Mapping_UU.
		@param BH_Concept_Mapping_UU BH_Concept_Mapping_UU
	*/
	public void setBH_Concept_Mapping_UU (String BH_Concept_Mapping_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Concept_Mapping_UU, BH_Concept_Mapping_UU);
	}

	/** Get BH_Concept_Mapping_UU.
		@return BH_Concept_Mapping_UU	  */
	public String getBH_Concept_Mapping_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Mapping_UU);
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

	/** Set From Concept Code.
		@param BH_From_Concept_Code From Concept Code
	*/
	public void setBH_From_Concept_Code (String BH_From_Concept_Code)
	{
		set_Value (COLUMNNAME_BH_From_Concept_Code, BH_From_Concept_Code);
	}

	/** Get From Concept Code.
		@return From Concept Code	  */
	public String getBH_From_Concept_Code()
	{
		return (String)get_Value(COLUMNNAME_BH_From_Concept_Code);
	}

	/** Set From Concept Name.
		@param BH_From_Concept_Name From Concept Name
	*/
	public void setBH_From_Concept_Name (String BH_From_Concept_Name)
	{
		set_Value (COLUMNNAME_BH_From_Concept_Name, BH_From_Concept_Name);
	}

	/** Get From Concept Name.
		@return From Concept Name	  */
	public String getBH_From_Concept_Name()
	{
		return (String)get_Value(COLUMNNAME_BH_From_Concept_Name);
	}

	/** Set From Concept Name Resolved.
		@param BH_From_Concept_Name_Resolved From Concept Name Resolved
	*/
	public void setBH_From_Concept_Name_Resolved (String BH_From_Concept_Name_Resolved)
	{
		set_Value (COLUMNNAME_BH_From_Concept_Name_Resolved, BH_From_Concept_Name_Resolved);
	}

	/** Get From Concept Name Resolved.
		@return From Concept Name Resolved	  */
	public String getBH_From_Concept_Name_Resolved()
	{
		return (String)get_Value(COLUMNNAME_BH_From_Concept_Name_Resolved);
	}

	/** Set From Concept Url.
		@param BH_From_Concept_Url From Concept Url
	*/
	public void setBH_From_Concept_Url (String BH_From_Concept_Url)
	{
		set_Value (COLUMNNAME_BH_From_Concept_Url, BH_From_Concept_Url);
	}

	/** Get From Concept Url.
		@return From Concept Url	  */
	public String getBH_From_Concept_Url()
	{
		return (String)get_Value(COLUMNNAME_BH_From_Concept_Url);
	}

	/** Set BH_Map_Type.
		@param BH_Map_Type BH_Map_Type
	*/
	public void setBH_Map_Type (String BH_Map_Type)
	{
		set_Value (COLUMNNAME_BH_Map_Type, BH_Map_Type);
	}

	/** Get BH_Map_Type.
		@return BH_Map_Type
	  */
	public String getBH_Map_Type()
	{
		return (String)get_Value(COLUMNNAME_BH_Map_Type);
	}

	/** Set OCL ID.
		@param BH_OclID A generic ID of type string
	*/
	public void setBH_OclID (String BH_OclID)
	{
		set_Value (COLUMNNAME_BH_OclID, BH_OclID);
	}

	/** Get OCL ID.
		@return A generic ID of type string
	  */
	public String getBH_OclID()
	{
		return (String)get_Value(COLUMNNAME_BH_OclID);
	}

	/** Set BH_Owner.
		@param BH_Owner BH_Owner
	*/
	public void setBH_Owner (String BH_Owner)
	{
		set_Value (COLUMNNAME_BH_Owner, BH_Owner);
	}

	/** Get BH_Owner.
		@return BH_Owner
	  */
	public String getBH_Owner()
	{
		return (String)get_Value(COLUMNNAME_BH_Owner);
	}

	/** Set Source.
		@param BH_Source Source
	*/
	public void setBH_Source (String BH_Source)
	{
		set_Value (COLUMNNAME_BH_Source, BH_Source);
	}

	/** Get Source.
		@return Source
	  */
	public String getBH_Source()
	{
		return (String)get_Value(COLUMNNAME_BH_Source);
	}

	/** Set To Concept Code.
		@param BH_To_Concept_Code To Concept Code
	*/
	public void setBH_To_Concept_Code (String BH_To_Concept_Code)
	{
		set_Value (COLUMNNAME_BH_To_Concept_Code, BH_To_Concept_Code);
	}

	/** Get To Concept Code.
		@return To Concept Code	  */
	public String getBH_To_Concept_Code()
	{
		return (String)get_Value(COLUMNNAME_BH_To_Concept_Code);
	}

	/** Set To Concept Name.
		@param BH_To_Concept_Name To Concept Name
	*/
	public void setBH_To_Concept_Name (String BH_To_Concept_Name)
	{
		set_Value (COLUMNNAME_BH_To_Concept_Name, BH_To_Concept_Name);
	}

	/** Get To Concept Name.
		@return To Concept Name	  */
	public String getBH_To_Concept_Name()
	{
		return (String)get_Value(COLUMNNAME_BH_To_Concept_Name);
	}

	/** Set To Concept Name Resolved.
		@param BH_To_Concept_Name_Resolved To Concept Name Resolved
	*/
	public void setBH_To_Concept_Name_Resolved (String BH_To_Concept_Name_Resolved)
	{
		set_Value (COLUMNNAME_BH_To_Concept_Name_Resolved, BH_To_Concept_Name_Resolved);
	}

	/** Get To Concept Name Resolved.
		@return To Concept Name Resolved	  */
	public String getBH_To_Concept_Name_Resolved()
	{
		return (String)get_Value(COLUMNNAME_BH_To_Concept_Name_Resolved);
	}

	/** Set To Concept Url.
		@param BH_To_Concept_Url To Concept Url
	*/
	public void setBH_To_Concept_Url (String BH_To_Concept_Url)
	{
		set_Value (COLUMNNAME_BH_To_Concept_Url, BH_To_Concept_Url);
	}

	/** Get To Concept Url.
		@return To Concept Url	  */
	public String getBH_To_Concept_Url()
	{
		return (String)get_Value(COLUMNNAME_BH_To_Concept_Url);
	}

	/** Set To Source Name.
		@param BH_To_Source_Name To Source Name
	*/
	public void setBH_To_Source_Name (String BH_To_Source_Name)
	{
		set_Value (COLUMNNAME_BH_To_Source_Name, BH_To_Source_Name);
	}

	/** Get To Source Name.
		@return To Source Name	  */
	public String getBH_To_Source_Name()
	{
		return (String)get_Value(COLUMNNAME_BH_To_Source_Name);
	}

	/** Set From Concept.
		@param From_BH_Concept_ID From Concept
	*/
	public void setFrom_BH_Concept_ID (int From_BH_Concept_ID)
	{
		if (From_BH_Concept_ID < 1)
			set_ValueNoCheck (COLUMNNAME_From_BH_Concept_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_From_BH_Concept_ID, Integer.valueOf(From_BH_Concept_ID));
	}

	/** Get From Concept.
		@return From Concept	  */
	public int getFrom_BH_Concept_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_From_BH_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Ocl Uuid.
		@param Ocl_Uuid A UUID from the OCL system
	*/
	public void setOcl_Uuid (String Ocl_Uuid)
	{
		set_Value (COLUMNNAME_Ocl_Uuid, Ocl_Uuid);
	}

	/** Get Ocl Uuid.
		@return A UUID from the OCL system
	  */
	public String getOcl_Uuid()
	{
		return (String)get_Value(COLUMNNAME_Ocl_Uuid);
	}

	/** Set To Concept.
		@param To_BH_Concept_ID To Concept
	*/
	public void setTo_BH_Concept_ID (int To_BH_Concept_ID)
	{
		if (To_BH_Concept_ID < 1)
			set_ValueNoCheck (COLUMNNAME_To_BH_Concept_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_To_BH_Concept_ID, Integer.valueOf(To_BH_Concept_ID));
	}

	/** Get To Concept.
		@return To Concept	  */
	public int getTo_BH_Concept_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_To_BH_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}