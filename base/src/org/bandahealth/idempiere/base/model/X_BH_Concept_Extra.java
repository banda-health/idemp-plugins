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

/** Generated Model for BH_Concept_Extra
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_Concept_Extra extends PO implements I_BH_Concept_Extra, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240227L;

    /** Standard Constructor */
    public X_BH_Concept_Extra (Properties ctx, int BH_Concept_Extra_ID, String trxName)
    {
      super (ctx, BH_Concept_Extra_ID, trxName);
      /** if (BH_Concept_Extra_ID == 0)
        {
        } */
    }

    /** Load Constructor */
    public X_BH_Concept_Extra (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Concept_Extra[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Concept Extra.
		@param BH_Concept_Extra_ID Concept Extra	  */
	public void setBH_Concept_Extra_ID (int BH_Concept_Extra_ID)
	{
		if (BH_Concept_Extra_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Concept_Extra_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Concept_Extra_ID, Integer.valueOf(BH_Concept_Extra_ID));
	}

	/** Get Concept Extra.
		@return Concept Extra	  */
	public int getBH_Concept_Extra_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Concept_Extra_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Concept_Extra_UU.
		@param BH_Concept_Extra_UU BH_Concept_Extra_UU	  */
	public void setBH_Concept_Extra_UU (String BH_Concept_Extra_UU)
	{
		set_ValueNoCheck (COLUMNNAME_BH_Concept_Extra_UU, BH_Concept_Extra_UU);
	}

	/** Get BH_Concept_Extra_UU.
		@return BH_Concept_Extra_UU	  */
	public String getBH_Concept_Extra_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Concept_Extra_UU);
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

	/** Set Key.
		@param BH_Key Key	  */
	public void setBH_Key (String BH_Key)
	{
		set_Value (COLUMNNAME_BH_Key, BH_Key);
	}

	/** Get Key.
		@return Key	  */
	public String getBH_Key () 
	{
		return (String)get_Value(COLUMNNAME_BH_Key);
	}

	/** Set BH_Value.
		@param BH_Value 
		BH_Value
	  */
	public void setBH_Value (String BH_Value)
	{
		set_Value (COLUMNNAME_BH_Value, BH_Value);
	}

	/** Get BH_Value.
		@return BH_Value
	  */
	public String getBH_Value () 
	{
		return (String)get_Value(COLUMNNAME_BH_Value);
	}
}