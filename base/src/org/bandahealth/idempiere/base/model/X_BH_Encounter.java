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

/** Generated Model for BH_Encounter
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="BH_Encounter")
public class X_BH_Encounter extends PO implements I_BH_Encounter, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250403L;

    /** Standard Constructor */
    public X_BH_Encounter (Properties ctx, int BH_Encounter_ID, String trxName)
    {
      super (ctx, BH_Encounter_ID, trxName);
      /** if (BH_Encounter_ID == 0)
        {
			setBH_Encounter_Date (new Timestamp( System.currentTimeMillis() ));
			setBH_Encounter_ID (0);
			setBH_Encounter_Type (null);
			setBH_Visit_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter (Properties ctx, int BH_Encounter_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Encounter_ID, trxName, virtualColumns);
      /** if (BH_Encounter_ID == 0)
        {
			setBH_Encounter_Date (new Timestamp( System.currentTimeMillis() ));
			setBH_Encounter_ID (0);
			setBH_Encounter_Type (null);
			setBH_Visit_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter (Properties ctx, String BH_Encounter_UU, String trxName)
    {
      super (ctx, BH_Encounter_UU, trxName);
      /** if (BH_Encounter_UU == null)
        {
			setBH_Encounter_Date (new Timestamp( System.currentTimeMillis() ));
			setBH_Encounter_ID (0);
			setBH_Encounter_Type (null);
			setBH_Visit_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_BH_Encounter (Properties ctx, String BH_Encounter_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Encounter_UU, trxName, virtualColumns);
      /** if (BH_Encounter_UU == null)
        {
			setBH_Encounter_Date (new Timestamp( System.currentTimeMillis() ));
			setBH_Encounter_ID (0);
			setBH_Encounter_Type (null);
			setBH_Visit_ID (0);
        } */
    }

    /** Load Constructor */
    public X_BH_Encounter (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Encounter[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Encounter Date.
		@param BH_Encounter_Date Encounter Date
	*/
	public void setBH_Encounter_Date (Timestamp BH_Encounter_Date)
	{
		set_Value (COLUMNNAME_BH_Encounter_Date, BH_Encounter_Date);
	}

	/** Get Encounter Date.
		@return Encounter Date	  */
	public Timestamp getBH_Encounter_Date()
	{
		return (Timestamp)get_Value(COLUMNNAME_BH_Encounter_Date);
	}

	/** Set Encounter.
		@param BH_Encounter_ID Encounter
	*/
	public void setBH_Encounter_ID (int BH_Encounter_ID)
	{
		if (BH_Encounter_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Encounter_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Encounter_ID, Integer.valueOf(BH_Encounter_ID));
	}

	/** Get Encounter.
		@return Encounter	  */
	public int getBH_Encounter_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Encounter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Chief Complaint = C */
	public static final String BH_ENCOUNTER_TYPE_ChiefComplaint = "C";
	/** Clinical Details = D */
	public static final String BH_ENCOUNTER_TYPE_ClinicalDetails = "D";
	/** Immunizations = I */
	public static final String BH_ENCOUNTER_TYPE_Immunizations = "I";
	/** Capture Vitals = V */
	public static final String BH_ENCOUNTER_TYPE_CaptureVitals = "V";
	/** Lab Diagnostics = l */
	public static final String BH_ENCOUNTER_TYPE_LabDiagnostics = "l";
	/** Diagnosis = m */
	public static final String BH_ENCOUNTER_TYPE_Diagnosis = "m";
	/** Set Encounter Type.
		@param BH_Encounter_Type Encounter Type
	*/
	public void setBH_Encounter_Type (String BH_Encounter_Type)
	{

		set_ValueNoCheck (COLUMNNAME_BH_Encounter_Type, BH_Encounter_Type);
	}

	/** Get Encounter Type.
		@return Encounter Type	  */
	public String getBH_Encounter_Type()
	{
		return (String)get_Value(COLUMNNAME_BH_Encounter_Type);
	}

	/** Set BH_Encounter_UU.
		@param BH_Encounter_UU BH_Encounter_UU
	*/
	public void setBH_Encounter_UU (String BH_Encounter_UU)
	{
		set_Value (COLUMNNAME_BH_Encounter_UU, BH_Encounter_UU);
	}

	/** Get BH_Encounter_UU.
		@return BH_Encounter_UU	  */
	public String getBH_Encounter_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Encounter_UU);
	}

	/** Set Visit.
		@param BH_Visit_ID Visit
	*/
	public void setBH_Visit_ID (int BH_Visit_ID)
	{
		if (BH_Visit_ID < 1)
			set_Value (COLUMNNAME_BH_Visit_ID, null);
		else
			set_Value (COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
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
}