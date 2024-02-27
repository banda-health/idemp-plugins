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

/** Generated Interface for BH_Concept_Mapping
 *  @author iDempiere (generated) 
 *  @version Release 7.1
 */
@SuppressWarnings("all")
public interface I_BH_Concept_Mapping 
{

    /** TableName=BH_Concept_Mapping */
    public static final String Table_Name = "BH_Concept_Mapping";

    /** AD_Table_ID=1000054 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name BH_Concept_ID */
    public static final String COLUMNNAME_BH_Concept_ID = "BH_Concept_ID";

	/** Set Concept	  */
	public void setBH_Concept_ID (int BH_Concept_ID);

	/** Get Concept	  */
	public int getBH_Concept_ID();

	public I_BH_Concept getBH_Concept() throws RuntimeException;

    /** Column name BH_Concept_Mapping_ID */
    public static final String COLUMNNAME_BH_Concept_Mapping_ID = "BH_Concept_Mapping_ID";

	/** Set Concept Mapping	  */
	public void setBH_Concept_Mapping_ID (int BH_Concept_Mapping_ID);

	/** Get Concept Mapping	  */
	public int getBH_Concept_Mapping_ID();

    /** Column name BH_Concept_Mapping_UU */
    public static final String COLUMNNAME_BH_Concept_Mapping_UU = "BH_Concept_Mapping_UU";

	/** Set BH_Concept_Mapping_UU	  */
	public void setBH_Concept_Mapping_UU (String BH_Concept_Mapping_UU);

	/** Get BH_Concept_Mapping_UU	  */
	public String getBH_Concept_Mapping_UU();

    /** Column name BH_External_ID */
    public static final String COLUMNNAME_BH_External_ID = "BH_External_ID";

	/** Set BH_External_ID.
	  * BH_External_ID
	  */
	public void setBH_External_ID (String BH_External_ID);

	/** Get BH_External_ID.
	  * BH_External_ID
	  */
	public String getBH_External_ID();

    /** Column name BH_From_Concept_Code */
    public static final String COLUMNNAME_BH_From_Concept_Code = "BH_From_Concept_Code";

	/** Set From Concept Code	  */
	public void setBH_From_Concept_Code (String BH_From_Concept_Code);

	/** Get From Concept Code	  */
	public String getBH_From_Concept_Code();

    /** Column name BH_From_Concept_Name */
    public static final String COLUMNNAME_BH_From_Concept_Name = "BH_From_Concept_Name";

	/** Set From Concept Name	  */
	public void setBH_From_Concept_Name (String BH_From_Concept_Name);

	/** Get From Concept Name	  */
	public String getBH_From_Concept_Name();

    /** Column name BH_From_Concept_Name_Resolved */
    public static final String COLUMNNAME_BH_From_Concept_Name_Resolved = "BH_From_Concept_Name_Resolved";

	/** Set From Concept Name Resolved	  */
	public void setBH_From_Concept_Name_Resolved (String BH_From_Concept_Name_Resolved);

	/** Get From Concept Name Resolved	  */
	public String getBH_From_Concept_Name_Resolved();

    /** Column name BH_From_Concept_Url */
    public static final String COLUMNNAME_BH_From_Concept_Url = "BH_From_Concept_Url";

	/** Set From Concept Url	  */
	public void setBH_From_Concept_Url (String BH_From_Concept_Url);

	/** Get From Concept Url	  */
	public String getBH_From_Concept_Url();

    /** Column name BH_Map_Type */
    public static final String COLUMNNAME_BH_Map_Type = "BH_Map_Type";

	/** Set BH_Map_Type.
	  * BH_Map_Type
	  */
	public void setBH_Map_Type (String BH_Map_Type);

	/** Get BH_Map_Type.
	  * BH_Map_Type
	  */
	public String getBH_Map_Type();

    /** Column name BH_OCL_ID */
    public static final String COLUMNNAME_BH_OCL_ID = "BH_OCL_ID";

	/** Set OCL ID.
	  * A generic ID of type string
	  */
	public void setBH_OCL_ID (String BH_OCL_ID);

	/** Get OCL ID.
	  * A generic ID of type string
	  */
	public String getBH_OCL_ID();

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

    /** Column name BH_To_Concept_Code */
    public static final String COLUMNNAME_BH_To_Concept_Code = "BH_To_Concept_Code";

	/** Set To Concept Code	  */
	public void setBH_To_Concept_Code (String BH_To_Concept_Code);

	/** Get To Concept Code	  */
	public String getBH_To_Concept_Code();

    /** Column name BH_To_Concept_Name */
    public static final String COLUMNNAME_BH_To_Concept_Name = "BH_To_Concept_Name";

	/** Set To Concept Name	  */
	public void setBH_To_Concept_Name (String BH_To_Concept_Name);

	/** Get To Concept Name	  */
	public String getBH_To_Concept_Name();

    /** Column name BH_To_Concept_Name_Resolved */
    public static final String COLUMNNAME_BH_To_Concept_Name_Resolved = "BH_To_Concept_Name_Resolved";

	/** Set To Concept Name Resolved	  */
	public void setBH_To_Concept_Name_Resolved (String BH_To_Concept_Name_Resolved);

	/** Get To Concept Name Resolved	  */
	public String getBH_To_Concept_Name_Resolved();

    /** Column name BH_To_Concept_Url */
    public static final String COLUMNNAME_BH_To_Concept_Url = "BH_To_Concept_Url";

	/** Set To Concept Url	  */
	public void setBH_To_Concept_Url (String BH_To_Concept_Url);

	/** Get To Concept Url	  */
	public String getBH_To_Concept_Url();

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
