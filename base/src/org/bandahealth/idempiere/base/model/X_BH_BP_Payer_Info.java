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
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_BP_Payer_Info
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="BH_BP_Payer_Info")
public class X_BH_BP_Payer_Info extends PO implements I_BH_BP_Payer_Info, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250127L;

    /** Standard Constructor */
    public X_BH_BP_Payer_Info (Properties ctx, int BH_BP_Payer_Info_ID, String trxName)
    {
      super (ctx, BH_BP_Payer_Info_ID, trxName);
      /** if (BH_BP_Payer_Info_ID == 0)
        {
			setBH_BP_Payer_Info_ID (0);
			setBH_Payer_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_BP_Payer_Info (Properties ctx, int BH_BP_Payer_Info_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_BP_Payer_Info_ID, trxName, virtualColumns);
      /** if (BH_BP_Payer_Info_ID == 0)
        {
			setBH_BP_Payer_Info_ID (0);
			setBH_Payer_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_BP_Payer_Info (Properties ctx, String BH_BP_Payer_Info_UU, String trxName)
    {
      super (ctx, BH_BP_Payer_Info_UU, trxName);
      /** if (BH_BP_Payer_Info_UU == null)
        {
			setBH_BP_Payer_Info_ID (0);
			setBH_Payer_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_BP_Payer_Info (Properties ctx, String BH_BP_Payer_Info_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_BP_Payer_Info_UU, trxName, virtualColumns);
      /** if (BH_BP_Payer_Info_UU == null)
        {
			setBH_BP_Payer_Info_ID (0);
			setBH_Payer_ID (0);
			setC_BPartner_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_BP_Payer_Info (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org
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
      StringBuilder sb = new StringBuilder ("X_BH_BP_Payer_Info[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Business Partner Payer Information.
		@param BH_BP_Payer_Info_ID Business Partner Payer Information
	*/
	public void setBH_BP_Payer_Info_ID (int BH_BP_Payer_Info_ID)
	{
		if (BH_BP_Payer_Info_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_BP_Payer_Info_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_BP_Payer_Info_ID, Integer.valueOf(BH_BP_Payer_Info_ID));
	}

	/** Get Business Partner Payer Information.
		@return Business Partner Payer Information	  */
	public int getBH_BP_Payer_Info_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_BP_Payer_Info_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_BP_Payer_Info_UU.
		@param BH_BP_Payer_Info_UU BH_BP_Payer_Info_UU
	*/
	public void setBH_BP_Payer_Info_UU (String BH_BP_Payer_Info_UU)
	{
		set_Value (COLUMNNAME_BH_BP_Payer_Info_UU, BH_BP_Payer_Info_UU);
	}

	/** Get BH_BP_Payer_Info_UU.
		@return BH_BP_Payer_Info_UU	  */
	public String getBH_BP_Payer_Info_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_BP_Payer_Info_UU);
	}

	public org.compiere.model.I_C_BPartner getBH_Payer() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getBH_Payer_ID(), get_TrxName());
	}

	/** Set Payer ID.
		@param BH_Payer_ID Payer ID
	*/
	public void setBH_Payer_ID (int BH_Payer_ID)
	{
		if (BH_Payer_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Payer_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Payer_ID, Integer.valueOf(BH_Payer_ID));
	}

	/** Get Payer ID.
		@return Payer ID	  */
	public int getBH_Payer_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payer_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair()
    {
        return new KeyNamePair(get_ID(), getName());
    }
}