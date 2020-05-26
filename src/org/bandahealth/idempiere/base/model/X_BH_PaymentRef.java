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
import org.compiere.model.I_Persistent;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.POInfo;
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_PaymentRef
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_PaymentRef extends PO implements I_BH_PaymentRef, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200521L;

    /** Standard Constructor */
    public X_BH_PaymentRef (Properties ctx, int BH_PaymentRef_ID, String trxName)
    {
      super (ctx, BH_PaymentRef_ID, trxName);
      /** if (BH_PaymentRef_ID == 0)
        {
			setAD_Reference_ID (0);
			setBH_PaymentRef_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_PaymentRef (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_PaymentRef[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Reference getAD_Reference() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Reference) MTable.get(getCtx(), org.compiere.model.I_AD_Reference.Table_Name)
			.getPO(getAD_Reference_ID(), get_TrxName());	}

	/** Set Reference.
		@param AD_Reference_ID 
		System Reference and Validation
	  */
	public void setAD_Reference_ID (int AD_Reference_ID)
	{
		if (AD_Reference_ID < 1) 
			set_Value (COLUMNNAME_AD_Reference_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Reference_ID, Integer.valueOf(AD_Reference_ID));
	}

	/** Get Reference.
		@return System Reference and Validation
	  */
	public int getAD_Reference_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Reference_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

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

	/** Set BH_PaymentRef_UU.
		@param BH_PaymentRef_UU BH_PaymentRef_UU	  */
	public void setBH_PaymentRef_UU (String BH_PaymentRef_UU)
	{
		set_Value (COLUMNNAME_BH_PaymentRef_UU, BH_PaymentRef_UU);
	}

	/** Get BH_PaymentRef_UU.
		@return BH_PaymentRef_UU	  */
	public String getBH_PaymentRef_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_PaymentRef_UU);
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