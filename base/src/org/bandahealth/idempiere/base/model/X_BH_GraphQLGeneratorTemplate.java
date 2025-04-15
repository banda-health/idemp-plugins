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
/** Generated Model - DO NOT CHANGE */
package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for BH_GraphQLGeneratorTemplate
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="BH_GraphQLGeneratorTemplate")
public class X_BH_GraphQLGeneratorTemplate extends PO implements I_BH_GraphQLGeneratorTemplate, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250127L;

    /** Standard Constructor */
    public X_BH_GraphQLGeneratorTemplate (Properties ctx, int BH_GraphQLGeneratorTemplate_ID, String trxName)
    {
      super (ctx, BH_GraphQLGeneratorTemplate_ID, trxName);
      /** if (BH_GraphQLGeneratorTemplate_ID == 0)
        {
			setBH_GraphQLGeneratorTemplate_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_GraphQLGeneratorTemplate (Properties ctx, int BH_GraphQLGeneratorTemplate_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_GraphQLGeneratorTemplate_ID, trxName, virtualColumns);
      /** if (BH_GraphQLGeneratorTemplate_ID == 0)
        {
			setBH_GraphQLGeneratorTemplate_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_GraphQLGeneratorTemplate (Properties ctx, String BH_GraphQLGeneratorTemplate_UU, String trxName)
    {
      super (ctx, BH_GraphQLGeneratorTemplate_UU, trxName);
      /** if (BH_GraphQLGeneratorTemplate_UU == null)
        {
			setBH_GraphQLGeneratorTemplate_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_GraphQLGeneratorTemplate (Properties ctx, String BH_GraphQLGeneratorTemplate_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_GraphQLGeneratorTemplate_UU, trxName, virtualColumns);
      /** if (BH_GraphQLGeneratorTemplate_UU == null)
        {
			setBH_GraphQLGeneratorTemplate_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_GraphQLGeneratorTemplate (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 4 - System
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_BH_GraphQLGeneratorTemplate[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Banda GraphQL Generator Template.
		@param BH_GraphQLGeneratorTemplate_ID Banda GraphQL Generator Template
	*/
	public void setBH_GraphQLGeneratorTemplate_ID (int BH_GraphQLGeneratorTemplate_ID)
	{
		if (BH_GraphQLGeneratorTemplate_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_GraphQLGeneratorTemplate_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_GraphQLGeneratorTemplate_ID, Integer.valueOf(BH_GraphQLGeneratorTemplate_ID));
	}

	/** Get Banda GraphQL Generator Template.
		@return Banda GraphQL Generator Template	  */
	public int getBH_GraphQLGeneratorTemplate_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_GraphQLGeneratorTemplate_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_GraphQLGeneratorTemplate_UU.
		@param BH_GraphQLGeneratorTemplate_UU BH_GraphQLGeneratorTemplate_UU
	*/
	public void setBH_GraphQLGeneratorTemplate_UU (String BH_GraphQLGeneratorTemplate_UU)
	{
		set_Value (COLUMNNAME_BH_GraphQLGeneratorTemplate_UU, BH_GraphQLGeneratorTemplate_UU);
	}

	/** Get BH_GraphQLGeneratorTemplate_UU.
		@return BH_GraphQLGeneratorTemplate_UU	  */
	public String getBH_GraphQLGeneratorTemplate_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_GraphQLGeneratorTemplate_UU);
	}

	/** Set Column Entity Type.
		@param ColumnEntityType Column Entity Type
	*/
	public void setColumnEntityType (String ColumnEntityType)
	{
		set_Value (COLUMNNAME_ColumnEntityType, ColumnEntityType);
	}

	/** Get Column Entity Type.
		@return Column Entity Type	  */
	public String getColumnEntityType()
	{
		return (String)get_Value(COLUMNNAME_ColumnEntityType);
	}

	/** Set Custom Model Folder.
		@param CustomModelFolder Custom Model Folder
	*/
	public void setCustomModelFolder (String CustomModelFolder)
	{
		set_Value (COLUMNNAME_CustomModelFolder, CustomModelFolder);
	}

	/** Get Custom Model Folder.
		@return Custom Model Folder	  */
	public String getCustomModelFolder()
	{
		return (String)get_Value(COLUMNNAME_CustomModelFolder);
	}

	/** Set Custom Model Package Name.
		@param CustomModelPackageName Custom Model Package Name
	*/
	public void setCustomModelPackageName (String CustomModelPackageName)
	{
		set_Value (COLUMNNAME_CustomModelPackageName, CustomModelPackageName);
	}

	/** Get Custom Model Package Name.
		@return Custom Model Package Name	  */
	public String getCustomModelPackageName()
	{
		return (String)get_Value(COLUMNNAME_CustomModelPackageName);
	}

	/** Set Data Loader Folder.
		@param DataLoaderFolder Data Loader Folder
	*/
	public void setDataLoaderFolder (String DataLoaderFolder)
	{
		set_Value (COLUMNNAME_DataLoaderFolder, DataLoaderFolder);
	}

	/** Get Data Loader Folder.
		@return Data Loader Folder	  */
	public String getDataLoaderFolder()
	{
		return (String)get_Value(COLUMNNAME_DataLoaderFolder);
	}

	/** Set Data Loader Package Name.
		@param DataLoaderPackageName Data Loader Package Name
	*/
	public void setDataLoaderPackageName (String DataLoaderPackageName)
	{
		set_Value (COLUMNNAME_DataLoaderPackageName, DataLoaderPackageName);
	}

	/** Get Data Loader Package Name.
		@return Data Loader Package Name	  */
	public String getDataLoaderPackageName()
	{
		return (String)get_Value(COLUMNNAME_DataLoaderPackageName);
	}

	/** Set Input Model Folder.
		@param InputModelFolder Input Model Folder
	*/
	public void setInputModelFolder (String InputModelFolder)
	{
		set_Value (COLUMNNAME_InputModelFolder, InputModelFolder);
	}

	/** Get Input Model Folder.
		@return Input Model Folder	  */
	public String getInputModelFolder()
	{
		return (String)get_Value(COLUMNNAME_InputModelFolder);
	}

	/** Set Input Model Package Name.
		@param InputModelPackageName Input Model Package Name
	*/
	public void setInputModelPackageName (String InputModelPackageName)
	{
		set_Value (COLUMNNAME_InputModelPackageName, InputModelPackageName);
	}

	/** Get Input Model Package Name.
		@return Input Model Package Name	  */
	public String getInputModelPackageName()
	{
		return (String)get_Value(COLUMNNAME_InputModelPackageName);
	}

	/** Set Model Resolver Folder.
		@param ModelResolverFolder Model Resolver Folder
	*/
	public void setModelResolverFolder (String ModelResolverFolder)
	{
		set_Value (COLUMNNAME_ModelResolverFolder, ModelResolverFolder);
	}

	/** Get Model Resolver Folder.
		@return Model Resolver Folder	  */
	public String getModelResolverFolder()
	{
		return (String)get_Value(COLUMNNAME_ModelResolverFolder);
	}

	/** Set Model Resolver Package Name.
		@param ModelResolverPackageName Model Resolver Package Name
	*/
	public void setModelResolverPackageName (String ModelResolverPackageName)
	{
		set_Value (COLUMNNAME_ModelResolverPackageName, ModelResolverPackageName);
	}

	/** Get Model Resolver Package Name.
		@return Model Resolver Package Name	  */
	public String getModelResolverPackageName()
	{
		return (String)get_Value(COLUMNNAME_ModelResolverPackageName);
	}

	/** Set Mutation Resolver Folder.
		@param MutationResolverFolder Mutation Resolver Folder
	*/
	public void setMutationResolverFolder (String MutationResolverFolder)
	{
		set_Value (COLUMNNAME_MutationResolverFolder, MutationResolverFolder);
	}

	/** Get Mutation Resolver Folder.
		@return Mutation Resolver Folder	  */
	public String getMutationResolverFolder()
	{
		return (String)get_Value(COLUMNNAME_MutationResolverFolder);
	}

	/** Set Mutation Resolver Package Name.
		@param MutationResolverPackageName Mutation Resolver Package Name
	*/
	public void setMutationResolverPackageName (String MutationResolverPackageName)
	{
		set_Value (COLUMNNAME_MutationResolverPackageName, MutationResolverPackageName);
	}

	/** Get Mutation Resolver Package Name.
		@return Mutation Resolver Package Name	  */
	public String getMutationResolverPackageName()
	{
		return (String)get_Value(COLUMNNAME_MutationResolverPackageName);
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Query Resolver Folder.
		@param QueryResolverFolder Query Resolver Folder
	*/
	public void setQueryResolverFolder (String QueryResolverFolder)
	{
		set_Value (COLUMNNAME_QueryResolverFolder, QueryResolverFolder);
	}

	/** Get Query Resolver Folder.
		@return Query Resolver Folder	  */
	public String getQueryResolverFolder()
	{
		return (String)get_Value(COLUMNNAME_QueryResolverFolder);
	}

	/** Set Query Resolver Package Name.
		@param QueryResolverPackageName Query Resolver Package Name
	*/
	public void setQueryResolverPackageName (String QueryResolverPackageName)
	{
		set_Value (COLUMNNAME_QueryResolverPackageName, QueryResolverPackageName);
	}

	/** Get Query Resolver Package Name.
		@return Query Resolver Package Name	  */
	public String getQueryResolverPackageName()
	{
		return (String)get_Value(COLUMNNAME_QueryResolverPackageName);
	}

	/** Set Schema Folder.
		@param SchemaFolder Schema Folder
	*/
	public void setSchemaFolder (String SchemaFolder)
	{
		set_Value (COLUMNNAME_SchemaFolder, SchemaFolder);
	}

	/** Get Schema Folder.
		@return Schema Folder	  */
	public String getSchemaFolder()
	{
		return (String)get_Value(COLUMNNAME_SchemaFolder);
	}

	/** Set Table Entity Type.
		@param TableEntityType Table Entity Type
	*/
	public void setTableEntityType (String TableEntityType)
	{
		set_Value (COLUMNNAME_TableEntityType, TableEntityType);
	}

	/** Get Table Entity Type.
		@return Table Entity Type	  */
	public String getTableEntityType()
	{
		return (String)get_Value(COLUMNNAME_TableEntityType);
	}

	/** Set DB Table Name.
		@param TableName Name of the table in the database
	*/
	public void setTableName (String TableName)
	{
		set_Value (COLUMNNAME_TableName, TableName);
	}

	/** Get DB Table Name.
		@return Name of the table in the database
	  */
	public String getTableName()
	{
		return (String)get_Value(COLUMNNAME_TableName);
	}
}