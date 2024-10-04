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

/** Generated Interface for BH_Concept
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_BH_Concept 
{

    /** TableName=BH_Concept */
    public static final String Table_Name = "BH_Concept";

    /** AD_Table_ID=1000053 */
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

    /** Column name bh_concept_class */
    public static final String COLUMNNAME_bh_concept_class = "bh_concept_class";

	/** Set bh_concept_class	  */
	public void setbh_concept_class (String bh_concept_class);

	/** Get bh_concept_class	  */
	public String getbh_concept_class();

    /** Column name BH_Concept_ID */
    public static final String COLUMNNAME_BH_Concept_ID = "BH_Concept_ID";

	/** Set Concept	  */
	public void setBH_Concept_ID (int BH_Concept_ID);

	/** Get Concept	  */
	public int getBH_Concept_ID();

    /** Column name BH_Concept_Type */
    public static final String COLUMNNAME_BH_Concept_Type = "BH_Concept_Type";

	/** Set Concept Type	  */
	public void setBH_Concept_Type (String BH_Concept_Type);

	/** Get Concept Type	  */
	public String getBH_Concept_Type();

    /** Column name BH_Concept_UU */
    public static final String COLUMNNAME_BH_Concept_UU = "BH_Concept_UU";

	/** Set BH_Concept_UU	  */
	public void setBH_Concept_UU (String BH_Concept_UU);

	/** Get BH_Concept_UU	  */
	public String getBH_Concept_UU();

    /** Column name BH_Data_Type */
    public static final String COLUMNNAME_BH_Data_Type = "BH_Data_Type";

	/** Set BH_Data_Type	  */
	public void setBH_Data_Type (String BH_Data_Type);

	/** Get BH_Data_Type	  */
	public String getBH_Data_Type();

    /** Column name BH_Display_Locale */
    public static final String COLUMNNAME_BH_Display_Locale = "BH_Display_Locale";

	/** Set Display Locale	  */
	public void setBH_Display_Locale (String BH_Display_Locale);

	/** Get Display Locale	  */
	public String getBH_Display_Locale();

    /** Column name BH_Display_Name */
    public static final String COLUMNNAME_BH_Display_Name = "BH_Display_Name";

	/** Set Display Name	  */
	public void setBH_Display_Name (String BH_Display_Name);

	/** Get Display Name	  */
	public String getBH_Display_Name();

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

    /** Column name BH_OclID */
    public static final String COLUMNNAME_BH_OclID = "BH_OclID";

	/** Set OCL ID.
	  * A generic ID of type string
	  */
	public void setBH_OclID (String BH_OclID);

	/** Get OCL ID.
	  * A generic ID of type string
	  */
	public String getBH_OclID();

    /** Column name BH_Owner */
    public static final String COLUMNNAME_BH_Owner = "BH_Owner";

	/** Set BH_Owner.
	  * BH_Owner
	  */
	public void setBH_Owner (String BH_Owner);

	/** Get BH_Owner.
	  * BH_Owner
	  */
	public String getBH_Owner();

    /** Column name BH_Source */
    public static final String COLUMNNAME_BH_Source = "BH_Source";

	/** Set Source.
	  * Source
	  */
	public void setBH_Source (String BH_Source);

	/** Get Source.
	  * Source
	  */
	public String getBH_Source();

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

    /** Column name Ocl_Uuid */
    public static final String COLUMNNAME_Ocl_Uuid = "Ocl_Uuid";

	/** Set Ocl Uuid.
	  * A UUID from the OCL System
	  */
	public void setOcl_Uuid (String Ocl_Uuid);

	/** Get Ocl Uuid.
	  * A UUID from the OCL System
	  */
	public String getOcl_Uuid();

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

    /** Column name URL */
    public static final String COLUMNNAME_URL = "URL";

	/** Set URL.
	  * Full URL address - e.g. http://www.idempiere.org
	  */
	public void setURL (String URL);

	/** Get URL.
	  * Full URL address - e.g. http://www.idempiere.org
	  */
	public String getURL();
}
