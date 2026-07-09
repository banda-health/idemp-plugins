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

/** Generated Model for BH_Employee_Component
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Employee_Component")
public class X_BH_Employee_Component extends PO implements I_BH_Employee_Component, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260709L;

    /** Standard Constructor */
    public X_BH_Employee_Component (Properties ctx, int BH_Employee_Component_ID, String trxName)
    {
      super (ctx, BH_Employee_Component_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_Employee_Component (Properties ctx, int BH_Employee_Component_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Employee_Component_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_Employee_Component (Properties ctx, String BH_Employee_Component_UU, String trxName)
    {
      super (ctx, BH_Employee_Component_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_Employee_Component (Properties ctx, String BH_Employee_Component_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Employee_Component_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_Employee_Component (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Employee_Component[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Amount.
		@param BH_Amount Amount
	*/
	public void setBH_Amount (BigDecimal BH_Amount)
	{
		set_Value (COLUMNNAME_BH_Amount, BH_Amount);
	}

	/** Get Amount.
		@return Amount	  */
	public BigDecimal getBH_Amount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Employee Payroll Component.
		@param BH_Employee_Component_ID Employee Payroll Component
	*/
	public void setBH_Employee_Component_ID (int BH_Employee_Component_ID)
	{
		if (BH_Employee_Component_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Employee_Component_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Employee_Component_ID, Integer.valueOf(BH_Employee_Component_ID));
	}

	/** Get Employee Payroll Component.
		@return Employee Payroll Component	  */
	public int getBH_Employee_Component_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Employee_Component_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Employee_Component_UU.
		@param BH_Employee_Component_UU BH_Employee_Component_UU
	*/
	public void setBH_Employee_Component_UU (String BH_Employee_Component_UU)
	{
		set_Value (COLUMNNAME_BH_Employee_Component_UU, BH_Employee_Component_UU);
	}

	/** Get BH_Employee_Component_UU.
		@return BH_Employee_Component_UU	  */
	public String getBH_Employee_Component_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Employee_Component_UU);
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

	/** Set Payroll Employee.
		@param HR_Employee_ID Payroll Employee
	*/
	public void setHR_Employee_ID (int HR_Employee_ID)
	{
		if (HR_Employee_ID < 1)
			set_Value (COLUMNNAME_HR_Employee_ID, null);
		else
			set_Value (COLUMNNAME_HR_Employee_ID, Integer.valueOf(HR_Employee_ID));
	}

	/** Get Payroll Employee.
		@return Payroll Employee	  */
	public int getHR_Employee_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Employee_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Valid from.
		@param ValidFrom Valid from including this date (first day)
	*/
	public void setValidFrom (Timestamp ValidFrom)
	{
		set_Value (COLUMNNAME_ValidFrom, ValidFrom);
	}

	/** Get Valid from.
		@return Valid from including this date (first day)
	  */
	public Timestamp getValidFrom()
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidFrom);
	}

	/** Set Valid to.
		@param ValidTo Valid to including this date (last day)
	*/
	public void setValidTo (Timestamp ValidTo)
	{
		set_Value (COLUMNNAME_ValidTo, ValidTo);
	}

	/** Get Valid to.
		@return Valid to including this date (last day)
	  */
	public Timestamp getValidTo()
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidTo);
	}

}
