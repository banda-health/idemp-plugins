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

/** Generated Model for BH_Payroll_Run_Line
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Payroll_Run_Line")
public class X_BH_Payroll_Run_Line extends PO implements I_BH_Payroll_Run_Line, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260709L;

    /** Standard Constructor */
    public X_BH_Payroll_Run_Line (Properties ctx, int BH_Payroll_Run_Line_ID, String trxName)
    {
      super (ctx, BH_Payroll_Run_Line_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run_Line (Properties ctx, int BH_Payroll_Run_Line_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Run_Line_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run_Line (Properties ctx, String BH_Payroll_Run_Line_UU, String trxName)
    {
      super (ctx, BH_Payroll_Run_Line_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run_Line (Properties ctx, String BH_Payroll_Run_Line_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Run_Line_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_Payroll_Run_Line (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Payroll_Run_Line[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Basic Salary.
		@param BH_BasicSalary Basic Salary
	*/
	public void setBH_BasicSalary (BigDecimal BH_BasicSalary)
	{
		set_Value (COLUMNNAME_BH_BasicSalary, BH_BasicSalary);
	}

	/** Get Basic Salary.
		@return Basic Salary	  */
	public BigDecimal getBH_BasicSalary()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_BasicSalary);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Cost To Employer.
		@param BH_CostToEmployer Cost To Employer
	*/
	public void setBH_CostToEmployer (BigDecimal BH_CostToEmployer)
	{
		set_Value (COLUMNNAME_BH_CostToEmployer, BH_CostToEmployer);
	}

	/** Get Cost To Employer.
		@return Cost To Employer	  */
	public BigDecimal getBH_CostToEmployer()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_CostToEmployer);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Employee Name.
		@param BH_EmployeeName Employee Name
	*/
	public void setBH_EmployeeName (String BH_EmployeeName)
	{
		set_Value (COLUMNNAME_BH_EmployeeName, BH_EmployeeName);
	}

	/** Get Employee Name.
		@return Employee Name	  */
	public String getBH_EmployeeName()
	{
		return (String)get_Value(COLUMNNAME_BH_EmployeeName);
	}

	/** Set Gross Pay.
		@param BH_GrossPay Gross Pay
	*/
	public void setBH_GrossPay (BigDecimal BH_GrossPay)
	{
		set_Value (COLUMNNAME_BH_GrossPay, BH_GrossPay);
	}

	/** Get Gross Pay.
		@return Gross Pay	  */
	public BigDecimal getBH_GrossPay()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_GrossPay);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set House Allowance.
		@param BH_HouseAllowance House Allowance
	*/
	public void setBH_HouseAllowance (BigDecimal BH_HouseAllowance)
	{
		set_Value (COLUMNNAME_BH_HouseAllowance, BH_HouseAllowance);
	}

	/** Get House Allowance.
		@return House Allowance	  */
	public BigDecimal getBH_HouseAllowance()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_HouseAllowance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set KRA PIN.
		@param BH_KRA_PIN KRA PIN
	*/
	public void setBH_KRA_PIN (String BH_KRA_PIN)
	{
		set_Value (COLUMNNAME_BH_KRA_PIN, BH_KRA_PIN);
	}

	/** Get KRA PIN.
		@return KRA PIN	  */
	public String getBH_KRA_PIN()
	{
		return (String)get_Value(COLUMNNAME_BH_KRA_PIN);
	}

	/** Set Net Pay.
		@param BH_NetPay Net Pay
	*/
	public void setBH_NetPay (BigDecimal BH_NetPay)
	{
		set_Value (COLUMNNAME_BH_NetPay, BH_NetPay);
	}

	/** Get Net Pay.
		@return Net Pay	  */
	public BigDecimal getBH_NetPay()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_NetPay);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set NSSF Number.
		@param BH_NSSF_Number NSSF Number
	*/
	public void setBH_NSSF_Number (String BH_NSSF_Number)
	{
		set_Value (COLUMNNAME_BH_NSSF_Number, BH_NSSF_Number);
	}

	/** Get NSSF Number.
		@return NSSF Number	  */
	public String getBH_NSSF_Number()
	{
		return (String)get_Value(COLUMNNAME_BH_NSSF_Number);
	}

	/** Set PAYE Amount.
		@param BH_PAYE_Amount PAYE Amount
	*/
	public void setBH_PAYE_Amount (BigDecimal BH_PAYE_Amount)
	{
		set_Value (COLUMNNAME_BH_PAYE_Amount, BH_PAYE_Amount);
	}

	/** Get PAYE Amount.
		@return PAYE Amount	  */
	public BigDecimal getBH_PAYE_Amount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_PAYE_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Payroll Run Line.
		@param BH_Payroll_Run_Line_ID Payroll Run Line
	*/
	public void setBH_Payroll_Run_Line_ID (int BH_Payroll_Run_Line_ID)
	{
		if (BH_Payroll_Run_Line_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Run_Line_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Run_Line_ID, Integer.valueOf(BH_Payroll_Run_Line_ID));
	}

	/** Get Payroll Run Line.
		@return Payroll Run Line	  */
	public int getBH_Payroll_Run_Line_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Run_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Payroll_Run_Line_UU.
		@param BH_Payroll_Run_Line_UU BH_Payroll_Run_Line_UU
	*/
	public void setBH_Payroll_Run_Line_UU (String BH_Payroll_Run_Line_UU)
	{
		set_Value (COLUMNNAME_BH_Payroll_Run_Line_UU, BH_Payroll_Run_Line_UU);
	}

	/** Get BH_Payroll_Run_Line_UU.
		@return BH_Payroll_Run_Line_UU	  */
	public String getBH_Payroll_Run_Line_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Payroll_Run_Line_UU);
	}

	/** Set Payslip Number.
		@param BH_PayslipNumber Payslip Number
	*/
	public void setBH_PayslipNumber (String BH_PayslipNumber)
	{
		set_Value (COLUMNNAME_BH_PayslipNumber, BH_PayslipNumber);
	}

	/** Get Payslip Number.
		@return Payslip Number	  */
	public String getBH_PayslipNumber()
	{
		return (String)get_Value(COLUMNNAME_BH_PayslipNumber);
	}

	/** Set SHIF Number.
		@param BH_SHIF_Number SHIF Number
	*/
	public void setBH_SHIF_Number (String BH_SHIF_Number)
	{
		set_Value (COLUMNNAME_BH_SHIF_Number, BH_SHIF_Number);
	}

	/** Get SHIF Number.
		@return SHIF Number	  */
	public String getBH_SHIF_Number()
	{
		return (String)get_Value(COLUMNNAME_BH_SHIF_Number);
	}

	/** Set Taxable Pay.
		@param BH_TaxablePay Taxable Pay
	*/
	public void setBH_TaxablePay (BigDecimal BH_TaxablePay)
	{
		set_Value (COLUMNNAME_BH_TaxablePay, BH_TaxablePay);
	}

	/** Get Taxable Pay.
		@return Taxable Pay	  */
	public BigDecimal getBH_TaxablePay()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_TaxablePay);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total Deductions.
		@param BH_TotalDeductions Total Deductions
	*/
	public void setBH_TotalDeductions (BigDecimal BH_TotalDeductions)
	{
		set_Value (COLUMNNAME_BH_TotalDeductions, BH_TotalDeductions);
	}

	/** Get Total Deductions.
		@return Total Deductions	  */
	public BigDecimal getBH_TotalDeductions()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_TotalDeductions);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Transport Allowance.
		@param BH_TransportAllowance Transport Allowance
	*/
	public void setBH_TransportAllowance (BigDecimal BH_TransportAllowance)
	{
		set_Value (COLUMNNAME_BH_TransportAllowance, BH_TransportAllowance);
	}

	/** Get Transport Allowance.
		@return Transport Allowance	  */
	public BigDecimal getBH_TransportAllowance()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_TransportAllowance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

}
