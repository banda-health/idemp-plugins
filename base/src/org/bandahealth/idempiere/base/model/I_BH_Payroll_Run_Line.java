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
package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for BH_Payroll_Run_Line
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Payroll_Run_Line 
{

    /** TableName=BH_Payroll_Run_Line */
    public static final String Table_Name = "BH_Payroll_Run_Line";

    /** AD_Table_ID */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set AD_Org_ID.	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get AD_Org_ID.	  */
	public int getAD_Org_ID();

    /** Column name BH_BasicSalary */
    public static final String COLUMNNAME_BH_BasicSalary = "BH_BasicSalary";

	/** Set Basic Salary.	  */
	public void setBH_BasicSalary (BigDecimal BH_BasicSalary);

	/** Get Basic Salary.	  */
	public BigDecimal getBH_BasicSalary();

    /** Column name BH_CostToEmployer */
    public static final String COLUMNNAME_BH_CostToEmployer = "BH_CostToEmployer";

	/** Set Cost To Employer.	  */
	public void setBH_CostToEmployer (BigDecimal BH_CostToEmployer);

	/** Get Cost To Employer.	  */
	public BigDecimal getBH_CostToEmployer();

    /** Column name BH_EmployeeName */
    public static final String COLUMNNAME_BH_EmployeeName = "BH_EmployeeName";

	/** Set Employee Name.	  */
	public void setBH_EmployeeName (String BH_EmployeeName);

	/** Get Employee Name.	  */
	public String getBH_EmployeeName();

    /** Column name BH_GrossPay */
    public static final String COLUMNNAME_BH_GrossPay = "BH_GrossPay";

	/** Set Gross Pay.	  */
	public void setBH_GrossPay (BigDecimal BH_GrossPay);

	/** Get Gross Pay.	  */
	public BigDecimal getBH_GrossPay();

    /** Column name BH_HouseAllowance */
    public static final String COLUMNNAME_BH_HouseAllowance = "BH_HouseAllowance";

	/** Set House Allowance.	  */
	public void setBH_HouseAllowance (BigDecimal BH_HouseAllowance);

	/** Get House Allowance.	  */
	public BigDecimal getBH_HouseAllowance();

    /** Column name BH_KRA_PIN */
    public static final String COLUMNNAME_BH_KRA_PIN = "BH_KRA_PIN";

	/** Set KRA PIN.	  */
	public void setBH_KRA_PIN (String BH_KRA_PIN);

	/** Get KRA PIN.	  */
	public String getBH_KRA_PIN();

    /** Column name BH_NetPay */
    public static final String COLUMNNAME_BH_NetPay = "BH_NetPay";

	/** Set Net Pay.	  */
	public void setBH_NetPay (BigDecimal BH_NetPay);

	/** Get Net Pay.	  */
	public BigDecimal getBH_NetPay();

    /** Column name BH_NSSF_Number */
    public static final String COLUMNNAME_BH_NSSF_Number = "BH_NSSF_Number";

	/** Set NSSF Number.	  */
	public void setBH_NSSF_Number (String BH_NSSF_Number);

	/** Get NSSF Number.	  */
	public String getBH_NSSF_Number();

    /** Column name BH_PAYE_Amount */
    public static final String COLUMNNAME_BH_PAYE_Amount = "BH_PAYE_Amount";

	/** Set PAYE Amount.	  */
	public void setBH_PAYE_Amount (BigDecimal BH_PAYE_Amount);

	/** Get PAYE Amount.	  */
	public BigDecimal getBH_PAYE_Amount();

    /** Column name BH_Payroll_Run_ID */
    public static final String COLUMNNAME_BH_Payroll_Run_ID = "BH_Payroll_Run_ID";

	/** Set Payroll Run.	  */
	public void setBH_Payroll_Run_ID (int BH_Payroll_Run_ID);

	/** Get Payroll Run.	  */
	public int getBH_Payroll_Run_ID();

    /** Column name BH_Payroll_Run_Line_ID */
    public static final String COLUMNNAME_BH_Payroll_Run_Line_ID = "BH_Payroll_Run_Line_ID";

	/** Set Payroll Run Line.	  */
	public void setBH_Payroll_Run_Line_ID (int BH_Payroll_Run_Line_ID);

	/** Get Payroll Run Line.	  */
	public int getBH_Payroll_Run_Line_ID();

    /** Column name BH_Payroll_Run_Line_UU */
    public static final String COLUMNNAME_BH_Payroll_Run_Line_UU = "BH_Payroll_Run_Line_UU";

	/** Set BH_Payroll_Run_Line_UU.	  */
	public void setBH_Payroll_Run_Line_UU (String BH_Payroll_Run_Line_UU);

	/** Get BH_Payroll_Run_Line_UU.	  */
	public String getBH_Payroll_Run_Line_UU();

    /** Column name BH_PayslipNumber */
    public static final String COLUMNNAME_BH_PayslipNumber = "BH_PayslipNumber";

	/** Set Payslip Number.	  */
	public void setBH_PayslipNumber (String BH_PayslipNumber);

	/** Get Payslip Number.	  */
	public String getBH_PayslipNumber();

    /** Column name BH_SHIF_Number */
    public static final String COLUMNNAME_BH_SHIF_Number = "BH_SHIF_Number";

	/** Set SHIF Number.	  */
	public void setBH_SHIF_Number (String BH_SHIF_Number);

	/** Get SHIF Number.	  */
	public String getBH_SHIF_Number();

    /** Column name BH_TaxablePay */
    public static final String COLUMNNAME_BH_TaxablePay = "BH_TaxablePay";

	/** Set Taxable Pay.	  */
	public void setBH_TaxablePay (BigDecimal BH_TaxablePay);

	/** Get Taxable Pay.	  */
	public BigDecimal getBH_TaxablePay();

    /** Column name BH_TotalDeductions */
    public static final String COLUMNNAME_BH_TotalDeductions = "BH_TotalDeductions";

	/** Set Total Deductions.	  */
	public void setBH_TotalDeductions (BigDecimal BH_TotalDeductions);

	/** Get Total Deductions.	  */
	public BigDecimal getBH_TotalDeductions();

    /** Column name BH_TransportAllowance */
    public static final String COLUMNNAME_BH_TransportAllowance = "BH_TransportAllowance";

	/** Set Transport Allowance.	  */
	public void setBH_TransportAllowance (BigDecimal BH_TransportAllowance);

	/** Get Transport Allowance.	  */
	public BigDecimal getBH_TransportAllowance();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name HR_Employee_ID */
    public static final String COLUMNNAME_HR_Employee_ID = "HR_Employee_ID";

	/** Set Payroll Employee.	  */
	public void setHR_Employee_ID (int HR_Employee_ID);

	/** Get Payroll Employee.	  */
	public int getHR_Employee_ID();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set IsActive.	  */
	public void setIsActive (boolean IsActive);

	/** Get IsActive.	  */
	public boolean isActive();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
