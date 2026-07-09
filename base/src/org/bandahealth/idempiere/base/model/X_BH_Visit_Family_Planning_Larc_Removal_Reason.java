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

/** Generated Model for BH_Visit_Family_Planning_Larc_Removal_Reason
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Visit_Family_Planning_Larc_Removal_Reason")
public class X_BH_Visit_Family_Planning_Larc_Removal_Reason extends PO implements I_BH_Visit_Family_Planning_Larc_Removal_Reason, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260630L;

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning_Larc_Removal_Reason (Properties ctx, int BH_Visit_Family_Planning_Larc_Removal_Reason_ID, String trxName)
    {
      super (ctx, BH_Visit_Family_Planning_Larc_Removal_Reason_ID, trxName);
      /** if (BH_Visit_Family_Planning_Larc_Removal_Reason_ID == 0)
        {
			setBH_Larc_Removal_Reason (null);
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_Family_Planning_Larc_Removal_Reason_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning_Larc_Removal_Reason (Properties ctx, int BH_Visit_Family_Planning_Larc_Removal_Reason_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Visit_Family_Planning_Larc_Removal_Reason_ID, trxName, virtualColumns);
      /** if (BH_Visit_Family_Planning_Larc_Removal_Reason_ID == 0)
        {
			setBH_Larc_Removal_Reason (null);
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_Family_Planning_Larc_Removal_Reason_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning_Larc_Removal_Reason (Properties ctx, String BH_Visit_Family_Planning_Larc_Removal_Reason_UU, String trxName)
    {
      super (ctx, BH_Visit_Family_Planning_Larc_Removal_Reason_UU, trxName);
      /** if (BH_Visit_Family_Planning_Larc_Removal_Reason_UU == null)
        {
			setBH_Larc_Removal_Reason (null);
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_Family_Planning_Larc_Removal_Reason_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning_Larc_Removal_Reason (Properties ctx, String BH_Visit_Family_Planning_Larc_Removal_Reason_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Visit_Family_Planning_Larc_Removal_Reason_UU, trxName, virtualColumns);
      /** if (BH_Visit_Family_Planning_Larc_Removal_Reason_UU == null)
        {
			setBH_Larc_Removal_Reason (null);
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_Family_Planning_Larc_Removal_Reason_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Visit_Family_Planning_Larc_Removal_Reason (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Visit_Family_Planning_Larc_Removal_Reason[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Desire to conceive = desireToConceive */
	public static final String BH_LARC_REMOVAL_REASON_DesireToConceive = "desireToConceive";
	/** Health concerns/side effects = healthConcernsSideEffects */
	public static final String BH_LARC_REMOVAL_REASON_HealthConcernsSideEffects = "healthConcernsSideEffects";
	/** Maturity = maturity */
	public static final String BH_LARC_REMOVAL_REASON_Maturity = "maturity";
	/** Method failure = methodFailure */
	public static final String BH_LARC_REMOVAL_REASON_MethodFailure = "methodFailure";
	/** Method switch = methodSwitch */
	public static final String BH_LARC_REMOVAL_REASON_MethodSwitch = "methodSwitch";
	/** Others = others */
	public static final String BH_LARC_REMOVAL_REASON_Others = "others";
	/** Set LARC Removal Reason.
		@param BH_Larc_Removal_Reason LARC Removal Reason
	*/
	public void setBH_Larc_Removal_Reason (String BH_Larc_Removal_Reason)
	{

		set_Value (COLUMNNAME_BH_Larc_Removal_Reason, BH_Larc_Removal_Reason);
	}

	/** Get LARC Removal Reason.
		@return LARC Removal Reason	  */
	public String getBH_Larc_Removal_Reason()
	{
		return (String)get_Value(COLUMNNAME_BH_Larc_Removal_Reason);
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

	/** Set Visit Family Planning LARC Removal Reason.
		@param BH_Visit_Family_Planning_Larc_Removal_Reason_ID Visit Family Planning LARC Removal Reason
	*/
	public void setBH_Visit_Family_Planning_Larc_Removal_Reason_ID (int BH_Visit_Family_Planning_Larc_Removal_Reason_ID)
	{
		if (BH_Visit_Family_Planning_Larc_Removal_Reason_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Visit_Family_Planning_Larc_Removal_Reason_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Visit_Family_Planning_Larc_Removal_Reason_ID, Integer.valueOf(BH_Visit_Family_Planning_Larc_Removal_Reason_ID));
	}

	/** Get Visit Family Planning LARC Removal Reason.
		@return Visit Family Planning LARC Removal Reason	  */
	public int getBH_Visit_Family_Planning_Larc_Removal_Reason_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_Family_Planning_Larc_Removal_Reason_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Visit_Family_Planning_Larc_Removal_Reason_UU.
		@param BH_Visit_Family_Planning_Larc_Removal_Reason_UU BH_Visit_Family_Planning_Larc_Removal_Reason_UU
	*/
	public void setBH_Visit_Family_Planning_Larc_Removal_Reason_UU (String BH_Visit_Family_Planning_Larc_Removal_Reason_UU)
	{
		set_Value (COLUMNNAME_BH_Visit_Family_Planning_Larc_Removal_Reason_UU, BH_Visit_Family_Planning_Larc_Removal_Reason_UU);
	}

	/** Get BH_Visit_Family_Planning_Larc_Removal_Reason_UU.
		@return BH_Visit_Family_Planning_Larc_Removal_Reason_UU	  */
	public String getBH_Visit_Family_Planning_Larc_Removal_Reason_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Visit_Family_Planning_Larc_Removal_Reason_UU);
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
}