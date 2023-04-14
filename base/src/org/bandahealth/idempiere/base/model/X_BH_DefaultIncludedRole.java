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

import org.compiere.model.I_Persistent;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.POInfo;
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_DefaultIncludedRole
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_DefaultIncludedRole extends PO implements I_BH_DefaultIncludedRole, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200920L;

    /** Standard Constructor */
    public X_BH_DefaultIncludedRole (Properties ctx, int BH_DefaultIncludedRole_ID, String trxName)
    {
      super (ctx, BH_DefaultIncludedRole_ID, trxName);
      /** if (BH_DefaultIncludedRole_ID == 0)
        {
			setBH_DefaultIncludedRole_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_DefaultIncludedRole (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_DefaultIncludedRole[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Default Included Roles.
		@param BH_DefaultIncludedRole_ID Default Included Roles	  */
	public void setBH_DefaultIncludedRole_ID (int BH_DefaultIncludedRole_ID)
	{
		if (BH_DefaultIncludedRole_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_DefaultIncludedRole_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_DefaultIncludedRole_ID, Integer.valueOf(BH_DefaultIncludedRole_ID));
	}

	/** Get Default Included Roles.
		@return Default Included Roles	  */
	public int getBH_DefaultIncludedRole_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_DefaultIncludedRole_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_DefaultIncludedRole_UU.
		@param BH_DefaultIncludedRole_UU BH_DefaultIncludedRole_UU	  */
	public void setBH_DefaultIncludedRole_UU (String BH_DefaultIncludedRole_UU)
	{
		set_Value (COLUMNNAME_BH_DefaultIncludedRole_UU, BH_DefaultIncludedRole_UU);
	}

	/** Get BH_DefaultIncludedRole_UU.
		@return BH_DefaultIncludedRole_UU	  */
	public String getBH_DefaultIncludedRole_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_DefaultIncludedRole_UU);
	}

	/** Admin = A */
	public static final String DB_USERTYPE_Admin = "A";
	/** User = U */
	public static final String DB_USERTYPE_User = "U";
	/** Advanced User = V */
	public static final String DB_USERTYPE_AdvancedUser = "V";
	/** Clinician = C */
	public static final String DB_USERTYPE_Clinician = "C";
	/** Set UserType.
		@param DB_UserType 
		The User Type when a new client is created
	  */
	public void setDB_UserType (String DB_UserType)
	{

		set_Value (COLUMNNAME_DB_UserType, DB_UserType);
	}

	/** Get UserType.
		@return The User Type when a new client is created
	  */
	public String getDB_UserType () 
	{
		return (String)get_Value(COLUMNNAME_DB_UserType);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	public org.compiere.model.I_AD_Role getIncluded_Role() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Role) MTable.get(getCtx(), org.compiere.model.I_AD_Role.Table_Name)
			.getPO(getIncluded_Role_ID(), get_TrxName());	}

	/** Set Included Role.
		@param Included_Role_ID Included Role	  */
	public void setIncluded_Role_ID (int Included_Role_ID)
	{
		if (Included_Role_ID < 1) 
			set_Value (COLUMNNAME_Included_Role_ID, null);
		else 
			set_Value (COLUMNNAME_Included_Role_ID, Integer.valueOf(Included_Role_ID));
	}

	/** Get Included Role.
		@return Included Role	  */
	public int getIncluded_Role_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Included_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }
}