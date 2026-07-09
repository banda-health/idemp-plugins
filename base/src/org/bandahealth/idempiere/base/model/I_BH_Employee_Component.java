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

/** Generated Interface for BH_Employee_Component
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Employee_Component 
{

    /** TableName=BH_Employee_Component */
    public static final String Table_Name = "BH_Employee_Component";

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

    /** Column name BH_Amount */
    public static final String COLUMNNAME_BH_Amount = "BH_Amount";

	/** Set Amount.	  */
	public void setBH_Amount (BigDecimal BH_Amount);

	/** Get Amount.	  */
	public BigDecimal getBH_Amount();

    /** Column name BH_Employee_Component_ID */
    public static final String COLUMNNAME_BH_Employee_Component_ID = "BH_Employee_Component_ID";

	/** Set Employee Payroll Component.	  */
	public void setBH_Employee_Component_ID (int BH_Employee_Component_ID);

	/** Get Employee Payroll Component.	  */
	public int getBH_Employee_Component_ID();

    /** Column name BH_Employee_Component_UU */
    public static final String COLUMNNAME_BH_Employee_Component_UU = "BH_Employee_Component_UU";

	/** Set BH_Employee_Component_UU.	  */
	public void setBH_Employee_Component_UU (String BH_Employee_Component_UU);

	/** Get BH_Employee_Component_UU.	  */
	public String getBH_Employee_Component_UU();

    /** Column name BH_Payroll_Component_ID */
    public static final String COLUMNNAME_BH_Payroll_Component_ID = "BH_Payroll_Component_ID";

	/** Set Payroll Component.	  */
	public void setBH_Payroll_Component_ID (int BH_Payroll_Component_ID);

	/** Get Payroll Component.	  */
	public int getBH_Payroll_Component_ID();

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

    /** Column name ValidTo */
    public static final String COLUMNNAME_ValidTo = "ValidTo";

	/** Set Valid to.
	  * Valid to including this date (last day)
	  */
	public void setValidTo (Timestamp ValidTo);

	/** Get Valid to.
	  * Valid to including this date (last day)
	  */
	public Timestamp getValidTo();
}
