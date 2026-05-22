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

/** Generated Interface for BH_Feature_Flag_Rule
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Feature_Flag_Rule 
{

    /** TableName=BH_Feature_Flag_Rule */
    public static final String Table_Name = "BH_Feature_Flag_Rule";

    /** AD_Table_ID=1000070 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 4 - System 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

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

    /** Column name BH_Environment */
    public static final String COLUMNNAME_BH_Environment = "BH_Environment";

	/** Set Environment	  */
	public void setBH_Environment (String BH_Environment);

	/** Get Environment	  */
	public String getBH_Environment();

    /** Column name BH_Feature_Flag_ID */
    public static final String COLUMNNAME_BH_Feature_Flag_ID = "BH_Feature_Flag_ID";

	/** Set Feature Flag	  */
	public void setBH_Feature_Flag_ID (int BH_Feature_Flag_ID);

	/** Get Feature Flag	  */
	public int getBH_Feature_Flag_ID();

	public I_BH_Feature_Flag getBH_Feature_Flag() throws RuntimeException;

    /** Column name BH_Feature_Flag_Rule_ID */
    public static final String COLUMNNAME_BH_Feature_Flag_Rule_ID = "BH_Feature_Flag_Rule_ID";

	/** Set Feature Flag Rule	  */
	public void setBH_Feature_Flag_Rule_ID (int BH_Feature_Flag_Rule_ID);

	/** Get Feature Flag Rule	  */
	public int getBH_Feature_Flag_Rule_ID();

    /** Column name BH_Feature_Flag_Rule_UU */
    public static final String COLUMNNAME_BH_Feature_Flag_Rule_UU = "BH_Feature_Flag_Rule_UU";

	/** Set BH_Feature_Flag_Rule_UU	  */
	public void setBH_Feature_Flag_Rule_UU (String BH_Feature_Flag_Rule_UU);

	/** Get BH_Feature_Flag_Rule_UU	  */
	public String getBH_Feature_Flag_Rule_UU();

    /** Column name BH_IsEnabled */
    public static final String COLUMNNAME_BH_IsEnabled = "BH_IsEnabled";

	/** Set Is Enabled	  */
	public void setBH_IsEnabled (boolean BH_IsEnabled);

	/** Get Is Enabled	  */
	public boolean isBH_IsEnabled();

    /** Column name BH_Rule_Client_ID */
    public static final String COLUMNNAME_BH_Rule_Client_ID = "BH_Rule_Client_ID";

	/** Set Client	  */
	public void setBH_Rule_Client_ID (int BH_Rule_Client_ID);

	/** Get Client	  */
	public int getBH_Rule_Client_ID();

	public org.compiere.model.I_AD_AllClients_V getBH_Rule_Client() throws RuntimeException;

    /** Column name BH_Rule_Org_ID */
    public static final String COLUMNNAME_BH_Rule_Org_ID = "BH_Rule_Org_ID";

	/** Set Org	  */
	public void setBH_Rule_Org_ID (int BH_Rule_Org_ID);

	/** Get Org	  */
	public int getBH_Rule_Org_ID();

    /** Column name BH_Rule_Role_ID */
    public static final String COLUMNNAME_BH_Rule_Role_ID = "BH_Rule_Role_ID";

	/** Set Role	  */
	public void setBH_Rule_Role_ID (int BH_Rule_Role_ID);

	/** Get Role	  */
	public int getBH_Rule_Role_ID();

	public org.compiere.model.I_AD_Role getBH_Rule_Role() throws RuntimeException;

    /** Column name BH_Rule_User_ID */
    public static final String COLUMNNAME_BH_Rule_User_ID = "BH_Rule_User_ID";

	/** Set User	  */
	public void setBH_Rule_User_ID (int BH_Rule_User_ID);

	/** Get User	  */
	public int getBH_Rule_User_ID();

	public org.compiere.model.I_AD_AllUsers_V getBH_Rule_User() throws RuntimeException;

    /** Column name BH_SystemAdmin */
    public static final String COLUMNNAME_BH_SystemAdmin = "BH_SystemAdmin";

	/** Set System Admin	  */
	public void setBH_SystemAdmin (boolean BH_SystemAdmin);

	/** Get System Admin	  */
	public boolean isBH_SystemAdmin();

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
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
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
