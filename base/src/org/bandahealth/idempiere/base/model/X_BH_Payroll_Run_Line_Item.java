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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_Payroll_Run_Line_Item
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Payroll_Run_Line_Item")
public class X_BH_Payroll_Run_Line_Item extends PO implements I_BH_Payroll_Run_Line_Item, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260709L;

    /** Standard Constructor */
    public X_BH_Payroll_Run_Line_Item (Properties ctx, int BH_Payroll_Run_Line_Item_ID, String trxName)
    {
      super (ctx, BH_Payroll_Run_Line_Item_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run_Line_Item (Properties ctx, int BH_Payroll_Run_Line_Item_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Run_Line_Item_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run_Line_Item (Properties ctx, String BH_Payroll_Run_Line_Item_UU, String trxName)
    {
      super (ctx, BH_Payroll_Run_Line_Item_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Run_Line_Item (Properties ctx, String BH_Payroll_Run_Line_Item_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Run_Line_Item_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_Payroll_Run_Line_Item (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Payroll_Run_Line_Item[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Category.
		@param BH_Category Category
	*/
	public void setBH_Category (String BH_Category)
	{
		set_Value (COLUMNNAME_BH_Category, BH_Category);
	}

	/** Get Category.
		@return Category	  */
	public String getBH_Category()
	{
		return (String)get_Value(COLUMNNAME_BH_Category);
	}

	/** Set Employee Amount.
		@param BH_EmployeeAmount Employee Amount
	*/
	public void setBH_EmployeeAmount (BigDecimal BH_EmployeeAmount)
	{
		set_Value (COLUMNNAME_BH_EmployeeAmount, BH_EmployeeAmount);
	}

	/** Get Employee Amount.
		@return Employee Amount	  */
	public BigDecimal getBH_EmployeeAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_EmployeeAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Employer Amount.
		@param BH_EmployerAmount Employer Amount
	*/
	public void setBH_EmployerAmount (BigDecimal BH_EmployerAmount)
	{
		set_Value (COLUMNNAME_BH_EmployerAmount, BH_EmployerAmount);
	}

	/** Get Employer Amount.
		@return Employer Amount	  */
	public BigDecimal getBH_EmployerAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_EmployerAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tax Deductible.
		@param BH_IsTaxDeductible Tax Deductible
	*/
	public void setBH_IsTaxDeductible (boolean BH_IsTaxDeductible)
	{
		set_Value (COLUMNNAME_BH_IsTaxDeductible, Boolean.valueOf(BH_IsTaxDeductible));
	}

	/** Get Tax Deductible.
		@return Tax Deductible	  */
	public boolean isBH_IsTaxDeductible()
	{
		Object oo = get_Value(COLUMNNAME_BH_IsTaxDeductible);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Payroll Run Line.
		@param BH_Payroll_Run_Line_ID Payroll Run Line
	*/
	public void setBH_Payroll_Run_Line_ID (int BH_Payroll_Run_Line_ID)
	{
		if (BH_Payroll_Run_Line_ID < 1)
			set_Value (COLUMNNAME_BH_Payroll_Run_Line_ID, null);
		else
			set_Value (COLUMNNAME_BH_Payroll_Run_Line_ID, Integer.valueOf(BH_Payroll_Run_Line_ID));
	}

	/** Get Payroll Run Line.
		@return Payroll Run Line	  */
	public int getBH_Payroll_Run_Line_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Run_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Payroll Run Line Item.
		@param BH_Payroll_Run_Line_Item_ID Payroll Run Line Item
	*/
	public void setBH_Payroll_Run_Line_Item_ID (int BH_Payroll_Run_Line_Item_ID)
	{
		if (BH_Payroll_Run_Line_Item_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Run_Line_Item_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Run_Line_Item_ID, Integer.valueOf(BH_Payroll_Run_Line_Item_ID));
	}

	/** Get Payroll Run Line Item.
		@return Payroll Run Line Item	  */
	public int getBH_Payroll_Run_Line_Item_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Run_Line_Item_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Payroll_Run_Line_Item_UU.
		@param BH_Payroll_Run_Line_Item_UU BH_Payroll_Run_Line_Item_UU
	*/
	public void setBH_Payroll_Run_Line_Item_UU (String BH_Payroll_Run_Line_Item_UU)
	{
		set_Value (COLUMNNAME_BH_Payroll_Run_Line_Item_UU, BH_Payroll_Run_Line_Item_UU);
	}

	/** Get BH_Payroll_Run_Line_Item_UU.
		@return BH_Payroll_Run_Line_Item_UU	  */
	public String getBH_Payroll_Run_Line_Item_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Payroll_Run_Line_Item_UU);
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

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair()
    {
        return new KeyNamePair(get_ID(), String.valueOf(getName()));
    }
}
