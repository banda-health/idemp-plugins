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

/** Generated Interface for BH_Payroll_Audit
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Payroll_Audit 
{

    /** TableName=BH_Payroll_Audit */
    public static final String Table_Name = "BH_Payroll_Audit";

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

    /** Column name AD_Role_ID */
    public static final String COLUMNNAME_AD_Role_ID = "AD_Role_ID";

	/** Set Role.
	  * Responsibility Role
	  */
	public void setAD_Role_ID (int AD_Role_ID);

	/** Get Role.
	  * Responsibility Role
	  */
	public int getAD_Role_ID();

    /** Column name BH_ActionType */
    public static final String COLUMNNAME_BH_ActionType = "BH_ActionType";

	/** Set Action Type.	  */
	public void setBH_ActionType (String BH_ActionType);

	/** Get Action Type.	  */
	public String getBH_ActionType();

    /** Column name BH_Detail */
    public static final String COLUMNNAME_BH_Detail = "BH_Detail";

	/** Set Detail.	  */
	public void setBH_Detail (String BH_Detail);

	/** Get Detail.	  */
	public String getBH_Detail();

    /** Column name BH_Payroll_Audit_ID */
    public static final String COLUMNNAME_BH_Payroll_Audit_ID = "BH_Payroll_Audit_ID";

	/** Set Payroll Audit.	  */
	public void setBH_Payroll_Audit_ID (int BH_Payroll_Audit_ID);

	/** Get Payroll Audit.	  */
	public int getBH_Payroll_Audit_ID();

    /** Column name BH_Payroll_Audit_UU */
    public static final String COLUMNNAME_BH_Payroll_Audit_UU = "BH_Payroll_Audit_UU";

	/** Set BH_Payroll_Audit_UU.	  */
	public void setBH_Payroll_Audit_UU (String BH_Payroll_Audit_UU);

	/** Get BH_Payroll_Audit_UU.	  */
	public String getBH_Payroll_Audit_UU();

    /** Column name BH_Payroll_Run_ID */
    public static final String COLUMNNAME_BH_Payroll_Run_ID = "BH_Payroll_Run_ID";

	/** Set Payroll Run.	  */
	public void setBH_Payroll_Run_ID (int BH_Payroll_Run_ID);

	/** Get Payroll Run.	  */
	public int getBH_Payroll_Run_ID();

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
