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

/** Generated Interface for BH_GraphQLGeneratorTemplate
 *  @author iDempiere (generated) 
 *  @version Release 13
 */
@SuppressWarnings("all")
public interface I_BH_GraphQLGeneratorTemplate 
{

    /** TableName=BH_GraphQLGeneratorTemplate */
    public static final String Table_Name = "BH_GraphQLGeneratorTemplate";

    /** AD_Table_ID=1000060 */
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

    /** Column name BH_GraphQLGeneratorTemplate_ID */
    public static final String COLUMNNAME_BH_GraphQLGeneratorTemplate_ID = "BH_GraphQLGeneratorTemplate_ID";

	/** Set Banda GraphQL Generator Template	  */
	public void setBH_GraphQLGeneratorTemplate_ID (int BH_GraphQLGeneratorTemplate_ID);

	/** Get Banda GraphQL Generator Template	  */
	public int getBH_GraphQLGeneratorTemplate_ID();

    /** Column name BH_GraphQLGeneratorTemplate_UU */
    public static final String COLUMNNAME_BH_GraphQLGeneratorTemplate_UU = "BH_GraphQLGeneratorTemplate_UU";

	/** Set BH_GraphQLGeneratorTemplate_UU	  */
	public void setBH_GraphQLGeneratorTemplate_UU (String BH_GraphQLGeneratorTemplate_UU);

	/** Get BH_GraphQLGeneratorTemplate_UU	  */
	public String getBH_GraphQLGeneratorTemplate_UU();

    /** Column name ColumnEntityType */
    public static final String COLUMNNAME_ColumnEntityType = "ColumnEntityType";

	/** Set Column Entity Type	  */
	public void setColumnEntityType (String ColumnEntityType);

	/** Get Column Entity Type	  */
	public String getColumnEntityType();

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

    /** Column name CustomModelFolder */
    public static final String COLUMNNAME_CustomModelFolder = "CustomModelFolder";

	/** Set Custom Model Folder	  */
	public void setCustomModelFolder (String CustomModelFolder);

	/** Get Custom Model Folder	  */
	public String getCustomModelFolder();

    /** Column name CustomModelPackageName */
    public static final String COLUMNNAME_CustomModelPackageName = "CustomModelPackageName";

	/** Set Custom Model Package Name	  */
	public void setCustomModelPackageName (String CustomModelPackageName);

	/** Get Custom Model Package Name	  */
	public String getCustomModelPackageName();

    /** Column name DataLoaderFolder */
    public static final String COLUMNNAME_DataLoaderFolder = "DataLoaderFolder";

	/** Set Data Loader Folder	  */
	public void setDataLoaderFolder (String DataLoaderFolder);

	/** Get Data Loader Folder	  */
	public String getDataLoaderFolder();

    /** Column name DataLoaderPackageName */
    public static final String COLUMNNAME_DataLoaderPackageName = "DataLoaderPackageName";

	/** Set Data Loader Package Name	  */
	public void setDataLoaderPackageName (String DataLoaderPackageName);

	/** Get Data Loader Package Name	  */
	public String getDataLoaderPackageName();

    /** Column name InputModelFolder */
    public static final String COLUMNNAME_InputModelFolder = "InputModelFolder";

	/** Set Input Model Folder	  */
	public void setInputModelFolder (String InputModelFolder);

	/** Get Input Model Folder	  */
	public String getInputModelFolder();

    /** Column name InputModelPackageName */
    public static final String COLUMNNAME_InputModelPackageName = "InputModelPackageName";

	/** Set Input Model Package Name	  */
	public void setInputModelPackageName (String InputModelPackageName);

	/** Get Input Model Package Name	  */
	public String getInputModelPackageName();

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

    /** Column name ModelResolverFolder */
    public static final String COLUMNNAME_ModelResolverFolder = "ModelResolverFolder";

	/** Set Model Resolver Folder	  */
	public void setModelResolverFolder (String ModelResolverFolder);

	/** Get Model Resolver Folder	  */
	public String getModelResolverFolder();

    /** Column name ModelResolverPackageName */
    public static final String COLUMNNAME_ModelResolverPackageName = "ModelResolverPackageName";

	/** Set Model Resolver Package Name	  */
	public void setModelResolverPackageName (String ModelResolverPackageName);

	/** Get Model Resolver Package Name	  */
	public String getModelResolverPackageName();

    /** Column name MutationResolverFolder */
    public static final String COLUMNNAME_MutationResolverFolder = "MutationResolverFolder";

	/** Set Mutation Resolver Folder	  */
	public void setMutationResolverFolder (String MutationResolverFolder);

	/** Get Mutation Resolver Folder	  */
	public String getMutationResolverFolder();

    /** Column name MutationResolverPackageName */
    public static final String COLUMNNAME_MutationResolverPackageName = "MutationResolverPackageName";

	/** Set Mutation Resolver Package Name	  */
	public void setMutationResolverPackageName (String MutationResolverPackageName);

	/** Get Mutation Resolver Package Name	  */
	public String getMutationResolverPackageName();

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

    /** Column name QueryResolverFolder */
    public static final String COLUMNNAME_QueryResolverFolder = "QueryResolverFolder";

	/** Set Query Resolver Folder	  */
	public void setQueryResolverFolder (String QueryResolverFolder);

	/** Get Query Resolver Folder	  */
	public String getQueryResolverFolder();

    /** Column name QueryResolverPackageName */
    public static final String COLUMNNAME_QueryResolverPackageName = "QueryResolverPackageName";

	/** Set Query Resolver Package Name	  */
	public void setQueryResolverPackageName (String QueryResolverPackageName);

	/** Get Query Resolver Package Name	  */
	public String getQueryResolverPackageName();

    /** Column name SchemaFolder */
    public static final String COLUMNNAME_SchemaFolder = "SchemaFolder";

	/** Set Schema Folder	  */
	public void setSchemaFolder (String SchemaFolder);

	/** Get Schema Folder	  */
	public String getSchemaFolder();

    /** Column name TableEntityType */
    public static final String COLUMNNAME_TableEntityType = "TableEntityType";

	/** Set Table Entity Type	  */
	public void setTableEntityType (String TableEntityType);

	/** Get Table Entity Type	  */
	public String getTableEntityType();

    /** Column name TableName */
    public static final String COLUMNNAME_TableName = "TableName";

	/** Set DB Table Name.
	  * Name of the table in the database
	  */
	public void setTableName (String TableName);

	/** Get DB Table Name.
	  * Name of the table in the database
	  */
	public String getTableName();

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
