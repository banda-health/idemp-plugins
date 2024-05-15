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

/** Generated Model for BH_Observation
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="BH_Observation")
public class X_BH_Observation extends PO implements I_BH_Observation, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240326L;

    /** Standard Constructor */
    public X_BH_Observation (Properties ctx, int BH_Observation_ID, String trxName)
    {
      super (ctx, BH_Observation_ID, trxName);
      /** if (BH_Observation_ID == 0)
        {
			setAD_Field_ID (0);
			setBH_Encounter_ID (0);
			setBH_Observation_ID (0);
			setBH_Value (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Observation (Properties ctx, int BH_Observation_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Observation_ID, trxName, virtualColumns);
      /** if (BH_Observation_ID == 0)
        {
			setAD_Field_ID (0);
			setBH_Encounter_ID (0);
			setBH_Observation_ID (0);
			setBH_Value (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Observation (Properties ctx, String BH_Observation_UU, String trxName)
    {
      super (ctx, BH_Observation_UU, trxName);
      /** if (BH_Observation_UU == null)
        {
			setAD_Field_ID (0);
			setBH_Encounter_ID (0);
			setBH_Observation_ID (0);
			setBH_Value (null);
        } */
    }

    /** Standard Constructor */
    public X_BH_Observation (Properties ctx, String BH_Observation_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Observation_UU, trxName, virtualColumns);
      /** if (BH_Observation_UU == null)
        {
			setAD_Field_ID (0);
			setBH_Encounter_ID (0);
			setBH_Observation_ID (0);
			setBH_Value (null);
        } */
    }

    /** Load Constructor */
    public X_BH_Observation (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_BH_Observation[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Field getAD_Field() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Field)MTable.get(getCtx(), org.compiere.model.I_AD_Field.Table_ID)
			.getPO(getAD_Field_ID(), get_TrxName());
	}

	/** Set Field.
		@param AD_Field_ID Field on a database table
	*/
	public void setAD_Field_ID (int AD_Field_ID)
	{
		if (AD_Field_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_Field_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_Field_ID, Integer.valueOf(AD_Field_ID));
	}

	/** Get Field.
		@return Field on a database table
	  */
	public int getAD_Field_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Field_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_BH_Encounter getBH_Encounter() throws RuntimeException
	{
		return (I_BH_Encounter)MTable.get(getCtx(), I_BH_Encounter.Table_ID)
			.getPO(getBH_Encounter_ID(), get_TrxName());
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

	/** Set Observation.
		@param BH_Observation_ID Observation
	*/
	public void setBH_Observation_ID (int BH_Observation_ID)
	{
		if (BH_Observation_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Observation_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Observation_ID, Integer.valueOf(BH_Observation_ID));
	}

	/** Get Observation.
		@return Observation	  */
	public int getBH_Observation_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Observation_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Observation_UU.
		@param BH_Observation_UU BH_Observation_UU
	*/
	public void setBH_Observation_UU (String BH_Observation_UU)
	{
		set_Value (COLUMNNAME_BH_Observation_UU, BH_Observation_UU);
	}

	/** Get BH_Observation_UU.
		@return BH_Observation_UU	  */
	public String getBH_Observation_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Observation_UU);
	}

	/** Set BH_Value.
		@param BH_Value BH_Value
	*/
	public void setBH_Value (String BH_Value)
	{
		set_Value (COLUMNNAME_BH_Value, BH_Value);
	}

	/** Get BH_Value.
		@return BH_Value
	  */
	public String getBH_Value()
	{
		return (String)get_Value(COLUMNNAME_BH_Value);
	}
}