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

/** Generated Model for BH_Payroll_Settings
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Payroll_Settings")
public class X_BH_Payroll_Settings extends PO implements I_BH_Payroll_Settings, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260719L;

    /** Standard Constructor */
    public X_BH_Payroll_Settings (Properties ctx, int BH_Payroll_Settings_ID, String trxName)
    {
      super (ctx, BH_Payroll_Settings_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Settings (Properties ctx, int BH_Payroll_Settings_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Settings_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Settings (Properties ctx, String BH_Payroll_Settings_UU, String trxName)
    {
      super (ctx, BH_Payroll_Settings_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Settings (Properties ctx, String BH_Payroll_Settings_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Settings_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_Payroll_Settings (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Payroll_Settings[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Pay Day.
		@param BH_PayDay Pay Day
	*/
	public void setBH_PayDay (int BH_PayDay)
	{
		set_Value (COLUMNNAME_BH_PayDay, Integer.valueOf(BH_PayDay));
	}

	/** Get Pay Day.
		@return Pay Day	  */
	public int getBH_PayDay()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PayDay);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Payroll Month.
		@param BH_PayrollMonth Payroll Month
	*/
	public void setBH_PayrollMonth (int BH_PayrollMonth)
	{
		set_Value (COLUMNNAME_BH_PayrollMonth, Integer.valueOf(BH_PayrollMonth));
	}

	/** Get Payroll Month.
		@return Payroll Month	  */
	public int getBH_PayrollMonth()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PayrollMonth);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Payroll Year.
		@param BH_PayrollYear Payroll Year
	*/
	public void setBH_PayrollYear (int BH_PayrollYear)
	{
		set_Value (COLUMNNAME_BH_PayrollYear, Integer.valueOf(BH_PayrollYear));
	}

	/** Get Payroll Year.
		@return Payroll Year	  */
	public int getBH_PayrollYear()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PayrollYear);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Payroll Settings.
		@param BH_Payroll_Settings_ID Payroll Settings
	*/
	public void setBH_Payroll_Settings_ID (int BH_Payroll_Settings_ID)
	{
		if (BH_Payroll_Settings_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Settings_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Settings_ID, Integer.valueOf(BH_Payroll_Settings_ID));
	}

	/** Get Payroll Settings.
		@return Payroll Settings	  */
	public int getBH_Payroll_Settings_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Settings_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Payroll_Settings_UU.
		@param BH_Payroll_Settings_UU BH_Payroll_Settings_UU
	*/
	public void setBH_Payroll_Settings_UU (String BH_Payroll_Settings_UU)
	{
		set_Value (COLUMNNAME_BH_Payroll_Settings_UU, BH_Payroll_Settings_UU);
	}

	/** Get BH_Payroll_Settings_UU.
		@return BH_Payroll_Settings_UU	  */
	public String getBH_Payroll_Settings_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Payroll_Settings_UU);
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
        return new KeyNamePair(get_ID(), String.valueOf(getName()));
    }
}
