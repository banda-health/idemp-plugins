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

/** Generated Interface for BH_Concept_Description
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_BH_Concept_Description 
{

    /** TableName=BH_Concept_Description */
    public static final String Table_Name = "BH_Concept_Description";

    /** AD_Table_ID=1000057 */
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

    /** Column name BH_Concept_Description_ID */
    public static final String COLUMNNAME_BH_Concept_Description_ID = "BH_Concept_Description_ID";

	/** Set Concept Description	  */
	public void setBH_Concept_Description_ID (int BH_Concept_Description_ID);

	/** Get Concept Description	  */
	public int getBH_Concept_Description_ID();

    /** Column name BH_Concept_Description_Type */
    public static final String COLUMNNAME_BH_Concept_Description_Type = "BH_Concept_Description_Type";

	/** Set Concept Description Type	  */
	public void setBH_Concept_Description_Type (String BH_Concept_Description_Type);

	/** Get Concept Description Type	  */
	public String getBH_Concept_Description_Type();

    /** Column name BH_Concept_Description_UU */
    public static final String COLUMNNAME_BH_Concept_Description_UU = "BH_Concept_Description_UU";

	/** Set BH_Concept_Description_UU	  */
	public void setBH_Concept_Description_UU (String BH_Concept_Description_UU);

	/** Get BH_Concept_Description_UU	  */
	public String getBH_Concept_Description_UU();

    /** Column name BH_Concept_ID */
    public static final String COLUMNNAME_BH_Concept_ID = "BH_Concept_ID";

	/** Set Concept	  */
	public void setBH_Concept_ID (int BH_Concept_ID);

	/** Get Concept	  */
	public int getBH_Concept_ID();

	public I_BH_Concept getBH_Concept() throws RuntimeException;

    /** Column name BH_Concept_Locale */
    public static final String COLUMNNAME_BH_Concept_Locale = "BH_Concept_Locale";

	/** Set Concept Locale	  */
	public void setBH_Concept_Locale (String BH_Concept_Locale);

	/** Get Concept Locale	  */
	public String getBH_Concept_Locale();

    /** Column name BH_Concept_Type */
    public static final String COLUMNNAME_BH_Concept_Type = "BH_Concept_Type";

	/** Set Concept Type	  */
	public void setBH_Concept_Type (String BH_Concept_Type);

	/** Get Concept Type	  */
	public String getBH_Concept_Type();

    /** Column name BH_ExternalID */
    public static final String COLUMNNAME_BH_ExternalID = "BH_ExternalID";

	/** Set BH_ExternalID.
	  * BH_External_ID
	  */
	public void setBH_ExternalID (String BH_ExternalID);

	/** Get BH_ExternalID.
	  * BH_External_ID
	  */
	public String getBH_ExternalID();

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

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
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
