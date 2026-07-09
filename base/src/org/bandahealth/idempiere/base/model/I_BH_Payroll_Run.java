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

/** Generated Interface for BH_Payroll_Run
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Payroll_Run 
{

    /** TableName=BH_Payroll_Run */
    public static final String Table_Name = "BH_Payroll_Run";

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

    /** Column name BH_Components_Snapshot */
    public static final String COLUMNNAME_BH_Components_Snapshot = "BH_Components_Snapshot";

	/** Set Components Snapshot.	  */
	public void setBH_Components_Snapshot (String BH_Components_Snapshot);

	/** Get Components Snapshot.	  */
	public String getBH_Components_Snapshot();

    /** Column name BH_PayDate */
    public static final String COLUMNNAME_BH_PayDate = "BH_PayDate";

	/** Set Pay Date.	  */
	public void setBH_PayDate (Timestamp BH_PayDate);

	/** Get Pay Date.	  */
	public Timestamp getBH_PayDate();

    /** Column name BH_PayrollMonth */
    public static final String COLUMNNAME_BH_PayrollMonth = "BH_PayrollMonth";

	/** Set Payroll Month.	  */
	public void setBH_PayrollMonth (int BH_PayrollMonth);

	/** Get Payroll Month.	  */
	public int getBH_PayrollMonth();

    /** Column name BH_PayrollYear */
    public static final String COLUMNNAME_BH_PayrollYear = "BH_PayrollYear";

	/** Set Payroll Year.	  */
	public void setBH_PayrollYear (int BH_PayrollYear);

	/** Get Payroll Year.	  */
	public int getBH_PayrollYear();

    /** Column name BH_Payroll_Run_ID */
    public static final String COLUMNNAME_BH_Payroll_Run_ID = "BH_Payroll_Run_ID";

	/** Set Payroll Run.	  */
	public void setBH_Payroll_Run_ID (int BH_Payroll_Run_ID);

	/** Get Payroll Run.	  */
	public int getBH_Payroll_Run_ID();

    /** Column name BH_Payroll_Run_UU */
    public static final String COLUMNNAME_BH_Payroll_Run_UU = "BH_Payroll_Run_UU";

	/** Set BH_Payroll_Run_UU.	  */
	public void setBH_Payroll_Run_UU (String BH_Payroll_Run_UU);

	/** Get BH_Payroll_Run_UU.	  */
	public String getBH_Payroll_Run_UU();

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

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DocAction */
    public static final String COLUMNNAME_DocAction = "DocAction";

	/** Set Document Action.
	  * The targeted status of the document
	  */
	public void setDocAction (String DocAction);

	/** Get Document Action.
	  * The targeted status of the document
	  */
	public String getDocAction();

    /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";

	/** Set Document Status.
	  * The current status of the document
	  */
	public void setDocStatus (String DocStatus);

	/** Get Document Status.
	  * The current status of the document
	  */
	public String getDocStatus();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set IsActive.	  */
	public void setIsActive (boolean IsActive);

	/** Get IsActive.	  */
	public boolean isActive();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

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
