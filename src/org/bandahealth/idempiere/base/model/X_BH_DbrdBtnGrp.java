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

/** Generated Model for BH_DbrdBtnGrp
 *  @author iDempiere (generated)
 *  @version Release 5.1 - $Id$ */
public class X_BH_DbrdBtnGrp extends PO implements I_BH_DbrdBtnGrp, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190306L;

	/** Standard Constructor */
	public X_BH_DbrdBtnGrp (Properties ctx, int BH_DbrdBtnGrp_ID, String trxName)
	{
		super (ctx, BH_DbrdBtnGrp_ID, trxName);
		/** if (BH_DbrdBtnGrp_ID == 0)
		 {
		 setBH_DbrdBtnGrp_ID (0);
		 setName (null);
		 } */
	}

	/** Load Constructor */
	public X_BH_DbrdBtnGrp (Properties ctx, ResultSet rs, String trxName)
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
		StringBuffer sb = new StringBuffer ("X_BH_DbrdBtnGrp[")
				.append(get_ID()).append("]");
		return sb.toString();
	}

	/** Set BH_DbrdBtnGrp_ID.
	 @param BH_DbrdBtnGrp_ID BH_DbrdBtnGrp_ID	  */
	public void setBH_DbrdBtnGrp_ID (int BH_DbrdBtnGrp_ID)
	{
		if (BH_DbrdBtnGrp_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_DbrdBtnGrp_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_DbrdBtnGrp_ID, Integer.valueOf(BH_DbrdBtnGrp_ID));
	}

	/** Get BH_DbrdBtnGrp_ID.
	 @return BH_DbrdBtnGrp_ID	  */
	public int getBH_DbrdBtnGrp_ID ()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_DbrdBtnGrp_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/** Set BH_DbrdBtnGrp_UU.
	 @param BH_DbrdBtnGrp_UU BH_DbrdBtnGrp_UU	  */
	public void setBH_DbrdBtnGrp_UU (String BH_DbrdBtnGrp_UU)
	{
		set_Value (COLUMNNAME_BH_DbrdBtnGrp_UU, BH_DbrdBtnGrp_UU);
	}

	/** Get BH_DbrdBtnGrp_UU.
	 @return BH_DbrdBtnGrp_UU	  */
	public String getBH_DbrdBtnGrp_UU ()
	{
		return (String)get_Value(COLUMNNAME_BH_DbrdBtnGrp_UU);
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

	/** Set Line.
	 @param LineNo
	 Line No
	 */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
	 @return Line No
	 */
	public int getLineNo ()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
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
}
