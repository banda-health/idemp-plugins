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

/** Generated Model for BH_Role_WarehouseAccess
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="BH_Role_WarehouseAccess")
public class X_BH_Role_WarehouseAccess extends PO implements I_BH_Role_WarehouseAccess, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250127L;

    /** Standard Constructor */
    public X_BH_Role_WarehouseAccess (Properties ctx, int BH_Role_WarehouseAccess_ID, String trxName)
    {
      super (ctx, BH_Role_WarehouseAccess_ID, trxName);
      /** if (BH_Role_WarehouseAccess_ID == 0)
        {
			setBH_Role_WarehouseAccess_ID (0);
			setIsReadOnly (false);
			setM_Warehouse_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Role_WarehouseAccess (Properties ctx, int BH_Role_WarehouseAccess_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Role_WarehouseAccess_ID, trxName, virtualColumns);
      /** if (BH_Role_WarehouseAccess_ID == 0)
        {
			setBH_Role_WarehouseAccess_ID (0);
			setIsReadOnly (false);
			setM_Warehouse_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Role_WarehouseAccess (Properties ctx, String BH_Role_WarehouseAccess_UU, String trxName)
    {
      super (ctx, BH_Role_WarehouseAccess_UU, trxName);
      /** if (BH_Role_WarehouseAccess_UU == null)
        {
			setBH_Role_WarehouseAccess_ID (0);
			setIsReadOnly (false);
			setM_Warehouse_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Role_WarehouseAccess (Properties ctx, String BH_Role_WarehouseAccess_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Role_WarehouseAccess_UU, trxName, virtualColumns);
      /** if (BH_Role_WarehouseAccess_UU == null)
        {
			setBH_Role_WarehouseAccess_ID (0);
			setIsReadOnly (false);
			setM_Warehouse_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Role_WarehouseAccess (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 6 - System - Client
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
      StringBuilder sb = new StringBuilder ("X_BH_Role_WarehouseAccess[")
        .append(get_UUID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Role getAD_Role() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Role)MTable.get(getCtx(), org.compiere.model.I_AD_Role.Table_ID)
			.getPO(getAD_Role_ID(), get_TrxName());
	}

	/** Set Role.
		@param AD_Role_ID Responsibility Role
	*/
	public void setAD_Role_ID (int AD_Role_ID)
	{
		if (AD_Role_ID < 0)
			set_ValueNoCheck (COLUMNNAME_AD_Role_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_Role_ID, Integer.valueOf(AD_Role_ID));
	}

	/** Get Role.
		@return Responsibility Role
	  */
	public int getAD_Role_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Role_WarehouseAccess_ID.
		@param BH_Role_WarehouseAccess_ID BH_Role_WarehouseAccess_ID
	*/
	public void setBH_Role_WarehouseAccess_ID (int BH_Role_WarehouseAccess_ID)
	{
		if (BH_Role_WarehouseAccess_ID < 1)
			set_Value (COLUMNNAME_BH_Role_WarehouseAccess_ID, null);
		else
			set_Value (COLUMNNAME_BH_Role_WarehouseAccess_ID, Integer.valueOf(BH_Role_WarehouseAccess_ID));
	}

	/** Get BH_Role_WarehouseAccess_ID.
		@return BH_Role_WarehouseAccess_ID	  */
	public int getBH_Role_WarehouseAccess_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Role_WarehouseAccess_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Role_WarehouseAccess_UU.
		@param BH_Role_WarehouseAccess_UU BH_Role_WarehouseAccess_UU
	*/
	public void setBH_Role_WarehouseAccess_UU (String BH_Role_WarehouseAccess_UU)
	{
		set_Value (COLUMNNAME_BH_Role_WarehouseAccess_UU, BH_Role_WarehouseAccess_UU);
	}

	/** Get BH_Role_WarehouseAccess_UU.
		@return BH_Role_WarehouseAccess_UU	  */
	public String getBH_Role_WarehouseAccess_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Role_WarehouseAccess_UU);
	}

	/** Set Read Only.
		@param IsReadOnly Field is read only
	*/
	public void setIsReadOnly (boolean IsReadOnly)
	{
		set_Value (COLUMNNAME_IsReadOnly, Boolean.valueOf(IsReadOnly));
	}

	/** Get Read Only.
		@return Field is read only
	  */
	public boolean isReadOnly()
	{
		Object oo = get_Value(COLUMNNAME_IsReadOnly);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
	{
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_ID)
			.getPO(getM_Warehouse_ID(), get_TrxName());
	}

	/** Set Warehouse.
		@param M_Warehouse_ID Storage Warehouse and Service Point
	*/
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1)
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}