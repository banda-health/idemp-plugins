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

/** Generated Model for BH_I_Product_Quantity
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_BH_I_Product_Quantity extends PO implements I_BH_I_Product_Quantity, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210909L;

    /** Standard Constructor */
    public X_BH_I_Product_Quantity (Properties ctx, int BH_I_Product_Quantity_ID, String trxName)
    {
      super (ctx, BH_I_Product_Quantity_ID, trxName);
      /** if (BH_I_Product_Quantity_ID == 0)
        {
			setBH_BuyPrice (Env.ZERO);
// 0
			setBH_HasExpiration (false);
// N
			setBH_I_Product_Quantity_ID (0);
			setBH_InitialQuantity (Env.ZERO);
// 0
			setBH_SellPrice (Env.ZERO);
// 0
			setCategoryName (null);
// Pharmacy
			setName (null);
// Product
        } */
    }

    /** Load Constructor */
    public X_BH_I_Product_Quantity (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_I_Product_Quantity[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set BH_BuyPrice.
		@param BH_BuyPrice 
		Purchase price of product
	  */
	public void setBH_BuyPrice (BigDecimal BH_BuyPrice)
	{
		set_Value (COLUMNNAME_BH_BuyPrice, BH_BuyPrice);
	}

	/** Get BH_BuyPrice.
		@return Purchase price of product
	  */
	public BigDecimal getBH_BuyPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_BuyPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Lot 2 Buying Price.
		@param BH_BuyPrice_Lot2 Lot 2 Buying Price	  */
	public void setBH_BuyPrice_Lot2 (BigDecimal BH_BuyPrice_Lot2)
	{
		set_Value (COLUMNNAME_BH_BuyPrice_Lot2, BH_BuyPrice_Lot2);
	}

	/** Get Lot 2 Buying Price.
		@return Lot 2 Buying Price	  */
	public BigDecimal getBH_BuyPrice_Lot2 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_BuyPrice_Lot2);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Lot 3 Buying Price.
		@param BH_BuyPrice_Lot3 Lot 3 Buying Price	  */
	public void setBH_BuyPrice_Lot3 (BigDecimal BH_BuyPrice_Lot3)
	{
		set_Value (COLUMNNAME_BH_BuyPrice_Lot3, BH_BuyPrice_Lot3);
	}

	/** Get Lot 3 Buying Price.
		@return Lot 3 Buying Price	  */
	public BigDecimal getBH_BuyPrice_Lot3 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_BuyPrice_Lot3);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Lot 2 Guarantee Date.
		@param BH_GuaranteeDate_Lot2 Lot 2 Guarantee Date	  */
	public void setBH_GuaranteeDate_Lot2 (Timestamp BH_GuaranteeDate_Lot2)
	{
		set_Value (COLUMNNAME_BH_GuaranteeDate_Lot2, BH_GuaranteeDate_Lot2);
	}

	/** Get Lot 2 Guarantee Date.
		@return Lot 2 Guarantee Date	  */
	public Timestamp getBH_GuaranteeDate_Lot2 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_GuaranteeDate_Lot2);
	}

	/** Set Lot 3 Guarantee Date.
		@param BH_GuaranteeDate_Lot3 Lot 3 Guarantee Date	  */
	public void setBH_GuaranteeDate_Lot3 (Timestamp BH_GuaranteeDate_Lot3)
	{
		set_Value (COLUMNNAME_BH_GuaranteeDate_Lot3, BH_GuaranteeDate_Lot3);
	}

	/** Get Lot 3 Guarantee Date.
		@return Lot 3 Guarantee Date	  */
	public Timestamp getBH_GuaranteeDate_Lot3 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_GuaranteeDate_Lot3);
	}

	/** Set Has Expiration.
		@param BH_HasExpiration Has Expiration	  */
	public void setBH_HasExpiration (boolean BH_HasExpiration)
	{
		set_Value (COLUMNNAME_BH_HasExpiration, Boolean.valueOf(BH_HasExpiration));
	}

	/** Get Has Expiration.
		@return Has Expiration	  */
	public boolean isBH_HasExpiration () 
	{
		Object oo = get_Value(COLUMNNAME_BH_HasExpiration);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Has Lot 1.
		@param BH_HasLot1 Has Lot 1	  */
	public void setBH_HasLot1 (boolean BH_HasLot1)
	{
		set_Value (COLUMNNAME_BH_HasLot1, Boolean.valueOf(BH_HasLot1));
	}

	/** Get Has Lot 1.
		@return Has Lot 1	  */
	public boolean isBH_HasLot1 () 
	{
		Object oo = get_Value(COLUMNNAME_BH_HasLot1);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Has Lot 2.
		@param BH_HasLot2 Has Lot 2	  */
	public void setBH_HasLot2 (boolean BH_HasLot2)
	{
		set_Value (COLUMNNAME_BH_HasLot2, Boolean.valueOf(BH_HasLot2));
	}

	/** Get Has Lot 2.
		@return Has Lot 2	  */
	public boolean isBH_HasLot2 () 
	{
		Object oo = get_Value(COLUMNNAME_BH_HasLot2);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Has Lot 3.
		@param BH_HasLot3 Has Lot 3	  */
	public void setBH_HasLot3 (boolean BH_HasLot3)
	{
		set_Value (COLUMNNAME_BH_HasLot3, Boolean.valueOf(BH_HasLot3));
	}

	/** Get Has Lot 3.
		@return Has Lot 3	  */
	public boolean isBH_HasLot3 () 
	{
		Object oo = get_Value(COLUMNNAME_BH_HasLot3);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Import Products with Quantities.
		@param BH_I_Product_Quantity_ID Import Products with Quantities	  */
	public void setBH_I_Product_Quantity_ID (int BH_I_Product_Quantity_ID)
	{
		if (BH_I_Product_Quantity_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_BH_I_Product_Quantity_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_BH_I_Product_Quantity_ID, Integer.valueOf(BH_I_Product_Quantity_ID));
	}

	/** Get Import Products with Quantities.
		@return Import Products with Quantities	  */
	public int getBH_I_Product_Quantity_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_I_Product_Quantity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_I_Product_Quantity_UU.
		@param BH_I_Product_Quantity_UU BH_I_Product_Quantity_UU	  */
	public void setBH_I_Product_Quantity_UU (String BH_I_Product_Quantity_UU)
	{
		set_Value (COLUMNNAME_BH_I_Product_Quantity_UU, BH_I_Product_Quantity_UU);
	}

	/** Get BH_I_Product_Quantity_UU.
		@return BH_I_Product_Quantity_UU	  */
	public String getBH_I_Product_Quantity_UU () 
	{
		return (String)get_Value(COLUMNNAME_BH_I_Product_Quantity_UU);
	}

	/** Set Initial Quantity.
		@param BH_InitialQuantity 
		The initial quantity of a product
	  */
	public void setBH_InitialQuantity (BigDecimal BH_InitialQuantity)
	{
		set_Value (COLUMNNAME_BH_InitialQuantity, BH_InitialQuantity);
	}

	/** Get Initial Quantity.
		@return The initial quantity of a product
	  */
	public BigDecimal getBH_InitialQuantity () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_InitialQuantity);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Lot 2 Initial Quantity.
		@param BH_InitialQuantity_Lot2 Lot 2 Initial Quantity	  */
	public void setBH_InitialQuantity_Lot2 (BigDecimal BH_InitialQuantity_Lot2)
	{
		set_Value (COLUMNNAME_BH_InitialQuantity_Lot2, BH_InitialQuantity_Lot2);
	}

	/** Get Lot 2 Initial Quantity.
		@return Lot 2 Initial Quantity	  */
	public BigDecimal getBH_InitialQuantity_Lot2 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_InitialQuantity_Lot2);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Lot 3 Initial Quantity.
		@param BH_InitialQuantity_Lot3 Lot 3 Initial Quantity	  */
	public void setBH_InitialQuantity_Lot3 (BigDecimal BH_InitialQuantity_Lot3)
	{
		set_Value (COLUMNNAME_BH_InitialQuantity_Lot3, BH_InitialQuantity_Lot3);
	}

	/** Get Lot 3 Initial Quantity.
		@return Lot 3 Initial Quantity	  */
	public BigDecimal getBH_InitialQuantity_Lot3 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_InitialQuantity_Lot3);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Re-order Level.
		@param bh_reorder_level Re-order Level	  */
	public void setbh_reorder_level (int bh_reorder_level)
	{
		set_Value (COLUMNNAME_bh_reorder_level, Integer.valueOf(bh_reorder_level));
	}

	/** Get Re-order Level.
		@return Re-order Level	  */
	public int getbh_reorder_level () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_bh_reorder_level);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_SellPrice.
		@param BH_SellPrice 
		Selling price of BandaGo product
	  */
	public void setBH_SellPrice (BigDecimal BH_SellPrice)
	{
		set_Value (COLUMNNAME_BH_SellPrice, BH_SellPrice);
	}

	/** Get BH_SellPrice.
		@return Selling price of BandaGo product
	  */
	public BigDecimal getBH_SellPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BH_SellPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Category Name.
		@param CategoryName 
		Name of the Category
	  */
	public void setCategoryName (String CategoryName)
	{
		set_Value (COLUMNNAME_CategoryName, CategoryName);
	}

	/** Get Category Name.
		@return Name of the Category
	  */
	public String getCategoryName () 
	{
		return (String)get_Value(COLUMNNAME_CategoryName);
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

	/** Set Guarantee Date.
		@param GuaranteeDate 
		Date when guarantee expires
	  */
	public void setGuaranteeDate (Timestamp GuaranteeDate)
	{
		set_Value (COLUMNNAME_GuaranteeDate, GuaranteeDate);
	}

	/** Get Guarantee Date.
		@return Date when guarantee expires
	  */
	public Timestamp getGuaranteeDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_GuaranteeDate);
	}

	/** Set Import Error Message.
		@param I_ErrorMsg 
		Messages generated from import process
	  */
	public void setI_ErrorMsg (String I_ErrorMsg)
	{
		set_Value (COLUMNNAME_I_ErrorMsg, I_ErrorMsg);
	}

	/** Get Import Error Message.
		@return Messages generated from import process
	  */
	public String getI_ErrorMsg () 
	{
		return (String)get_Value(COLUMNNAME_I_ErrorMsg);
	}

	/** Set Imported.
		@param I_IsImported 
		Has this import been processed
	  */
	public void setI_IsImported (boolean I_IsImported)
	{
		set_Value (COLUMNNAME_I_IsImported, Boolean.valueOf(I_IsImported));
	}

	/** Get Imported.
		@return Has this import been processed
	  */
	public boolean isI_IsImported () 
	{
		Object oo = get_Value(COLUMNNAME_I_IsImported);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product/Service.
		@param M_Product_ID 
		Product, Service, Item
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
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}