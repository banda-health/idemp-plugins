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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for BH_Feature_Flag_Rule
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Feature_Flag_Rule")
public class X_BH_Feature_Flag_Rule extends PO implements I_BH_Feature_Flag_Rule, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260522L;

    /** Standard Constructor */
    public X_BH_Feature_Flag_Rule (Properties ctx, int BH_Feature_Flag_Rule_ID, String trxName)
    {
      super (ctx, BH_Feature_Flag_Rule_ID, trxName);
      /** if (BH_Feature_Flag_Rule_ID == 0)
        {
			setBH_Feature_Flag_ID (0);
			setBH_Feature_Flag_Rule_ID (0);
			setBH_IsEnabled (false);
// N
			setBH_SystemAdmin (false);
// N
			setSeqNo (0);
// 0
        } */
    }

    /** Standard Constructor */
    public X_BH_Feature_Flag_Rule (Properties ctx, int BH_Feature_Flag_Rule_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Feature_Flag_Rule_ID, trxName, virtualColumns);
      /** if (BH_Feature_Flag_Rule_ID == 0)
        {
			setBH_Feature_Flag_ID (0);
			setBH_Feature_Flag_Rule_ID (0);
			setBH_IsEnabled (false);
// N
			setBH_SystemAdmin (false);
// N
			setSeqNo (0);
// 0
        } */
    }

    /** Standard Constructor */
    public X_BH_Feature_Flag_Rule (Properties ctx, String BH_Feature_Flag_Rule_UU, String trxName)
    {
      super (ctx, BH_Feature_Flag_Rule_UU, trxName);
      /** if (BH_Feature_Flag_Rule_UU == null)
        {
			setBH_Feature_Flag_ID (0);
			setBH_Feature_Flag_Rule_ID (0);
			setBH_IsEnabled (false);
// N
			setBH_SystemAdmin (false);
// N
			setSeqNo (0);
// 0
        } */
    }

    /** Standard Constructor */
    public X_BH_Feature_Flag_Rule (Properties ctx, String BH_Feature_Flag_Rule_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Feature_Flag_Rule_UU, trxName, virtualColumns);
      /** if (BH_Feature_Flag_Rule_UU == null)
        {
			setBH_Feature_Flag_ID (0);
			setBH_Feature_Flag_Rule_ID (0);
			setBH_IsEnabled (false);
// N
			setBH_SystemAdmin (false);
// N
			setSeqNo (0);
// 0
        } */
    }

    /** Load Constructor */
    public X_BH_Feature_Flag_Rule (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Feature_Flag_Rule[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** BH_Environment AD_Reference_ID=374 */
	public static final int BH_ENVIRONMENT_AD_Reference_ID=374;
	/** Evaluation = E */
	public static final String BH_ENVIRONMENT_Evaluation = "E";
	/** Implementation = I */
	public static final String BH_ENVIRONMENT_Implementation = "I";
	/** Production = P */
	public static final String BH_ENVIRONMENT_Production = "P";
	/** Set Environment.
		@param BH_Environment Environment
	*/
	public void setBH_Environment (String BH_Environment)
	{

		set_Value (COLUMNNAME_BH_Environment, BH_Environment);
	}

	/** Get Environment.
		@return Environment	  */
	public String getBH_Environment()
	{
		return (String)get_Value(COLUMNNAME_BH_Environment);
	}

	public I_BH_Feature_Flag getBH_Feature_Flag() throws RuntimeException
	{
		return (I_BH_Feature_Flag)MTable.get(getCtx(), I_BH_Feature_Flag.Table_ID)
			.getPO(getBH_Feature_Flag_ID(), get_TrxName());
	}

	/** Set Feature Flag.
		@param BH_Feature_Flag_ID Feature Flag
	*/
	public void setBH_Feature_Flag_ID (int BH_Feature_Flag_ID)
	{
		if (BH_Feature_Flag_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Feature_Flag_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Feature_Flag_ID, Integer.valueOf(BH_Feature_Flag_ID));
	}

	/** Get Feature Flag.
		@return Feature Flag	  */
	public int getBH_Feature_Flag_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Feature_Flag_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Feature Flag Rule.
		@param BH_Feature_Flag_Rule_ID Feature Flag Rule
	*/
	public void setBH_Feature_Flag_Rule_ID (int BH_Feature_Flag_Rule_ID)
	{
		if (BH_Feature_Flag_Rule_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Feature_Flag_Rule_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Feature_Flag_Rule_ID, Integer.valueOf(BH_Feature_Flag_Rule_ID));
	}

	/** Get Feature Flag Rule.
		@return Feature Flag Rule	  */
	public int getBH_Feature_Flag_Rule_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Feature_Flag_Rule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Feature_Flag_Rule_UU.
		@param BH_Feature_Flag_Rule_UU BH_Feature_Flag_Rule_UU
	*/
	public void setBH_Feature_Flag_Rule_UU (String BH_Feature_Flag_Rule_UU)
	{
		set_Value (COLUMNNAME_BH_Feature_Flag_Rule_UU, BH_Feature_Flag_Rule_UU);
	}

	/** Get BH_Feature_Flag_Rule_UU.
		@return BH_Feature_Flag_Rule_UU	  */
	public String getBH_Feature_Flag_Rule_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Feature_Flag_Rule_UU);
	}

	/** Set Is Enabled.
		@param BH_IsEnabled Is Enabled
	*/
	public void setBH_IsEnabled (boolean BH_IsEnabled)
	{
		set_Value (COLUMNNAME_BH_IsEnabled, Boolean.valueOf(BH_IsEnabled));
	}

	/** Get Is Enabled.
		@return Is Enabled	  */
	public boolean isBH_IsEnabled()
	{
		Object oo = get_Value(COLUMNNAME_BH_IsEnabled);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_AD_AllClients_V getBH_Rule_Client() throws RuntimeException
	{
		return (org.compiere.model.I_AD_AllClients_V)MTable.get(getCtx(), org.compiere.model.I_AD_AllClients_V.Table_ID)
			.getPO(getBH_Rule_Client_ID(), get_TrxName());
	}

	/** Set Client.
		@param BH_Rule_Client_ID Client
	*/
	public void setBH_Rule_Client_ID (int BH_Rule_Client_ID)
	{
		if (BH_Rule_Client_ID < 1)
			set_Value (COLUMNNAME_BH_Rule_Client_ID, null);
		else
			set_Value (COLUMNNAME_BH_Rule_Client_ID, Integer.valueOf(BH_Rule_Client_ID));
	}

	/** Get Client.
		@return Client	  */
	public int getBH_Rule_Client_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Rule_Client_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Org.
		@param BH_Rule_Org_ID Org
	*/
	public void setBH_Rule_Org_ID (int BH_Rule_Org_ID)
	{
		if (BH_Rule_Org_ID < 1)
			set_Value (COLUMNNAME_BH_Rule_Org_ID, null);
		else
			set_Value (COLUMNNAME_BH_Rule_Org_ID, Integer.valueOf(BH_Rule_Org_ID));
	}

	/** Get Org.
		@return Org	  */
	public int getBH_Rule_Org_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Rule_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Role getBH_Rule_Role() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Role)MTable.get(getCtx(), org.compiere.model.I_AD_Role.Table_ID)
			.getPO(getBH_Rule_Role_ID(), get_TrxName());
	}

	/** Set Role.
		@param BH_Rule_Role_ID Role
	*/
	public void setBH_Rule_Role_ID (int BH_Rule_Role_ID)
	{
		if (BH_Rule_Role_ID < 1)
			set_Value (COLUMNNAME_BH_Rule_Role_ID, null);
		else
			set_Value (COLUMNNAME_BH_Rule_Role_ID, Integer.valueOf(BH_Rule_Role_ID));
	}

	/** Get Role.
		@return Role	  */
	public int getBH_Rule_Role_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Rule_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_AllUsers_V getBH_Rule_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_AllUsers_V)MTable.get(getCtx(), org.compiere.model.I_AD_AllUsers_V.Table_ID)
			.getPO(getBH_Rule_User_ID(), get_TrxName());
	}

	/** Set User.
		@param BH_Rule_User_ID User
	*/
	public void setBH_Rule_User_ID (int BH_Rule_User_ID)
	{
		if (BH_Rule_User_ID < 1)
			set_Value (COLUMNNAME_BH_Rule_User_ID, null);
		else
			set_Value (COLUMNNAME_BH_Rule_User_ID, Integer.valueOf(BH_Rule_User_ID));
	}

	/** Get User.
		@return User	  */
	public int getBH_Rule_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Rule_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set System Admin.
		@param BH_SystemAdmin System Admin
	*/
	public void setBH_SystemAdmin (boolean BH_SystemAdmin)
	{
		set_Value (COLUMNNAME_BH_SystemAdmin, Boolean.valueOf(BH_SystemAdmin));
	}

	/** Get System Admin.
		@return System Admin	  */
	public boolean isBH_SystemAdmin()
	{
		Object oo = get_Value(COLUMNNAME_BH_SystemAdmin);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
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

	/** Set Sequence.
		@param SeqNo Method of ordering records; lowest number comes first
	*/
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Valid from.
		@param ValidFrom Valid from including this date (first day)
	*/
	public void setValidFrom (Timestamp ValidFrom)
	{
		set_Value (COLUMNNAME_ValidFrom, ValidFrom);
	}

	/** Get Valid from.
		@return Valid from including this date (first day)
	  */
	public Timestamp getValidFrom()
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidFrom);
	}

	/** Set Valid to.
		@param ValidTo Valid to including this date (last day)
	*/
	public void setValidTo (Timestamp ValidTo)
	{
		set_Value (COLUMNNAME_ValidTo, ValidTo);
	}

	/** Get Valid to.
		@return Valid to including this date (last day)
	  */
	public Timestamp getValidTo()
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidTo);
	}
}