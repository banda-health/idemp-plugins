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

/** Generated Model for BH_Coded_Diagnosis_Mapping
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BH_Coded_Diagnosis_Mapping extends PO implements I_BH_Coded_Diagnosis_Mapping, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240111L;

    /** Standard Constructor */
    public X_BH_Coded_Diagnosis_Mapping (Properties ctx, int BH_Coded_Diagnosis_Mapping_ID, String trxName)
    {
      super (ctx, BH_Coded_Diagnosis_Mapping_ID, trxName);
      /** if (BH_Coded_Diagnosis_Mapping_ID == 0)
        {
			setBH_Coded_Diagnosis_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Coded_Diagnosis_Mapping (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Coded_Diagnosis_Mapping[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_BH_Coded_Diagnosis getBH_Coded_Diagnosis() throws RuntimeException
    {
		return (I_BH_Coded_Diagnosis)MTable.get(getCtx(), I_BH_Coded_Diagnosis.Table_Name)
			.getPO(getBH_Coded_Diagnosis_ID(), get_TrxName());	}

	/** Set Coded Diagnosis.
		@param BH_Coded_Diagnosis_ID Coded Diagnosis	  */
	public void setBH_Coded_Diagnosis_ID (int BH_Coded_Diagnosis_ID)
	{
		if (BH_Coded_Diagnosis_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Coded_Diagnosis_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Coded_Diagnosis_ID, Integer.valueOf(BH_Coded_Diagnosis_ID));
	}

	/** Get Coded Diagnosis.
		@return Coded Diagnosis	  */
	public int getBH_Coded_Diagnosis_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Coded_Diagnosis_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Coded Diagnosis Mapping ID.
		@param BH_Coded_Diagnosis_Mapping_ID 
		Coded Diagnosis Mapping ID
	  */
	public void setBH_Coded_Diagnosis_Mapping_ID (int BH_Coded_Diagnosis_Mapping_ID)
	{
		if (BH_Coded_Diagnosis_Mapping_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Coded_Diagnosis_Mapping_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Coded_Diagnosis_Mapping_ID, Integer.valueOf(BH_Coded_Diagnosis_Mapping_ID));
	}

	/** Get Coded Diagnosis Mapping ID.
		@return Coded Diagnosis Mapping ID
	  */
	public int getBH_Coded_Diagnosis_Mapping_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Coded_Diagnosis_Mapping_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Coded_Diagnosis_Mapping_UU.
		@param BH_Coded_Diagnosis_Mapping_UU BH_Coded_Diagnosis_Mapping_UU	  */
	public void setBH_Coded_Diagnosis_Mapping_UU (String BH_Coded_Diagnosis_Mapping_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Coded_Diagnosis_Mapping_UU, BH_Coded_Diagnosis_Mapping_UU);
	}

	/** Get BH_Coded_Diagnosis_Mapping_UU.
		@return BH_Coded_Diagnosis_Mapping_UU	  */
	public String getBH_Coded_Diagnosis_Mapping_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Coded_Diagnosis_Mapping_UU);
	}

	/** Set BH_Concept_Code.
		@param BH_Concept_Code 
		BH_Concept_Code
	  */
	public void setBH_Concept_Code (String BH_Concept_Code)
	{
		set_Value (COLUMNNAME_BH_Concept_Code, BH_Concept_Code);
	}

	/** Get BH_Concept_Code.
		@return BH_Concept_Code
	  */
	public String getBH_Concept_Code () 
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Code);
	}

	/** Set BH_Concept_Name_Resolved.
		@param BH_Concept_Name_Resolved 
		BH_Concept_Name_Resolved
	  */
	public void setBH_Concept_Name_Resolved (String BH_Concept_Name_Resolved)
	{
		set_Value (COLUMNNAME_BH_Concept_Name_Resolved, BH_Concept_Name_Resolved);
	}

	/** Get BH_Concept_Name_Resolved.
		@return BH_Concept_Name_Resolved
	  */
	public String getBH_Concept_Name_Resolved () 
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Name_Resolved);
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

	/** Set BH_Map_Type.
		@param BH_Map_Type 
		BH_Map_Type
	  */
	public void setBH_Map_Type (String BH_Map_Type)
	{
		set_Value (COLUMNNAME_BH_Map_Type, BH_Map_Type);
	}

	/** Get BH_Map_Type.
		@return BH_Map_Type
	  */
	public String getBH_Map_Type () 
	{
		return (String)get_Value(COLUMNNAME_BH_Map_Type);
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
}