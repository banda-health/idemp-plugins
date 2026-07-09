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

/** Generated Model for BH_Payroll_Component
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Payroll_Component")
public class X_BH_Payroll_Component extends PO implements I_BH_Payroll_Component, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260709L;

    /** Standard Constructor */
    public X_BH_Payroll_Component (Properties ctx, int BH_Payroll_Component_ID, String trxName)
    {
      super (ctx, BH_Payroll_Component_ID, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Component (Properties ctx, int BH_Payroll_Component_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Component_ID, trxName, virtualColumns);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Component (Properties ctx, String BH_Payroll_Component_UU, String trxName)
    {
      super (ctx, BH_Payroll_Component_UU, trxName);
    }

    /** Standard Constructor */
    public X_BH_Payroll_Component (Properties ctx, String BH_Payroll_Component_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Payroll_Component_UU, trxName, virtualColumns);
    }

    /** Load Constructor */
    public X_BH_Payroll_Component (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org
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
      StringBuilder sb = new StringBuilder ("X_BH_Payroll_Component[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Calculation Method.
		@param BH_CalcMethod Calculation Method
	*/
	public void setBH_CalcMethod (String BH_CalcMethod)
	{
		set_Value (COLUMNNAME_BH_CalcMethod, BH_CalcMethod);
	}

	/** Get Calculation Method.
		@return Calculation Method	  */
	public String getBH_CalcMethod()
	{
		return (String)get_Value(COLUMNNAME_BH_CalcMethod);
	}

	/** Set Cap Amount.
		@param BH_Cap Cap Amount
	*/
	public void setBH_Cap (BigDecimal BH_Cap)
	{
		set_Value (COLUMNNAME_BH_Cap, BH_Cap);
	}

	/** Get Cap Amount.
		@return Cap Amount	  */
	public BigDecimal getBH_Cap()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_Cap);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Employer Rate.
		@param BH_EmployerRate Employer Rate
	*/
	public void setBH_EmployerRate (BigDecimal BH_EmployerRate)
	{
		set_Value (COLUMNNAME_BH_EmployerRate, BH_EmployerRate);
	}

	/** Get Employer Rate.
		@return Employer Rate	  */
	public BigDecimal getBH_EmployerRate()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_EmployerRate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Filing Due Day.
		@param BH_FilingDueDay Filing Due Day
	*/
	public void setBH_FilingDueDay (int BH_FilingDueDay)
	{
		set_Value (COLUMNNAME_BH_FilingDueDay, Integer.valueOf(BH_FilingDueDay));
	}

	/** Get Filing Due Day.
		@return Filing Due Day	  */
	public int getBH_FilingDueDay()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_FilingDueDay);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Floor Amount.
		@param BH_Floor Floor Amount
	*/
	public void setBH_Floor (BigDecimal BH_Floor)
	{
		set_Value (COLUMNNAME_BH_Floor, BH_Floor);
	}

	/** Get Floor Amount.
		@return Floor Amount	  */
	public BigDecimal getBH_Floor()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_Floor);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Statutory.
		@param BH_IsStatutory Statutory
	*/
	public void setBH_IsStatutory (boolean BH_IsStatutory)
	{
		set_Value (COLUMNNAME_BH_IsStatutory, Boolean.valueOf(BH_IsStatutory));
	}

	/** Get Statutory.
		@return Statutory	  */
	public boolean isBH_IsStatutory()
	{
		Object oo = get_Value(COLUMNNAME_BH_IsStatutory);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Payroll Component.
		@param BH_Payroll_Component_ID Payroll Component
	*/
	public void setBH_Payroll_Component_ID (int BH_Payroll_Component_ID)
	{
		if (BH_Payroll_Component_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Component_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Payroll_Component_ID, Integer.valueOf(BH_Payroll_Component_ID));
	}

	/** Get Payroll Component.
		@return Payroll Component	  */
	public int getBH_Payroll_Component_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Payroll_Component_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Payroll_Component_UU.
		@param BH_Payroll_Component_UU BH_Payroll_Component_UU
	*/
	public void setBH_Payroll_Component_UU (String BH_Payroll_Component_UU)
	{
		set_Value (COLUMNNAME_BH_Payroll_Component_UU, BH_Payroll_Component_UU);
	}

	/** Get BH_Payroll_Component_UU.
		@return BH_Payroll_Component_UU	  */
	public String getBH_Payroll_Component_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Payroll_Component_UU);
	}

	/** Set Rate.
		@param BH_Rate Rate
	*/
	public void setBH_Rate (BigDecimal BH_Rate)
	{
		set_Value (COLUMNNAME_BH_Rate, BH_Rate);
	}

	/** Get Rate.
		@return Rate	  */
	public BigDecimal getBH_Rate()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_Rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tax Deductible Cap.
		@param BH_TaxDeductibleCap Tax Deductible Cap
	*/
	public void setBH_TaxDeductibleCap (BigDecimal BH_TaxDeductibleCap)
	{
		set_Value (COLUMNNAME_BH_TaxDeductibleCap, BH_TaxDeductibleCap);
	}

	/** Get Tax Deductible Cap.
		@return Tax Deductible Cap	  */
	public BigDecimal getBH_TaxDeductibleCap()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_TaxDeductibleCap);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tier 1 Limit.
		@param BH_Tier1_Limit Tier 1 Limit
	*/
	public void setBH_Tier1_Limit (BigDecimal BH_Tier1_Limit)
	{
		set_Value (COLUMNNAME_BH_Tier1_Limit, BH_Tier1_Limit);
	}

	/** Get Tier 1 Limit.
		@return Tier 1 Limit	  */
	public BigDecimal getBH_Tier1_Limit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_Tier1_Limit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tier 2 Limit.
		@param BH_Tier2_Limit Tier 2 Limit
	*/
	public void setBH_Tier2_Limit (BigDecimal BH_Tier2_Limit)
	{
		set_Value (COLUMNNAME_BH_Tier2_Limit, BH_Tier2_Limit);
	}

	/** Get Tier 2 Limit.
		@return Tier 2 Limit	  */
	public BigDecimal getBH_Tier2_Limit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_Tier2_Limit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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
