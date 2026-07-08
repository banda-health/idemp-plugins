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

/** Generated Model for BH_Field_Rule
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Field_Rule")
public class X_BH_Field_Rule extends PO implements I_BH_Field_Rule, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260702L;

    /** Standard Constructor */
    public X_BH_Field_Rule (Properties ctx, int BH_Field_Rule_ID, String trxName)
    {
      super (ctx, BH_Field_Rule_ID, trxName);
      /** if (BH_Field_Rule_ID == 0)
        {
			setBH_Field_Rule_ID (0);
			setBH_FieldKey (null);
			setBH_Form (null);
			setBH_Required (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Field_Rule (Properties ctx, int BH_Field_Rule_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Field_Rule_ID, trxName, virtualColumns);
      /** if (BH_Field_Rule_ID == 0)
        {
			setBH_Field_Rule_ID (0);
			setBH_FieldKey (null);
			setBH_Form (null);
			setBH_Required (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Field_Rule (Properties ctx, String BH_Field_Rule_UU, String trxName)
    {
      super (ctx, BH_Field_Rule_UU, trxName);
      /** if (BH_Field_Rule_UU == null)
        {
			setBH_Field_Rule_ID (0);
			setBH_FieldKey (null);
			setBH_Form (null);
			setBH_Required (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Field_Rule (Properties ctx, String BH_Field_Rule_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Field_Rule_UU, trxName, virtualColumns);
      /** if (BH_Field_Rule_UU == null)
        {
			setBH_Field_Rule_ID (0);
			setBH_FieldKey (null);
			setBH_Form (null);
			setBH_Required (false);
// N
        } */
    }

    /** Load Constructor */
    public X_BH_Field_Rule (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Field_Rule[")
        .append(get_ID()).append(",BH_Form=").append(getBH_Form()).append(",BH_FieldKey=").append(getBH_FieldKey()).append("]");
      return sb.toString();
    }

	/** Set Field Rule.
		@param BH_Field_Rule_ID Field Rule
	*/
	public void setBH_Field_Rule_ID (int BH_Field_Rule_ID)
	{
		if (BH_Field_Rule_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Field_Rule_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Field_Rule_ID, Integer.valueOf(BH_Field_Rule_ID));
	}

	/** Get Field Rule.
		@return Field Rule	  */
	public int getBH_Field_Rule_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Field_Rule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Field_Rule_UU.
		@param BH_Field_Rule_UU BH_Field_Rule_UU
	*/
	public void setBH_Field_Rule_UU (String BH_Field_Rule_UU)
	{
		set_Value (COLUMNNAME_BH_Field_Rule_UU, BH_Field_Rule_UU);
	}

	/** Get BH_Field_Rule_UU.
		@return BH_Field_Rule_UU	  */
	public String getBH_Field_Rule_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Field_Rule_UU);
	}

	/** Set Field Key.
		@param BH_FieldKey Field Key
	*/
	public void setBH_FieldKey (String BH_FieldKey)
	{
		set_Value (COLUMNNAME_BH_FieldKey, BH_FieldKey);
	}

	/** Get Field Key.
		@return Field Key	  */
	public String getBH_FieldKey()
	{
		return (String)get_Value(COLUMNNAME_BH_FieldKey);
	}

	/** Set Form.
		@param BH_Form Form
	*/
	public void setBH_Form (String BH_Form)
	{
		set_Value (COLUMNNAME_BH_Form, BH_Form);
	}

	/** Get Form.
		@return Form	  */
	public String getBH_Form()
	{
		return (String)get_Value(COLUMNNAME_BH_Form);
	}

	/** Set Required.
		@param BH_Required Required
	*/
	public void setBH_Required (boolean BH_Required)
	{
		set_Value (COLUMNNAME_BH_Required, Boolean.valueOf(BH_Required));
	}

	/** Get Required.
		@return Required	  */
	public boolean isBH_Required()
	{
		Object oo = get_Value(COLUMNNAME_BH_Required);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair()
    {
        return new KeyNamePair(get_ID(), String.valueOf(getBH_FieldKey()));
    }
}
