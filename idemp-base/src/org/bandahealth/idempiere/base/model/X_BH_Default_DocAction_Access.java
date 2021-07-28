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

/** Generated Model for BH_Default_DocAction_Access
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_Default_DocAction_Access extends PO implements I_BH_Default_DocAction_Access, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210216L;

    /** Standard Constructor */
    public X_BH_Default_DocAction_Access (Properties ctx, int BH_Default_DocAction_Access_ID, String trxName)
    {
      super (ctx, BH_Default_DocAction_Access_ID, trxName);
      /** if (BH_Default_DocAction_Access_ID == 0)
        {
			setAD_Ref_List_ID (0);
			setC_DocType_ID (0);
			setDB_UserType (null);
        } */
    }

    /** Load Constructor */
    public X_BH_Default_DocAction_Access (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Default_DocAction_Access[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Ref_List getAD_Ref_List() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Ref_List)MTable.get(getCtx(), org.compiere.model.I_AD_Ref_List.Table_Name)
			.getPO(getAD_Ref_List_ID(), get_TrxName());	}

	/** Set Reference List.
		@param AD_Ref_List_ID 
		Reference List based on Table
	  */
	public void setAD_Ref_List_ID (int AD_Ref_List_ID)
	{
		if (AD_Ref_List_ID < 1) 
			set_Value (COLUMNNAME_AD_Ref_List_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Ref_List_ID, Integer.valueOf(AD_Ref_List_ID));
	}

	/** Get Reference List.
		@return Reference List based on Table
	  */
	public int getAD_Ref_List_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Ref_List_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Default_DocAction_Access_ID.
		@param BH_Default_DocAction_Access_ID BH_Default_DocAction_Access_ID	  */
	public void setBH_Default_DocAction_Access_ID (int BH_Default_DocAction_Access_ID)
	{
		if (BH_Default_DocAction_Access_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_Default_DocAction_Access_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_Default_DocAction_Access_ID, Integer.valueOf(BH_Default_DocAction_Access_ID));
	}

	/** Get BH_Default_DocAction_Access_ID.
		@return BH_Default_DocAction_Access_ID	  */
	public int getBH_Default_DocAction_Access_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Default_DocAction_Access_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Default_DocAction_Access_UU.
		@param BH_Default_DocAction_Access_UU BH_Default_DocAction_Access_UU	  */
	public void setBH_Default_DocAction_Access_UU (String BH_Default_DocAction_Access_UU)
	{
		set_Value (COLUMNNAME_BH_Default_DocAction_Access_UU, BH_Default_DocAction_Access_UU);
	}

	/** Get BH_Default_DocAction_Access_UU.
		@return BH_Default_DocAction_Access_UU	  */
	public String getBH_Default_DocAction_Access_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_Default_DocAction_Access_UU);
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Admin = A */
	public static final String DB_USERTYPE_Admin = "A";
	/** User = U */
	public static final String DB_USERTYPE_User = "U";
	/** Advanced User = V */
	public static final String DB_USERTYPE_AdvancedUser = "V";
	/** Set UserType.
		@param DB_UserType 
		The User Type when a new client is created
	  */
	public void setDB_UserType (String DB_UserType)
	{

		set_ValueNoCheck (COLUMNNAME_DB_UserType, DB_UserType);
	}

	/** Get UserType.
		@return The User Type when a new client is created
	  */
	public String getDB_UserType () 
	{
		return (String)get_Value(COLUMNNAME_DB_UserType);
	}
}