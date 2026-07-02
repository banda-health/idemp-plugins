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
import org.compiere.util.KeyNamePair;

/** Generated Model for BH_SickOff
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_SickOff")
public class X_BH_SickOff extends PO implements I_BH_SickOff, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260701L;

    /** Standard Constructor */
    public X_BH_SickOff (Properties ctx, int BH_SickOff_ID, String trxName)
    {
      super (ctx, BH_SickOff_ID, trxName);
      /** if (BH_SickOff_ID == 0)
        {
			setBH_Clinician_User_ID (0);
			setBH_SickOff_ID (0);
			setBH_Visit_ID (0);
			setEndDate (null);
			setStartDate (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_SickOff (Properties ctx, int BH_SickOff_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_SickOff_ID, trxName, virtualColumns);
      /** if (BH_SickOff_ID == 0)
        {
			setBH_Clinician_User_ID (0);
			setBH_SickOff_ID (0);
			setBH_Visit_ID (0);
			setEndDate (null);
			setStartDate (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_SickOff (Properties ctx, String BH_SickOff_UU, String trxName)
    {
      super (ctx, BH_SickOff_UU, trxName);
      /** if (BH_SickOff_UU == null)
        {
			setBH_Clinician_User_ID (0);
			setBH_SickOff_ID (0);
			setBH_Visit_ID (0);
			setEndDate (null);
			setStartDate (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_SickOff (Properties ctx, String BH_SickOff_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_SickOff_UU, trxName, virtualColumns);
      /** if (BH_SickOff_UU == null)
        {
			setBH_Clinician_User_ID (0);
			setBH_SickOff_ID (0);
			setBH_Visit_ID (0);
			setEndDate (null);
			setStartDate (null);
        } */
    }

    /** Load Constructor */
    public X_BH_SickOff (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_SickOff[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set BH_SickOff_UU.
		@param BH_SickOff_UU BH_SickOff_UU
	*/
	public void setBH_SickOff_UU (String BH_SickOff_UU)
	{
		set_Value (COLUMNNAME_BH_SickOff_UU, BH_SickOff_UU);
	}

	/** Get BH_SickOff_UU.
		@return BH_SickOff_UU	  */
	public String getBH_SickOff_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_SickOff_UU);
	}

	/** Set BH_Additional_Clinical_Notes.
		@param BH_Additional_Clinical_Notes Any further instructions for the employer or patient
	*/
	public void setBH_Additional_Clinical_Notes (String BH_Additional_Clinical_Notes)
	{
		set_Value (COLUMNNAME_BH_Additional_Clinical_Notes, BH_Additional_Clinical_Notes);
	}

	/** Get BH_Additional_Clinical_Notes.
		@return Any further instructions for the employer or patient
	  */
	public String getBH_Additional_Clinical_Notes()
	{
		return (String)get_Value(COLUMNNAME_BH_Additional_Clinical_Notes);
	}

	public org.compiere.model.I_AD_User getBH_Clinician_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getBH_Clinician_User_ID(), get_TrxName());
	}

	/** Set BH_Clinician_User_ID.
		@param BH_Clinician_User_ID BH_Clinician_User_ID
	*/
	public void setBH_Clinician_User_ID (int BH_Clinician_User_ID)
	{
		if (BH_Clinician_User_ID < 1)
			set_Value (COLUMNNAME_BH_Clinician_User_ID, null);
		else
			set_Value (COLUMNNAME_BH_Clinician_User_ID, Integer.valueOf(BH_Clinician_User_ID));
	}

	/** Get BH_Clinician_User_ID.
		@return BH_Clinician_User_ID
	  */
	public int getBH_Clinician_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Clinician_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_BH_Visit getBH_Visit() throws RuntimeException
	{
		return (I_BH_Visit)MTable.get(getCtx(), I_BH_Visit.Table_ID)
			.getPO(getBH_Visit_ID(), get_TrxName());
	}

	/** Set Visit.
		@param BH_Visit_ID Visit
	*/
	public void setBH_Visit_ID (int BH_Visit_ID)
	{
		if (BH_Visit_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Visit_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
	}

	/** Get Visit.
		@return Visit	  */
	public int getBH_Visit_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set End Date.
		@param EndDate End Date
	*/
	public void setEndDate (Timestamp EndDate)
	{
		set_Value (COLUMNNAME_EndDate, EndDate);
	}

	/** Get End Date.
		@return End Date	  */
	public Timestamp getEndDate()
	{
		return (Timestamp)get_Value(COLUMNNAME_EndDate);
	}

	/** Set Start Date.
		@param StartDate Start Date
	*/
	public void setStartDate (Timestamp StartDate)
	{
		set_Value (COLUMNNAME_StartDate, StartDate);
	}

	/** Get Start Date.
		@return Start Date	  */
	public Timestamp getStartDate()
	{
		return (Timestamp)get_Value(COLUMNNAME_StartDate);
	}
}
