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

/** Generated Interface for BH_Payroll_Filing
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Payroll_Filing 
{

    /** TableName=BH_Payroll_Filing */
    public static final String Table_Name = "BH_Payroll_Filing";

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

    /** Column name BH_EmployeeAmount */
    public static final String COLUMNNAME_BH_EmployeeAmount = "BH_EmployeeAmount";

	/** Set Employee Amount.	  */
	public void setBH_EmployeeAmount (BigDecimal BH_EmployeeAmount);

	/** Get Employee Amount.	  */
	public BigDecimal getBH_EmployeeAmount();

    /** Column name BH_EmployerAmount */
    public static final String COLUMNNAME_BH_EmployerAmount = "BH_EmployerAmount";

	/** Set Employer Amount.	  */
	public void setBH_EmployerAmount (BigDecimal BH_EmployerAmount);

	/** Get Employer Amount.	  */
	public BigDecimal getBH_EmployerAmount();

    /** Column name BH_FilingType */
    public static final String COLUMNNAME_BH_FilingType = "BH_FilingType";

	/** Set Filing Type.	  */
	public void setBH_FilingType (String BH_FilingType);

	/** Get Filing Type.	  */
	public String getBH_FilingType();

    /** Column name BH_IsPaid */
    public static final String COLUMNNAME_BH_IsPaid = "BH_IsPaid";

	/** Set Paid.	  */
	public void setBH_IsPaid (boolean BH_IsPaid);

	/** Get Paid.	  */
	public boolean isBH_IsPaid();

    /** Column name BH_PaidDate */
    public static final String COLUMNNAME_BH_PaidDate = "BH_PaidDate";

	/** Set Paid Date.	  */
	public void setBH_PaidDate (Timestamp BH_PaidDate);

	/** Get Paid Date.	  */
	public Timestamp getBH_PaidDate();

    /** Column name BH_PaymentReference */
    public static final String COLUMNNAME_BH_PaymentReference = "BH_PaymentReference";

	/** Set Payment Reference.	  */
	public void setBH_PaymentReference (String BH_PaymentReference);

	/** Get Payment Reference.	  */
	public String getBH_PaymentReference();

    /** Column name BH_Payroll_Filing_ID */
    public static final String COLUMNNAME_BH_Payroll_Filing_ID = "BH_Payroll_Filing_ID";

	/** Set Payroll Filing.	  */
	public void setBH_Payroll_Filing_ID (int BH_Payroll_Filing_ID);

	/** Get Payroll Filing.	  */
	public int getBH_Payroll_Filing_ID();

    /** Column name BH_Payroll_Filing_UU */
    public static final String COLUMNNAME_BH_Payroll_Filing_UU = "BH_Payroll_Filing_UU";

	/** Set BH_Payroll_Filing_UU.	  */
	public void setBH_Payroll_Filing_UU (String BH_Payroll_Filing_UU);

	/** Get BH_Payroll_Filing_UU.	  */
	public String getBH_Payroll_Filing_UU();

    /** Column name BH_Payroll_Run_ID */
    public static final String COLUMNNAME_BH_Payroll_Run_ID = "BH_Payroll_Run_ID";

	/** Set Payroll Run.	  */
	public void setBH_Payroll_Run_ID (int BH_Payroll_Run_ID);

	/** Get Payroll Run.	  */
	public int getBH_Payroll_Run_ID();

    /** Column name BH_TotalAmount */
    public static final String COLUMNNAME_BH_TotalAmount = "BH_TotalAmount";

	/** Set Total Amount.	  */
	public void setBH_TotalAmount (BigDecimal BH_TotalAmount);

	/** Get Total Amount.	  */
	public BigDecimal getBH_TotalAmount();

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
