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

/** Generated Interface for BH_Visit_Family_Planning_Larc_Removal_Reason
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Visit_Family_Planning_Larc_Removal_Reason 
{

    /** TableName=BH_Visit_Family_Planning_Larc_Removal_Reason */
    public static final String Table_Name = "BH_Visit_Family_Planning_Larc_Removal_Reason";

    /** AD_Table_ID=1000073 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

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

    /** Column name BH_Larc_Removal_Reason */
    public static final String COLUMNNAME_BH_Larc_Removal_Reason = "BH_Larc_Removal_Reason";

	/** Set LARC Removal Reason	  */
	public void setBH_Larc_Removal_Reason (String BH_Larc_Removal_Reason);

	/** Get LARC Removal Reason	  */
	public String getBH_Larc_Removal_Reason();

    /** Column name BH_Visit_Family_Planning_ID */
    public static final String COLUMNNAME_BH_Visit_Family_Planning_ID = "BH_Visit_Family_Planning_ID";

	/** Set Visit Family Planning	  */
	public void setBH_Visit_Family_Planning_ID (int BH_Visit_Family_Planning_ID);

	/** Get Visit Family Planning	  */
	public int getBH_Visit_Family_Planning_ID();

	public I_BH_Visit_Family_Planning getBH_Visit_Family_Planning() throws RuntimeException;

    /** Column name BH_Visit_Family_Planning_Larc_Removal_Reason_ID */
    public static final String COLUMNNAME_BH_Visit_Family_Planning_Larc_Removal_Reason_ID = "BH_Visit_Family_Planning_Larc_Removal_Reason_ID";

	/** Set Visit Family Planning LARC Removal Reason	  */
	public void setBH_Visit_Family_Planning_Larc_Removal_Reason_ID (int BH_Visit_Family_Planning_Larc_Removal_Reason_ID);

	/** Get Visit Family Planning LARC Removal Reason	  */
	public int getBH_Visit_Family_Planning_Larc_Removal_Reason_ID();

    /** Column name BH_Visit_Family_Planning_Larc_Removal_Reason_UU */
    public static final String COLUMNNAME_BH_Visit_Family_Planning_Larc_Removal_Reason_UU = "BH_Visit_Family_Planning_Larc_Removal_Reason_UU";

	/** Set BH_Visit_Family_Planning_Larc_Removal_Reason_UU	  */
	public void setBH_Visit_Family_Planning_Larc_Removal_Reason_UU (String BH_Visit_Family_Planning_Larc_Removal_Reason_UU);

	/** Get BH_Visit_Family_Planning_Larc_Removal_Reason_UU	  */
	public String getBH_Visit_Family_Planning_Larc_Removal_Reason_UU();

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
