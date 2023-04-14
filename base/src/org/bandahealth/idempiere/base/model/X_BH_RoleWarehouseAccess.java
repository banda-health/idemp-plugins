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

import org.compiere.model.I_Persistent;
import org.compiere.model.PO;
import org.compiere.model.POInfo;

/**
 * Generated Model for BH_RoleWarehouseAccess
 * 
 * @author iDempiere (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_RoleWarehouseAccess extends PO implements I_BH_RoleWarehouseAccess, I_Persistent {

	/**
	 *
	 */
	private static final long serialVersionUID = 20200526L;

	/** Standard Constructor */
	public X_BH_RoleWarehouseAccess(Properties ctx, int BH_RoleWarehouse_ID, String trxName) {
		super(ctx, BH_RoleWarehouse_ID, trxName);
	}

	/** Load Constructor */
	public X_BH_RoleWarehouseAccess(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * AccessLevel
	 * 
	 * @return 4 - System
	 */
	protected int get_AccessLevel() {
		return accessLevel.intValue();
	}

	/**
	 * Load Meta Data
	 * 
	 * @return
	 */
	protected POInfo initPO(Properties ctx) {
		POInfo poi = POInfo.getPOInfo(ctx, Table_ID, get_TrxName());
		return poi;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("X_BH_RoleWarehouse[").append(get_ID()).append("]");
		return sb.toString();
	}

	/**
	 * Set BH_RoleWarehouse_ID.
	 * 
	 * @param BH_RoleWarehouse_ID BH_RoleWarehouse
	 */
	public void setBH_RoleWarehouseAccess_ID(int BH_RoleWarehouse_ID) {
		if (BH_RoleWarehouse_ID < 1)
			set_ValueNoCheck(COLUMNNAME_BH_RoleWarehouseAccess_ID, null);
		else
			set_ValueNoCheck(COLUMNNAME_BH_RoleWarehouseAccess_ID, Integer.valueOf(BH_RoleWarehouse_ID));
	}

	/**
	 * Get BH_RoleWarehouse.
	 * 
	 * @return BH_RoleWarehouse
	 */
	public int getBH_RoleWarehouseAccess_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_RoleWarehouseAccess_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set BH_RoleWarehouse_UU.
	 * 
	 * @param BH_RoleWarehouseAccess_UU BH_RoleWarehouse_UU
	 */
	public void setBH_RoleWarehouseAccess_UU(String BH_RoleWarehouseAccess_UU) {
		set_Value(COLUMNNAME_BH_RoleWarehouseAccess_UU, BH_RoleWarehouseAccess_UU);
	}

	/**
	 * Get BH_RoleWarehouse_UU.
	 * 
	 * @return BH_RoleWarehouse_UU
	 */
	public String getBH_RoleWarehouseAccess_UU() {
		return (String) get_Value(COLUMNNAME_BH_RoleWarehouseAccess_UU);
	}

	@Override
	public void setMWarehouseId(int mWarehouseId) {
		if (mWarehouseId < 1)
			set_ValueNoCheck(COLUMNNAME_M_Warehouse_Id, null);
		else
			set_ValueNoCheck(COLUMNNAME_M_Warehouse_Id, Integer.valueOf(mWarehouseId));
	}

	@Override
	public int getMWarehouseId() {
		Integer ii = (Integer) get_Value(COLUMNNAME_M_Warehouse_Id);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	@Override
	public void setRoleId(int role_id) {
		if (role_id < 1)
			set_ValueNoCheck(COLUMNNAME_Role_Id, null);
		else
			set_ValueNoCheck(COLUMNNAME_Role_Id, Integer.valueOf(role_id));
	}

	@Override
	public int getRoleId() {
		Integer ii = (Integer) get_Value(COLUMNNAME_Role_Id);
		if (ii == null)
			return 0;
		return ii.intValue();
	}
}