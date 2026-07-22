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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_PAYE_Band
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_PAYE_Band")
public class X_BH_PAYE_Band extends PO implements I_BH_PAYE_Band, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260709L;

    /** Standard Constructor */
    public X_BH_PAYE_Band (Properties ctx, int BH_PAYE_Band_ID, String trxName)
    {
      super (ctx, BH_PAYE_Band_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_PAYE_Band (Properties ctx, int BH_PAYE_Band_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_PAYE_Band_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_PAYE_Band (Properties ctx, String BH_PAYE_Band_UU, String trxName)
    {
      super (ctx, BH_PAYE_Band_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_PAYE_Band (Properties ctx, String BH_PAYE_Band_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_PAYE_Band_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_PAYE_Band (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org
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
      StringBuilder sb = new StringBuilder ("X_BH_PAYE_Band[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set PAYE Band.
		@param BH_PAYE_Band_ID PAYE Band
	*/
	public void setBH_PAYE_Band_ID (int BH_PAYE_Band_ID)
	{
		if (BH_PAYE_Band_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_PAYE_Band_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_PAYE_Band_ID, Integer.valueOf(BH_PAYE_Band_ID));
	}

	/** Get PAYE Band.
		@return PAYE Band	  */
	public int getBH_PAYE_Band_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PAYE_Band_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_PAYE_Band_UU.
		@param BH_PAYE_Band_UU BH_PAYE_Band_UU
	*/
	public void setBH_PAYE_Band_UU (String BH_PAYE_Band_UU)
	{
		set_Value (COLUMNNAME_BH_PAYE_Band_UU, BH_PAYE_Band_UU);
	}

	/** Get BH_PAYE_Band_UU.
		@return BH_PAYE_Band_UU	  */
	public String getBH_PAYE_Band_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_PAYE_Band_UU);
	}

	/** Set Payroll Component.
		@param BH_Payroll_Component_ID Payroll Component
	*/
	public void setBH_Payroll_Component_ID (int BH_Payroll_Component_ID)
	{
		if (BH_Payroll_Component_ID < 1)
			set_Value (COLUMNNAME_BH_Payroll_Component_ID, null);
		else
			set_Value (COLUMNNAME_BH_Payroll_Component_ID, Integer.valueOf(BH_Payroll_Component_ID));
	}

	/** Get Payroll Component.
		@return Payroll Component	  */
	public int getBH_Payroll_Component_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Component_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Rate.
		@param BH_Rate Rate
	*/
	public void setBH_Rate (BigDecimal BH_Rate)
	{
		set_Value (COLUMNNAME_BH_Rate, BH_Rate);
	}

	/** Get Rate.
		@return Rate	  */
	public BigDecimal getBH_Rate()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_Rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Upper Limit.
		@param BH_UpperLimit Upper Limit
	*/
	public void setBH_UpperLimit (BigDecimal BH_UpperLimit)
	{
		set_Value (COLUMNNAME_BH_UpperLimit, BH_UpperLimit);
	}

	/** Get Upper Limit.
		@return Upper Limit	  */
	public BigDecimal getBH_UpperLimit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_UpperLimit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Sequence.
		@param SeqNo Method of ordering records; lowest number comes first
	*/
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

}
