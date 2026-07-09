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

/** Generated Interface for BH_Payroll_Component
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Payroll_Component 
{

    /** TableName=BH_Payroll_Component */
    public static final String Table_Name = "BH_Payroll_Component";

    /** AD_Table_ID */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 7 - System - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(7);

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

    /** Column name BH_CalcMethod */
    public static final String COLUMNNAME_BH_CalcMethod = "BH_CalcMethod";

	/** Set Calculation Method.	  */
	public void setBH_CalcMethod (String BH_CalcMethod);

	/** Get Calculation Method.	  */
	public String getBH_CalcMethod();

    /** Column name BH_Cap */
    public static final String COLUMNNAME_BH_Cap = "BH_Cap";

	/** Set Cap Amount.	  */
	public void setBH_Cap (BigDecimal BH_Cap);

	/** Get Cap Amount.	  */
	public BigDecimal getBH_Cap();

    /** Column name BH_Category */
    public static final String COLUMNNAME_BH_Category = "BH_Category";

	/** Set Category.	  */
	public void setBH_Category (String BH_Category);

	/** Get Category.	  */
	public String getBH_Category();

    /** Column name BH_EmployerRate */
    public static final String COLUMNNAME_BH_EmployerRate = "BH_EmployerRate";

	/** Set Employer Rate.	  */
	public void setBH_EmployerRate (BigDecimal BH_EmployerRate);

	/** Get Employer Rate.	  */
	public BigDecimal getBH_EmployerRate();

    /** Column name BH_FilingDueDay */
    public static final String COLUMNNAME_BH_FilingDueDay = "BH_FilingDueDay";

	/** Set Filing Due Day.	  */
	public void setBH_FilingDueDay (int BH_FilingDueDay);

	/** Get Filing Due Day.	  */
	public int getBH_FilingDueDay();

    /** Column name BH_Floor */
    public static final String COLUMNNAME_BH_Floor = "BH_Floor";

	/** Set Floor Amount.	  */
	public void setBH_Floor (BigDecimal BH_Floor);

	/** Get Floor Amount.	  */
	public BigDecimal getBH_Floor();

    /** Column name BH_IsStatutory */
    public static final String COLUMNNAME_BH_IsStatutory = "BH_IsStatutory";

	/** Set Statutory.	  */
	public void setBH_IsStatutory (boolean BH_IsStatutory);

	/** Get Statutory.	  */
	public boolean isBH_IsStatutory();

    /** Column name BH_IsTaxDeductible */
    public static final String COLUMNNAME_BH_IsTaxDeductible = "BH_IsTaxDeductible";

	/** Set Tax Deductible.	  */
	public void setBH_IsTaxDeductible (boolean BH_IsTaxDeductible);

	/** Get Tax Deductible.	  */
	public boolean isBH_IsTaxDeductible();

    /** Column name BH_Payroll_Component_ID */
    public static final String COLUMNNAME_BH_Payroll_Component_ID = "BH_Payroll_Component_ID";

	/** Set Payroll Component.	  */
	public void setBH_Payroll_Component_ID (int BH_Payroll_Component_ID);

	/** Get Payroll Component.	  */
	public int getBH_Payroll_Component_ID();

    /** Column name BH_Payroll_Component_UU */
    public static final String COLUMNNAME_BH_Payroll_Component_UU = "BH_Payroll_Component_UU";

	/** Set BH_Payroll_Component_UU.	  */
	public void setBH_Payroll_Component_UU (String BH_Payroll_Component_UU);

	/** Get BH_Payroll_Component_UU.	  */
	public String getBH_Payroll_Component_UU();

    /** Column name BH_Rate */
    public static final String COLUMNNAME_BH_Rate = "BH_Rate";

	/** Set Rate.	  */
	public void setBH_Rate (BigDecimal BH_Rate);

	/** Get Rate.	  */
	public BigDecimal getBH_Rate();

    /** Column name BH_TaxDeductibleCap */
    public static final String COLUMNNAME_BH_TaxDeductibleCap = "BH_TaxDeductibleCap";

	/** Set Tax Deductible Cap.	  */
	public void setBH_TaxDeductibleCap (BigDecimal BH_TaxDeductibleCap);

	/** Get Tax Deductible Cap.	  */
	public BigDecimal getBH_TaxDeductibleCap();

    /** Column name BH_Tier1_Limit */
    public static final String COLUMNNAME_BH_Tier1_Limit = "BH_Tier1_Limit";

	/** Set Tier 1 Limit.	  */
	public void setBH_Tier1_Limit (BigDecimal BH_Tier1_Limit);

	/** Get Tier 1 Limit.	  */
	public BigDecimal getBH_Tier1_Limit();

    /** Column name BH_Tier2_Limit */
    public static final String COLUMNNAME_BH_Tier2_Limit = "BH_Tier2_Limit";

	/** Set Tier 2 Limit.	  */
	public void setBH_Tier2_Limit (BigDecimal BH_Tier2_Limit);

	/** Get Tier 2 Limit.	  */
	public BigDecimal getBH_Tier2_Limit();

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

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records; lowest number comes first
	  */
	public int getSeqNo();

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

    /** Column name ValidFrom */
    public static final String COLUMNNAME_ValidFrom = "ValidFrom";

	/** Set Valid from.
	  * Valid from including this date (first day)
	  */
	public void setValidFrom (Timestamp ValidFrom);

	/** Get Valid from.
	  * Valid from including this date (first day)
	  */
	public Timestamp getValidFrom();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
