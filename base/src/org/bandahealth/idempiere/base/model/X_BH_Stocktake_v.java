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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for BH_Stocktake_v
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_BH_Stocktake_v extends PO implements I_BH_Stocktake_v, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200609L;

    /** Standard Constructor */
    public X_BH_Stocktake_v (Properties ctx, int BH_Stocktake_v_ID, String trxName)
    {
      super (ctx, BH_Stocktake_v_ID, trxName);
      /** if (BH_Stocktake_v_ID == 0)
        {
        } */
    }

    /** Load Constructor */
    public X_BH_Stocktake_v (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
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
      StringBuilder sb = new StringBuilder ("X_BH_Stocktake_v[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set BH Document Action.
		@param BH_DocAction 
		The targeted status of the document
	  */
	public void setBH_DocAction (String BH_DocAction)
	{
		set_Value (COLUMNNAME_BH_DocAction, BH_DocAction);
	}

	/** Get BH Document Action.
		@return The targeted status of the document
	  */
	public String getBH_DocAction () 
	{
		return (String)get_Value(COLUMNNAME_BH_DocAction);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_ValueNoCheck (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set expirationdate.
		@param expirationdate expirationdate	  */
	public void setexpirationdate (Timestamp expirationdate)
	{
		set_Value (COLUMNNAME_expirationdate, expirationdate);
	}

	/** Get expirationdate.
		@return expirationdate	  */
	public Timestamp getexpirationdate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_expirationdate);
	}

	/** Set Instance Attribute.
		@param IsInstanceAttribute 
		The product attribute is specific to the instance (like Serial No, Lot or Guarantee Date)
	  */
	public void setIsInstanceAttribute (boolean IsInstanceAttribute)
	{
		set_ValueNoCheck (COLUMNNAME_IsInstanceAttribute, Boolean.valueOf(IsInstanceAttribute));
	}

	/** Get Instance Attribute.
		@return The product attribute is specific to the instance (like Serial No, Lot or Guarantee Date)
	  */
	public boolean isInstanceAttribute () 
	{
		Object oo = get_Value(COLUMNNAME_IsInstanceAttribute);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set location.
		@param location location	  */
	public void setlocation (String location)
	{
		set_ValueNoCheck (COLUMNNAME_location, location);
	}

	/** Get location.
		@return location	  */
	public String getlocation () 
	{
		return (String)get_Value(COLUMNNAME_location);
	}

	public org.compiere.model.I_M_AttributeSet getM_AttributeSet() throws RuntimeException
    {
		return (org.compiere.model.I_M_AttributeSet)MTable.get(getCtx(), org.compiere.model.I_M_AttributeSet.Table_Name)
			.getPO(getM_AttributeSet_ID(), get_TrxName());	}

	/** Set Attribute Set.
		@param M_AttributeSet_ID 
		Product Attribute Set
	  */
	public void setM_AttributeSet_ID (int M_AttributeSet_ID)
	{
		if (M_AttributeSet_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_M_AttributeSet_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_AttributeSet_ID, Integer.valueOf(M_AttributeSet_ID));
	}

	/** Get Attribute Set.
		@return Product Attribute Set
	  */
	public int getM_AttributeSet_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_AttributeSet_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_M_AttributeSetInstance getM_AttributeSetInstance() throws RuntimeException
    {
		return (I_M_AttributeSetInstance)MTable.get(getCtx(), I_M_AttributeSetInstance.Table_Name)
			.getPO(getM_AttributeSetInstance_ID(), get_TrxName());	}

	/** Set Attribute Set Instance.
		@param M_AttributeSetInstance_ID 
		Product Attribute Set Instance
	  */
	public void setM_AttributeSetInstance_ID (int M_AttributeSetInstance_ID)
	{
		if (M_AttributeSetInstance_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_M_AttributeSetInstance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_AttributeSetInstance_ID, Integer.valueOf(M_AttributeSetInstance_ID));
	}

	/** Get Attribute Set Instance.
		@return Product Attribute Set Instance
	  */
	public int getM_AttributeSetInstance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_AttributeSetInstance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
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

	/** Set M_Storage_UU.
		@param M_Storage_UU M_Storage_UU	  */
	public void setM_Storage_UU (String M_Storage_UU)
	{
		set_ValueNoCheck (COLUMNNAME_M_Storage_UU, M_Storage_UU);
	}

	/** Get M_Storage_UU.
		@return M_Storage_UU	  */
	public String getM_Storage_UU () 
	{
		return (String)get_Value(COLUMNNAME_M_Storage_UU);
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
    {
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
			.getPO(getM_Warehouse_ID(), get_TrxName());	}

	/** Set Warehouse.
		@param M_Warehouse_ID 
		Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1) 
			set_Value (COLUMNNAME_M_Warehouse_ID, null);
		else 
			set_Value (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_ValueNoCheck (COLUMNNAME_Processed, Boolean.valueOf(Processed));
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

	/** Set Product.
		@param Product Product	  */
	public void setProduct (String Product)
	{
		set_ValueNoCheck (COLUMNNAME_Product, Product);
	}

	/** Get Product.
		@return Product	  */
	public String getProduct () 
	{
		return (String)get_Value(COLUMNNAME_Product);
	}

	/** Set quantity.
		@param quantity quantity	  */
	public void setquantity (int quantity)
	{
		set_ValueNoCheck (COLUMNNAME_quantity, Integer.valueOf(quantity));
	}

	/** Get quantity.
		@return quantity	  */
	public int getquantity () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_quantity);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Shelf Life Days.
		@param ShelfLifeDays 
		Shelf Life in days based on Product Instance Guarantee Date
	  */
	public void setShelfLifeDays (int ShelfLifeDays)
	{
		set_ValueNoCheck (COLUMNNAME_ShelfLifeDays, Integer.valueOf(ShelfLifeDays));
	}

	/** Get Shelf Life Days.
		@return Shelf Life in days based on Product Instance Guarantee Date
	  */
	public int getShelfLifeDays () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ShelfLifeDays);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}