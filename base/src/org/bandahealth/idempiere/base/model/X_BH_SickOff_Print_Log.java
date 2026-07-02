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

/** Generated Model for BH_SickOff_Print_Log
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_SickOff_Print_Log")
public class X_BH_SickOff_Print_Log extends PO implements I_BH_SickOff_Print_Log, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260701L;

    /** Standard Constructor */
    public X_BH_SickOff_Print_Log (Properties ctx, int BH_SickOff_Print_Log_ID, String trxName)
    {
      super (ctx, BH_SickOff_Print_Log_ID, trxName);
      /** if (BH_SickOff_Print_Log_ID == 0)
        {
			setBH_SickOff_ID (0);
			setBH_SickOff_Print_Log_ID (0);
			setPrintedBy (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_SickOff_Print_Log (Properties ctx, int BH_SickOff_Print_Log_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_SickOff_Print_Log_ID, trxName, virtualColumns);
      /** if (BH_SickOff_Print_Log_ID == 0)
        {
			setBH_SickOff_ID (0);
			setBH_SickOff_Print_Log_ID (0);
			setPrintedBy (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_SickOff_Print_Log (Properties ctx, String BH_SickOff_Print_Log_UU, String trxName)
    {
      super (ctx, BH_SickOff_Print_Log_UU, trxName);
      /** if (BH_SickOff_Print_Log_UU == null)
        {
			setBH_SickOff_ID (0);
			setBH_SickOff_Print_Log_ID (0);
			setPrintedBy (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_SickOff_Print_Log (Properties ctx, String BH_SickOff_Print_Log_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_SickOff_Print_Log_UU, trxName, virtualColumns);
      /** if (BH_SickOff_Print_Log_UU == null)
        {
			setBH_SickOff_ID (0);
			setBH_SickOff_Print_Log_ID (0);
			setPrintedBy (0);
        } */
    }

    /** Load Constructor */
    public X_BH_SickOff_Print_Log (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_SickOff_Print_Log[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_BH_SickOff getBH_SickOff() throws RuntimeException
	{
		return (I_BH_SickOff)MTable.get(getCtx(), I_BH_SickOff.Table_ID)
			.getPO(getBH_SickOff_ID(), get_TrxName());
	}

	/** Set Sick Off.
		@param BH_SickOff_ID Sick Off
	*/
	public void setBH_SickOff_ID (int BH_SickOff_ID)
	{
		if (BH_SickOff_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_SickOff_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_SickOff_ID, Integer.valueOf(BH_SickOff_ID));
	}

	/** Get Sick Off.
		@return Sick Off	  */
	public int getBH_SickOff_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_SickOff_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Sick Off Print Log.
		@param BH_SickOff_Print_Log_ID Sick Off Print Log
	*/
	public void setBH_SickOff_Print_Log_ID (int BH_SickOff_Print_Log_ID)
	{
		if (BH_SickOff_Print_Log_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_SickOff_Print_Log_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_SickOff_Print_Log_ID, Integer.valueOf(BH_SickOff_Print_Log_ID));
	}

	/** Get Sick Off Print Log.
		@return Sick Off Print Log	  */
	public int getBH_SickOff_Print_Log_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_SickOff_Print_Log_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_SickOff_Print_Log_UU.
		@param BH_SickOff_Print_Log_UU BH_SickOff_Print_Log_UU
	*/
	public void setBH_SickOff_Print_Log_UU (String BH_SickOff_Print_Log_UU)
	{
		set_Value (COLUMNNAME_BH_SickOff_Print_Log_UU, BH_SickOff_Print_Log_UU);
	}

	/** Get BH_SickOff_Print_Log_UU.
		@return BH_SickOff_Print_Log_UU	  */
	public String getBH_SickOff_Print_Log_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_SickOff_Print_Log_UU);
	}

	/** Set Printed.
		@param Printed Date and time this record was printed
	*/
	public void setPrinted (Timestamp Printed)
	{
		set_Value (COLUMNNAME_Printed, Printed);
	}

	/** Get Printed.
		@return Date and time this record was printed
	  */
	public Timestamp getPrinted()
	{
		return (Timestamp)get_Value(COLUMNNAME_Printed);
	}

	public org.compiere.model.I_AD_User getPrintedByUser() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getPrintedBy(), get_TrxName());
	}

	/** Set Printed By.
		@param PrintedBy User who printed this record
	*/
	public void setPrintedBy (int PrintedBy)
	{
		if (PrintedBy < 1)
			set_Value (COLUMNNAME_PrintedBy, null);
		else
			set_Value (COLUMNNAME_PrintedBy, Integer.valueOf(PrintedBy));
	}

	/** Get Printed By.
		@return User who printed this record
	  */
	public int getPrintedBy()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PrintedBy);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}
