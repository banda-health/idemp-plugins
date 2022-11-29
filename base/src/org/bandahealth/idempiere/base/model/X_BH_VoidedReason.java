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
import org.compiere.util.KeyNamePair;

/**
 * Generated Model for BH_VoidedReason
 * 
 * @author iDempiere (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_VoidedReason extends PO implements I_BH_VoidedReason, I_Persistent {

	/**
	 *
	 */
	private static final long serialVersionUID = 20200526L;

	/** Standard Constructor */
	public X_BH_VoidedReason(Properties ctx, int BH_VoidedReason_ID, String trxName) {
		super(ctx, BH_VoidedReason_ID, trxName);
	}

	/** Load Constructor */
	public X_BH_VoidedReason(Properties ctx, ResultSet rs, String trxName) {
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
		StringBuilder sb = new StringBuilder("X_BH_VoidedReason[").append(get_ID()).append(",Name=")
				.append(getName()).append("]");
		return sb.toString();
	}

	/**
	 * Set BH_VoidedReason_ID.
	 * 
	 * @param BH_VoidedReason_ID BH_VoidedReason
	 */
	public void setBH_VoidedReason_ID(int BH_VoidedReason_ID) {
		if (BH_VoidedReason_ID < 1)
			set_ValueNoCheck(COLUMNNAME_BH_Voided_Reason_ID, null);
		else
			set_ValueNoCheck(COLUMNNAME_BH_Voided_Reason_ID, Integer.valueOf(BH_VoidedReason_ID));
	}

	/**
	 * Get BH_VoidedReason.
	 * 
	 * @return BH_VoidedReason
	 */
	public int getBH_VoidedReason_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Voided_Reason_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set BH_VoidedReason_UU.
	 * 
	 * @param BH_VoidedReason_UU BH_VoidedReason_UU
	 */
	public void setBH_VoidedReason_UU(String BH_VoidedReason_UU) {
		set_Value(COLUMNNAME_BH_Voided_Reason_UU, BH_VoidedReason_UU);
	}

	/**
	 * Get BH_VoidedReason_UU.
	 * 
	 * @return BH_VoidedReason_UU
	 */
	public String getBH_VoidedReason_UU() {
		return (String) get_Value(COLUMNNAME_BH_Voided_Reason_UU);
	}

	/**
	 * Set Description.
	 * 
	 * @param Description Optional short description of the record
	 */
	public void setDescription(String Description) {
		set_Value(COLUMNNAME_Description, Description);
	}

	/**
	 * Get Description.
	 * 
	 * @return Optional short description of the record
	 */
	public String getDescription() {
		return (String) get_Value(COLUMNNAME_Description);
	}

	/**
	 * Get Record ID/ColumnName
	 * 
	 * @return ID/ColumnName pair
	 */
	public KeyNamePair getKeyNamePair() {
		return new KeyNamePair(get_ID(), getName());
	}

	@Override
	public void setName(String name) {
		set_Value(COLUMNNAME_Name, name);
	}

	@Override
	public String getName() {
		return (String) get_Value(COLUMNNAME_Name);
	}

	@Override
	public void setBH_WindowId(int bh_windowId) {
		if (bh_windowId < 1)
			set_ValueNoCheck(COLUMNNAME_BH_Window_Id, null);
		else
			set_ValueNoCheck(COLUMNNAME_BH_Window_Id, Integer.valueOf(bh_windowId));
	}

	@Override
	public int getBH_WindowId() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Window_Id);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	@Override
	public void setLineNo(int lineNo) {
		if (lineNo < 1)
			set_ValueNoCheck(COLUMNNAME_LINE_NO, null);
		else
			set_ValueNoCheck(COLUMNNAME_LINE_NO, Integer.valueOf(lineNo));
	}

	@Override
	public int getLineNo() {
		Integer ii = (Integer) get_Value(COLUMNNAME_LINE_NO);
		if (ii == null)
			return 0;
		return ii.intValue();
	}
}