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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for BH_Voided_Reason
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BH_Voided_Reason extends PO implements I_BH_Voided_Reason, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230425L;

    /** Standard Constructor */
    public X_BH_Voided_Reason (Properties ctx, int BH_Voided_Reason_ID, String trxName)
    {
      super (ctx, BH_Voided_Reason_ID, trxName);
      /** if (BH_Voided_Reason_ID == 0)
        {
			setBH_Voided_Reason_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Voided_Reason (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Voided_Reason[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set BH_Voided_Reason_ID.
		@param BH_Voided_Reason_ID BH_Voided_Reason_ID	  */
	public void setBH_Voided_Reason_ID (int BH_Voided_Reason_ID)
	{
		if (BH_Voided_Reason_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Voided_Reason_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Voided_Reason_ID, Integer.valueOf(BH_Voided_Reason_ID));
	}

	/** Get BH_Voided_Reason_ID.
		@return BH_Voided_Reason_ID	  */
	public int getBH_Voided_Reason_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Voided_Reason_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set bh_voided_reason_uu.
		@param bh_voided_reason_uu bh_voided_reason_uu	  */
	public void setbh_voided_reason_uu (String bh_voided_reason_uu)
	{
		set_Value (COLUMNNAME_bh_voided_reason_uu, bh_voided_reason_uu);
	}

	/** Get bh_voided_reason_uu.
		@return bh_voided_reason_uu	  */
	public String getbh_voided_reason_uu () 
	{
		return (String)get_Value(COLUMNNAME_bh_voided_reason_uu);
	}

	/** Set Window ID.
		@param bh_window_id Window ID	  */
	public void setbh_window_id (BigDecimal bh_window_id)
	{
		set_Value (COLUMNNAME_bh_window_id, bh_window_id);
	}

	/** Get Window ID.
		@return Window ID	  */
	public BigDecimal getbh_window_id () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_bh_window_id);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Line.
		@param LineNo 
		Line No
	  */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
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