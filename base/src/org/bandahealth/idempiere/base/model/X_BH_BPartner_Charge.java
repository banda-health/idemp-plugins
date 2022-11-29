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

/** Generated Model for BH_BPartner_Charge
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_BPartner_Charge extends PO implements I_BH_BPartner_Charge, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210521L;

    /** Standard Constructor */
    public X_BH_BPartner_Charge (Properties ctx, int BH_BPartner_Charge_ID, String trxName)
    {
      super (ctx, BH_BPartner_Charge_ID, trxName);
      /** if (BH_BPartner_Charge_ID == 0)
        {
			setBH_BPartner_Charge_ID (0);
			setC_BPartner_ID (0);
			setC_Charge_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_BH_BPartner_Charge (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_BPartner_Charge[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Business Partner Charges.
		@param BH_BPartner_Charge_ID Business Partner Charges	  */
	public void setBH_BPartner_Charge_ID (int BH_BPartner_Charge_ID)
	{
		if (BH_BPartner_Charge_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_BPartner_Charge_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_BPartner_Charge_ID, Integer.valueOf(BH_BPartner_Charge_ID));
	}

	/** Get Business Partner Charges.
		@return Business Partner Charges	  */
	public int getBH_BPartner_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_BPartner_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_BPartner_Charge_UU.
		@param BH_BPartner_Charge_UU BH_BPartner_Charge_UU	  */
	public void setBH_BPartner_Charge_UU (String BH_BPartner_Charge_UU)
	{
		set_Value (COLUMNNAME_BH_BPartner_Charge_UU, BH_BPartner_Charge_UU);
	}

	/** Get BH_BPartner_Charge_UU.
		@return BH_BPartner_Charge_UU	  */
	public String getBH_BPartner_Charge_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_BPartner_Charge_UU);
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getC_Charge_ID(), get_TrxName());	}

	/** Set Charge.
		@param C_Charge_ID 
		Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Charge_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}

	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
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