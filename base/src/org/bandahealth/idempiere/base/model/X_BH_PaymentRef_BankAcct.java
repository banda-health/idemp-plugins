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

/** Generated Model for BH_PaymentRef_BankAcct
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_PaymentRef_BankAcct extends PO implements I_BH_PaymentRef_BankAcct, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200521L;

    /** Standard Constructor */
    public X_BH_PaymentRef_BankAcct (Properties ctx, int BH_PaymentRef_BankAcct_ID, String trxName)
    {
      super (ctx, BH_PaymentRef_BankAcct_ID, trxName);
      /** if (BH_PaymentRef_BankAcct_ID == 0)
        {
			setBH_PaymentRef_BankAcct_ID (0);
			setBH_PaymentRef_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_PaymentRef_BankAcct (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client 
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
      StringBuilder sb = new StringBuilder ("X_BH_PaymentRef_BankAcct[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Ref_List getAD_Ref_List() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Ref_List) MTable.get(getCtx(), org.compiere.model.I_AD_Ref_List.Table_Name)
			.getPO(getAD_Ref_List_ID(), get_TrxName());	}

	/** Set Reference List.
		@param AD_Ref_List_ID 
		Reference List based on Table
	  */
	public void setAD_Ref_List_ID (int AD_Ref_List_ID)
	{
		if (AD_Ref_List_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_Ref_List_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Ref_List_ID, Integer.valueOf(AD_Ref_List_ID));
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

	/** Set BH_PaymentRef_BankAcct.
		@param BH_PaymentRef_BankAcct_ID BH_PaymentRef_BankAcct	  */
	public void setBH_PaymentRef_BankAcct_ID (int BH_PaymentRef_BankAcct_ID)
	{
		if (BH_PaymentRef_BankAcct_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_PaymentRef_BankAcct_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_PaymentRef_BankAcct_ID, Integer.valueOf(BH_PaymentRef_BankAcct_ID));
	}

	/** Get BH_PaymentRef_BankAcct.
		@return BH_PaymentRef_BankAcct	  */
	public int getBH_PaymentRef_BankAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PaymentRef_BankAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_PaymentRef_BankAcct_UU.
		@param BH_PaymentRef_BankAcct_UU BH_PaymentRef_BankAcct_UU	  */
	public void setBH_PaymentRef_BankAcct_UU (String BH_PaymentRef_BankAcct_UU)
	{
		set_Value (COLUMNNAME_BH_PaymentRef_BankAcct_UU, BH_PaymentRef_BankAcct_UU);
	}

	/** Get BH_PaymentRef_BankAcct_UU.
		@return BH_PaymentRef_BankAcct_UU	  */
	public String getBH_PaymentRef_BankAcct_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_PaymentRef_BankAcct_UU);
	}

	public I_BH_PaymentRef getBH_PaymentRef() throws RuntimeException
    {
		return (I_BH_PaymentRef)MTable.get(getCtx(), I_BH_PaymentRef.Table_Name)
			.getPO(getBH_PaymentRef_ID(), get_TrxName());	}

	/** Set BH_PaymentRef.
		@param BH_PaymentRef_ID BH_PaymentRef	  */
	public void setBH_PaymentRef_ID (int BH_PaymentRef_ID)
	{
		if (BH_PaymentRef_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_PaymentRef_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_PaymentRef_ID, Integer.valueOf(BH_PaymentRef_ID));
	}

	/** Get BH_PaymentRef.
		@return BH_PaymentRef	  */
	public int getBH_PaymentRef_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_PaymentRef_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_PaymentRefList_Value.
		@param BH_PaymentRefList_Value 
		The value of the payment reference list entry
	  */
	public void setBH_PaymentRefList_Value (String BH_PaymentRefList_Value)
	{
		set_Value (COLUMNNAME_BH_PaymentRefList_Value, BH_PaymentRefList_Value);
	}

	/** Get BH_PaymentRefList_Value.
		@return The value of the payment reference list entry
	  */
	public String getBH_PaymentRefList_Value () 
	{
		return (String)get_Value(COLUMNNAME_BH_PaymentRefList_Value);
	}

	/** Set BH_ReferenceList_IsActive.
		@param BH_ReferenceList_IsActive BH_ReferenceList_IsActive	  */
	public void setBH_ReferenceList_IsActive (boolean BH_ReferenceList_IsActive)
	{
		throw new IllegalArgumentException ("BH_ReferenceList_IsActive is virtual column");	}

	/** Get BH_ReferenceList_IsActive.
		@return BH_ReferenceList_IsActive	  */
	public boolean isBH_ReferenceList_IsActive () 
	{
		Object oo = get_Value(COLUMNNAME_BH_ReferenceList_IsActive);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_C_BankAccount getC_BankAccount() throws RuntimeException
    {
		return (org.compiere.model.I_C_BankAccount)MTable.get(getCtx(), org.compiere.model.I_C_BankAccount.Table_Name)
			.getPO(getC_BankAccount_ID(), get_TrxName());	}

	/** Set Bank Account.
		@param C_BankAccount_ID 
		Account at the Bank
	  */
	public void setC_BankAccount_ID (int C_BankAccount_ID)
	{
		if (C_BankAccount_ID < 1) 
			set_Value (COLUMNNAME_C_BankAccount_ID, null);
		else 
			set_Value (COLUMNNAME_C_BankAccount_ID, Integer.valueOf(C_BankAccount_ID));
	}

	/** Get Bank Account.
		@return Account at the Bank
	  */
	public int getC_BankAccount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BankAccount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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