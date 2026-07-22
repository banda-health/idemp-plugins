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

/** Generated Model for BH_Payroll_Filing
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Payroll_Filing")
public class X_BH_Payroll_Filing extends PO implements I_BH_Payroll_Filing, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260709L;

    /** Standard Constructor */
    public X_BH_Payroll_Filing (Properties ctx, int BH_Payroll_Filing_ID, String trxName)
    {
      super (ctx, BH_Payroll_Filing_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Filing (Properties ctx, int BH_Payroll_Filing_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Filing_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Filing (Properties ctx, String BH_Payroll_Filing_UU, String trxName)
    {
      super (ctx, BH_Payroll_Filing_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Filing (Properties ctx, String BH_Payroll_Filing_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Filing_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_Payroll_Filing (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Payroll_Filing[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Employee Amount.
		@param BH_EmployeeAmount Employee Amount
	*/
	public void setBH_EmployeeAmount (BigDecimal BH_EmployeeAmount)
	{
		set_Value (COLUMNNAME_BH_EmployeeAmount, BH_EmployeeAmount);
	}

	/** Get Employee Amount.
		@return Employee Amount	  */
	public BigDecimal getBH_EmployeeAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_EmployeeAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Employer Amount.
		@param BH_EmployerAmount Employer Amount
	*/
	public void setBH_EmployerAmount (BigDecimal BH_EmployerAmount)
	{
		set_Value (COLUMNNAME_BH_EmployerAmount, BH_EmployerAmount);
	}

	/** Get Employer Amount.
		@return Employer Amount	  */
	public BigDecimal getBH_EmployerAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_EmployerAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Filing Type.
		@param BH_FilingType Filing Type
	*/
	public void setBH_FilingType (String BH_FilingType)
	{
		set_Value (COLUMNNAME_BH_FilingType, BH_FilingType);
	}

	/** Get Filing Type.
		@return Filing Type	  */
	public String getBH_FilingType()
	{
		return (String)get_Value(COLUMNNAME_BH_FilingType);
	}

	/** Set Paid.
		@param BH_IsPaid Paid
	*/
	public void setBH_IsPaid (boolean BH_IsPaid)
	{
		set_Value (COLUMNNAME_BH_IsPaid, Boolean.valueOf(BH_IsPaid));
	}

	/** Get Paid.
		@return Paid	  */
	public boolean isBH_IsPaid()
	{
		Object oo = get_Value(COLUMNNAME_BH_IsPaid);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Paid Date.
		@param BH_PaidDate Paid Date
	*/
	public void setBH_PaidDate (Timestamp BH_PaidDate)
	{
		set_Value (COLUMNNAME_BH_PaidDate, BH_PaidDate);
	}

	/** Get Paid Date.
		@return Paid Date	  */
	public Timestamp getBH_PaidDate()
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_PaidDate);
	}

	/** Set Payment Reference.
		@param BH_PaymentReference Payment Reference
	*/
	public void setBH_PaymentReference (String BH_PaymentReference)
	{
		set_Value (COLUMNNAME_BH_PaymentReference, BH_PaymentReference);
	}

	/** Get Payment Reference.
		@return Payment Reference	  */
	public String getBH_PaymentReference()
	{
		return (String)get_Value(COLUMNNAME_BH_PaymentReference);
	}

	/** Set Payroll Filing.
		@param BH_Payroll_Filing_ID Payroll Filing
	*/
	public void setBH_Payroll_Filing_ID (int BH_Payroll_Filing_ID)
	{
		if (BH_Payroll_Filing_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Filing_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Filing_ID, Integer.valueOf(BH_Payroll_Filing_ID));
	}

	/** Get Payroll Filing.
		@return Payroll Filing	  */
	public int getBH_Payroll_Filing_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Filing_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Payroll_Filing_UU.
		@param BH_Payroll_Filing_UU BH_Payroll_Filing_UU
	*/
	public void setBH_Payroll_Filing_UU (String BH_Payroll_Filing_UU)
	{
		set_Value (COLUMNNAME_BH_Payroll_Filing_UU, BH_Payroll_Filing_UU);
	}

	/** Get BH_Payroll_Filing_UU.
		@return BH_Payroll_Filing_UU	  */
	public String getBH_Payroll_Filing_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Payroll_Filing_UU);
	}

	/** Set Payroll Run.
		@param BH_Payroll_Run_ID Payroll Run
	*/
	public void setBH_Payroll_Run_ID (int BH_Payroll_Run_ID)
	{
		if (BH_Payroll_Run_ID < 1)
			set_Value (COLUMNNAME_BH_Payroll_Run_ID, null);
		else
			set_Value (COLUMNNAME_BH_Payroll_Run_ID, Integer.valueOf(BH_Payroll_Run_ID));
	}

	/** Get Payroll Run.
		@return Payroll Run	  */
	public int getBH_Payroll_Run_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Run_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Total Amount.
		@param BH_TotalAmount Total Amount
	*/
	public void setBH_TotalAmount (BigDecimal BH_TotalAmount)
	{
		set_Value (COLUMNNAME_BH_TotalAmount, BH_TotalAmount);
	}

	/** Get Total Amount.
		@return Total Amount	  */
	public BigDecimal getBH_TotalAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_TotalAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

}
