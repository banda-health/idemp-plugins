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

/** Generated Model for BH_Product_Included
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Product_Included")
public class X_BH_Product_Included extends PO implements I_BH_Product_Included, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250429L;

    /** Standard Constructor */
    public X_BH_Product_Included (Properties ctx, int BH_Product_Included_ID, String trxName)
    {
      super (ctx, BH_Product_Included_ID, trxName);
      /** if (BH_Product_Included_ID == 0)
        {
			setIncluded_Product_ID (0);
			setM_Product_ID (0);
			setQty (Env.ZERO);
			setSeqNo (0);
// @SQL=SELECT NVL(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Role_Included WHERE AD_Role_ID=@AD_Role_ID@
        } */
    }

    /** Standard Constructor */
    public X_BH_Product_Included (Properties ctx, int BH_Product_Included_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Product_Included_ID, trxName, virtualColumns);
      /** if (BH_Product_Included_ID == 0)
        {
			setIncluded_Product_ID (0);
			setM_Product_ID (0);
			setQty (Env.ZERO);
			setSeqNo (0);
// @SQL=SELECT NVL(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Role_Included WHERE AD_Role_ID=@AD_Role_ID@
        } */
    }

    /** Standard Constructor */
    public X_BH_Product_Included (Properties ctx, String BH_Product_Included_UU, String trxName)
    {
      super (ctx, BH_Product_Included_UU, trxName);
      /** if (BH_Product_Included_UU == null)
        {
			setIncluded_Product_ID (0);
			setM_Product_ID (0);
			setQty (Env.ZERO);
			setSeqNo (0);
// @SQL=SELECT NVL(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Role_Included WHERE AD_Role_ID=@AD_Role_ID@
        } */
    }

    /** Standard Constructor */
    public X_BH_Product_Included (Properties ctx, String BH_Product_Included_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Product_Included_UU, trxName, virtualColumns);
      /** if (BH_Product_Included_UU == null)
        {
			setIncluded_Product_ID (0);
			setM_Product_ID (0);
			setQty (Env.ZERO);
			setSeqNo (0);
// @SQL=SELECT NVL(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Role_Included WHERE AD_Role_ID=@AD_Role_ID@
        } */
    }

    /** Load Constructor */
    public X_BH_Product_Included (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Product_Included[")
        .append(get_UUID()).append("]");
      return sb.toString();
    }

	/** Set BH_Product_Included_UU.
		@param BH_Product_Included_UU BH_Product_Included_UU
	*/
	public void setBH_Product_Included_UU (String BH_Product_Included_UU)
	{
		set_Value (COLUMNNAME_BH_Product_Included_UU, BH_Product_Included_UU);
	}

	/** Get BH_Product_Included_UU.
		@return BH_Product_Included_UU	  */
	public String getBH_Product_Included_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Product_Included_UU);
	}

	public org.compiere.model.I_M_Product getIncluded_Product() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getIncluded_Product_ID(), get_TrxName());
	}

	/** Set Included Product.
		@param Included_Product_ID Included Product
	*/
	public void setIncluded_Product_ID (int Included_Product_ID)
	{
		if (Included_Product_ID < 1)
			set_ValueNoCheck (COLUMNNAME_Included_Product_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_Included_Product_ID, Integer.valueOf(Included_Product_ID));
	}

	/** Get Included Product.
		@return Included Product	  */
	public int getIncluded_Product_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Included_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
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

	/** Set Quantity.
		@param Qty Quantity
	*/
	public void setQty (BigDecimal Qty)
	{
		set_Value (COLUMNNAME_Qty, Qty);
	}

	/** Get Quantity.
		@return Quantity
	  */
	public BigDecimal getQty()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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
}