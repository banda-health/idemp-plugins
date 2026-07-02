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

/** Generated Interface for BH_SickOff
 *  @author iDempiere (generated)
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_SickOff
{

    /** TableName=BH_SickOff */
    public static final String Table_Name = "BH_SickOff";

    /** AD_Table_ID=1000071 */
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

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name BH_Additional_Clinical_Notes */
    public static final String COLUMNNAME_BH_Additional_Clinical_Notes = "BH_Additional_Clinical_Notes";

	/** Set BH_Additional_Clinical_Notes.
	  * Any further instructions for the employer or patient
	  */
	public void setBH_Additional_Clinical_Notes (String BH_Additional_Clinical_Notes);

	/** Get BH_Additional_Clinical_Notes.
	  * Any further instructions for the employer or patient
	  */
	public String getBH_Additional_Clinical_Notes();

    /** Column name BH_Clinician_User_ID */
    public static final String COLUMNNAME_BH_Clinician_User_ID = "BH_Clinician_User_ID";

	/** Set BH_Clinician_User_ID.
	  * BH_Clinician_User_ID
	  */
	public void setBH_Clinician_User_ID (int BH_Clinician_User_ID);

	/** Get BH_Clinician_User_ID.
	  * BH_Clinician_User_ID
	  */
	public int getBH_Clinician_User_ID();

	public org.compiere.model.I_AD_User getBH_Clinician_User() throws RuntimeException;

    /** Column name BH_SickOff_ID */
    public static final String COLUMNNAME_BH_SickOff_ID = "BH_SickOff_ID";

	/** Set Sick Off	  */
	public void setBH_SickOff_ID (int BH_SickOff_ID);

	/** Get Sick Off	  */
	public int getBH_SickOff_ID();

    /** Column name BH_SickOff_UU */
    public static final String COLUMNNAME_BH_SickOff_UU = "BH_SickOff_UU";

	/** Set BH_SickOff_UU	  */
	public void setBH_SickOff_UU (String BH_SickOff_UU);

	/** Get BH_SickOff_UU	  */
	public String getBH_SickOff_UU();

    /** Column name BH_Visit_ID */
    public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";

	/** Set Visit	  */
	public void setBH_Visit_ID (int BH_Visit_ID);

	/** Get Visit	  */
	public int getBH_Visit_ID();

	public I_BH_Visit getBH_Visit() throws RuntimeException;

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

    /** Column name EndDate */
    public static final String COLUMNNAME_EndDate = "EndDate";

	/** Set End Date	  */
	public void setEndDate (Timestamp EndDate);

	/** Get End Date	  */
	public Timestamp getEndDate();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name StartDate */
    public static final String COLUMNNAME_StartDate = "StartDate";

	/** Set Start Date	  */
	public void setStartDate (Timestamp StartDate);

	/** Get Start Date	  */
	public Timestamp getStartDate();

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
