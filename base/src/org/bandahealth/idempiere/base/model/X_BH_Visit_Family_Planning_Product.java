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
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for BH_Visit_Family_Planning_Product
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Visit_Family_Planning_Product")
public class X_BH_Visit_Family_Planning_Product extends PO implements I_BH_Visit_Family_Planning_Product, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260630L;

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning_Product (Properties ctx, int BH_Visit_Family_Planning_Product_ID, String trxName)
    {
      super (ctx, BH_Visit_Family_Planning_Product_ID, trxName);
      /** if (BH_Visit_Family_Planning_Product_ID == 0)
        {
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_Family_Planning_Product_ID (0);
			setM_Product_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning_Product (Properties ctx, int BH_Visit_Family_Planning_Product_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Visit_Family_Planning_Product_ID, trxName, virtualColumns);
      /** if (BH_Visit_Family_Planning_Product_ID == 0)
        {
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_Family_Planning_Product_ID (0);
			setM_Product_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning_Product (Properties ctx, String BH_Visit_Family_Planning_Product_UU, String trxName)
    {
      super (ctx, BH_Visit_Family_Planning_Product_UU, trxName);
      /** if (BH_Visit_Family_Planning_Product_UU == null)
        {
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_Family_Planning_Product_ID (0);
			setM_Product_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning_Product (Properties ctx, String BH_Visit_Family_Planning_Product_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Visit_Family_Planning_Product_UU, trxName, virtualColumns);
      /** if (BH_Visit_Family_Planning_Product_UU == null)
        {
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_Family_Planning_Product_ID (0);
			setM_Product_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Visit_Family_Planning_Product (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Visit_Family_Planning_Product[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Condoms = condomsForFp */
	public static final String BH_FP_METHOD_Condoms = "condomsForFp";
	/** Cycle beads = cycleBeads */
	public static final String BH_FP_METHOD_CycleBeads = "cycleBeads";
	/** Emergency contraception = emergencyContraception */
	public static final String BH_FP_METHOD_EmergencyContraception = "emergencyContraception";
	/** Implants = implants */
	public static final String BH_FP_METHOD_Implants = "implants";
	/** Injectable = injectable */
	public static final String BH_FP_METHOD_Injectable = "injectable";
	/** IUCD = iucd */
	public static final String BH_FP_METHOD_IUCD = "iucd";
	/** Oral contraceptive = oralContraceptive */
	public static final String BH_FP_METHOD_OralContraceptive = "oralContraceptive";
	/** Set FP Method.
		@param BH_Fp_Method FP Method
	*/
	public void setBH_Fp_Method (String BH_Fp_Method)
	{

		set_Value (COLUMNNAME_BH_Fp_Method, BH_Fp_Method);
	}

	/** Get FP Method.
		@return FP Method	  */
	public String getBH_Fp_Method()
	{
		return (String)get_Value(COLUMNNAME_BH_Fp_Method);
	}

	/** Female = female */
	public static final String BH_LINE_ROLE_Female = "female";
	/** Male = male */
	public static final String BH_LINE_ROLE_Male = "male";
	/** Set Line Role.
		@param BH_Line_Role Line Role
	*/
	public void setBH_Line_Role (String BH_Line_Role)
	{

		set_Value (COLUMNNAME_BH_Line_Role, BH_Line_Role);
	}

	/** Get Line Role.
		@return Line Role	  */
	public String getBH_Line_Role()
	{
		return (String)get_Value(COLUMNNAME_BH_Line_Role);
	}

	public I_BH_Visit_Family_Planning getBH_Visit_Family_Planning() throws RuntimeException
	{
		return (I_BH_Visit_Family_Planning)MTable.get(getCtx(), I_BH_Visit_Family_Planning.Table_ID)
			.getPO(getBH_Visit_Family_Planning_ID(), get_TrxName());
	}

	/** Set Visit Family Planning.
		@param BH_Visit_Family_Planning_ID Visit Family Planning
	*/
	public void setBH_Visit_Family_Planning_ID (int BH_Visit_Family_Planning_ID)
	{
		if (BH_Visit_Family_Planning_ID < 1)
			set_Value (COLUMNNAME_BH_Visit_Family_Planning_ID, null);
		else
			set_Value (COLUMNNAME_BH_Visit_Family_Planning_ID, Integer.valueOf(BH_Visit_Family_Planning_ID));
	}

	/** Get Visit Family Planning.
		@return Visit Family Planning	  */
	public int getBH_Visit_Family_Planning_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_Family_Planning_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Visit Family Planning Product.
		@param BH_Visit_Family_Planning_Product_ID Visit Family Planning Product
	*/
	public void setBH_Visit_Family_Planning_Product_ID (int BH_Visit_Family_Planning_Product_ID)
	{
		if (BH_Visit_Family_Planning_Product_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Visit_Family_Planning_Product_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Visit_Family_Planning_Product_ID, Integer.valueOf(BH_Visit_Family_Planning_Product_ID));
	}

	/** Get Visit Family Planning Product.
		@return Visit Family Planning Product	  */
	public int getBH_Visit_Family_Planning_Product_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_Family_Planning_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Visit_Family_Planning_Product_UU.
		@param BH_Visit_Family_Planning_Product_UU BH_Visit_Family_Planning_Product_UU
	*/
	public void setBH_Visit_Family_Planning_Product_UU (String BH_Visit_Family_Planning_Product_UU)
	{
		set_Value (COLUMNNAME_BH_Visit_Family_Planning_Product_UU, BH_Visit_Family_Planning_Product_UU);
	}

	/** Get BH_Visit_Family_Planning_Product_UU.
		@return BH_Visit_Family_Planning_Product_UU	  */
	public String getBH_Visit_Family_Planning_Product_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Visit_Family_Planning_Product_UU);
	}

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException
	{
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_ID)
			.getPO(getC_OrderLine_ID(), get_TrxName());
	}

	/** Set Sales Order Line.
		@param C_OrderLine_ID Sales Order Line
	*/
	public void setC_OrderLine_ID (int C_OrderLine_ID)
	{
		if (C_OrderLine_ID < 1)
			set_Value (COLUMNNAME_C_OrderLine_ID, null);
		else
			set_Value (COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
	}

	/** Get Sales Order Line.
		@return Sales Order Line
	  */
	public int getC_OrderLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_OrderLine_ID);
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

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getM_Product_ID(), get_TrxName());
	}

	/** Set Product/Service.
		@param M_Product_ID Product, Service, Item
	*/
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1)
			set_Value (COLUMNNAME_M_Product_ID, null);
		else
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product/Service.
		@return Product, Service, Item
	  */
	public int getM_Product_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Quantity Entered.
		@param QtyEntered Quantity Entered
	*/
	public void setQtyEntered (BigDecimal QtyEntered)
	{
		set_Value (COLUMNNAME_QtyEntered, QtyEntered);
	}

	/** Get Quantity Entered.
		@return Quantity Entered	  */
	public BigDecimal getQtyEntered()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyEntered);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}